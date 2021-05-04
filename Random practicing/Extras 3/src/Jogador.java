public class Jogador {
	
	private String nome;
	private int idade, tentativas;
	private Carta carta;
	
	public Jogador(String _nome, int _idade) {
		this.nome = _nome;
		this.idade = _idade;
		this.tentativas = 0;
		this.carta = null;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public int getTentativas() {
		return tentativas;
	}
	
	public Carta getCarta() {
		return carta;
	}

	public void pegaCarta() {
		String nomeNaipe = null;
		int numeroCarta = (int)(Math.random() * 13 + 1);
		int numeroNaipe = (int)(Math.random() * 4 + 1);
		
		switch (numeroNaipe) {
			case 1:
				nomeNaipe = "copas";
				break;
			case 2:
				nomeNaipe = "ouros";
				break;
			case 3:
				nomeNaipe = "paus";
				break;
			case 4:
				nomeNaipe = "espadas";
				break;
		}
		tentativas++;
		Carta cartaTemp = new Carta(nomeNaipe, numeroCarta);
		carta = cartaTemp;
	}
	
	public String imprimeCarta() {
		if (carta != null) {
			return carta.imprimeInfo();
		}
		else {
			return "Este jogador ainda não retirou uma carta!";
		}
	}
}