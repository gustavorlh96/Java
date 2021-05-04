public class VagaGestor extends Vaga {
	
	private Competencia[] reqMetodologias;
	
	// Método construtor padrão da classe VagaGestor, subclasse de Vaga;
	public VagaGestor(String _descricao, double _salario) {
		super(_descricao, _salario);
		
		this.reqMetodologias = new Competencia[100];
	}
	
	// Método construtor com array de competências recebidas da classe VagaGestor, subclasse de Vaga;
	public VagaGestor(String _descricao, double _salario, Competencia[] reqMet) {
		super(_descricao, _salario);
		
		this.reqMetodologias = reqMet;
	}
	
	// Ao receber uma competência metodologia, verifica se já existe;
	// Caso se: Aumenta nível da competência;
	// Caso não: Recebe a competência e a armazena em um array;
	public boolean alteraReqMetodologias(Competencia compMet) {
		boolean verif = false;
		
		for (int i = 0; i < reqMetodologias.length; i++) {
			if (reqMetodologias[i].equals(compMet)) {
				verif = true;
				int nivelMaior = compMet.getNivel();
				nivelMaior++;
				compMet.setNivel(nivelMaior);
				return verif;
			}
		}
		
		if (verif == false) {
			for (int i = 0; i < reqMetodologias.length; i++) {
				if (reqMetodologias[i] == null) {
					verif = true;
					reqMetodologias[i] = compMet;
					return verif;
				}
			}
		}
		
		return verif;
	}
	
	public Competencia[] getReqMetodologias() {
		return reqMetodologias;
	}
	
	// Método toString com laço para mostrar as metodologias exigidas pela vaga com seus
	// respectivos níveis;
	public String toString() {
		String toString = "\nDescrição da vaga: " + getDescricao() + "\nSalário: " + getSalario() + "\nID da vaga: " + getId()
		                   + "\nMetodologias requisitadas: ";
		int j = 0;
		
		for (int i = 0; i < reqMetodologias.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + reqMetodologias[i].getCompetencia() + " Nível: " + reqMetodologias[i].getNivel();
		}
		return toString;
	}
}