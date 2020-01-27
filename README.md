# TDD_AdvantageOnlineShopping
Teste TDD da loja online "Advantage Online Shopping"

1. Cadastrar novo Cliente
2. Acessar pagina de um produto pela Home
3. Busca de produto pela barra de busca

* Para cada senario criar Testes positivos e negativos
* Tirar print dos reultados, criar um report, criar massa de dados

++++Considerações++++

	✓ Page Objects
		✓BasePage - SuperClasse (Representa funcionalidades que todas as paginas tem em comum) com métodos de uso comuns das subclasses
		✓ProdutoPage  - Abstração da pagina de um produto generico com suas respectivas funcionalidades
		✓CadastroPage - Abstração da pagina de cadastro com suas respectivas funcionalidades
		✓CategoriaProdutoPage - Abstração de uma pagina de categoria de produtos generica
		✓ErrorProdutoPage - Abstração da pagina de item não encontrado
		✓HomePage - Abstração da home page com suas respectivas funcionalidades
		
	✓Test Cases
		✓AcessarUmProdutoPelaHome.java - simula a ação do usuário acessando a home clicando em uma categoria de produco e clicando em uma produto
									      verifica se o produto clicado é o produto esperado
		✓BuscarUmProdutoPelaBusca.java - simula a ação do usuário acessando a home clicando no campo buscar e digitando um item a ser buscado
									      verifica se o produto buscado foi encontrado
		✓CadastrarNovoCliente.java - simula a ação do usuário acessando a home clicando em usuário, nova conta, preenche os campos, clicando em registrar
									  verifica se o cliente foi cadastrado
	
	✓Suporte
		✓ExelUtils.java - classe responsável por gerir um arquivo do exel com seus gets e sets
		✓ExcelConsumer.java - classe responsável por comsumir os dados da massa
		✓Generator.java - classe responsável por gerar uma string com a data e hora atual usada no Screenshot
		✓ExtentReport.java - classe responsável por gerar um relatorio com o resultado dos testes
		✓Screenshot.java - classe responsável por tirar uma Screenshot do resultado do test
		✓Web.java - Classe responsável em gerar  WebDriver e cumprir todos os requisitos pré-teste
		
	✓Resources
		✓TDD_AdvantageOnlineShoppingData.xlsx massa de dados controlada via apache poi
		
	✓Evidencias
		✓  DataHora_nomeDoTest.png - evidencia que o teste foi realizado
	✓testng - Roda todos os testes e gera um unico report
	