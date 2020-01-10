package br.com.rsinet.HUB_TDD.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovaContaPage extends BasePage {
	public NovaContaPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement element;
	private static Logger Log = Logger.getLogger(HomePage.class.getName());

	public static WebElement campoUserName(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		Log.info("Elemento campoUserName encontrado");
		return element;
	}
	
	public static WebElement campoPassword(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		Log.info("Elemento campoPassword encontrado");
		return element;
	}
	
	public static WebElement campoComfirmPassword(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		Log.info("Elemento campoComfirmPassword encontrado");
		return element;
	}
	
	public static WebElement campoEmail(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		Log.info("Elemento emailRegisterPage encontrado");
		return element;
	}
	
	
	public static WebElement campoPrimeiroNome(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		Log.info("Elemento campoPrimeiroNome encontrado");
		return element;
	}
	public static WebElement campoSegundoNome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		Log.info("Elemento campoSegundoNome encontrado");
		return element;
	}
	public static WebElement campoTelefone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		Log.info("Elemento campoTelefone encontrado");
		return element;
	}
	public static Select cbxContinentes(WebDriver driver) {
		Select select = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Log.info("Elemento(Select) cbxContinentes encontrado");
		return select;
	}
	public static WebElement campoCidade(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		Log.info("Elemento campoCidade encontrado");
		return element;
	}
	public static WebElement campoEndereco(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		Log.info("Elemento campoEndereco encontrado");
		return element;
	}
	public static WebElement campoCodigoPostal(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		Log.info("Elemento campoCodigoPostal encontrado");
		return element;
	}
	public static WebElement CampoEstado(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		Log.info("Elemento CampoEstado encontrado");
		return element;
	}
	public static WebElement ckBoxAceitoTermos(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		Log.info("Elemento ckBoxAceitoTermos encontrado");
		return element;
	}

	public static WebElement btnRegirtrar(WebDriver driver) {
		element = driver.findElement(By.name("register_btnundefined"));
		Log.info("Elemento btnRegirtrar encontrado");
		return element;
	}	


	
}
