import java.io.IOException;
import java.util.Scanner;

public class Principal {
	
	static Scanner in = new Scanner(System.in);
	static String nomeDoArquivo = "default";

	public static void main(String[] args) throws IOException, IllegalArgumentException, ProdutoNaoEncontradoException {	
		testePrincipal();
	}
	
	private static void testePrincipal() throws IOException {
		Estoque novoEstoque = new Estoque();
		novoEstoque.preencheEstoque(nomeDoArquivo);
		novoEstoque.ordenaEstoque(nomeDoArquivo);
		
		String nome, descricao, arquitetura, soquete, chipset, certificacao, serial, id;
		double preco, freqGhz;
		int quantNucleos, capacidade, freqMhz, vram, potencia;
		
		loop: while (true) {
			imprimeMenu();
			int opcao = in.nextInt();
			in.nextLine();
			
			switch (opcao) {
			case 1:
				espacosConsole();
				System.out.println("                   --- Cadastro de produto ---                   ");
				System.out.println("+===============================================================+");
				System.out.println("|           Escolha o tipo de produto para cadastrar:           |");
				System.out.println("| 1 - Processador                                               |");
				System.out.println("| 2 - Mem�ria RAM                                               |");
				System.out.println("| 3 - Placa de v�deo                                            |");
				System.out.println("| 4 - Placa m�e                                                 |");
				System.out.println("| 5 - Fonte                                                     |");
				System.out.println("| 6 - Perif�rico                                                |");
				System.out.println("| 7 - Voltar ao menu anterior                                   |");
				System.out.println("+===============================================================+");
				int opcaoCadastro = in.nextInt();
				in.nextLine();
				
				switch (opcaoCadastro) {
				case 1:
					espacosConsole();
					System.out.println("                --- Cadastro de processador ---                  ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome do processador: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descri��o do processador: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o pre�o: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite o n�mero de n�cleos do processador: ");
					quantNucleos = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a frequ�ncia (em GHz) do processador: ");
					freqGhz = in.nextDouble();
					in.nextLine();
					Processador novoProcessador = new Processador(nome, descricao, preco, quantNucleos, freqGhz);
					novoEstoque.cadastraProduto(novoProcessador, nomeDoArquivo);
					System.out.println("Processador cadastrado com sucesso!");
					saindoMenu();
					break;
					
				case 2:
					espacosConsole();
					System.out.println("                --- Cadastro de mem�ria RAM ---                  ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da RAM: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descri��o da RAM: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o pre�o: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite a capacidade (em GB) da RAM: ");
					capacidade = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a frequ�ncia (em MHz) da RAM: ");
					freqMhz = in.nextInt();
					in.nextLine();
					MemoriaRam novaRAM = new MemoriaRam(nome, descricao, preco, capacidade, freqMhz);
					novoEstoque.cadastraProduto(novaRAM, nomeDoArquivo);
					System.out.println("Mem�ria RAM cadastrada com sucesso!");
					saindoMenu();
					break;
					
				case 3:
					espacosConsole();
					System.out.println("               --- Cadastro de placa de v�deo ---                ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da placa de v�deo: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descri��o da placa de v�deo: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o pre�o: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite a capacidade (em GB) da mem�ria de v�deo: ");
					vram = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a arquitetura do chip gr�fico: ");
					arquitetura = in.nextLine();
					PlacaDeVideo novaPlacaDeVideo = new PlacaDeVideo(nome, descricao, preco, vram, arquitetura);
					novoEstoque.cadastraProduto(novaPlacaDeVideo, nomeDoArquivo);
					System.out.println("Placa de v�deo cadastrada com sucesso!");
					saindoMenu();
					break;
				
				case 4:
					espacosConsole();
					System.out.println("                 --- Cadastro de placa m�e ---                   ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da placa m�e: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descri��o da placa m�e: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o pre�o: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite o soquete da placa m�e: ");
					soquete = in.nextLine();
					System.out.println("[5/5] Digite o chipset da placa m�e: ");
					chipset = in.nextLine();
					PlacaMae novaPlacaMae = new PlacaMae(nome, descricao, preco, soquete, chipset);
					novoEstoque.cadastraProduto(novaPlacaMae, nomeDoArquivo);
					System.out.println("Placa m�e cadastrada com sucesso!");
					saindoMenu();
					break;
					
				case 5:
					espacosConsole();
					System.out.println("                   --- Cadastro de fonte ---                     ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da fonte: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descri��o da fonte: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o pre�o: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite a pot�ncia (em Watts) da fonte: ");
					potencia = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a certifica��o da fonte: ");
					certificacao = in.nextLine();
					Fonte novaFonte = new Fonte(nome, descricao, preco, potencia, certificacao);
					novoEstoque.cadastraProduto(novaFonte, nomeDoArquivo);
					System.out.println("Fonte cadastrada com sucesso!");
					saindoMenu();
					break;
					
				case 6:
					espacosConsole();
					System.out.println("                --- Cadastro de perif�rico ---                   ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome do perif�rico: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descri��o do perif�rico: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o pre�o: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite o n�mero serial do perif�rico: ");
					serial = in.nextLine();
					System.out.println("[5/5] Digite o c�digo ID do perif�rico: ");
					id = in.nextLine();
					Periferico novoPeriferico = new Periferico(nome, descricao, preco, serial, id);
					novoEstoque.cadastraProduto(novoPeriferico, nomeDoArquivo);
					System.out.println("Perif�rico cadastrado com sucesso!");
					saindoMenu();
					break;
					
				default:
					saindoMenu();
					break;
				}
				break;
				
			case 2:
				espacosConsole();
				System.out.println("                   --- Remo��o de produto ---                    ");
				System.out.println("+===============================================================+");
				System.out.println("|   Aten��o: Caso exista mais de um produto com o mesmo nome,   |");
				System.out.println("|                    todos ser�o removidos!                     |");
				System.out.println("+===============================================================+");
				System.out.println("Digite o nome do produto que deseja remover do estoque: ");
				nome = in.nextLine();
				novoEstoque.removeProduto(nome, nomeDoArquivo);
				saindoMenu();
				break;
				
			case 3:
				espacosConsole();
				System.out.println("           --- Atualizar informa��es de um produto ---           ");
				System.out.println("+===============================================================+");
				System.out.println("|   Aten��o: Caso exista um produto em estoque de mesmo nome,   |");
				System.out.println("|      ser� modificado aquele que for encontrado primeiro!      |");
				System.out.println("+===============================================================+");
				System.out.println("Digite o nome do produto que deseja atualizar: ");
				nome = in.nextLine();
				novoEstoque.buscaProduto(nome, nomeDoArquivo);
				saindoMenu();
				break;
				
			case 4:
				espacosConsole();
				System.out.println("                        --- Produtos cadastrados ---                          ");
				System.out.println("+============================================================================+");
				novoEstoque.listaCadastrados();
				System.out.println("Pressione ENTER para continuar.");
				in.nextLine();
				saindoMenu();
				break;
				
			case 5:
				espacosConsole();
				System.out.println("                 --- Limpar lista de estoque ---                 ");
				System.out.println("+===============================================================+");
				System.out.println("|   Aten��o: Ap�s limpar a lista, n�o ser� poss�vel recuperar   |");
				System.out.println("|        os produtos deletados. Deseja prosseguir [S/N]?        |");
				System.out.println("+===============================================================+");
				while (true) {
					String opcaoLimpa = in.nextLine();
					if (opcaoLimpa.equalsIgnoreCase("s")) {
						novoEstoque.limpaLista(nomeDoArquivo);
						System.out.println("Lista limpa com sucesso!");
						saindoMenu();
						break;
					}
					else if (opcaoLimpa.equalsIgnoreCase("n")) {
						saindoMenu();
						break;
					}
					else
						System.out.println("ERRO: Entrada inv�lida, digite novamente.");
				}
				break;
				
			default:
				System.out.println("Encerrando o programa. At� mais!");
				saindoMenu();
				break loop;
			}
		}
	}

	private static void imprimeMenu() {
		espacosConsole();
		System.out.println("  *** Trabalho do GA: Gerenciamento de Estoque ***  ");
		System.out.println("             --- Prof. Mateus Raeder ---            ");
		System.out.println("   --- Criado por Gustavo Rodrigues Lima Haag ---   ");
		System.out.println("+==================================================+");
		System.out.println("|             Insira a op��o desejada:             |");
		System.out.println("| 1 - Cadastrar um produto                         |");
		System.out.println("| 2 - Remover um produto                           |");
		System.out.println("| 3 - Atualizar informa��es de um produto          |");
		System.out.println("| 4 - Listar produtos cadastrados                  |");
		System.out.println("| 5 - Limpar lista de estoque                      |");
		System.out.println("| 6 - Sair                                         |");
		System.out.println("+==================================================+");
	}

	public static void espacosConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
	
	public static void saindoMenu() {
		System.out.print("Saindo do menu em ");
		for (int i = 4; i > 1; i--) {
			try {
				Thread.sleep(1000);
				} catch (Exception e) {}
			System.out.print(i - 1 + "...");
		}
	}
}