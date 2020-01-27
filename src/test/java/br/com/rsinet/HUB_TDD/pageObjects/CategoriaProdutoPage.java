package br.com.rsinet.HUB_TDD.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriaProdutoPage extends BasePage {

	public CategoriaProdutoPage(WebDriver driver) {
		super(driver);
	}

	public ProdutoPage ClicarEm(String produto) {
		WebElement element = driver.findElement(By.linkText(produto));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		return new ProdutoPage(driver);
	}

	public String ClicarEmProdutoValido(String produto) {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		try {
			WebElement element = driver.findElement(By.linkText(produto));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			return new BasePage(driver).urlAtual();
		}
		return new BasePage(driver).urlAtual();
	}

}
