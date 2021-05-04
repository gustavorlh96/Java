import java.util.Scanner;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean flag = false;
		
		System.out.println("Digite o nome e idade do(a) primeiro(a) jogador(a): ");
		String n1 = in.nextLine();
		int i1 = in.nextInt();
		in.nextLine();
		
		Jogador j1 = new Jogador(n1, i1);
		
		System.out.println("Digite o nome e idade do(a) segundo(a) jogador(a): ");
		String n2 = in.nextLine();
		int i2 = in.nextInt();
		in.nextLine();
		
		Jogador j2 = new Jogador(n2, i2);
		
		System.out.println("Digite o nome e idade do(a) terceiro(a) jogador(a): ");
		String n3 = in.nextLine();
		int i3 = in.nextInt();
		in.nextLine();
		
		Jogador j3 = new Jogador(n3, i3);
		
		do {
			j1.pegaCarta();
			
			if (j1.getCarta().getNaipe().equals("ouros") && j1.getCarta().getNumero() == 7) {
				flag = true;
			}
			else {
				continue;
			}
		} while (flag == false);
		
		flag = false;
		
		do {
			j2.pegaCarta();
			
			if (j2.getCarta().getNaipe().equals("ouros") && j2.getCarta().getNumero() == 7) {
				flag = true;
			}
			else {
				continue;
			}
		} while (flag == false);
		
		flag = false;
		
		do {
			j3.pegaCarta();
			
			if (j3.getCarta().getNaipe().equals("ouros") && j3.getCarta().getNumero() == 7) {
				flag = true;
			}
			else {
				continue;
			}
		} while (flag == false);
		
		if (j1.getTentativas() < j2.getTentativas() && j1.getTentativas() < j3.getTentativas()) {
			System.out.print("O(A) jogador(a) " + j1.getNome() + " de " + j1.getIdade()
							+ " anos pegou o 7 de ouros em menos tentativas! Total: " + j1.getTentativas());
		}
		else if (j2.getTentativas() < j1.getTentativas() && j2.getTentativas() < j3.getTentativas()) {
			System.out.print("O(A) jogador(a) " + j2.getNome() + " de " + j2.getIdade()
							+ " anos pegou o 7 de ouros em menos tentativas! Total: " + j2.getTentativas());
		}
		else if (j3.getTentativas() < j1.getTentativas() && j3.getTentativas() < j2.getTentativas()) {
			System.out.print("O(A) jogador(a) " + j3.getNome() + " de " + j3.getIdade()
							+ " anos pegou o 7 de ouros em menos tentativas! Total: " + j3.getTentativas());
		}
		
		System.out.println("\n*** Estatísticas de jogo ***\nTentativas jogador(a) 1: "
							+ j1.getTentativas() + "\nTentativas jogador(a) 2: "
							+ j2.getTentativas() + "\nTentativas jogador(a) 3: "
							+ j3.getTentativas());
	}
}