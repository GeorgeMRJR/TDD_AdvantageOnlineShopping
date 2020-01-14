package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;


public class CadastrarNovoCliente {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = Web.createChrome();
	}

	  @Test
	  public void DeveCadasTrarUmNovoClienteComSucessoTest() throws Exception {
		  ExcelUtils.setExcelFile("CadastrarNovoCliente_N");
			String nomeusuario = ExcelUtils.getCellData(1, 1);
			String senha = ExcelUtils.getCellData(1, 2);
			String Resenha = ExcelUtils.getCellData(1, 3);
			String email = ExcelUtils.getCellData(1, 4);
			String primeiroNome = ExcelUtils.getCellData(1, 5);
			String segundoNome = ExcelUtils.getCellData(1, 6);
			String telefone = ExcelUtils.getCellData(1, 7);
			String continente = ExcelUtils.getCellData(1, 8);
			String cidade = ExcelUtils.getCellData(1, 9);
			String estado = ExcelUtils.getCellData(1, 10);
			String endereco = ExcelUtils.getCellData(1, 11);
			String codPostal = ExcelUtils.getCellData(1, 12);
			
			boolean usuarioLogado = new HomePage(driver)
				.clicarUsuario()
				.clicarNewAccount()
				.DigitarNomeUsuario(nomeusuario)
				.DigitaSenha(senha)
				.DigitarNovamenteSenha(Resenha)
				.DigitarEmail(email)
				.DigitarPrimeiroNome(primeiroNome)
				.DigitarSegundoNome(segundoNome)
				.DigitarTelefone(telefone)
				.EscolherContinente(continente)
				.escreverCidade(cidade)
				.DigitarEstado(estado)
				.DigitarEndereco(endereco)
				.DigitarCodigoPostal(codPostal)
				.ClicarCbxAceitoTermos()
				.ClicarEmRegistrar()
				.usuarioLogado();
			
			assertTrue(usuarioLogado);
			
			String testName = new Throwable().getStackTrace()[0].getMethodName();
			String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
			Screenshot.tirar(driver, nomeDoArquivo);
	  }
	
	
	@Test
	public void DeveCadasTrarUmNovoClienteComFalha() throws Exception {
		  	ExcelUtils.setExcelFile("CadastrarNovoCliente_N");
			String nomeusuario = ExcelUtils.getCellData(1, 1);
			String senha = ExcelUtils.getCellData(1, 2);
			String Resenha = ExcelUtils.getCellData(1, 3);
			String email = ExcelUtils.getCellData(1, 4);
			String primeiroNome = ExcelUtils.getCellData(1, 5);
			String segundoNome = ExcelUtils.getCellData(1, 6);
			String telefone = ExcelUtils.getCellData(1, 7);
			String continente = ExcelUtils.getCellData(1, 8);
			String cidade = ExcelUtils.getCellData(1, 9);
			String estado = ExcelUtils.getCellData(1, 10);
			String endereco = ExcelUtils.getCellData(1, 11);
			String codPostal = ExcelUtils.getCellData(1, 12);
			
		boolean usuarioLogado = new HomePage(driver)
			.clicarUsuario()
			.clicarNewAccount()
			.DigitarNomeUsuario(nomeusuario)
			.DigitaSenha(senha)
			.DigitarNovamenteSenha(Resenha)
			.DigitarEmail(email)
			.DigitarPrimeiroNome(primeiroNome)
			.DigitarSegundoNome(segundoNome)
			.DigitarTelefone(telefone)
			.EscolherContinente(continente)
			.escreverCidade(cidade)
			.DigitarEstado(estado)
			.DigitarEndereco(endereco)
			.DigitarCodigoPostal(codPostal)
			.ClicarCbxAceitoTermos()
			.ClicarEmRegistrar()
			.usuarioLogado();
		
		assertFalse(usuarioLogado);
		
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
