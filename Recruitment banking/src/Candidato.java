public class Candidato extends Pessoa {
	
	private Competencia[] competencias;
	private double expSalario;
	
	// Método construtor padrão da classe Candidato, subclasse de Pessoa;
	public Candidato(String _nome, Data _dataNasc) {
		super(_nome, _dataNasc);
		
		this.expSalario = 0;
		this.competencias = new Competencia[100];
	}
	
	// Método construtor da classe Candidato que recebe um array
	// de competências e uma expectativa salarial, subclasse de Pessoa;
	public Candidato(String _nome, Data _dataNasc, Competencia[] comp, double expSalario) {
		super(_nome, _dataNasc);
		
		this.competencias = comp;
		this.expSalario = expSalario;
	}
	
	// Ao receber uma competência, verifica se já existe;
	// Caso se: Aumenta nível da competência;
	// Caso não: Recebe a competência e a armazena em um array;
	public boolean alteraCompetencias(Competencia comp) {
		boolean verif = false;
		
		for (int i = 0; i < competencias.length; i++) {
			if (competencias[i].equals(comp)) {
				verif = true;
				int nivelMaior = comp.getNivel();
				nivelMaior++;
				comp.setNivel(nivelMaior);
				return verif;
			}
		}
		
		if (verif == false) {
			for (int i = 0; i < competencias.length; i++) {
				if (competencias[i] == null) {
					verif = true;
					competencias[i] = comp;
					return verif;
				}
			}
		}
		
		return verif;
	}
	
	public Competencia[] getCompetencias() {
		return competencias;
	}
	
	public void setExpSalario(double expSalario) {
		this.expSalario = expSalario;
	}
	
	public double getExpSalario() {
		return expSalario;
	}
	
	// Método toString com laço para mostrar as competências exigidas pela vaga com seus
	// respectivos níveis;
	public String toString() {
		String toString = "\nNome: " + getNome() + "\nData de nascimento: " + getDataNascimento() + "\nID: " + getId()
							+ "\nExpectativa salarial: R$ " + getExpSalario() + " reais\nCompetência(s):";
		int j = 0;
		
		for (int i = 0; i < competencias.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + competencias[i].getCompetencia() + " Nível: " + competencias[i].getNivel();
		}
		return toString;
	}
}