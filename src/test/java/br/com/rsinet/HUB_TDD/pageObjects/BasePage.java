package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	protected WebDriver driver;
	private WebElement logado;
	private JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean usuarioLogado() {
		boolean displayed = false;
		try {
			logado = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
			displayed = logado.isDisplayed();
		} catch (Exception e) {
			return displayed;
		}
		return displayed;
	}

	public BasePage clicarLupa() {
		driver.findElement(By.id("menuSearch")).click();
		return this;
	}

	public ProdutoPage buscar(String produto) {
		driver.findElement(By.id("autoComplete")).sendKeys("" + produto + "" + Keys.ENTER);
		return new ProdutoPage(driver);
	}

	public String urlAtual() {
		return driver.getCurrentUrl();

	}

	public void rolar(int qtd) {
		js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0," + qtd + ")");
	}

}
