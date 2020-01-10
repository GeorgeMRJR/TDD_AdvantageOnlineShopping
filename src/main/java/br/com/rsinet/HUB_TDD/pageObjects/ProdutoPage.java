package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage extends BasePage {

	public ProdutoPage(WebDriver driver) {
		super(driver);
	}

	public ProdutoPage ClicarEm(String produto) {
		driver.findElement(By.linkText(produto)).click();
		return this;
	}
}
