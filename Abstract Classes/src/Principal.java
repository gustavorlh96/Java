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
			System.out.println("*** Retângulo " + r1.getCor() + " ***");
			System.out.println("A área do retângulo é: " + r1.calculaArea() + "\nE o perímetro é: " + r1.calculaPerimetro() + "\n");
		}
		else if (figura instanceof Circulo) {
			Circulo c1 = (Circulo) figura;
			System.out.println("*** Círculo " + c1.getCor() + " ***");
			System.out.println("A área do círculo é: " + c1.calculaArea() + "\nE o perímetro é: " + c1.calculaPerimetro() + "\n");
		}
		else if (figura instanceof Triangulo){
			Triangulo t1 = (Triangulo) figura;
			System.out.println("*** Triângulo " + t1.getCor() + " ***");
			System.out.println("A área do triângulo é: " + t1.calculaArea() + "\nE o perímetro é: " + t1.calculaPerimetro() + "\n");
		}
		else {
			System.out.println("ERRO! Algo de errado aconteceu!");
		}
	}
}