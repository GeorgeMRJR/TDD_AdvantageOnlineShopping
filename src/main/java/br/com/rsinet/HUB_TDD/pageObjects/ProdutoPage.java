package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage extends BasePage {

	public ProdutoPage(WebDriver driver) {
		super(driver);
	}

	public String produtoAtualTxt() {
		String text;
		try {
			text = driver.findElement(By.xpath("//h1[@class='roboto-regular screen768 ng-binding']")).getText();
		} catch (Exception e) {
			text = driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();
			e.getMessage();
			return text;
		}
		return text;
	}

	public String encontrou() {
		WebElement element = driver.findElement(By.xpath("//a[@class='productName ng-binding']"));
		return element.getText();
	}

	public ErrorProdutoPage naoEncontrou() {

		return new ErrorProdutoPage(driver);
	}

}
