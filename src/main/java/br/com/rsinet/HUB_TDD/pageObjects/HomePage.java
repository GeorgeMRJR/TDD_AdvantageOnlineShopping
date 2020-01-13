package br.com.rsinet.HUB_TDD.pageObjects;

import org.junit.rules.TestName;
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
		new TestName();
		// Log.info("Elemento de id 'menuUser' encontrado e clicado ");
		return this;
	}

	public HomePage digitarUserName(String UserName) {
		driver.findElement(By.name("username")).sendKeys(UserName);
		// Log.info("Elemento de nome 'username' encontrado string passada");
		return this;
	}

	public HomePage digitarPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
		// Log.info("Elemento de nome 'password' encontrado string passada");
		return this;
	}

	public HomePage clicarSingIN() {
		driver.findElement(By.id("sign_in_btnundefined")).click();
		// Log.info("Elemento de nome 'sign_in_btnundefined' encontrado string
		// passada");
		return this;
	}

	public CadastroPage clicarNewAccount() throws InterruptedException {

		// System.out.println(1);
		driver.findElement(By.cssSelector(
				"body.ng-scope:nth-child(2) login-modal:nth-child(3) div.PopUp div:nth-child(1) div.login.ng-scope > a.create-new-account.ng-scope:nth-child(6)"))
				.sendKeys(Keys.ENTER);

		System.out.println(2);
		// Log.info("Elemento link nova conta encontrado ");
		return new CadastroPage(driver);
	}

	public HomePage fazerLogIn(String UserName, String password) {
		digitarUserName(UserName);
		digitarPassword(password);
		clicarSingIN();
		// Log.info("Login realisado");
		return this;
	}

	public HomePage popupVisivel() {
		driver.findElement(By.id("//div[@class='PopUp']")).isDisplayed();
		return this;

	}

	public CategoriaProdutoPage clicarCategoria(String idCategoria) {
		
		WebElement element = driver.findElement(By.id(""+idCategoria+""));

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		return new CategoriaProdutoPage(driver);
	}

}
