package br.com.rsinet.HUB_TDD.testCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

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

public class AcessarUmProdutoPelaHome {

	private WebDriver driver;
	private ExtentTest test;
	private ExtentReports extent;
	private String testName;
	private ExcelConsumer consumer;

	@BeforeTest
	public void setUpReport() {
		extent = ExtentReport.setReport();
	}

	@BeforeMethod
	public void setUp() {
		driver = Web.inicializarDriver();
		consumer = new ExcelConsumer();

	}

	@Test
	public void DeveAbrirPaginaDeUmProdutoPelaCategoria() throws Throwable {
		//report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);

		// massa
		ExcelUtils.setExcelFile("AcessarUmProdutoPelaHome_Po");
		int row = 1;

		// teste
		String produtoPage = new HomePage(driver)
				.clicarCategoria(consumer.getCategoria(row))
				.ClicarEm(consumer.getProduto(row))
				.produtoAtualTxt();

		assertEquals(consumer.getProduto(row).toLowerCase(), produtoPage.toLowerCase());

	}

	@Test
	public void DeveTentarAbrirPaginaDeUmProdutoInesistentePelaCategoria() throws Throwable {
		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		
		// massa
		ExcelUtils.setExcelFile("AcessarUmProdutoPelaHome_Ne");
		int row = 1;

		// teste
		String produtoPageValido = new HomePage(driver)
				.clicarCategoria(consumer.getCategoria(row))
				.ClicarEmProdutoValido(consumer.getProduto(row));

		assertFalse(produtoPageValido.contains("product"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		Web.fecharDriver();
	}
}
