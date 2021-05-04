public class Principal {

	public static void main(String[] args) {
		exercicio1();
		exercicio2();
		
		Principal executaEx3 = new Principal();
		int[] array = {10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120};
		System.out.println(executaEx3.exercicio3(array, 95));
	}
	
	/* Exercício 1: Mostre (indique a ordem em que as posições
	 * são percorridas no próprio vetor) os passos realizados
	 * pela pesquisa sequencial e pela pesquisa binária no vetor
	 * abaixo para encontrar o valor 95. 
	 */
	public static void exercicio1() {
		int[] array = {10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120};
		boolean flag = false;
		
		System.out.println("****** Pesquisa sequencial ******\n");
		for (int i = 0; (i < array.length) && (array[i] <= 95); i++) {
			System.out.println("Procurando o elemento na posição " + i + " do array.");
			if (array[i] == 95) {
				System.out.println("Elemento 95 encontrado na posição " + i);
				flag = true;
				break;
			}
		}
		if (flag == false)
			System.out.println("Elemento 95 não encontrado no array.");
		
		System.out.println("\n****** Pesquisa binária ******\n");
		flag = false;
		int inf = 0, sup = array.length - 1;
		
		while (inf <= sup) {
			System.out.println("Index inferior está na posição " + inf + " e o superior em " + sup);
			int media = (inf + sup) / 2;
			System.out.println("A média de " + inf + " e " + sup + " é " + media);
			if (95 == array[media]) {
				System.out.println("Elemento 95 encontrado na posição " + media);
				flag = true;
				break;
			}
			else if (95 < array[media]) {
				System.out.println("95 é menor que " + array[media] + ". Procurando na primeira metade...");
				sup = media - 1;
			}
			else {
				System.out.println("95 é maior que " + array[media] + ". Procurando na segunda metade...");
				inf = media + 1;
			}
		}	
		if (flag == false)
			System.out.println("Elemento 95 não encontrado no array.");
	}
	
	public static void exercicio2() {
		System.out.println("\n****** Pesquisa binária ******\n");
		int[] array = {10, 34, 65, 76, 78, 81, 86, 87, 90, 95, 104, 120};
		boolean flag = false;
		int inf = 0, sup = array.length - 1;
		
		while (inf <= sup) {
			System.out.println("Index inferior está na posição " + inf + " e o superior em " + sup);
			int media = (inf + sup) / 2;
			System.out.println("A média de " + inf + " e " + sup + " é " + media);
			if (95 == array[media]) {
				System.out.println("Elemento 12 encontrado na posição " + media);
				flag = true;
				break;
			}
			else if (12 < array[media]) {
				System.out.println("12 é menor que " + array[media] + ". Procurando na primeira metade...");
				sup = media - 1;
			}
			else {
				System.out.println("12 é maior que " + array[media] + ". Procurando na segunda metade...");
				inf = media + 1;
			}
		}	
		if (flag == false)
			System.out.println("Elemento 12 não encontrado no array.");
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