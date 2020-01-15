package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

public class AcessarUmProdutoPelaHome {

	private WebDriver driver;
 
	@Before
	public void setUp() {
		driver = Web.createChrome();
	}

//	@Test
	public void deveAbrirPaginaDeUmProdutoPelaCategoriaComSucesso() throws Exception {

		ExcelUtils.setExcelFile("AcessarUmProdutoPelaHome_P");
		String idCategoria = ExcelUtils.getCellData(1, 1);
		String produto = ExcelUtils.getCellData(1, 2);

		String produtoPage = new HomePage(driver).clicarCategoria(idCategoria).ClicarEm(produto).produtoAtualTxt();

		assertEquals(produto.toLowerCase(), produtoPage.toLowerCase());

		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@Test
	public void deveAbrirPaginaDeUmProdutoPelaCategoriaComFalha() throws Exception  {
		ExcelUtils.setExcelFile("AcessarUmProdutoPelaHome_N");
		String idCategoria = ExcelUtils.getCellData(1, 1);
		String produto = ExcelUtils.getCellData(1, 2);
		
		String produtoPageValido = new HomePage(driver).clicarCategoria(idCategoria).ClicarEmProdutoValido(produto);

		assertFalse(produtoPageValido.contains("product"));

		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
