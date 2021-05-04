public class Turma {
	private String nome;
	private double[] notaAlunos;
	private int numNotas;
	
	public Turma(String nome, int maxArray) {
	this.nome = nome;
	this.notaAlunos = new double[maxArray];
	this.numNotas = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumNotas() {
		return numNotas;
	}
	
	public void insert(double nota) {
		for (int i = 0; i < notaAlunos.length; i++) {
			if (notaAlunos[i] == 0) {
				notaAlunos[i] = nota;
				numNotas++;
				break;
			}
		}
	}
	
	public double getNota(int pos) {
		if (pos < numNotas && pos >= 0) {
			return notaAlunos[pos];
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		String arrayConvString = "";
		for (int i = 0; i < numNotas; i++) {
			String temp = String.valueOf(notaAlunos[i]); // Converte o double em String.
			arrayConvString += temp + ", "; // Agrega o valor anterior com um atual e coloca uma separação.
			}
		arrayConvString = arrayConvString.substring(0, arrayConvString.lastIndexOf(", ")); // Remove a última separação vazia.
		return arrayConvString;
	}
	
	public double calculaMedia() {
		double somatorio = 0, media = 0;
		for (int i = 0; i < numNotas; i++) {
			somatorio += notaAlunos[i];
		}
		media = somatorio / numNotas;
		return media;
	}
}