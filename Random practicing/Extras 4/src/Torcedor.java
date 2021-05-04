public class Torcedor {
	
	private String nome, sexo;
	private int idade;
	private Time time;
	
	public Torcedor(String _nome, String _sexo, int _idade, Time _time) {
		this.nome = _nome;
		this.sexo = _sexo;
		this.idade = _idade;
		this.time = _time;
	}
	
	public Torcedor(String _nome, String _sexo, int _idade) {
		this.nome = _nome;
		this.sexo = _sexo;
		this.idade = _idade;
		this.time = null;
	}
	
	public Torcedor(String _nome, int _idade) {
		this.nome = _nome;
		this.idade = _idade;
		this.sexo = "Indefinido";
		this.time = null;
	}
	
	public Torcedor() {
		this.nome = "Indefinido";
		this.sexo = "Indefinido";
		this.time = null;
		this.idade = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public double obtemReceitaTime() {
		System.out.println("O time " + time.getNome() + " do(a) torcedor(a) " + getNome() + " gera R$ "
							+ time.calculaReceita() + " reais por mês.");
		return time.calculaReceita();
	}
	
	public void imprimeTime() {
		System.out.println("Torcedor(a) " + getNome() + " torce para o time " + getTime() + ".");
	}

	public void imprimeInfo() {
		System.out.println("**************** Informações do(a) torcedor(a) ****************");
		System.out.println("\nNome do time: " + getNome() + "\nSexo: " + getSexo()
	  						+ "\nIdade: " + getIdade());
	}
}