package br.com.rsinet.HUB_TDD.testCase;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelConsumer;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.ExtentReport;
import br.com.rsinet.HUB_TDD.suporte.Web;

public class CadastrarNovoCliente {
	private WebDriver driver;
	private ExtentTest test;
	private ExtentReports extent;
	private String testName;
	private ExcelConsumer cadastro;

	@BeforeTest
	public void setUpReport() {
		extent = ExtentReport.setReport();
	}

	@BeforeMethod
	public void setUp() {
		driver = Web.inicializarDriver();
		cadastro = new ExcelConsumer();
	}

	@Test
	public void DeveCadasTrarUmNovoClienteComSucesso() throws Throwable {
		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		// massa
		ExcelUtils.setExcelFile("CadastrarNovoCliente_Po");
		int row = 2;

		// teste
		boolean usuarioLogado = new HomePage(driver)
				.clicarUsuario()
				.clicarNewAccount()
				.DigitarNomeUsuario(cadastro.getNomeUsuario(row))
				.DigitaSenha(cadastro.getSenha(row))
				.DigitarNovamenteSenha(cadastro.getReSenha(row))
				.DigitarEmail(cadastro.getEmail(row))
				.DigitarPrimeiroNome(cadastro.getPrimeiroNome(row))
				.DigitarSegundoNome(cadastro.getSegundoNome(row))
				.DigitarTelefone(cadastro.getTelefone(row))
				.EscolherContinente(cadastro.getContinente(row))
				.escreverCidade(cadastro.getCidade(row))
				.DigitarEstado(cadastro.getEstado(row))
				.DigitarEndereco(cadastro.getEndereco(row))
				.DigitarCodigoPostal(cadastro.getCodPostal(row))
				.ClicarCbxAceitoTermos()
				.ClicarEmRegistrar()
				.usuarioLogado();
		assertTrue(usuarioLogado);

	}

	@Test
	public void DeveTentarCadasTrarUmNovoClienteComFalha() throws Throwable {
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		
		// massa
		ExcelUtils.setExcelFile("CadastrarNovoCliente_Ne");
		int row = 3;
		

		// teste
		boolean usuarioLogado = new HomePage(driver)
				.clicarUsuario()
				.clicarNewAccount()
				.DigitarNomeUsuario(cadastro.getNomeUsuario(row))
				.DigitaSenha(cadastro.getSenha(row))
				.DigitarNovamenteSenha(cadastro.getReSenha(row))
				.DigitarEmail(cadastro.getEmail(row))
				.DigitarPrimeiroNome(cadastro.getPrimeiroNome(row))
				.DigitarSegundoNome(cadastro.getSegundoNome(row))
				.DigitarTelefone(cadastro.getTelefone(row))
				.EscolherContinente(cadastro.getContinente(row))
				.escreverCidade(cadastro.getCidade(row))
				.DigitarEstado(cadastro.getEstado(row))
				.DigitarEndereco(cadastro.getEndereco(row))
				.DigitarCodigoPostal(cadastro.getCodPostal(row))
				.ClicarCbxAceitoTermos()
				.ClicarEmRegistrar()
				.cadastroFalhou();
		assertFalse(usuarioLogado);


	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		Web.fecharDriver();
	}
}
