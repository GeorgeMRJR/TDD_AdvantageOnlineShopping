package br.com.rsinet.HUB_TDD.testCase;



import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageObjects.HomePage;
import br.com.rsinet.HUB_TDD.suporte.ExcelUtils;
import br.com.rsinet.HUB_TDD.suporte.Generator;
import br.com.rsinet.HUB_TDD.suporte.Screenshot;
import br.com.rsinet.HUB_TDD.suporte.Web;


public class CadastrarNovoCliente {
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = Web.inicializarDriver();
	}

	  @Test
	  public void DeveCadasTrarUmNovoClienteComSucesso() throws Exception {
		  //massa
		  	ExcelUtils.setExcelFile("CadastrarNovoCliente_Po");
		  	int col=3;
			String nomeusuario = ExcelUtils.getCellData(col, 1);
			String senha = ExcelUtils.getCellData(col, 2);
			String Resenha = ExcelUtils.getCellData(col, 3);
			String email = ExcelUtils.getCellData(col, 4);
			String primeiroNome = ExcelUtils.getCellData(col, 5);
			String segundoNome = ExcelUtils.getCellData(col, 6);
			String telefone = ExcelUtils.getCellData(col, 7);
			String continente = ExcelUtils.getCellData(col, 8);
			String cidade = ExcelUtils.getCellData(col, 9);
			String estado = ExcelUtils.getCellData(col, 10);
			String endereco = ExcelUtils.getCellData(col, 11);
			String codPostal = ExcelUtils.getCellData(col, 12);
			
			//teste
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
			System.out.println("suce>>>>>"+usuarioLogado);
			assertTrue(usuarioLogado);
			
			// Screenshot
			String testName = new Throwable().getStackTrace()[0].getMethodName();
			String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
			Screenshot.tirar(driver, nomeDoArquivo);
	  }
	
	
	@Test
	public void DeveTentarCadasTrarUmNovoClienteComFalha() throws Exception {
			//massa
		  	ExcelUtils.setExcelFile("CadastrarNovoCliente_Ne");
		  	int col=3;
			String nomeusuario = ExcelUtils.getCellData(col, 1);
			String senha = ExcelUtils.getCellData(col, 2);
			String Resenha = ExcelUtils.getCellData(col, 3);
			String email = ExcelUtils.getCellData(col, 4);
			String primeiroNome = ExcelUtils.getCellData(col, 5);
			String segundoNome = ExcelUtils.getCellData(col, 6);
			String telefone = ExcelUtils.getCellData(col, 7);
			String continente = ExcelUtils.getCellData(col, 8);
			String cidade = ExcelUtils.getCellData(col, 9);
			String estado = ExcelUtils.getCellData(col, 10);
			String endereco = ExcelUtils.getCellData(col, 11);
			String codPostal = ExcelUtils.getCellData(col, 12);
			
			//teste
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
			.cadastroFalhou();
		System.out.println("falha>>>>"+usuarioLogado);
		assertFalse(usuarioLogado);
		
		// Screenshot
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		String nomeDoArquivo = "evidencias\\" + Generator.dataHoraParaArquivo() + testName + ".png";
		Screenshot.tirar(driver, nomeDoArquivo);
	}

	@AfterMethod
	public void tearDown() {
		Web.fecharDriver();
	}
}
