public class Principal {

	public static void main(String[] args) {
		exercicio1();
		exercicio2();
		
		Principal executaEx3 = new Principal();
		int[] array = {10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120};
		System.out.println(executaEx3.exercicio3(array, 95));
	}
	
	/* Exerc�cio 1: Mostre (indique a ordem em que as posi��es
	 * s�o percorridas no pr�prio vetor) os passos realizados
	 * pela pesquisa sequencial e pela pesquisa bin�ria no vetor
	 * abaixo para encontrar o valor 95. 
	 */
	public static void exercicio1() {
		int[] array = {10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120};
		boolean flag = false;
		
		System.out.println("****** Pesquisa sequencial ******\n");
		for (int i = 0; (i < array.length) && (array[i] <= 95); i++) {
			System.out.println("Procurando o elemento na posi��o " + i + " do array.");
			if (array[i] == 95) {
				System.out.println("Elemento 95 encontrado na posi��o " + i);
				flag = true;
				break;
			}
		}
		if (flag == false)
			System.out.println("Elemento 95 n�o encontrado no array.");
		
		System.out.println("\n****** Pesquisa bin�ria ******\n");
		flag = false;
		int inf = 0, sup = array.length - 1;
		
		while (inf <= sup) {
			System.out.println("Index inferior est� na posi��o " + inf + " e o superior em " + sup);
			int media = (inf + sup) / 2;
			System.out.println("A m�dia de " + inf + " e " + sup + " � " + media);
			if (95 == array[media]) {
				System.out.println("Elemento 95 encontrado na posi��o " + media);
				flag = true;
				break;
			}
			else if (95 < array[media]) {
				System.out.println("95 � menor que " + array[media] + ". Procurando na primeira metade...");
				sup = media - 1;
			}
			else {
				System.out.println("95 � maior que " + array[media] + ". Procurando na segunda metade...");
				inf = media + 1;
			}
		}	
		if (flag == false)
			System.out.println("Elemento 95 n�o encontrado no array.");
	}
	
	public static void exercicio2() {
		System.out.println("\n****** Pesquisa bin�ria ******\n");
		int[] array = {10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120};
		boolean flag = false;
		int inf = 0, sup = array.length - 1;
		
		while (inf <= sup) {
			System.out.println("Index inferior est� na posi��o " + inf + " e o superior em " + sup);
			int media = (inf + sup) / 2;
			System.out.println("A m�dia de " + inf + " e " + sup + " � " + media);
			if (95 == array[media]) {
				System.out.println("Elemento 12 encontrado na posi��o " + media);
				flag = true;
				break;
			}
			else if (12 < array[media]) {
				System.out.println("12 � menor que " + array[media] + ". Procurando na primeira metade...");
				sup = media - 1;
			}
			else {
				System.out.println("12 � maior que " + array[media] + ". Procurando na segunda metade...");
				inf = media + 1;
			}
		}	
		if (flag == false)
			System.out.println("Elemento 12 n�o encontrado no array.");
	}
	
	public boolean exercicio3(int[] array, int arg) throws IllegalArgumentException {
		if (array == null) throw new IllegalArgumentException();
		return exercicio3(array, 0, array.length - 1, 0, arg);
	}
	
	private boolean exercicio3(int[] array, int inf, int sup, int med, int arg) {
		if (inf > sup) return false;
		med = (inf + sup) / 2;
		if (array[med] == arg) return true;
		return arg < array[med] ? exercicio3(array, inf, sup = med - 1, med, arg) : exercicio3(array, inf = med + 1, sup, med, arg);
	}
}