public class Triangulo extends Figura {
	
	private double base, altura, ladoUm, ladoDois;
	
	public Triangulo(double _base, double _altura, double _ladoUm, double _ladoDois, String _cor) {
		super(_cor);
		this.base = _base;
		this.altura = _altura;
		this.ladoUm = _ladoUm;
		this.ladoDois = _ladoDois;
	}
	
	public Triangulo(String _cor) {
		super(_cor);
		this.base = 5;
		this.altura = 10;
		this.ladoUm = 7.5;
		this.ladoDois = 7.5;
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

	public double getLadoUm() {
		return ladoUm;
	}

	public void setLadoUm(double ladoUm) {
		this.ladoUm = ladoUm;
	}

	public double getLadoDois() {
		return ladoDois;
	}

	public void setLadoDois(double ladoDois) {
		this.ladoDois = ladoDois;
	}

	@Override
	public double calculaArea() {
		double areaFinal = 0;
		
		if (getLadoUm() == getLadoDois() || getLadoUm() == getLadoDois()) {
			areaFinal = (getBase() * getAltura()) / 2;
		}
		else {
			System.out.println("Ainda será implementada a fórmula.");
		}
		
		return areaFinal;
	}

	@Override
	public double calculaPerimetro() {
		double perimetro = getLadoUm() + getLadoDois() + getBase();
		
		return perimetro;
	}
}