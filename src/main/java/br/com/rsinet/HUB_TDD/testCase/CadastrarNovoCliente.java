package br.com.rsinet.HUB_TDD.testCase;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "CadastrarNovoCliente.csv")
public class CadastrarNovoCliente {

	@Rule
	public TestName test = new TestName();

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Web.createChrome();
	}

//	@Test
	public void DeveLogarClienteComSucesso(@Param(name = "userName") String userName,
			@Param(name = "password") String password) {
		boolean usuarioLogado = new HomePage(driver).clicarUsuario().digitarUserName(userName).digitarPassword(password)
				.clicarSingIN().usuarioLogado();

		assertTrue(usuarioLogado);
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@Test
	public void DeveCadasTrarUmNovoClienteComSucesso(
			@Param(name = "nomeusuario") String nomeusuario,
			@Param(name = "senha") String senha,
			@Param(name = "Resenha") String Resenha,
			@Param(name = "email") String email,
			@Param(name = "primeiroNome") String primeiroNome,
			@Param(name = "segundoNome") String segundoNome,
			@Param(name = "telefone") String telefone,
			@Param(name = "continente") String continente,
			@Param(name = "cidade") String cidade,
			@Param(name = "estado") String estado,
			@Param(name = "endereco") String endereco,
			@Param(name = "codPostal") String codPostal
			
			) throws InterruptedException {
			
		boolean usuarioLogado = new HomePage(driver)
		.clicarUsuario()
		.clicarNewAccount()
		.DigitarNomeUsuario(nomeusuario)
		.DigitaSenha(senha)
		.DigitarNovamenteSenha(Resenha)
		.DigitarEmail(email)
		.DigitarPrimeiroNome(primeiroNome)
		.DigitarSegundoNome(segundoNome)
		.DigitarTelefone(telefone)
		.EscolherContinente(continente)
		.escreverCidade(cidade)
		.DigitarEstado(estado)
		.DigitarEndereco(endereco)
		.DigitarCodigoPostal(codPostal)
		.ClicarCbxAceitoTermos()
		.ClicarEmRegistrar()
		.usuarioLogado();
		
		assertTrue(usuarioLogado);
		
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}
	
	//@Test
	public void DeveCadasTrarUmNovoClienteComFalha(
			@Param(name = "nomeusuario") String nomeusuario,
			@Param(name = "senha") String senha,
			@Param(name = "Resenha") String Resenha,
			@Param(name = "email") String email,
			@Param(name = "primeiroNome") String primeiroNome,
			@Param(name = "segundoNome") String segundoNome,
			@Param(name = "telefone") String telefone,
			@Param(name = "continente") String continente,
			@Param(name = "cidade") String cidade,
			@Param(name = "estado") String estado,
			@Param(name = "endereco") String endereco,
			@Param(name = "codPostal") String codPostal
			
			) throws InterruptedException {
			
		boolean usuarioLogado = new HomePage(driver)
		.clicarUsuario()
		.clicarNewAccount()
		.DigitarNomeUsuario(nomeusuario)
		.DigitaSenha(senha)
		.DigitarNovamenteSenha(Resenha)
		.DigitarEmail(email)
		.DigitarPrimeiroNome(primeiroNome)
		.DigitarSegundoNome(segundoNome)
		.DigitarTelefone(telefone)
		.EscolherContinente(continente)
		.escreverCidade(cidade)
		.DigitarEstado(estado)
		.DigitarEndereco(endereco)
		.DigitarCodigoPostal(codPostal)
		.ClicarCbxAceitoTermos()
		.ClicarEmRegistrar()
		.usuarioLogado();
		
		assertFalse(usuarioLogado);
		
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
