package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.assertTrue;

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
@DataLoader(filePaths = "CadastrarNovoClientePageObject.csv")
public class CadastrarNovoCliente {

	@Rule
	public TestName test = new TestName();

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.createChrome();
	}
	
	@Test
	public void DeveLogarClienteComSucesso(
			@Param(name = "userName")String userName, 
			@Param(name = "password")String password) {
		boolean usuarioLogado = new HomePage(driver).clicarUsuario().digitarUserName(userName).digitarPassword(password)
				.clicarSingIN().usuarioLogado();

		assertTrue(usuarioLogado);
		String nomeDoArquivo = "C:\\Users\\george.junior\\eclipse-XPTO\\TDD_AdvantageOnlineShopping\\evidencias\\"
				+ Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}
	
	

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
