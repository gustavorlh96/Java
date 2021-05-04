public class Pessoa {
	
	private static int countPessoa = 0;
	protected int id;
	protected String nome;
	protected Data dataNascimento;
	
	// M�todo constutor da classe Pessoa;
	// Cont�m um ID que � incrementado e cadastrado
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
	
	// M�todo toString que retorna caracter�sticas prim�rias de Pessoa;
	public String toString() {
		return "\nNome: " + getNome() + "\nData de nascimento: " + getDataNascimento() + "\nID: " + getId();
	}
}