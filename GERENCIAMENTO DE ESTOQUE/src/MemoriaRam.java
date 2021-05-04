public class MemoriaRam extends Produto {

	private int capacidade, freqMhz;

	public MemoriaRam(String _nome, String _descricao, double _preco, int capacidade, int freqMhz) {
		super(_nome, _descricao, _preco);
		this.capacidade = capacidade;
		this.freqMhz = freqMhz;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getFreqMhz() {
		return freqMhz;
	}

	public void setFreqMhz(int freqMhz) {
		this.freqMhz = freqMhz;
	}

	public String toString() {
		return "[Mem�ria RAM]\nNome: " + getNome() + "\nDescri��o: " + getDescricao() + "\nPre�o: R$ " + getPreco()
				+ " reais\nCapacidade: " + getCapacidade() + "GB\nFrequ�ncia: " + getFreqMhz() + "MHz";
	}
}