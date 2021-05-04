import java.util.Scanner;

public class Principal {
	
	static Scanner teclado = new Scanner(System.in);
	static String nome1, nome2;
	static Jogador primeiroJogador, segundoJogador;
	static int tamanhoTabuleiro, jogada = 1;
	static JogoDaVelha novaPartida;
	static boolean flag, flagJogada;
	
	public static void main(String[] args) {
		
		System.out.println("=================== Jogo da Velha ===================");
		System.out.print("\nDigite o nome do(a) primeiro(a) jogador(a): ");
		nome1 = teclado.nextLine();
		primeiroJogador = new Jogador(nome1);
		
		System.out.print("\nDigite o nome do(a) segundo(a) jogador(a): ");
		nome2 = teclado.nextLine();
		segundoJogador = new Jogador(nome2);

		System.out.print("\nDigite a dimensão do tabuleiro (um número inteiro): ");
		tamanhoTabuleiro = teclado.nextInt();
		novaPartida = new JogoDaVelha(tamanhoTabuleiro);
		
		flagJogada = false;
		digitaJogadas();
	}
	
	public static void digitaJogadas() {
		int lin, col;
		
		System.out.println("\n*************** Que os jogos comecem! ***************");
		
		do {
			System.out.println("\n[X] " + primeiroJogador.getNome() + ", faça sua jogada: \n" + jogada + "ª jogada");
			do {
				flagJogada = false;
				System.out.println(novaPartida.toString());
				lin = 0; col = 0;
				System.out.print("\nLinha: ");
				lin = teclado.nextInt();
				teclado.nextLine(); // Aqui evita que o enter seja detectado como input!
				
				System.out.print("Coluna: ");
				col = teclado.nextInt();
				teclado.nextLine();
			    
				if (lin > tamanhoTabuleiro || col > tamanhoTabuleiro || lin < 1 || col < 1)
					System.out.println("\nJogada inválida (excedeu tamanho da matriz)! Digite novamente: ");
				else {
					flagJogada = novaPartida.realizaJogada(lin, col, 'X');
					
					if (flagJogada == false) 
						System.out.println("\nA posição escolhida já está ocupada! Tente novamente: ");
					else
						jogada++;
				}	
			} while (flagJogada == false);
			
			flag = novaPartida.verificaGanhador();
			if (flag == true) {
				System.out.println("\n*************** Fim de jogo! ***************");
				System.out.println(novaPartida.toString());
				int pontos = primeiroJogador.getPontos(); pontos++; primeiroJogador.setPontos(pontos);
				System.out.println(primeiroJogador.getNome() + " venceu a rodada!");
				verificaNovaRodada();
				break;
			}
			
			flag = novaPartida.verificaEmpate();
			if (flag == true) {
				System.out.println("\n*************** Fim de jogo! ***************");
				System.out.println(novaPartida.toString());
				System.out.println("Jogo empatado!");
				verificaNovaRodada();
				break;
			}
			
			System.out.println("\n[O] " + segundoJogador.getNome() + ", faça sua jogada: \n" + jogada + "ª jogada");
			do {
				flagJogada = false;
				System.out.println(novaPartida.toString());
				lin = 0; col = 0;
				System.out.print("\nLinha: ");
				lin = teclado.nextInt();
				teclado.nextLine();
				
				System.out.print("Coluna: ");
				col = teclado.nextInt();
				teclado.nextLine();
			    
				if (lin > tamanhoTabuleiro || col > tamanhoTabuleiro || lin < 1 || col < 1)
					System.out.println("\nJogada inválida (excedeu tamanho da matriz)! Digite novamente: ");
				else {
					flagJogada = novaPartida.realizaJogada(lin, col, 'O');
					
					if (flagJogada == false) 
						System.out.println("\nA posição escolhida já está ocupada! Tente novamente: ");
					else
						jogada++;
				}	
			} while (flagJogada == false);
			
			flag = novaPartida.verificaGanhador();
			if (flag == true) {
				System.out.println("\n*************** Fim de jogo! ***************");
				System.out.println(novaPartida.toString());
				int pontos = segundoJogador.getPontos(); pontos++; segundoJogador.setPontos(pontos);
				System.out.println(segundoJogador.getNome() + " venceu a rodada!");
				verificaNovaRodada();
				break;
			}
			
			flag = novaPartida.verificaEmpate();
			if (flag == true) {
				System.out.println("\n*************** Fim de jogo! ***************");
				System.out.println(novaPartida.toString());
				System.out.println("Jogo empatado!");
				verificaNovaRodada();
				break;
			}
			
		} while (flag == false);
	}
	
	public static void verificaNovaRodada() {
		flag = false;
		do {
			System.out.println("Desejam jogar novamente (S/N)?");
			String simOuNao = teclado.nextLine();
			do {
				if (simOuNao.equalsIgnoreCase("S")) {
					novaPartida = null; // Aqui reseta o objeto da partida!
					novaPartida = new JogoDaVelha(tamanhoTabuleiro);
					jogada = 1;
					digitaJogadas();
					break;
				}
				else if (simOuNao.equalsIgnoreCase("N")) {
					if (primeiroJogador.getPontos() > segundoJogador.getPontos()) 
						System.out.println(primeiroJogador.getNome() + " ganhou o jogo com " + primeiroJogador.getPontos() + " ponto(s)!");
					else if (segundoJogador.getPontos() > primeiroJogador.getPontos()) 
						System.out.println(segundoJogador.getNome() + " ganhou o jogo com " + segundoJogador.getPontos() + " ponto(s)!");
					else 
						System.out.println("Jogo finalizado empatado!");
					flag = true;
				}
				else 
					System.out.println("Entrada inválida! Digite novamente (S/N): ");
			} while (simOuNao.equalsIgnoreCase("S"));
		} while (flag == false);
	}
}