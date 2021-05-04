public class Time {
	
	private String nome, categoria, historico;
	private int ano, quantSocios;
	private double mensalidade;
	
	public Time(String _nome, String _categoria) {
		this.nome = _nome;
		this.categoria = _categoria;
		this.historico = null;
		this.ano = 0;
		this.quantSocios = 0;
		this.mensalidade = 0;
	}
	
	public Time() {
		this.nome = "Indefinido";
		this.categoria = "Indefinido";
		this.historico = "Indefinido";
		this.ano = 0;
		this.quantSocios = 0;
		this.mensalidade = 0;
	}

	public String getNome() {
		return nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getHistorico() {
		return historico;
	}

	public int getAno() {
		return ano;
	}

	public int getQuantSocios() {
		return quantSocios;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setQuantSocios(int quantSocios) {
		this.quantSocios = quantSocios;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void calculaIdade(int anoRef) {
		int idadeTime = anoRef - getAno();
		System.out.println("O time tem " + idadeTime + " ano(s).");
	}
	
	public void adicionaSocios(int sociosAdd) {
		this.quantSocios += sociosAdd;
		System.out.println("Foram adicionados mais " + sociosAdd + " sócios.");
	}
	
	public void contagemRegressiva() {
		int dias = (2020 - getAno()) * 365;
		
		if (dias < 36500) {
			int diasRest = 36500 - dias;
			System.out.println("Faltam " + diasRest + " dias para o centenário do time.");
		}
		else {
			System.out.println("O time já tem 100 anos ou mais.");
		}
	}
	
	public double calculaReceita() {
		double receita = getQuantSocios() * getMensalidade();
		return receita;
	}
	
	public void imprimeInfo() {
		System.out.println("******************* Informações do time *******************");
		System.out.println("\nNome do time: " + getNome() + "\nCategoria: " + getCategoria()
						  	+ "\nHistórico: " + getHistorico() + "\nAno do time: " + getAno()
						  	+ "\nQuantidade de sócios: " + getQuantSocios() + "\nCusto da mensalidade: "
						  	+ getMensalidade());
	}
}