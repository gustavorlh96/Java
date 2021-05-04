public class Universidade {
	private String nome;
	private int quantAlunos, quantProfessores;
	
	public Universidade(String nome, int quantAlunos, int quantProfessores) {
		this.nome = nome;
		this.quantAlunos = quantAlunos;
		this.quantProfessores = quantProfessores;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantAlunos() {
		return quantAlunos;
	}

	public int getQuantProfessores() {
		return quantProfessores;
	}
}