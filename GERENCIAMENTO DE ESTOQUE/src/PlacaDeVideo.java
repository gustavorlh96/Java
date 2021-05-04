public class PlacaDeVideo extends Produto {
	
	private int vram;
	private String arquitetura;
	
	public PlacaDeVideo(String _nome, String _descricao, double _preco, int vram, String arquitetura) {
		super(_nome, _descricao, _preco);
		this.vram = vram;
		this.arquitetura = arquitetura;
	}

	public int getVram() {
		return vram;
	}

	public void setVram(int vram) {
		this.vram = vram;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public String toString() {
		return "[Placa de vídeo]\nNome: " + getNome() + "\nDescrição: " + getDescricao() + "\nPreço: R$ " + getPreco()
				+ " reais\nMemória de vídeo: " + getVram() + "GB\nArquitetura da GPU: " + getArquitetura();
	}
}