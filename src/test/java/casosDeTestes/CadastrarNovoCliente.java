package casosDeTestes;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.*;
import pageObjects.actions.*;

public class CadastrarNovoCliente {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DOMConfigurator.configure("log4j.xml");
		driver.get("https://www.advantageonlineshopping.com/");
	}
	
	@Test
	public void DeveCadastrarNovoClienteComSucesso() {
		boolean displayed = false;
		
		//Logar.Executar(driver, "teste5", "Abc123");
		Cadastrar.Executar(driver, "teste6", "Abc1234", "teste6", "testesegundonopme", "656565656565", "Brasil", "Sorocaba", "São Paulo", "123456", "Abc1234");
		
		try {
			 displayed = HomePage.lblNomeLogin(driver).isDisplayed();
		} catch (Exception e) {
			assertTrue(displayed);
		}

	}
	
	
	@After
	public void end() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
