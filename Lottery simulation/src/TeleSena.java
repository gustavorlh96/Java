/*
 *                                    Comentários da classe TeleSena:
 * 
 * Aqui se encontra os dois arrays responsáveis por guardar 25 números, representando os dois conjuntos da Tele Sena.
 * Também se encontra um double responsável por representar o valor de cada Tele Sena.
 * 
*/

public class TeleSena {
	private int[] conjuntoUm;
	private int[] conjuntoDois;
	private double valorVenda;
	
	// Um método inicializador das variáveis da classe;
	public TeleSena() {
		this.conjuntoUm = new int[25];
		this.conjuntoDois = new int[25];
		this.valorVenda = 10.00;
	}
	
	// Alguns Getters e Setters;
	public int[] getConjuntoUm() {
		return conjuntoUm;
	}

	public int[] getConjuntoDois() {
		return conjuntoDois;
	}

	public void setConjuntoUm(int[] conjuntoUm) {
		this.conjuntoUm = conjuntoUm;
	}

	public void setConjuntoDois(int[] conjuntoDois) {
		this.conjuntoDois = conjuntoDois;
	}

	public double getValorVenda() {
		return valorVenda;
	}
	
	/* registraNumeros(): Este método gera 25 números aleatórios de 1 a 60 e preenche os conjuntos. A cada iteração
	 * é verificado se algum número repetiu com o método verificaRepetidos() e em seguida organiza os números
	 * de forma crescente fazendo uso do algorítmo Bubble Sort;*/
	public void registraNumeros() {
		for (int i = 0; i < conjuntoUm.length; i++) {
			conjuntoUm[i] = (int) (Math.random() * 60 + 1);
			conjuntoDois[i] = (int) (Math.random() * 60 + 1);
			verificaRepetidos();
		}
		ordenaCrescente();
	}
	
	/* verificaRepetidos(): Aqui se verifica a cada iteração se houve números repetidos nos conjuntos. Se houve,
	 * ele gera um novo número aleatório de 1 a 60 para substituí-lo e re-começa a verificação para encontrar novas
	 * repetições;*/
	public void verificaRepetidos() {
		for (int i = 0; i < conjuntoUm.length; i++) {
			if (conjuntoUm[i] != 0) {
				for (int j = i + 1; j < conjuntoUm.length; j++) {
					if (conjuntoUm[i] == conjuntoUm[j]) {
						conjuntoUm[i] = (int) (Math.random() * 60 + 1);
						i = 0; j = 0; // Este é o trecho que força o laço reiniciar para re-começar a verificação!
					}
				}
			}
		}
		for (int i = 0; i < conjuntoDois.length; i++) {
			if (conjuntoDois[i] != 0) {
				for (int j = i + 1; j < conjuntoDois.length; j++) {
					if (conjuntoDois[i] == conjuntoDois[j]) {
						conjuntoDois[i] = (int) (Math.random() * 60 + 1);
						i = 0; j = 0;
					}
				}
			}
		}
	}
	
	/* ordenaCrescente(): Utilizando o algorítmo Bubble Sort, os dois conjuntos são ordenados de forma crescente.
	 * Foi criado para facilitar a comparação com os números gerados no sorteio;*/
	public void ordenaCrescente() {
		int temp = 0;
		for (int i = 0; i < conjuntoUm.length; i++) {
			for (int j = i + 1; j < conjuntoUm.length; j++) {
				if (conjuntoUm[i] > conjuntoUm[j]) {
					temp = conjuntoUm[i];
					conjuntoUm[i] = conjuntoUm[j];
					conjuntoUm[j] = temp;
				}
			}
		}
		temp = 0;
		for (int i = 0; i < conjuntoDois.length; i++) {
			for (int j = i + 1; j < conjuntoDois.length; j++) {
				if (conjuntoDois[i] > conjuntoDois[j]) {
					temp = conjuntoDois[i];
					conjuntoDois[i] = conjuntoDois[j];
					conjuntoDois[j] = temp;
				}
			}
		}
	}
}