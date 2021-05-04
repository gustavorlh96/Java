/*
 *                                      Coment�rios da classe Pessoa:
 * 
 * Nesta classe se encontra veri�veis que constituem uma pessoa no programa: Nome, quantidade de Tele Senas
 * e o valor que recebeu de premia��o ap�s o sorteio. Obs.: O uso do "SuppressWarnings" � para evitar alertas
 * do Eclipse (IDE onde desenvolvi o programa), pois aquela vari�vel s� tem uso ap�s o sorteio realizado.
 * 
*/

@SuppressWarnings("unused")
public class Pessoa {
	private String nome;
	private TeleSena[] teleSenas;
	private double premiacao;
	
	// Um m�todo inicializador das vari�veis da classe;
	public Pessoa(String nome) {
		this.nome = nome;
		this.teleSenas = new TeleSena[15];
		double premiacao = 0;
	}

	// Alguns Getters e Setters;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(double premiacao) {
		this.premiacao = premiacao;
	}

	public TeleSena[] getTeleSenas() {
		return teleSenas;
	}
	
	/* atribuiTeleSena(): Este m�todo atribui uma Tele Sena ao participante do sorteio. Se o participante atingiu
	 * o limite de Tele Senas, recebe uma mensagem;*/
	public boolean atribuiTeleSena() {
		boolean verif = false;
		for (int i = 0; i < teleSenas.length; i++) {
			if (teleSenas[i] == null) {
				TeleSena tempSena = new TeleSena();
				tempSena.registraNumeros();
				teleSenas[i] = tempSena;
				verif = true;
				break;
			}
			else {
				verif = false;
				continue;
			}
		}
		if (verif == true) {
			return verif;
		}
		else {
			System.out.println("O n�mero m�ximo de Tele Senas de " + this.nome + " foi atingido!");
			return verif;
		}
	}
	
	// retornaQuantSenas(): Conta e retorna a quantidade de Tele Senas registradas pelo participante;
	public int retornaQuantSenas() {
		int contadorIndividual = 0;
		for (int i = 0; i < teleSenas.length; i++) {
			if (teleSenas[i] != null) {
				contadorIndividual++;
			}
		}
		return contadorIndividual;
	}
	
	// contaDinheiro(): Conta e retorna o valor total de Tele Senas compradas pelo participante.
	public double contaDinheiro() {
		double contadorIndividual = 0.00;
		for (int i = 0; i < teleSenas.length; i++) {
			if (teleSenas[i] != null) {		
				contadorIndividual += teleSenas[i].getValorVenda();
			}
		}
		return contadorIndividual;
	}
}