public class Circulo extends Figura {
	
	private double raio;
	
	public Circulo(double _raio, String _cor) {
		super(_cor);
		this.raio = _raio;
	}
	
	public Circulo(String _cor) {
		super(_cor);
		this.raio = 8;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public double calculaArea() {
		double area = Math.PI * (Math.pow(getRaio(), 2));
		
		return area;
	}

	@Override
	public double calculaPerimetro() {
		double perimetro = 2 * (Math.PI * getRaio());
		
		return perimetro;
	}
}