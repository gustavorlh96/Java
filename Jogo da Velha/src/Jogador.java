public class Jogador {
	
	public String nome;
	public int pontos;
	
	public Jogador(String _nome) {
		this.nome = _nome;
		this.pontos = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String toString() {
		return "O(A) jogador(a) " + nome + " está com " + pontos + " pontos.";
	}
}