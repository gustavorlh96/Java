public class Tecnico extends Assistente {
	
	private double bonus;
	
	public Tecnico(String _nome, double _salario, int _numMatricula, double _bonus) {
		super(_nome, _salario, _numMatricula);
		
		this.bonus = _bonus;
	}
	
	public double getBonus() {
		return bonus;
	}

	public String exibeDados() {
		return "\nDados do(a) assistente técnico:\nNome: " + getNome() + "\nSalário: R$ " + getSalario() + "\nMatrícula: "
				+ getNumMatricula() + "\nBônus salarial: R$ " + getBonus();
	}
}
