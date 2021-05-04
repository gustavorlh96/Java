/*
 *                                     Comentários da classe Principal:
 * 
 * Esta é a classe principal, ou seja, aquela que faz todas as chamadas dos métodos das outras classes para uso
 * final. Desenvolvi um menu inicial que entrega três opções: A primeira, iniciar um menu onde cada participante
 * da Tele Sena é cadastrado de forma manual, com opções manuais para visualizar os lucros, prêmios, realizar
 * um novo concurso, etc. A cada tarefa executada, um timer é iniciado, que varia de 10 a 3 segundos. A segunda
 * opção imprime na tela todos os requisitos do trabalho de forma automática, com 20 participantes predefinidos,
 * cada um com uma Tele Sena. Nesta segunda opção existe um intervalo de 2 segundos a cada passo executado. Por
 * fim, a terceira opção encerra o programa. Algumas mensagens que não eram apresentadas nas outras classes, são
 * apresentadas aqui de acordo com as condições, como adicionar um novo comprador se o array de pessoas estiver
 * cheio, retorna uma mensagem. Esta classe contém uma variável estática do tipo int que serve para sinalizar
 * qual edição do sorteio que está sendo realizado na opção 1 do menu principal. Obs.: O uso do
 * "SuppressWarnings" é para evitar alertas do Eclipse (IDE onde desenvolvi o programa), pois aquela variável
 * só tem uso após o sorteio realizado.
 * 
*/

import java.util.Scanner;

@SuppressWarnings({"unused", "resource"})
public class Principal {
	
	public static int edicaoSorteio = 1; // Este é o contador estático que indica qual edição
										 // do sorteio está ocorrendo!
	
	// main(...): Inicializa o programa e imprime o primeiro menu;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("          *** Trabalho do GB: Tele Sena ***         ");
		System.out.println("       --- Prof. Gabriel de Oliveira Ramos ---      ");
		System.out.println("   --- Criado por Gustavo Rodrigues Lima Haag ---   ");
		System.out.println("+==================================================+");
		System.out.println("| Digite como deseja executar o programa:          |");
		System.out.println("| 1 - Com menu e entradas manuais                  |");
		System.out.println("| 2 - Automático e com 20 pessoas predefinidas     |");
		System.out.println("| 3 - Sair                                         |");
		System.out.println("+==================================================+");
		
		int escolha = in.nextInt();
		in.nextLine();
		
		loop: while (true) {
			switch (escolha) {
					case 1:
						testePrincipal();
						break loop;
					case 2:
						testeAutomatico();
						break loop;
					default:
						System.out.print("Encerrando o programa em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break loop;		
			}
		}
	}

	// testeAutomatico(): Este é o método executado ao selecionar a opção 2 do menu principal;
	public static void testeAutomatico() {
		
		Pessoa p1 = new Pessoa("Helena Souza");
		Pessoa p2 = new Pessoa("Miguel Lima");
		Pessoa p3 = new Pessoa("Alice da Silva");
		Pessoa p4 = new Pessoa("Arthur de Oliveira");
		Pessoa p5 = new Pessoa("Laura Monteiro");
		Pessoa p6 = new Pessoa("Heitor Castro");
		Pessoa p7 = new Pessoa("Manuela Freitas");
		Pessoa p8 = new Pessoa("Bernardo Lopes");
		Pessoa p9 = new Pessoa("Valentina da Rocha");
		Pessoa p10 = new Pessoa("Sophia Gonçalves");
		Pessoa p11 = new Pessoa("Théo Nunes");
		Pessoa p12 = new Pessoa("Isabella Gomes");
		Pessoa p13 = new Pessoa("Lorenzo Campos");
		Pessoa p14 = new Pessoa("Heloísa Martins");
		Pessoa p15 = new Pessoa("Gabriel Teixeira");
		Pessoa p16 = new Pessoa("Luiza de Moraes");
		Pessoa p17 = new Pessoa("Pedro Vieira");
		Pessoa p18 = new Pessoa("Júlia Reis");
		Pessoa p19 = new Pessoa("Benjamin Ferreira");
		Pessoa p20 = new Pessoa("Lorena da Costa");
		
		ControleTeleSena ct1 = new ControleTeleSena();
		
		ct1.registraPessoa(p1);
		ct1.registraPessoa(p2);
		ct1.registraPessoa(p3);
		ct1.registraPessoa(p4);
		ct1.registraPessoa(p5);
		ct1.registraPessoa(p6);
		ct1.registraPessoa(p7);
		ct1.registraPessoa(p8);
		ct1.registraPessoa(p9);
		ct1.registraPessoa(p10);
		ct1.registraPessoa(p11);
		ct1.registraPessoa(p12);
		ct1.registraPessoa(p13);
		ct1.registraPessoa(p14);
		ct1.registraPessoa(p15);
		ct1.registraPessoa(p16);
		ct1.registraPessoa(p17);
		ct1.registraPessoa(p18);
		ct1.registraPessoa(p19);
		ct1.registraPessoa(p20);
		
		System.out.println("          --- Número de Tele Senas vendidas ---          ");
		System.out.println("+=======================================================+");
		ct1.quantTeleVendidas();
		System.out.println("+=======================================================+\n");
		
		try {
			Thread.sleep(2000);
			} catch (Exception e) {}
		
		ct1.sorteioTelaSena();
		
		System.out.println("--- Participante(s) premiado(s). Parabéns ao(s) ganhador(es)! ---");
		System.out.println("+===============================================================+");
		ct1.infoPremios();
		System.out.println("+=============================================================+\n");
		
		try {
			Thread.sleep(2000);
			} catch (Exception e) {}
		
		System.out.println("   --- $$$ Valor total das Tele Senas vendidas $$$ ---   ");
		System.out.println("+=======================================================+");
		System.out.println("R$ " + (ct1.quantTeleVendidas() * 10.00) + " reais em Tele Senas vendidas.");
		System.out.println("+=======================================================+\n");
		
		try {
			Thread.sleep(2000);
			} catch (Exception e) {}
		
		System.out.println("                  --- $$$ Lucros $$$ ---                 ");
		System.out.println("+=======================================================+");
		ct1.infoLucros();
		System.out.println("+=======================================================+\n");
	}
	
