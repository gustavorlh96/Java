public class Assistente extends Funcionario {
	
	private int numMatricula;
	
	public Assistente(String _nome, double _salario, int _numMatricula) {
		super(_nome, _salario);
		
		this.numMatricula = _numMatricula;
	}

	public int getNumMatricula() {
		return numMatricula;
	}
	
	public String exibeDados() {
		return "\nDados do(a) assistente:\nNome: " + getNome() + "\nSalário: R$ " + getSalario() + "\nMatrícula: " + getNumMatricula();
	}
}