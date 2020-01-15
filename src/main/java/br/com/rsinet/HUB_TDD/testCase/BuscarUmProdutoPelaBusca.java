package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.BasePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

public class BuscarUmProdutoPelaBusca {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.createChrome();
	}

	@Test
	public void DeveRealisarUmaBuscaComSucesso() throws Exception {
		ExcelUtils.setExcelFile("BuscarUmProdutoPelaBusca_P");
		String produto = ExcelUtils.getCellData(1, 1);

		String produtoAtual = new BasePage(driver).buscar(produto).encontrou().toString();

		assertEquals(produto.toLowerCase(), produtoAtual.toLowerCase());

		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);

	}

	@Test
	public void DeveRealisarUmaBuscaComFalha() throws Exception {
		ExcelUtils.setExcelFile("BuscarUmProdutoPelaBusca_N");
		String produto = ExcelUtils.getCellData(2, 1);

		String buscaNegativa = new BasePage(driver).buscar(produto).naoEncontrou().rerultadoBuscaNegativa();
		String esperado = "No results for \"" + produto + "\"";

		assertEquals(esperado.toLowerCase(), buscaNegativa.toLowerCase());

		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

}