	/* testePrincipal(): Este método é executado ao selecionar a opção 1 do menu principal. Aqui existem mensagens
	 * específicas para algumas condições e também chama o menu com as opções manuais;*/
	public static void testePrincipal() {
		Scanner in = new Scanner(System.in);
		ControleTeleSena novaEdicao = new ControleTeleSena();
		
		loop: while (true) {
			imprimeMenu();
			int opcao = in.nextInt();
			in.nextLine();
			
			switch (opcao) {
					case 1:
						espacosConsole();
						System.out.println("               --- Registrador de compradores ---                ");
						System.out.println("+===============================================================+");
						System.out.println("Digite o nome do(a) comprador(a): ");
						String nome = in.nextLine();
						Pessoa comprador = new Pessoa(nome);
						
						boolean flagComp;
						if (flagComp = novaEdicao.registraPessoa(comprador) == true) {
							System.out.println("Comprador registrado com sucesso!");
						}
						else {
							System.out.println("Não é possível adicionar mais compradores!");
						}
						
						System.out.println("+===============================================================+");
						System.out.print("Saindo em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
						
					case 2:
						espacosConsole();
						System.out.println("              --- Comprar Tele Senas adicionais ---              ");
						System.out.println("+===============================================================+");
						boolean flagTele;
						
						if (flagTele = novaEdicao.vendaTeleSena() == true) {
							System.out.println("Tele Sena registrada com sucesso!");
						}
						System.out.println("+===============================================================+");
						System.out.print("Saindo em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
						
					case 3:
						espacosConsole();
						novaEdicao.quantTeleVendidas();
						System.out.println("+===============================================================+");
						System.out.print("Saindo em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
						
					case 4:
						espacosConsole();
						System.out.println("                   --- Sorteio! MAH OE!!! ---                    ");
						System.out.println("+===============================================================+");
						novaEdicao.limpaPremios();
						novaEdicao.sorteioTelaSena();
						novaEdicao.infoPremios();
						System.out.println("+===============================================================+");
						System.out.print("Saindo em ");
						for (int i = 10; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
						
					case 5:
						espacosConsole();
						System.out.println("--- Participante(s) premiado(s). Parabéns ao(s) ganhador(es)! ---");
						System.out.println("+===============================================================+");
						novaEdicao.infoPremios();
						System.out.println("+===============================================================+");
						System.out.print("Saindo em ");
						for (int i = 10; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
						
					case 6:
						espacosConsole();
						System.out.println("                      --- $$$ Lucros $$$ ---                     ");
						System.out.println("+===============================================================+");
						novaEdicao.infoLucros();
						System.out.println("+===============================================================+");
						System.out.print("Saindo em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
						
					case 7:
						espacosConsole();
						System.out.println("                  --- Até a próxima edição! ---                  ");
						System.out.println("+===============================================================+");
						novaEdicao = null;
						novaEdicao = new ControleTeleSena();
						edicaoSorteio++;
						System.out.print("Próxima edição inicia em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break;
					
					default:
						espacosConsole();
						System.out.println("                        --- Até mais! ---                        ");
						System.out.println("+===============================================================+");
						System.out.print("Encerrando o programa em ");
						for (int i = 4; i > 0; i--) {
							try {
								Thread.sleep(1000);
								} catch (Exception e) {}
							System.out.print(i - 1 + "...");
						}
						break loop;
			}
		}
	}
	
	// imprimeMenu(): Imprime na tela o menu da opção 1;
	public static void imprimeMenu() {
		espacosConsole();
		System.out.println("\t*** " + edicaoSorteio + "º sorteio da Tele Sena! ***");
		System.out.println("+==================================================+");
		System.out.println("| Digite a opção desejada:                         |");
		System.out.println("| 1 - Registrar compradores                        |");
		System.out.println("| 2 - Comprar Tele Senas adicionais                |");
		System.out.println("| 3 - Ver Nº de Tele Senas vendidas                |");
		System.out.println("| 4 - Realizar sorteio                             |");
		System.out.println("| 5 - Ver os participantes premiados               |");
		System.out.println("| 6 - Ver lucros                                   |");
		System.out.println("| 7 - Ir para a próxima edição (resetar)           |");
		System.out.println("| 8 - Sair                                         |");
		System.out.println("+==================================================+");
	}
	
	/* espacosConsole(): Este método é chamado em vários momentos nessa classe. A função dele é dar o distanciamento
	 * de 50 linhas entre certas tarefas executadas para evitar a poluição visual no console.*/
	public static void espacosConsole() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
}