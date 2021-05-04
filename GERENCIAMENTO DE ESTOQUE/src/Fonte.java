public class Fonte extends Produto {
	
	private int potencia;
	private String certificacao;
	
	public Fonte(String _nome, String _descricao, double _preco, int potencia, String certificacao) {
		super(_nome, _descricao, _preco);
		this.potencia = potencia;
		this.certificacao = certificacao;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public String getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(String certificacao) {
		this.certificacao = certificacao;
	}

	public String toString() {
		return "[Fonte]\nNome: " + getNome() + "\nDescrição: " + getDescricao() + "\nPreço: R$ " + getPreco()
				+ " reais\nPotência: " + getPotencia() + "W\nCertificação: " + getCertificacao();
	}
}