/*
 *                                    Coment�rios da classe TeleSena:
 * 
 * Aqui se encontra os dois arrays respons�veis por guardar 25 n�meros, representando os dois conjuntos da Tele Sena.
 * Tamb�m se encontra um double respons�vel por representar o valor de cada Tele Sena.
 * 
*/

public class TeleSena {
	private int[] conjuntoUm;
	private int[] conjuntoDois;
	private double valorVenda;
	
	// Um m�todo inicializador das vari�veis da classe;
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
	
	/* registraNumeros(): Este m�todo gera 25 n�meros aleat�rios de 1 a 60 e preenche os conjuntos. A cada itera��o
	 * � verificado se algum n�mero repetiu com o m�todo verificaRepetidos() e em seguida organiza os n�meros
	 * de forma crescente fazendo uso do algor�tmo Bubble Sort;*/
	public void registraNumeros() {
		for (int i = 0; i < conjuntoUm.length; i++) {
			conjuntoUm[i] = (int) (Math.random() * 60 + 1);
			conjuntoDois[i] = (int) (Math.random() * 60 + 1);
			verificaRepetidos();
		}
		ordenaCrescente();
	}
	
	/* verificaRepetidos(): Aqui se verifica a cada itera��o se houve n�meros repetidos nos conjuntos. Se houve,
	 * ele gera um novo n�mero aleat�rio de 1 a 60 para substitu�-lo e re-come�a a verifica��o para encontrar novas
	 * repeti��es;*/
	public void verificaRepetidos() {
		for (int i = 0; i < conjuntoUm.length; i++) {
			if (conjuntoUm[i] != 0) {
				for (int j = i + 1; j < conjuntoUm.length; j++) {
					if (conjuntoUm[i] == conjuntoUm[j]) {
						conjuntoUm[i] = (int) (Math.random() * 60 + 1);
						i = 0; j = 0; // Este � o trecho que for�a o la�o reiniciar para re-come�ar a verifica��o!
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
	
	/* ordenaCrescente(): Utilizando o algor�tmo Bubble Sort, os dois conjuntos s�o ordenados de forma crescente.
	 * Foi criado para facilitar a compara��o com os n�meros gerados no sorteio;*/
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