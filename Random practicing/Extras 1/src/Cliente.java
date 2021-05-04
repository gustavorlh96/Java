public class Cliente {
	
	private String nome, email, sexo, senha;
	private int idade;
	
	public Cliente(String _nome, String _email, String _sexo, String _senha, int _idade) {
		this.nome = _nome;
		this.email = _email;
		this.sexo = _sexo;
		this.senha = _senha;
		this.idade = _idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", sexo=" + sexo + ", senha=" + senha + ", idade=" + idade
				+ "]";
	}
}