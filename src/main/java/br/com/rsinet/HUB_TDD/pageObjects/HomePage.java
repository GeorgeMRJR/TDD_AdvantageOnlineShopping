package br.com.rsinet.HUB_TDD.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	private static Logger Log = Logger.getLogger(HomePage.class.getName());

	public HomePage(WebDriver driver) {
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

	public CadastroPage clicarNewAccount() {

		driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();
		return new CadastroPage(driver);
	}

	public HomePage fazerLogIn(String UserName, String password) {
		digitarUserName(UserName);
		digitarPassword(password);
		clicarSingIN();
		return this;

	}

}
