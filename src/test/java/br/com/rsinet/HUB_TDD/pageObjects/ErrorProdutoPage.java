package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorProdutoPage extends BasePage {

	private WebDriverWait wait;

	public ErrorProdutoPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 20);

	}

	public String rerultadoBuscaNegativa() throws InterruptedException {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'No results for ')]")));
		return driver.findElement(By.xpath("//span[contains(text(),'No results for ')]")).getText();

	}

}
