package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.BasePage;
import br.com.rsinet.HUB_TDD.pageObjects.ProdutoPage;
import br.com.rsinet.HUB_TDD.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "BuscarUmProdutoPelaBusca.csv")
public class BuscarUmProdutoPelaBusca{
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = Web.createChrome();
	}

	//@Test
	public void DeveRealisarUmaBuscaComSucesso(@Param(name = "produto") String produto) {
		Object produtoAtual = new BasePage(driver).buscar(produto).produtoAtual();
		assertEquals( produto, produtoAtual);
		
	}
	
	@Test
	public void DeveRealisarUmaBuscaComFalha(@Param(name = "produto") String produto) {
		new BasePage(driver).buscar(produto);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	

}
