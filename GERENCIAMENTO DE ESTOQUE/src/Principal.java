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
				System.out.println("| 2 - Memória RAM                                               |");
				System.out.println("| 3 - Placa de vídeo                                            |");
				System.out.println("| 4 - Placa mãe                                                 |");
				System.out.println("| 5 - Fonte                                                     |");
				System.out.println("| 6 - Periférico                                                |");
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
					System.out.println("[2/5] Digite uma descrição do processador: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o preço: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite o número de núcleos do processador: ");
					quantNucleos = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a frequência (em GHz) do processador: ");
					freqGhz = in.nextDouble();
					in.nextLine();
					Processador novoProcessador = new Processador(nome, descricao, preco, quantNucleos, freqGhz);
					novoEstoque.cadastraProduto(novoProcessador, nomeDoArquivo);
					System.out.println("Processador cadastrado com sucesso!");
					saindoMenu();
					break;
					
				case 2:
					espacosConsole();
					System.out.println("                --- Cadastro de memória RAM ---                  ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da RAM: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descrição da RAM: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o preço: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite a capacidade (em GB) da RAM: ");
					capacidade = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a frequência (em MHz) da RAM: ");
					freqMhz = in.nextInt();
					in.nextLine();
					MemoriaRam novaRAM = new MemoriaRam(nome, descricao, preco, capacidade, freqMhz);
					novoEstoque.cadastraProduto(novaRAM, nomeDoArquivo);
					System.out.println("Memória RAM cadastrada com sucesso!");
					saindoMenu();
					break;
					
				case 3:
					espacosConsole();
					System.out.println("               --- Cadastro de placa de vídeo ---                ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da placa de vídeo: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descrição da placa de vídeo: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o preço: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite a capacidade (em GB) da memória de vídeo: ");
					vram = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a arquitetura do chip gráfico: ");
					arquitetura = in.nextLine();
					PlacaDeVideo novaPlacaDeVideo = new PlacaDeVideo(nome, descricao, preco, vram, arquitetura);
					novoEstoque.cadastraProduto(novaPlacaDeVideo, nomeDoArquivo);
					System.out.println("Placa de vídeo cadastrada com sucesso!");
					saindoMenu();
					break;
				
				case 4:
					espacosConsole();
					System.out.println("                 --- Cadastro de placa mãe ---                   ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da placa mãe: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descrição da placa mãe: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o preço: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite o soquete da placa mãe: ");
					soquete = in.nextLine();
					System.out.println("[5/5] Digite o chipset da placa mãe: ");
					chipset = in.nextLine();
					PlacaMae novaPlacaMae = new PlacaMae(nome, descricao, preco, soquete, chipset);
					novoEstoque.cadastraProduto(novaPlacaMae, nomeDoArquivo);
					System.out.println("Placa mãe cadastrada com sucesso!");
					saindoMenu();
					break;
					
				case 5:
					espacosConsole();
					System.out.println("                   --- Cadastro de fonte ---                     ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome da fonte: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descrição da fonte: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o preço: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite a potência (em Watts) da fonte: ");
					potencia = in.nextInt();
					in.nextLine();
					System.out.println("[5/5] Digite a certificação da fonte: ");
					certificacao = in.nextLine();
					Fonte novaFonte = new Fonte(nome, descricao, preco, potencia, certificacao);
					novoEstoque.cadastraProduto(novaFonte, nomeDoArquivo);
					System.out.println("Fonte cadastrada com sucesso!");
					saindoMenu();
					break;
					
				case 6:
					espacosConsole();
					System.out.println("                --- Cadastro de periférico ---                   ");
					System.out.println("+===============================================================+");
					System.out.println("[1/5] Digite o nome do periférico: ");
					nome = in.nextLine();
					System.out.println("[2/5] Digite uma descrição do periférico: ");
					descricao = in.nextLine();
					System.out.println("[3/5] Digite o preço: ");
					preco = in.nextDouble();
					in.nextLine();
					System.out.println("[4/5] Digite o número serial do periférico: ");
					serial = in.nextLine();
					System.out.println("[5/5] Digite o código ID do periférico: ");
					id = in.nextLine();
					Periferico novoPeriferico = new Periferico(nome, descricao, preco, serial, id);
					novoEstoque.cadastraProduto(novoPeriferico, nomeDoArquivo);
					System.out.println("Periférico cadastrado com sucesso!");
					saindoMenu();
					break;
					
				default:
					saindoMenu();
					break;
				}
				break;
				
			case 2:
				espacosConsole();
				System.out.println("                   --- Remoção de produto ---                    ");
				System.out.println("+===============================================================+");
				System.out.println("|   Atenção: Caso exista mais de um produto com o mesmo nome,   |");
				System.out.println("|                    todos serão removidos!                     |");
				System.out.println("+===============================================================+");
				System.out.println("Digite o nome do produto que deseja remover do estoque: ");
				nome = in.nextLine();
				novoEstoque.removeProduto(nome, nomeDoArquivo);
				saindoMenu();
				break;
				
			case 3:
				espacosConsole();
				System.out.println("           --- Atualizar informações de um produto ---           ");
				System.out.println("+===============================================================+");
				System.out.println("|   Atenção: Caso exista um produto em estoque de mesmo nome,   |");
				System.out.println("|      será modificado aquele que for encontrado primeiro!      |");
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
				System.out.println("|   Atenção: Após limpar a lista, não será possível recuperar   |");
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
						System.out.println("ERRO: Entrada inválida, digite novamente.");
				}
				break;
				
			default:
				System.out.println("Encerrando o programa. Até mais!");
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
		System.out.println("|             Insira a opção desejada:             |");
		System.out.println("| 1 - Cadastrar um produto                         |");
		System.out.println("| 2 - Remover um produto                           |");
		System.out.println("| 3 - Atualizar informações de um produto          |");
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