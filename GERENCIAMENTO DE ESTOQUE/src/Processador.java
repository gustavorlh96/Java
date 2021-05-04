public class Processador extends Produto {
	
	private int quantNucleos;
	private double freqGhz;
	
	public Processador(String _nome, String _descricao, double _preco, int quantNucleos, double freqGhz) {
		super(_nome, _descricao, _preco);
		this.quantNucleos = quantNucleos;
		this.freqGhz = freqGhz;
	}

	public int getQuantNucleos() {
		return quantNucleos;
	}

	public void setQuantNucleos(int quantNucleos) {
		this.quantNucleos = quantNucleos;
	}

	public double getFreqGhz() {
		return freqGhz;
	}

	public void setFreqGhz(double freqGhz) {
		this.freqGhz = freqGhz;
	}

	public String toString() {
		return "[Processador]\nNome: " + getNome() + "\nDescri��o: " + getDescricao() + "\nPre�o: R$ " + getPreco()
				+ " reais\nN� de n�cleos: " + getQuantNucleos() + "\nFrequ�ncia: " + getFreqGhz() + "GHz";
	}
}