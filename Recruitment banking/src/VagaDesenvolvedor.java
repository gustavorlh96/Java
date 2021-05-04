public class VagaDesenvolvedor extends Vaga {
	
	private Competencia[] reqLinguagens;
	private Competencia[] reqBancosDeDados;
	
	// M�todo construtor padr�o da classe VagaDesenvolvedor, subclasse de Vaga;
	public VagaDesenvolvedor(String _descricao, double _salario) {
		super(_descricao, _salario);
		
		this.reqLinguagens = new Competencia[100];
		this.reqBancosDeDados = new Competencia[100];
	}
	
	// M�todo construtor da classe VagaDesenvolvedor que recebe dois arrays
	// de compet�ncias, subclasse de Vaga;
	public VagaDesenvolvedor(String _descricao, double _salario, Competencia[] reqLing, Competencia[] reqBanc) {
		super(_descricao, _salario);
		
		this.reqLinguagens = reqLing;
		this.reqBancosDeDados = reqBanc;
	}
	
	// Ao receber uma compet�ncia linguagem, verifica se j� existe;
	// Caso se: Aumenta n�vel da compet�ncia;
	// Caso n�o: Recebe a compet�ncia e a armazena em um array;
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
	
	// Ao receber uma compet�ncia banco de dados, verifica se j� existe;
	// Caso se: Aumenta n�vel da compet�ncia;
	// Caso n�o: Recebe a compet�ncia e a armazena em um array;
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
	
	// M�todo toString com la�o para mostrar as linguagens e bancos exigidos pela vaga com seus
	// respectivos n�veis;
	public String toString() {
		String toString = "\nDescri��o da vaga: " + getDescricao() + "\nSal�rio: " + getSalario() + "\nID da vaga: " + getId();
		
		toString += "\nLinguagen(s) requisitada(s): ";
		
		int j = 0;
		for (int i = 0; i < reqLinguagens.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + getReqLinguagens()[i].getCompetencia() + " N�vel: " + getReqLinguagens()[i].getNivel();
		}
		
		toString += "\nBanco(s) de dados requisitado(s): ";
		
		j = 0;
		for (int i = 0; i < reqBancosDeDados.length; i++) {
			++j;
			toString += "\n\t" + j + ". " + getReqBancosDeDados()[i].getCompetencia() + " N�vel: " + getReqBancosDeDados()[i].getNivel();
		}
		return toString;
	}
}