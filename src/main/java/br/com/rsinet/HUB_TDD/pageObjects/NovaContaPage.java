package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovaContaPage extends BasePage {
	public NovaContaPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement element;

	public static WebElement campoUserName(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		return element;
	}
	
	public static WebElement campoPassword(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}
	
	public static WebElement campoComfirmPassword(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}
	
	public static WebElement campoEmail(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}
	
	
	public static WebElement campoPrimeiroNome(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		return element;
	}
	public static WebElement campoSegundoNome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}
	public static WebElement campoTelefone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}
	public static Select cbxContinentes(WebDriver driver) {
		Select select = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		return select;
	}
	public static WebElement campoCidade(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;
	}
	public static WebElement campoEndereco(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}
	public static WebElement campoCodigoPostal(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}
	public static WebElement CampoEstado(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}
	public static WebElement ckBoxAceitoTermos(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;
	}

	public static WebElement btnRegirtrar(WebDriver driver) {
		element = driver.findElement(By.name("register_btnundefined"));
		return element;
	}	


	
}
