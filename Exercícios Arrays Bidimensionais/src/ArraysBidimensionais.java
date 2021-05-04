import java.util.Scanner;

public class ArraysBidimensionais {
	
	Scanner entrada = new Scanner(System.in);
	
	public int[][] exercicio1a() {
		int[][] array = new int[3][10];
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = j;
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		
		return array;
	}
	
	public int[][] exercicio1b() {
		int[][] array = new int[5][10];
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] =  (int) Math.pow(j, 2); // j * j;
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		
		return array;
	}
	
	public int[][] exercicio1c() {
		int[][] array = new int[6][6];
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = i;
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		
		return array;
	}
	
	public int[][] exercicio1d() {
		int[][] array = new int[9][6];
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = i % 2 == 0 ? -1 : 0;
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
		
		return array;
	}
	
	public int[][] exercicio2() {
		int lin = entrada.nextInt();
		int col = entrada.nextInt();
		int[][] array = new int[lin][col];
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = (int)(Math.floor(Math.random() * 99) + 1);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t ");
			}
		}
		
		return array;
	}
	
	public double[][] exercicio3() {
		double[][] array = new double[2][5];
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = entrada.nextDouble();
				
		for (int i = 0; i < array.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
		}
				
		
		return array;
	}
	
	public int exercicio4(double[][] _array) {
		int contadorElementos = 0;
		
		for (int i = 0; i < _array.length; i++)
			for (int j = 0; j < _array[i].length; j++)
				contadorElementos++;
		
		System.out.println("Este array contém " + contadorElementos + " elementos.");
		
		return contadorElementos;
	}
	
	public int exercicio5(double[][] _array) {
		int contadorElementos = 0;
		
		for (int i = 0; i < _array.length; i++)
			for (int j = 0; j < _array[i].length; j++)
				contadorElementos++;
		
		System.out.println("Este array contém " + contadorElementos + " elementos.");
		
		return contadorElementos;
	}
	
	public String exercicio6(double[][] _array) {	
		  
		 String retorno = "";
		  
		 for (int i = 0; i < _array.length; i++)
			 for (int j = 0; j < _array[i].length; j++)
				 retorno += j == _array[i].length - 1 ? _array[i][j] : _array[i][j] + " - ";
			 retorno += "\n";
			 
		return retorno;
	}
	
	public double exercicio7(double[][] _array) {
		double maiorValor = Double.MIN_VALUE;
		
		for (int i = 0; i < _array.length; i++)
			for (int j = 0; j < _array[i].length; j++)
				maiorValor = _array[i][j] > maiorValor ? _array[i][j] : maiorValor;
				
		System.out.println("O maior elemento da matriz é " + maiorValor + ".");
		
		return maiorValor;
	}
	
	public int exercicio8(int[][] _array) {
		int somaValoresArray = 0;
		
		for (int i = 0; i < _array.length; i++)
			for (int j = 0; j < _array[i].length; j++)
				somaValoresArray += _array[i][j];
		
		System.out.println("A soma dos valores da matriz é " + somaValoresArray + ".");
		
		return somaValoresArray;
	}
	
	public double exercicio9(double[][] _array) {
		double mediaValoresArray = 0;
		int quantidadeValoresArray = 0;
		
		for (int i = 0; i < _array.length; i++)
			for (int j = 0; j < _array[i].length; j++) {
				quantidadeValoresArray++;
				mediaValoresArray += _array[i][j];
			}
		
		mediaValoresArray = mediaValoresArray / quantidadeValoresArray;
		
		System.out.println("A média dos valores da matriz é " + mediaValoresArray + ".");
		
		return mediaValoresArray;
	}
	
	public char[][] exercicio10() {
		int lin = (int) (Math.floor(Math.random() * 5) + 1);
		int col = (int) (Math.floor(Math.random() * 3) + 1);
		
		char[][] matriz = new char[lin][col];
		
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz[i].length; j++)
				matriz[i][j] = entrada.next().charAt(matriz[i][j]);
		
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}
		
		return matriz;
	}
	
	public int[] exercicio11(int[][] _matriz) {
		int tamanhoArray = 0;
		
		for (int i = 0; i < _matriz.length; i++)
			for (int j = 0; j < _matriz[i].length; j++) {
				if (_matriz[i][j] > 0)
					tamanhoArray++;
			}
		
		int[] arrayPositivos = new int[tamanhoArray];
		
		for (int i = 0; i < _matriz.length; i++)
			for (int j = 0; j < _matriz[i].length; j++)
				loopArray:
				for (int k = 0; k < arrayPositivos.length; k++) {
					if (arrayPositivos[k] == 0 && _matriz[i][j] > 0) {
						arrayPositivos[k] = _matriz[i][j];
						break loopArray;
					}
				}
		
		for (int i = 0; i < arrayPositivos.length; i++)
			System.out.print(" " + arrayPositivos[i]);
				
		return arrayPositivos;
	}
	
	public void imprimeArrayBidimensional(int[][] array) {
		for (int i = 0; i < array.length; i++) 
			for (int j = 0; j < array[i].length; j++) 
				System.out.print(array[i][j] + " ");
		System.out.println();
	}
}