public class VIP extends Ingresso {
	
	private double valorAdicional = 10.50;
	
	public String imprimeValor() {
		return "O valor do ingresso VIP �: R$ " + valorAdicional + getValor() + " reais.";
	}
}