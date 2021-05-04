/*
 *                                 Comentários da classe ControleTeleSena:
 * 
 * Aqui se encontra as principais operações lógicas como cálculos e chamadas de atribuições do programa.
 * Esta classe é responsável pelo gerenciamento e cadastro de participantes, atribuições individuais de
 * Tele Senas, resetar os prêmios, contar a quantidade de Tele Senas vendidas, contagem de dinheiro total,
 * informações de lucros, informações de prêmios e sorteio. Obs.: O uso do "SuppressWarnings" é para evitar
 * alertas do Eclipse (IDE onde desenvolvi o programa), pois aquela variável só tem uso após o sorteio realizado.
 * 
*/

import java.util.Scanner;

@SuppressWarnings("resource")
public class ControleTeleSena {
	private Pessoa[] arrayPessoas;
	
	// Um método inicializador do array de participantes;
	public ControleTeleSena() {
		this.arrayPessoas = new Pessoa[20];
	}
	
	// registraPessoa(Pessoa): Cadastra um participante do tipo Pessoa e atribui automaticamente uma Tele Sena;
	public boolean registraPessoa(Pessoa comprador) {
		boolean verif = false;
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] == null) {
				comprador.atribuiTeleSena();
				arrayPessoas[i] = comprador;
				verif = true;
				break;
			}
			else {
				verif = false;
				continue;
			}
		}
		if (verif == true) {
			return verif;
		}
		else {
			return verif;
		}
	}
	
	/* vendaTeleSena(): Atribui uma Tele Sena adicional à um participante já registrado, podendo selecionar
	 * através de uma lista numerada com os participantes. Caso o limite total de Tele Senas tenha sido atingido
	 * (300), não atribui e retorna mensagem. Caso não exista participantes, retorna uma mensagem. Caso a seleção
	 * do participante esteja fora do alcance da lista, retorna mensagem e aguarda nova entrada;*/
	public boolean vendaTeleSena() {
		Scanner in = new Scanner(System.in);
		boolean verif = false;
		int contador = 0;
		int contSenas = 0;
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null) {
				contador++;
			}
		}
		
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null) {
				contSenas += arrayPessoas[i].retornaQuantSenas();
			}
		}
		
		if (contSenas >= 300) {
			System.out.println("O estoque de Tele Senas foi vendido! Não é possível comprar mais.");
			return verif;
		}
		
		if (contador == 0) {
			System.out.println("Ninguém registrado ainda!");
			return verif;
		}
		
		System.out.println("Insira o número de quem vai comprar outra Tele Sena: ");
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null) {
				System.out.println(i + " - " + arrayPessoas[i].getNome());
			}
		}
		
		do {
			int selecao = in.nextInt();
			in.nextLine();
			
			if (arrayPessoas[selecao] != null) {
				arrayPessoas[selecao].atribuiTeleSena();
				verif = true;
			}
			else {
				System.out.println("Número inválido, tente novamente!");
				continue;
			}
		} while (verif == false);
	    return verif;
	}
	
	/* limpaPremios(): Zera os prêmios atribuídos aos participantes ganhadores caso o sorteio tenha sido
	 * realizado;*/
	public void limpaPremios() {
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null) {
				arrayPessoas[i].setPremiacao(0);
			}
		}
	}
	
	/* quantTeleVendidas(): Retorna a quantidade total de Tele Senas vendidas entre todos participantes. Caso
	 * não tenha participantes, retorna uma mensagem;*/
	public int quantTeleVendidas() {
		int contadorUniversal = 0;
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null) {
				contadorUniversal += arrayPessoas[i].retornaQuantSenas();
			}
		}
		if (contadorUniversal != 0) {
			System.out.println("Foram vendidas " + contadorUniversal + " Tele Sena(s).");
		}
		else {
			System.out.println("Nenhuma Tele Sena foi vendida.");
		}
		return contadorUniversal;
	}
	
	/* infoPremios(): Retorna os ganhadores do sorteio com seus respectivos prêmios. Caso o sorteio não tenha
	 * ocorrido, retorna uma mensagem;*/
	public int infoPremios() {
		int numGanhadores = 0;
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null && arrayPessoas[i].getPremiacao() != 0.00) {
				numGanhadores++;
				System.out.printf("%s  foi premiado(a) com o valor de R$ ", arrayPessoas[i].getNome());
				System.out.printf("%.2f", arrayPessoas[i].getPremiacao());
				System.out.print(" reais!\n");
			}
		}
		if (numGanhadores == 0) {
			System.out.println("Não há premiados pois o sorteio ainda não ocorreu!");
		}
		return numGanhadores;
	}
	
	/* infoLucros(): Retorna os lucros referentes à 20% das vendas de Tele Senas. Caso não haja Tele Senas
	 * vendidas/participantes, retorna uma mensagem;*/
	public void infoLucros() {
		double contadorUniversal = 0.00, lucroTotal = 0.00, contaPremios = 0.00, restoPremios = 0.00;
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null && arrayPessoas[i].retornaQuantSenas() != 0) {
				contadorUniversal += arrayPessoas[i].contaDinheiro();
			}
		}
		
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null && arrayPessoas[i].retornaQuantSenas() != 0) {
				contaPremios += arrayPessoas[i].getPremiacao();
			}
		}
		
		lucroTotal = ((contadorUniversal * 20) / 100);
		if (contaPremios != 0.00) {
			restoPremios = (dinheiroBruto() - lucroTotal) - contaPremios;
			lucroTotal = lucroTotal + restoPremios;
		}
		if (lucroTotal != 0) {
			System.out.printf("O lucro total é de R$ %.2f", lucroTotal);
			System.out.print(" reais!\n");
		}
		else {
			System.out.println("Não há lucro pois nenhuma Tele Sena foi vendida.");
		}
	}
	
	// dinheiroBruto(): Retorna o valor total das vendas de Tele Senas sem o desconto de lucro;
	public double dinheiroBruto() {
		double dinheiroTotal = 0.00;
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null && arrayPessoas[i].retornaQuantSenas() != 0) {
				dinheiroTotal += arrayPessoas[i].contaDinheiro();
			}
		}
		return dinheiroTotal;
	}
	
	/* geraNumerosSorteio(): Aqui, os números sorteados são gerados. Em uma estrutura semelhante a geração
	 * de números dos conjuntos de Tele Senas dos participantes, os números sorteados são: Gerados, verificados
	 * se existe números repetidos (caso existam, um número novo o substitui e a verificação reinicia) e por fim,
	 * organizados através do algorítmo Bubble Sort. São 25 números sorteados de 1 a 60;*/
	public int[] geraNumerosSorteio() {
		int temp = 0;
		int[] numerosSorteados = new int[25];
		
		for (int i = 0; i < numerosSorteados.length; i++) {
			numerosSorteados[i] = (int) (Math.random() * 60 + 1);
		}
		
		for (int i = 0; i < numerosSorteados.length; i++) {
			if (numerosSorteados[i] != 0) {
				for (int j = i + 1; j < numerosSorteados.length; j++) {
					if (numerosSorteados[i] == numerosSorteados[j]) {
						numerosSorteados[i] = (int) (Math.random() * 60 + 1);
						i = 0; j = 0;
					}
				}
			}
		}
		
		for (int i = 0; i < numerosSorteados.length; i++) {
			for (int j = i + 1; j < numerosSorteados.length; j++) {
				if (numerosSorteados[i] > numerosSorteados[j]) {
					temp = numerosSorteados[i];
					numerosSorteados[i] = numerosSorteados[j];
					numerosSorteados[j] = temp;
				}
			}
		}
		return numerosSorteados;
	}
	
	/* sorteioTelaSena(): Neste método ocorre o sorteio. Começa sendo administrado o valor do prêmio sem
	 * o desconto de lucros, em seguida é gerado os números do sorteio através do método explicado no tópico
	 * acima, comparado com os dois conjuntos de cada Tele Sena do participante e por fim, distribuído o prêmio
	 * (80% dos valores arrecadados com as vendas) entre os ganhadores. Caso não exista ganhadores, novos números
	 * para o sorteio são gerados até que tenha no mínimo um ganhador. No fim, apresenta os números sorteados.
	 * Caso ocorra a tentativa de iniciar o sorteio sem participantes, retorna uma mensagem;*/
	public void sorteioTelaSena() {
		boolean verif = false;		
		double premioBruto = (dinheiroBruto() - ((dinheiroBruto() * 20) / 100)), premioLiquido = 0.00;
		int numGanhadores = 0;
		Pessoa[] listaGanhadores = new Pessoa[20];
		int contador = 0;
		int[] numerosSorteados = new int[25];
		
		for (int i = 0; i < arrayPessoas.length; i++) {
			if (arrayPessoas[i] != null) {
				contador++;
			}
		}
		
		if (contador != 0) {
			do {
				numerosSorteados = geraNumerosSorteio();
				for (int i = 0; i < arrayPessoas.length; i++) {
					if (arrayPessoas[i] != null) {
						for (int j = 0; j < arrayPessoas[i].getTeleSenas().length; j++) {
							if (arrayPessoas[i].getTeleSenas()[j] != null) {
								if (arrayPessoas[i].getTeleSenas()[j].getConjuntoUm()[j] != 0 && arrayPessoas[i].getTeleSenas()[j].getConjuntoDois()[j] != 0) {
									if (arrayPessoas[i].getTeleSenas()[j].getConjuntoUm()[j] == numerosSorteados[j] || arrayPessoas[i].getTeleSenas()[j].getConjuntoDois()[j] == numerosSorteados[j]) {
										numGanhadores++;
										listaGanhadores[i] = arrayPessoas[i];
									}
								}
							}
						}
					}
				}
				premioLiquido = (premioBruto / numGanhadores);
				for (int i = 0; i < listaGanhadores.length; i++) {
					if (listaGanhadores[i] != null) {
						listaGanhadores[i].setPremiacao(premioLiquido);
						verif = true;
					}
				}
				
			} while (verif == false);
			imprimeNumerosSorteados(numerosSorteados);
		}
		else {
			System.out.println("O sorteio não pode prosseguir pois não há participantes!");
		}
	}
	
	// imprimeNumerosSorteados(int[]): Este método realiza a impressão dos números sorteados.
	public void imprimeNumerosSorteados(int[] numeros) {
		System.out.println("        --- Os números sorteados foram: ---          ");
		for (int i = 0; i < numeros.length; i++) {
			System.out.print("\t[" + numeros[i] + "]");
			if (i == 5 || i == 11 || i == 17 || i == 23) {
				System.out.print("\n");
			}
		}
		System.out.println("\n                --- Boa sorte! ---                  \n");
	}
}