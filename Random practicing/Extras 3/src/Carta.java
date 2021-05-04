public class Carta {
	
	private String naipe;
	private int numero;
	
	public Carta(String _naipe, int _numero) {
		this.naipe = _naipe;
		this.numero = _numero;
	}

	public String getNaipe() {
		return naipe;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String imprimeInfo() {
		return "*** Carta do jogador ***\nNúmero da carta: " + getNumero() + "\nNaipe: " + getNaipe();
	}
}
