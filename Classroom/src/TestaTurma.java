import java.util.Scanner;

public class TestaTurma {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o tamanho do array: ");
		int ta1 = in.nextInt();
		
		Turma t1 = new Turma("Nome Turma", ta1);
		
		double nota = 0;
		for (int i = 0; i < ta1; i++) {
			nota = (double) (Math.random() * 11); // Aqui gera um double aleatório de 0 a 10.
			t1.insert(nota);
		}
		
		t1.toString();
		System.out.println("" + t1.toString());
		System.out.println(t1.calculaMedia());
	}
}