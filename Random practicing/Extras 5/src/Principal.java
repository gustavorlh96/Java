import java.util.Locale;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {	
		//criaComputador();
		//testaComputadores();
		testaFinanciamento();	
	}
	
	@SuppressWarnings("resource")
	public static Computador criaComputador() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite os dados do computador:");
		System.out.println("\tDigite o processador do computador: ");
		String cpu = in.nextLine();
		System.out.println("\tDigite a quantidade de memória RAM do computador: ");
		int ram = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite o tamanho do HD do computador: ");
		int hdd = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite a placa-mãe do computador: ");
		String mobo = in.nextLine();
		System.out.println("\tDigite a placa de vídeo do computador: ");
		String gpu = in.nextLine();
		
		return new Computador(cpu, mobo, gpu, ram, hdd);
	}
	
	@SuppressWarnings("resource")
	public static void testaComputadores() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("------------------------------------------------------");
		System.out.println("Testando os computadores");
		System.out.println("------------------------------------------------------");
		
		System.out.println("Digite os dados do computador 1:");
		System.out.println("\tDigite o processador do computador: ");
		String cpu1 = in.nextLine();
		System.out.println("\tDigite a quantidade de memória RAM do computador: ");
		int ram1 = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite o tamanho do HD do computador: ");
		int hdd1 = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite a placa-mãe do computador: ");
		String mobo1 = in.nextLine();
		System.out.println("\tDigite a placa de vídeo do computador: ");
		String gpu1 = in.nextLine();
		
		Computador c1 = new Computador(cpu1, mobo1, gpu1, ram1, hdd1);
		
		System.out.println("Digite os dados do computador 2:");
		System.out.println("\tDigite o processador do computador: ");
		String cpu2 = in.nextLine();
		System.out.println("\tDigite a quantidade de memória RAM do computador: ");
		int ram2 = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite o tamanho do HD do computador: ");
		int hdd2 = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite a placa-mãe do computador: ");
		String mobo2 = in.nextLine();
		System.out.println("\tDigite a placa de vídeo do computador: ");
		String gpu2 = in.nextLine();
		
		Computador c2 = new Computador(cpu2, mobo2, gpu2, ram2, hdd2);
		
		System.out.println("Digite os dados do computador 3:");
		System.out.println("\tDigite o processador do computador: ");
		String cpu3 = in.nextLine();
		System.out.println("\tDigite a quantidade de memória RAM do computador: ");
		int ram3 = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite o tamanho do HD do computador: ");
		int hdd3 = in.nextInt();
		in.nextLine();
		System.out.println("\tDigite a placa-mãe do computador: ");
		String mobo3 = in.nextLine();
		System.out.println("\tDigite a placa de vídeo do computador: ");
		String gpu3 = in.nextLine();
		
		Computador c3 = new Computador(cpu3, mobo3, gpu3, ram3, hdd3);
		
		System.out.println("\nComputador 1:");
		System.out.println(c1.toString());
		System.out.println("Computador 2:");
		System.out.println(c2.toString());
		System.out.println("Computador 3:");
		System.out.println(c3.toString());
		
		System.out.println("Digite a nova quantidade de memória RAM do computador 2: ");
		ram2 = in.nextInt();
		in.nextLine();
		c2.upgrade(ram2);
		
		System.out.println("Digite a nova placa de vídeo do computador 3: ");
		gpu3 = in.nextLine();
		c3.upgrade(gpu3);
		
		System.out.println("\nComputador 1:");
		System.out.println(c1.toString());
		System.out.println("Computador 2:");
		System.out.println(c2.toString());
		System.out.println("Computador 3:");
		System.out.println(c3.toString());
	}
	
	@SuppressWarnings("resource")
	public static void testaFinanciamento() {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		
		System.out.println("------------------------------------------------------");
		System.out.println("Testando o financiamento");
		System.out.println("------------------------------------------------------");
		
		System.out.println("Digite o valor a ser financiado: ");
		double fin1 = in.nextDouble();
		System.out.println("Digite o prazo (em meses): ");
		int prz1 = in.nextInt();
		in.nextLine();
		System.out.println("Digite a taxa de juros ao mês: ");
		double txj1 = in.nextDouble();
		
		Financiamento f1 = new Financiamento(fin1, txj1, prz1);
		
		f1.calculaValorParcela();
		
		System.out.println(f1.toString());
	}
}