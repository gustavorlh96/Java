public class Ingresso {
	
	private double valor = 13.50;

	public double getValor() {
		return valor;
	}
	
	public String imprimeValor() {
		return "O valor do ingresso �: R$ " + getValor() + " reais.";
	}
}