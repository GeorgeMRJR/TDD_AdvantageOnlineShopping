package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean usuarioLogado() {
		 boolean usuarioLogado;
		try {
			usuarioLogado = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']")).isDisplayed();
		} catch (Exception e) {
			usuarioLogado = false;
			
		}
		 return usuarioLogado;
	}
}
