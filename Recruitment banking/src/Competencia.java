public class Competencia {
	
	private String competencia;
	private int nivel;
	
	// Método construtor da classe Competencia, recebendo uma
	// String que representa um conhecimento técnico
	// e seu respectivo nível;
	public Competencia(String competencia, int nivel) {
		this.competencia = competencia;
		this.nivel = nivel;
	}

	public String getCompetencia() {
		return competencia;
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	// Método toString que retorna as duas características
	// que fazem uma competência;
	public String toString() {
		return "\nCompetência: " + getCompetencia() + "\nNível: " + getNivel();
	}
}
