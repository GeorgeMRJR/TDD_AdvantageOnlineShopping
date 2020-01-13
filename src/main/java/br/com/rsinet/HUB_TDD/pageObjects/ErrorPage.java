package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ErrorPage extends BasePage {

	public ErrorPage(WebDriver driver) {
		super(driver);
	}

	public String rerultadoBuscaNegativa() throws InterruptedException {
		Thread.sleep(2000);

		return driver.findElement(By.xpath("//span[@class='ng-binding']")).getText();

	}

}
