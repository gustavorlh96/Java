public class Computador {
	
	private String processador, placaMae, placaDeVideo;
	private int ram, armazenamento;
	
	public Computador(String _processador, String _placaMae, String _placaDeVideo, int _ram, int _armazenamento) {
		this.processador = _processador;
		this.placaMae = _placaMae;
		this.placaDeVideo = _placaDeVideo;
		this.ram = _ram;
		this.armazenamento = _armazenamento;
	}

	public String getProcessador() {
		return processador;
	}

	public String getPlacaMae() {
		return placaMae;
	}

	public String getPlacaDeVideo() {
		return placaDeVideo;
	}

	public int getRam() {
		return ram;
	}

	public int getArmazenamento() {
		return armazenamento;
	}
	
	public void upgrade(int upRam) {
		this.ram = upRam;
	}
	
	public void upgrade(String upPlacaDeVideo) {
		this.placaDeVideo = upPlacaDeVideo;
	}
	
	public String toString() {
		return "\tProcessador: " + getProcessador() + "\n\tMemória RAM: " + getRam()
				+ "\n\tArmazenamento" + getArmazenamento() + "\n\tPlaca mãe: " + getPlacaMae()
				+ "\n\tPlaca de vídeo: " + getPlacaDeVideo();
	}
}