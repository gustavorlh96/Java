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
		return "\nDados do(a) assistente t�cnico:\nNome: " + getNome() + "\nSal�rio: R$ " + getSalario() + "\nMatr�cula: "
				+ getNumMatricula() + "\nB�nus salarial: R$ " + getBonus();
	}
}
