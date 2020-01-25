package br.com.rsinet.HUB_TDD.testCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.pageObjects.BasePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelConsumer;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.ExtentReport;
import br.com.rsinet.HUB_TDD.suporte.Web;

public class BuscarUmProdutoPelaBusca {

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
	public void DeveRealisarUmaBuscaComSucesso() throws Throwable {
		//report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		
		// massa
		ExcelUtils.setExcelFile("BuscarUmProdutoPelaBusca_Po");
		int row = 1;
		
		// teste
		String produtoAtual = new BasePage(driver)
				.buscar(consumer.getProduto(row))
				.encontrou()
				.toString();
		
		assertEquals(consumer.getProduto(row).toLowerCase(), produtoAtual.toLowerCase());
	}

	@Test
	public void DeveRealisarUmaBuscaDeProdutoInvalido() throws Throwable {
		// report
		testName = new Throwable().getStackTrace()[0].getMethodName();
		test = ExtentReport.createTest(testName);
		
		// massa
		ExcelUtils.setExcelFile("BuscarUmProdutoPelaBusca_Ne");
		int row = 2;
		
		// teste
		String buscaNegativa = new BasePage(driver)
				.buscar(consumer.getProduto(row))
				.naoEncontrou()
				.rerultadoBuscaNegativa();
		
		String esperado = "No results for \"" + consumer.getProduto(row) + "\"";
		assertEquals(esperado.toLowerCase(), buscaNegativa.toLowerCase());
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException {
		ExtentReport.statusReported(test, result, driver);
		ExtentReport.quitExtent(extent);
		Web.fecharDriver();
	}

}
