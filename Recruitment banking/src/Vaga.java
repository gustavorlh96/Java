public class Vaga {
	
	private static int countVaga;
	protected int id;
	protected String descricao;
	protected double salario;
	
	// M�todo constutor da classe Vaga;
	// Cont�m um ID que � incrementado e cadastrado
	// a cada vaga criada.
	public Vaga(String descricao, double salario) {
		this.descricao = descricao;
		this.salario = salario;
		this.id = ++countVaga;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getSalario() {
		return salario;
	}
	
	// Recebe um double representando um salario
	// e o altera;
	public void alteraSalario(double novoSalario) {
		this.salario = novoSalario;
	}
	
	// toString que retorna descri��es prim�rias da vaga;
	public String toString() {
		return "\nDescri��o da vaga: " + getDescricao() + "\nSal�rio: " + getSalario() + "\nID da vaga: " + getId();
	}
}