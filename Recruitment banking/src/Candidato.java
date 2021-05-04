public class Candidato extends Pessoa {
	
	private Competencia[] competencias;
	private double expSalario;
	
	// M�todo construtor padr�o da classe Candidato, subclasse de Pessoa;
	public Candidato(String _nome, Data _dataNasc) {
		super(_nome, _dataNasc);
		
		this.expSalario = 0;
		this.competencias = new Competencia[100];
	}
	
	// M�todo construtor da classe Candidato que recebe um array
	// de compet�ncias e uma expectativa salarial, subclasse de Pessoa;
	public Candidato(String _nome, Data _dataNasc, Competencia[] comp, double expSalario) {
		super(_nome, _dataNasc);
		
		this.competencias = comp;
		this.expSalario = expSalario;
	}
	
	// Ao receber uma compet�ncia, verifica se j� existe;
	// Caso se: Aumenta n�vel da compet�ncia;
	// Caso n�o: Recebe a compet�ncia e a armazena em um array;
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
	
	// M�todo toString com la�o para mostrar as compet�ncias exigidas pela vaga com seus
	// respectivos n�veis;
	public String toString() {
		String toString = "\nNome: " + getNome() + "\nData de nascimento: " + getDataNascimento() + "\nID: " + getId()
							+ "\nExpectativa salarial: R$ " + getExpSalario() + " reais\nCompet�ncia(s):";
		int j = 0;
		
		for (int i = 0; i < competencias.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + competencias[i].getCompetencia() + " N�vel: " + competencias[i].getNivel();
		}
		return toString;
	}
}