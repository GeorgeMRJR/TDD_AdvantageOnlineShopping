package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriaProdutoPage extends BasePage {

	public CategoriaProdutoPage(WebDriver driver) {
		super(driver);
	}

	public BuscaPage ClicarEm(String produto) {
		try {
			WebElement element = driver.findElement(By.linkText(produto));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Nao Foi Encontrado o produto na pagina ");
			// + e.getMessage()
			return new BuscaPage(driver);
		}

		return new BuscaPage(driver);
	}

}
