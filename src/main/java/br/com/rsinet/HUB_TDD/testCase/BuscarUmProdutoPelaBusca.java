package br.com.rsinet.HUB_TDD.testCase;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageObjects.BasePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

public class BuscarUmProdutoPelaBusca {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = Web.inicializarDriver();
	}

	@Test
	public void DeveRealisarUmaBuscaComSucesso() throws Exception {
		//massa
		ExcelUtils.setExcelFile("BuscarUmProdutoPelaBusca_Po");
		String produto = ExcelUtils.getCellData(1, 1);

		//teste
		String produtoAtual = new BasePage(driver).buscar(produto).encontrou().toString();

		assertEquals(produto.toLowerCase(), produtoAtual.toLowerCase());

		// Screenshot
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@Test
	public void DeveRealisarUmaBuscaDeProdutoInvalido() throws Exception {
		//massa
		ExcelUtils.setExcelFile("BuscarUmProdutoPelaBusca_Ne");
		String produto = ExcelUtils.getCellData(2, 1);

		//teste
		String buscaNegativa = new BasePage(driver).buscar(produto).naoEncontrou().rerultadoBuscaNegativa();
		String esperado = "No results for \"" + produto + "\"";

		assertEquals(esperado.toLowerCase(), buscaNegativa.toLowerCase());

		// Screenshot
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Web.fecharDriver();
	}

}
