public class Competencia {
	
	private String competencia;
	private int nivel;
	
	// M�todo construtor da classe Competencia, recebendo uma
	// String que representa um conhecimento t�cnico
	// e seu respectivo n�vel;
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
	
	// M�todo toString que retorna as duas caracter�sticas
	// que fazem uma compet�ncia;
	public String toString() {
		return "\nCompet�ncia: " + getCompetencia() + "\nN�vel: " + getNivel();
	}
}
