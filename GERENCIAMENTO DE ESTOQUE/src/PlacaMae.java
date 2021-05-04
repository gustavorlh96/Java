public class PlacaMae extends Produto {
	
	private String soquete, chipset;

	public PlacaMae(String _nome, String _descricao, double _preco, String soquete, String chipset) {
		super(_nome, _descricao, _preco);
		this.soquete = soquete;
		this.chipset = chipset;
	}

	public String getSoquete() {
		return soquete;
	}

	public void setSoquete(String soquete) {
		this.soquete = soquete;
	}

	public String getChipset() {
		return chipset;
	}

	public void setChipset(String chipset) {
		this.chipset = chipset;
	}

	public String toString() {
		return "[Placa mãe]\nNome: " + getNome() + "\nDescrição: " + getDescricao() + "\nPreço: R$ " + getPreco()
				+ " reais\nSoquete: " + getSoquete() + "\nChipset: " + getChipset();
	}
}