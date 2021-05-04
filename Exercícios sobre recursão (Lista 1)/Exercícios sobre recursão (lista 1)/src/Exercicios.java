public class Exercicios {
		
	// Verifica se N está no array
	public boolean exercicio1(int[] array, int N) throws IllegalArgumentException {
		if (array == null) throw new IllegalArgumentException();
		return exercicio1(array, N, 0);
	}
	
	private boolean exercicio1(int[] array, int N, int i) {
		if (i >= array.length) return false;
		else if (array[i] == N) return true;
		return exercicio1(array, N, i + 1);
	}
	
	// Verifica se N é primo
	public boolean exercicio2(int N) {
		if (N <= 1) return false;
		return exercicio2(N, 2);
	}
	
	private boolean exercicio2(int N, int i) {
		if (i > N / 2) return true;
		else if (N % i == 0) return false;
		return exercicio2(N, i + 1);
	}
	
	// Inverte String
	public String exercicio3(String s) throws IllegalArgumentException {
		if (s == null) throw new IllegalArgumentException();
		return exercicio3(s, 0, "");
	}
	
	private String exercicio3(String s, int i, String reversa) {
		if (i >= s.length()) return reversa;
		reversa = s.charAt(i) + reversa;
		return exercicio3(s, i + 1, reversa);
	}
	
	// Inverte String alternativo
	public String exercicio3_alt(String s) throws IllegalArgumentException {
		if (s == null) throw new IllegalArgumentException();
		return exercicio3_alt(s, 0);
	}
	
	private String exercicio3_alt(String s, int i) {
		if (i >= s.length()) return "";
		return exercicio3_alt(s, i + 1) + s.charAt(i);
	}
	
	// Soma recursiva 1 + 1/2 + 1/3...+ 1/N
	public double exercicio4(int N) throws IllegalArgumentException {
		if (N <= 0) throw new IllegalArgumentException();
		return exercicio4 (N, 1);
	}
	
	private double exercicio4(int N, double i) {
		if (i >= N) return 1 / i;
		return 1 / i + exercicio4(N, i + 1);
	}
	
	// Palíndromo retorna true, caso contrário false.
	public boolean exercicio5(String s) throws IllegalArgumentException {
		if (s == null) throw new IllegalArgumentException();
		s = s.replaceAll("[\\\\,.?!@(){}\\[\\] \\/]", "").toLowerCase();
		return exercicio5(s, 0);
	}
	
	private boolean exercicio5(String s, int i) {
		if (i >= s.length() / 2) return true;
		return s.charAt(i) == s.charAt(s.length() - 1 - i) ? exercicio5(s, i + 1) : false;
	}
	
	// Conta quantos palíndromos acontece dentro de um array de Strings.
	public int exercicio6(String[] arrStr) throws IllegalArgumentException {
		if (arrStr == null) throw new IllegalArgumentException();
		return exercicio6(arrStr, 0);
	}
	
	private int exercicio6(String[] arrStr, int i) {
		if (i >= arrStr.length) return 0;
		return exercicio5(arrStr[i]) ? 1 + exercicio6(arrStr, i + 1) : exercicio6(arrStr, i + 1);
	}
	
	// Encontrar quantas vezes int D aparece em um int N.
	@SuppressWarnings("unused")
	private int exercicio7(int D, int N) throws IllegalArgumentException {
		if (D < 0 || N < 0 || D > 9) throw new IllegalArgumentException();
		return exercicio7_contador(D, N);
	}
	
	private int exercicio7_contador(int D, int N) {
		if (N == 0) return 0;
		return N % 10 == D ? 1 + exercicio7_contador(D, N / 10) : exercicio7_contador(D, N / 10);
	}
	
	// Mostrar a média de todos os digitos de um int
	public double exercicio8(int N) throws IllegalArgumentException {
		if (N <= 0) throw new IllegalArgumentException();
		return exercicio8(N, 0, 0);
	}
	
	private double exercicio8(int N, double soma, int i) {
		if (N == 0) return soma / i;
		return exercicio8(N / 10, soma + (N % 10), ++i);
	}
	
	// Verifica se o número é perfeito (true) ou não (false)
	public boolean exercicio9(int N) throws IllegalArgumentException {
		if (N <= 0) throw new IllegalArgumentException();
		return exercicio9(N, 0, 1);
	}
	
	private boolean exercicio9(int N, int soma, int i) {
		if (i > N / 2) return soma == N;
		return N % i == 0 ? exercicio9(N, soma + i, ++i) : exercicio9(N, soma, ++i);
	}
	
	public static void main(String[] args) {
		Exercicios teste = new Exercicios();
		
		for (int i = 1; i < 9000; i++)
			if (teste.exercicio9(i))
				System.out.println(i);
	}
}