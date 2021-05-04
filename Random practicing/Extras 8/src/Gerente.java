public class Gerente extends Funcionario {
	
	private String setor;
	
	public Gerente(String _nome, double _salario, String _setor) {
		super(_nome, _salario);
		
		this.setor = _setor;
	}

	public String getSetor() {
		return setor;
	}
	
	public String exibeDados() {
		return "\nDados do(a) gerente:\nNome: " + getNome() + "\nSalário: R$ " + getSalario() + "\nSetor: " + getSetor();
	}
}