package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "AcessarUmProdutoPelaHome.csv")
public class AcessarUmProdutoPelaHome {
	@Rule
	public TestName test = new TestName();
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.createChrome();
	}

	 @Test
	public void deveAbrirPaginaDeUmProdutoPelaCategoriaComSucesso(@Param(name = "idCategoria") String idCategoria,
			@Param(name = "produto") String produto) {

		String produtoPage = new HomePage(driver).clicarCategoria(idCategoria).ClicarEm(produto).produtoAtualTxt();

		assertEquals(produto.toLowerCase(), produtoPage.toLowerCase());
		
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	//@Test
	public void deveAbrirPaginaDeUmProdutoPelaCategoriaComFalha(@Param(name = "idCategoria") String idCategoria,
			@Param(name = "produto") String produto) {

		String atual = new HomePage(driver).clicarCategoria(idCategoria).ClicarEm(produto).produtoAtualTxt();
		//String encontrou = new HomePage(driver).clicarCategoria(idCategoria).ClicarEm(produto).encontrou();
		System.out.println(atual);
		//System.out.println(encontrou);

		//assertFalse(false);
		
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
