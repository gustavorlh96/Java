public class UnivPublica extends Universidade {
	private String estado;
	
	public UnivPublica(String _nome, int _quantAlunos, int _quantProfessores, String estado) {
		super(_nome, _quantAlunos, _quantProfessores);
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}
	
	@Override
	public String toString() {
		return "Universidade pública: " + getNome() + "\nEstado: " + this.estado + "\nAlunos: " + getQuantAlunos() + "\nProfessores: " + getQuantProfessores();
	}
}