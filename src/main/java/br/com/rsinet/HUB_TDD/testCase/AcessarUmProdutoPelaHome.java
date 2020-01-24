package br.com.rsinet.HUB_TDD.testCase;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

public class AcessarUmProdutoPelaHome {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = Web.inicializarDriver();
	}

	@Test
	public void DeveAbrirPaginaDeUmProdutoPelaCategoria() throws Exception {

		// massa
		ExcelUtils.setExcelFile("AcessarUmProdutoPelaHome_Po");
		String Categoria = ExcelUtils.getCellData(1, 1);
		String produto = ExcelUtils.getCellData(1, 2);

		// teste
		String produtoPage = new HomePage(driver).clicarCategoria(Categoria).ClicarEm(produto).produtoAtualTxt();

		assertEquals(produto.toLowerCase(), produtoPage.toLowerCase());

		// Screenshot
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@Test
	public void DeveTentarAbrirPaginaDeUmProdutoInesistentePelaCategoria() throws Exception {
		// massa
		ExcelUtils.setExcelFile("AcessarUmProdutoPelaHome_Ne");
		String idCategoria = ExcelUtils.getCellData(1, 1);
		String produto = ExcelUtils.getCellData(1, 2);

		// teste
		String produtoPageValido = new HomePage(driver).clicarCategoria(idCategoria).ClicarEmProdutoValido(produto);

		assertFalse(produtoPageValido.contains("product"));

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
