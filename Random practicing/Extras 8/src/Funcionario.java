public class Funcionario {
	
	private String nome;
	private double salario;
	
	public Funcionario(String _nome, double _salario) {
		this.nome = _nome;
		this.salario = _salario;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public String exibeDados() {
		return "\nDados do(a) funcionário(a):\nNome: " + getNome() + "\nSalário: R$ " + getSalario();
	}
}