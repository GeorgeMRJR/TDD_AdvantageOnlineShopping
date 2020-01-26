package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorProdutoPage extends BasePage {

	public ErrorProdutoPage(WebDriver driver) {
		super(driver);
	}

	public String rerultadoBuscaNegativa() throws InterruptedException {

		return driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[3]/div[1]/label[1]/span[1]")).getText();

	}

}
