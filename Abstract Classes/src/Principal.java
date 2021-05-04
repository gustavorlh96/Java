public class Principal {

	public static void main(String[] args) {
		
		Figura[] figuras = new Figura[3];
		
		figuras[0] = new Retangulo("Vermelho");
		figuras[1] = new Circulo("Azul");
		figuras[2] = new Triangulo("Verde");
		
		for (int i = 0; i < figuras.length; i++)
			imprimeArea(figuras[i]);	
	}

	private static void imprimeArea(Figura figura) {
		if (figura instanceof Retangulo) {
			Retangulo r1 = (Retangulo) figura;
			System.out.println("*** Ret�ngulo " + r1.getCor() + " ***");
			System.out.println("A �rea do ret�ngulo �: " + r1.calculaArea() + "\nE o per�metro �: " + r1.calculaPerimetro() + "\n");
		}
		else if (figura instanceof Circulo) {
			Circulo c1 = (Circulo) figura;
			System.out.println("*** C�rculo " + c1.getCor() + " ***");
			System.out.println("A �rea do c�rculo �: " + c1.calculaArea() + "\nE o per�metro �: " + c1.calculaPerimetro() + "\n");
		}
		else if (figura instanceof Triangulo){
			Triangulo t1 = (Triangulo) figura;
			System.out.println("*** Tri�ngulo " + t1.getCor() + " ***");
			System.out.println("A �rea do tri�ngulo �: " + t1.calculaArea() + "\nE o per�metro �: " + t1.calculaPerimetro() + "\n");
		}
		else {
			System.out.println("ERRO! Algo de errado aconteceu!");
		}
	}
}