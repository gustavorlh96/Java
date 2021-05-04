public class VagaDesenvolvedor extends Vaga {
	
	private Competencia[] reqLinguagens;
	private Competencia[] reqBancosDeDados;
	
	// Método construtor padrão da classe VagaDesenvolvedor, subclasse de Vaga;
	public VagaDesenvolvedor(String _descricao, double _salario) {
		super(_descricao, _salario);
		
		this.reqLinguagens = new Competencia[100];
		this.reqBancosDeDados = new Competencia[100];
	}
	
	// Método construtor da classe VagaDesenvolvedor que recebe dois arrays
	// de competências, subclasse de Vaga;
	public VagaDesenvolvedor(String _descricao, double _salario, Competencia[] reqLing, Competencia[] reqBanc) {
		super(_descricao, _salario);
		
		this.reqLinguagens = reqLing;
		this.reqBancosDeDados = reqBanc;
	}
	
	// Ao receber uma competência linguagem, verifica se já existe;
	// Caso se: Aumenta nível da competência;
	// Caso não: Recebe a competência e a armazena em um array;
	public boolean alteraReqLinguagens(Competencia compLing) {
		boolean verif = false;
		
		for (int i = 0; i < reqLinguagens.length; i++) {
			if (reqLinguagens[i].equals(compLing)) {
				verif = true;
				int nivelMaior = compLing.getNivel();
				nivelMaior++;
				compLing.setNivel(nivelMaior);
				return verif;
			}
		}
		
		if (verif == false) {
			for (int i = 0; i < reqLinguagens.length; i++) {
				if (reqLinguagens[i] == null) {
					verif = true;
					reqLinguagens[i] = compLing;
					return verif;
				}
			}
		}
		
		return verif;
	}
	
	public Competencia[] getReqLinguagens() {
		return reqLinguagens;
	}
	
	// Ao receber uma competência banco de dados, verifica se já existe;
	// Caso se: Aumenta nível da competência;
	// Caso não: Recebe a competência e a armazena em um array;
	public boolean alteraReqBancosDeDados(Competencia compBanc) {
		boolean verif = false;
		
		for (int i = 0; i < reqBancosDeDados.length; i++) {
			if (reqBancosDeDados[i].equals(compBanc)) {
				verif = true;
				int nivelMaior = compBanc.getNivel();
				nivelMaior++;
				compBanc.setNivel(nivelMaior);
				return verif;
			}
		}
		
		if (verif == false) {
			for (int i = 0; i < reqBancosDeDados.length; i++) {
				if (reqBancosDeDados[i] == null) {
					verif = true;
					reqBancosDeDados[i] = compBanc;
					return verif;
				}
			}
		}
		
		return verif;
	}
	
	public Competencia[] getReqBancosDeDados() {
		return reqBancosDeDados;
	}
	
	// Método toString com laço para mostrar as linguagens e bancos exigidos pela vaga com seus
	// respectivos níveis;
	public String toString() {
		String toString = "\nDescrição da vaga: " + getDescricao() + "\nSalário: " + getSalario() + "\nID da vaga: " + getId();
		
		toString += "\nLinguagen(s) requisitada(s): ";
		
		int j = 0;
		for (int i = 0; i < reqLinguagens.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + getReqLinguagens()[i].getCompetencia() + " Nível: " + getReqLinguagens()[i].getNivel();
		}
		
		toString += "\nBanco(s) de dados requisitado(s): ";
		
		j = 0;
		for (int i = 0; i < reqBancosDeDados.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + getReqBancosDeDados()[i].getCompetencia() + " Nível: " + getReqBancosDeDados()[i].getNivel();
		}
		return toString;
	}
}