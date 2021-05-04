import java.util.Scanner;

public class Main {
	
	static int scoreUm = 0, scoreDois = 0;
	static String nomeUm = null, nomeDois = null;
	static boolean flag = false;
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		
		System.out.println("\t\t*** PEDRA, PAPEL, TESOURA, LAGARTO, SPOCK ***");
		System.out.println("Digite o nome do(a) primeiro(a) jogador(a): ");
		nomeUm = in.nextLine();
		System.out.println("Digite o nome do(a) segundo(a) jogador(a): ");
		nomeDois = in.nextLine();
		
		digitaJogadas();
	}
			
	@SuppressWarnings("resource")
	public static void digitaJogadas() {
		Scanner in = new Scanner(System.in);
		
		String jogadaUm = null, jogadaDois = null;
		System.out.println("Digite a jogada de " + nomeUm + ": ");
		do {
			jogadaUm = in.nextLine();
			
			if (jogadaUm.equalsIgnoreCase("Pedra") || jogadaUm.equalsIgnoreCase("Papel")
				|| jogadaUm.equalsIgnoreCase("Tesoura") || jogadaUm.equalsIgnoreCase("Lagarto")
			    || jogadaUm.equalsIgnoreCase("Spock")) {
			    	flag = true;
			}
			else {
				System.out.println("Jogada inválida! Digite novamente: ");
			}
			
		} while (flag == false);
		
		flag = false;
		
		System.out.println("Digite a jogada de " + nomeDois + ": ");
		do {
			jogadaDois = in.nextLine();
			
			if (jogadaDois.equalsIgnoreCase("Pedra") || jogadaDois.equalsIgnoreCase("Papel")
				|| jogadaDois.equalsIgnoreCase("Tesoura") || jogadaDois.equalsIgnoreCase("Lagarto")
			    || jogadaDois.equalsIgnoreCase("Spock")) {
			    	flag = true;
			}
			else {
				System.out.println("Jogada inválida! Digite novamente: ");
			}
			
		} while (flag == false);
		
    	novasJogadas(jogadaUm, jogadaDois);
	}
	
	public static void novaRodada() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		flag = false;
		do {
			//digitaJogadas();
			//novasJogadas();
			
			System.out.println("Desejam jogar novamente (S/N)?");
			String simOuNao = in.nextLine();
			do {
				if (simOuNao.equalsIgnoreCase("S")) {
					digitaJogadas();
					break;
				}
				else if (simOuNao.equalsIgnoreCase("N")) {
					if (scoreUm > scoreDois) {
						System.out.println(nomeUm + " ganhou o jogo com " + scoreUm + " vitória(s)!");
					}
					else if (scoreDois > scoreUm) {
						System.out.println(nomeDois + " ganhou o jogo com " + scoreDois + " vitória(s)!");
					}
					else {
						System.out.println("Jogo finalizado empatado!");
					}
					flag = true;
				}
				else {
					System.out.println("Entrada inválida! Digite novamente (S/N): ");
				}
			} while (simOuNao.equalsIgnoreCase("S"));
		} while (flag == false);
	}
	
	// Aqui pode ser polido, utilizando menos if's e incluindo case switch;
	public static void novasJogadas(String jogadaUm, String jogadaDois) {
		// Tesoura vs papel
		if (jogadaUm.equalsIgnoreCase("Tesoura") && jogadaDois.equalsIgnoreCase("Papel")) {
			System.out.println("Tesoura corta papel! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Tesoura") && jogadaUm.equalsIgnoreCase("Papel")) {
			System.out.println("Tesoura corta papel! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Papel vs pedra
		else if (jogadaUm.equalsIgnoreCase("Papel") && jogadaDois.equalsIgnoreCase("Pedra")) {
			System.out.println("Papel cobre pedra! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Papel") && jogadaUm.equalsIgnoreCase("Pedra")) {
			System.out.println("Papel cobre pedra! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Pedra vs lagarto
		else if (jogadaUm.equalsIgnoreCase("Pedra") && jogadaDois.equalsIgnoreCase("Lagarto")) {
			System.out.println("Pedra esmaga lagarto! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Pedra") && jogadaUm.equalsIgnoreCase("Lagarto")) {
			System.out.println("Pedra esmaga lagarto! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Lagarto vs spock
		else if (jogadaUm.equalsIgnoreCase("Lagarto") && jogadaDois.equalsIgnoreCase("Spock")) {
			System.out.println("Lagarto envenena Spock! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Lagarto") && jogadaUm.equalsIgnoreCase("Spock")) {
			System.out.println("Lagarto envenena Spock! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Spock vs tesoura
		else if (jogadaUm.equalsIgnoreCase("Spock") && jogadaDois.equalsIgnoreCase("Tesoura")) {
			System.out.println("Spock quebra tesoura! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Spock") && jogadaUm.equalsIgnoreCase("Tesoura")) {
			System.out.println("Spock quebra tesoura! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Tesoura vs lagarto
		else if (jogadaUm.equalsIgnoreCase("Tesoura") && jogadaDois.equalsIgnoreCase("Lagarto")) {
			System.out.println("Tesoura decapita lagarto! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Tesoura") && jogadaUm.equalsIgnoreCase("Lagarto")) {
			System.out.println("Tesoura decapita lagarto! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Lagarto vs papel
		else if (jogadaUm.equalsIgnoreCase("Lagarto") && jogadaDois.equalsIgnoreCase("Papel")) {
			System.out.println("Lagarto come papel! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Lagarto") && jogadaUm.equalsIgnoreCase("Papel")) {
			System.out.println("Lagarto come papel! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Papel vs spock
		else if (jogadaUm.equalsIgnoreCase("Papel") && jogadaDois.equalsIgnoreCase("Spock")) {
			System.out.println("Papel desaprova Spock! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Papel") && jogadaUm.equalsIgnoreCase("Spock")) {
			System.out.println("Papel desaprova Spock! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Spock vs pedra
		else if (jogadaUm.equalsIgnoreCase("Spock") && jogadaDois.equalsIgnoreCase("Pedra")) {
			System.out.println("Spock vaporiza pedra! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Spock") && jogadaUm.equalsIgnoreCase("Pedra")) {
			System.out.println("Spock vaporiza pedra! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		// Pedra vs tesoura
		else if (jogadaUm.equalsIgnoreCase("Pedra") && jogadaDois.equalsIgnoreCase("Tesoura")) {
			System.out.println("Pedra destrói tesoura! " + nomeUm + " vence!");
			scoreUm++;
		}
		else if (jogadaDois.equalsIgnoreCase("Pedra") && jogadaUm.equalsIgnoreCase("Tesoura")) {
			System.out.println("Pedra destrói tesoura! " + nomeDois + " vence!");
			scoreDois++;
		}
		
		else {
			System.out.println("Ops! Algo de errado deve ter ocorrido!");
		}
		novaRodada();
	}
}