package br.com.rsinet.HUB_TDD.testCase;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "AcessarUmProdutoPelaHome.csv")
public class AcessarUmProdutoPelaHome {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = Web.createChrome();
	}
	
	//@Test
	public void deveAbrirPaginaDeUmProdutoPelaCategoria(
			@Param(name = "idCategoria") String idCategoria,
			@Param(name = "produto") String produto) {

		new HomePage(driver).clicarCategoria(idCategoria).ClicarEm(produto);
	}

	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
