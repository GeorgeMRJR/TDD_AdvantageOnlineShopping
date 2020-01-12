package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage extends BasePage{

	public ProdutoPage(WebDriver driver) {
		super(driver);
	}
	
	public ProdutoPage produtoAtual() {
		driver.findElement(By.xpath("//*[@id=\"Description\"]/h1[1]")).getText();
		return this;
		
	}

	public String assertEquals(String produto, String produtoAtual) {
		// TODO Auto-generated method stub
		return null;
	}

}
