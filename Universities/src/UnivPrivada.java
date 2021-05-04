public class UnivPrivada extends Universidade {
	private double valorMensalidade;
	
	public UnivPrivada(String _nome, int _quantAlunos, int _quantProfessores, double valorMensalidade) {
		super(_nome, _quantAlunos, _quantProfessores);
		this.valorMensalidade = valorMensalidade;
	}

	public double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	
	public String toString() {
		return "Universidade privada: " + getNome() + "\nMensalidade: " + this.valorMensalidade + "\nAlunos: " + getQuantAlunos() + "\nProfessores: " + getQuantProfessores();
	}
}