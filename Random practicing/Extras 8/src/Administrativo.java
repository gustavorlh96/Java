public class Administrativo extends Assistente {
	
	private String turno;
	private double adicionalNoturno;
	
	public Administrativo(String _nome, double _salario, int _numMatricula, String _turno, double _adicionalNoturno) {
		super(_nome, _salario, _numMatricula);
		
		this.turno = _turno;
		this.adicionalNoturno = _adicionalNoturno;
	}

	public String getTurno() {
		return turno;
	}

	public double getAdicionalNoturno() {
		return adicionalNoturno;
	}
	
	public String exibeDados() {
		
		if (getTurno().equalsIgnoreCase("Noite")) {
			return "\nDados do(a) assistente administrativo:\nNome: " + getNome() + "\nSalário: R$ " + getSalario() + "\nMatrícula: "
					+ getNumMatricula() + "\nTurno: " + getTurno() + "\nAdicional noturno: R$ " + getAdicionalNoturno();
		}
		else {
			return "\nDados do(a) assistente administrativo:\nNome: " + getNome() + "\nSalário: R$ " + getSalario() + "\nMatrícula: "
					+ getNumMatricula() + "\nTurno: " + getTurno();
		}
	}
}