public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	// M�todo construtor da classe Data, recebe tr�s inteiros
	// representando uma data de nascimento;
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}
	
	// M�todo toString que exibe formatado uma data de nascimento;
	public String toString() {
		return getDia() + "/" + getMes() + "/" + getAno();
	}
}
