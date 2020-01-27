package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoPage extends BasePage {

	private WebDriverWait wait;

	public ProdutoPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='productName ng-binding']")));
		WebElement element = driver.findElement(By.xpath("//a[@class='productName ng-binding']"));
		return element.getText();
	}

	public ErrorProdutoPage naoEncontrou() {
		return new ErrorProdutoPage(driver);
	}

}
