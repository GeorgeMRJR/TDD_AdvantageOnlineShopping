package br.com.rsinet.HUB_TDD.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage extends BasePage {

	public CadastroPage(WebDriver driver) {
		super(driver);
	}

	public CadastroPage DigitarNomeUsuario(String NomeUsuario){
		
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(NomeUsuario);
		return this;
	}

	public CadastroPage DigitaSenha(String Senha) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(Senha);
		return this;
	}

	public CadastroPage DigitarNovamenteSenha(String ReSenha) {
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(ReSenha);
		return this;
	}

	public CadastroPage DigitarEmail(String Email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(Email);
		return this;
	}

	public CadastroPage DigitarPrimeiroNome(String Nome) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(Nome);
		return this;
	}

	public CadastroPage DigitarSegundoNome(String Sobrenome) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(Sobrenome);
		;
		return this;
	}

	public CadastroPage DigitarTelefone(String Telefone) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(Telefone);
		;
		return this;
	}

	public CadastroPage EscolherContinente(String Continente) {
		new Select(driver.findElement(By.name("countryListboxRegisterPage"))).selectByVisibleText(Continente);
		return this;
	}

	public CadastroPage escreverCidade(String Cidade) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(Cidade);
		return this;
	}

	public CadastroPage DigitarEndereco(String Endereco) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(Endereco);
		return this;
	}

	public CadastroPage DigitarCodigoPostal(String zip) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(zip);
		return this;
	}

	public CadastroPage DigitarEstado(String Estado) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(Estado);
		return this;
	}

	public CadastroPage ClicarCbxAceitoTermos() {
		driver.findElement(By.name("i_agree")).click();
		return this;
	}
	public CadastroPage textoDoErro() {
		driver.findElement(By.xpath("//label[@class='center block smollMargin marked-element']")).getText();
		return this;
	}

	public HomePage ClicarEmRegistrar() {
		driver.findElement(By.id("register_btnundefined")).click();
		return new HomePage(driver);
	}
	

}
