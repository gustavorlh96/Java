public class Funcionario extends Pessoa {
	
	private String cargo;
	private double salario;
	
	// M�todo construtor da classe Funcionario que recebe
	// um cargo e um salario, subclasse de Pessoa;
	public Funcionario(String _nome, Data _dataNasc, String cargo, double salario) {
		super(_nome, _dataNasc);
		
		this.cargo = cargo;
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// M�todo toString que retorna as informa��es de um funcion�rio (candidato contratado);
	public String toString() {
		return "\nNome: " + getNome() + "\nData de nascimento: " + getDataNascimento() + "\nID: " + getId()
				+ "\nCargo: " + getCargo() + "\nSal�rio: " + getSalario();
	}
}