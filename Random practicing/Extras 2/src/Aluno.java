public class Aluno {
	
	private String nome, matricula;
	private double notaA, notaB;
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public double getNotaA() {
		return notaA;
	}

	public double getNotaB() {
		return notaB;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNotaA(double notaA) {
		this.notaA = notaA;
	}

	public void setNotaB(double notaB) {
		this.notaB = notaB;
	}

	public double calculaMediaFinal() {
		double mediaFinal = (this.notaA * 0.33) + (notaB * 0.67);
		
		return mediaFinal;
	}
	
	public void imprimeInfo() {
		System.out.println("------------Informações do Aluno-----------");
		System.out.println("Nome: " + getNome());
		System.out.println("Matrícula: " + getMatricula());
		System.out.println("Nota do grau A: " + getNotaA());
		System.out.println("Nota do grau B: " + getNotaB());
		System.out.println("Média final: " + calculaMediaFinal());
		System.out.println("-------------------------------------------");
	}
}