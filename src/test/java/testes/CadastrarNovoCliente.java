package testes;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastrarNovoCliente {
	private WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/");
	}
	
	@Test
	public void DeveCadastrarNovoClienteComSucesso() {
		boolean displayed_hiUser = false;
		try {
			 displayed_hiUser = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).isDisplayed();
		} catch (Exception e) {
			assertTrue(displayed_hiUser);
		}
		

	}
	
	
	@After
	public void end() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
