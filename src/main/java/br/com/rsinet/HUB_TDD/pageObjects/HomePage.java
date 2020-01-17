package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


	public HomePage(WebDriver driver ) {
		super(driver);
	}

	public HomePage clicarUsuario() {
		driver.findElement(By.id("menuUser")).click();
		return this;
	}

	public HomePage digitarUserName(String UserName) {
		driver.findElement(By.name("username")).sendKeys(UserName);
		return this;
	}

	public HomePage digitarPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
		return this;
	}

	public HomePage clicarSingIN() {
		driver.findElement(By.id("sign_in_btnundefined")).click();
		return this;
	}

	public CadastroPage clicarNewAccount() throws InterruptedException {

		driver.findElement(By.cssSelector(
				"body.ng-scope:nth-child(2) login-modal:nth-child(3) div.PopUp div:nth-child(1) div.login.ng-scope > a.create-new-account.ng-scope:nth-child(6)"))
				.sendKeys(Keys.ENTER);
		return new CadastroPage(driver);
	}

	public HomePage fazerLogIn(String UserName, String password) {
		digitarUserName(UserName);
		digitarPassword(password);
		clicarSingIN();
		return this;
	}

	public HomePage popupVisivel() {
		driver.findElement(By.id("//div[@class='PopUp']")).isDisplayed();
		return this;

	}

	public CategoriaProdutoPage clicarCategoria(String Categoria) {
		
		WebElement element = driver.findElement(By.xpath("//span[.='"+Categoria+"']"));

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		return new CategoriaProdutoPage(driver);
		
		
	}

}
