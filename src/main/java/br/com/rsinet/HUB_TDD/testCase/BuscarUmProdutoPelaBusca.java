package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
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

import br.com.rsinet.HUB_TDD.pageObjects.BasePage;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "BuscarUmProdutoPelaBusca.csv")
public class BuscarUmProdutoPelaBusca {
	//private static Logger Log = Logger.getLogger(BuscarUmProdutoPelaBusca.class.getName());
	
	@Rule
	public TestName test = new TestName();
	
	private WebDriver driver;
	private Logger Log;

	@Before
	public void setUp() {
		Log = Logger.getLogger(BuscarUmProdutoPelaBusca.class.getName());
		driver = Web.createChrome();
	}

	 @Test
	public void DeveRealisarUmaBuscaComSucesso(@Param(name = "produto") String produto) throws InterruptedException {
		String produtoAtual = new BasePage(driver).buscar(produto).encontrou().toString();
		
		assertEquals(produto.toLowerCase(), produtoAtual.toLowerCase());
		
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);


	}

	@Test
	public void DeveRealisarUmaBuscaComFalha(@Param(name = "produto") String produto) throws InterruptedException {
		String buscaNegativa = new BasePage(driver).buscar(produto).naoEncontrou().rerultadoBuscaNegativa();
		String esperado = "No results for \"" + produto + "\"";

		assertEquals(esperado, buscaNegativa);
		
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		Log.info("OK");
		driver.quit();
	}

}
