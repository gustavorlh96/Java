public class Candidato {
	
	private String nome, sobrenome, partido;
	private int intencaoVotos;
	
	public Candidato(String nome, String sobrenome, String partido) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.partido = partido;
		this.intencaoVotos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getIntencaoVotos() {
		return intencaoVotos;
	}
	public void setIntencaoVotos(int intencaoVotos) {
		this.intencaoVotos = intencaoVotos;
	}
	
	public String toString() {
		return "------------------------------" + "\nNome: " + getNome() + " " + getSobrenome() + "\nPartido: " + getPartido() + "\nIntenção de votos: " + getIntencaoVotos();
	}
}