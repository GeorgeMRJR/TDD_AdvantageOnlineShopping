package br.com.rsinet.HUB_TDD.suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	public static WebDriver createChrome() {
		//System.setProperty("webdriver.chrome.driver", "/Users/georgejunior/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/");
		return driver;
	}
}