public class Principal {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArraysBidimensionais teste = new ArraysBidimensionais();
		double[][] _arrayExercicio4 = new double[5][3];
		double[][] _arrayExercicio5 = new double[4][2];
		double[][] _arrayExercicio6 = {
				{2.5, 5.6, 76.3, 98.0},
				{7.9, 4.4, 1.0, 19.4},
				{3.4, 21.0, 12.6, 54.3}
		};
		double[][] _arrayExercicio7 = {
				{12.50, 15.20, 19.78, 50.62},
				{67.80, 96.05,  5.80, 60.99}
				};
		int[][] _arrayExercicio8 = {
				{2, 5, 76, 98},
				{7, 4,  1, 19},
				{3, 21, 12, 54}
				};
		double[][] _arrayExercicio9 = {
				{2, 3, 3},
				{5, 7, 10}
		};
		
		int[][] _arrayExercicio11 = {
				{2, -5, 76, 98},
				{7, 4,  1, -19},
				{-3, 21, -12, 54}
		};
		
		/*teste.exercicio1a();
		teste.exercicio1b();
		teste.exercicio1c();
		teste.exercicio1d();
		teste.exercicio2();
		teste.exercicio3();*/
		//teste.exercicio4(_arrayExercicio4);
		//teste.exercicio5(_arrayExercicio5);
		System.out.println("" + teste.exercicio6(_arrayExercicio6));
		//teste.exercicio7(_arrayExercicio7);
		//teste.exercicio8(_arrayExercicio8);
		//teste.exercicio9(_arrayExercicio9);
		//teste.exercicio10();
		//teste.exercicio11(_arrayExercicio11);
	}
}