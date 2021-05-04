public class Pessoa {
	
	private String nome, sexo;
	private int idade;
	
	public Pessoa(String _nome, String _sexo, int _idade) {
		this.nome = _nome;
		this.sexo = _sexo;
		this.idade = _idade;
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
	
	public void imprimeInfo() {
		System.out.println("-----------Informações da pessoa-----------");
		System.out.println("Nome: " + getNome());
		System.out.println("Idade: " + getSexo());
		System.out.println("Sexo: " + getIdade());
		System.out.println("-------------------------------------------");
	}
	
	public void aumentaIdade() {
		this.idade++;
	}
}