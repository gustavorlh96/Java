public class Retangulo extends Figura {
	
	private double base, altura;
	
	public Retangulo(double _base, double _altura, String _cor) {
		super(_cor);
		this.base = _base;
		this.altura = _altura;
	}
	
	public Retangulo(String _cor) {
		super(_cor);
		this.base = 7;
		this.altura = 5;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double calculaArea() {
		double area = getBase() * getAltura();

		return area;
	}

	@Override
	public double calculaPerimetro() {
		double perimetro = 2 * (getBase() + getAltura());
		
		return perimetro;
	}
}