public class Pessoa {
	
	private static int countPessoa = 0;
	protected int id;
	protected String nome;
	protected Data dataNascimento;
	
	// Método constutor da classe Pessoa;
	// Contém um ID que é incrementado e cadastrado
	// a cada pessoa criada;
	public Pessoa(String nome, Data dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.id = ++countPessoa;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}
	
	// Método toString que retorna características primárias de Pessoa;
	public String toString() {
		return "\nNome: " + getNome() + "\nData de nascimento: " + getDataNascimento() + "\nID: " + getId();
	}
}