public class VagaGestor extends Vaga {
	
	private Competencia[] reqMetodologias;
	
	// M�todo construtor padr�o da classe VagaGestor, subclasse de Vaga;
	public VagaGestor(String _descricao, double _salario) {
		super(_descricao, _salario);
		
		this.reqMetodologias = new Competencia[100];
	}
	
	// M�todo construtor com array de compet�ncias recebidas da classe VagaGestor, subclasse de Vaga;
	public VagaGestor(String _descricao, double _salario, Competencia[] reqMet) {
		super(_descricao, _salario);
		
		this.reqMetodologias = reqMet;
	}
	
	// Ao receber uma compet�ncia metodologia, verifica se j� existe;
	// Caso se: Aumenta n�vel da compet�ncia;
	// Caso n�o: Recebe a compet�ncia e a armazena em um array;
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
	
	// M�todo toString com la�o para mostrar as metodologias exigidas pela vaga com seus
	// respectivos n�veis;
	public String toString() {
		String toString = "\nDescri��o da vaga: " + getDescricao() + "\nSal�rio: " + getSalario() + "\nID da vaga: " + getId()
		                   + "\nMetodologias requisitadas: ";
		int j = 0;
		
		for (int i = 0; i < reqMetodologias.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + reqMetodologias[i].getCompetencia() + " N�vel: " + reqMetodologias[i].getNivel();
		}
		return toString;
	}
}