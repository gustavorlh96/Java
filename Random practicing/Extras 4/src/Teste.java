import java.util.Scanner;

public class Teste {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String n1 = in.nextLine();
		String c1 = in.nextLine();
		
		Time time1 = new Time(n1, c1);
		
		Time time2 = new Time();
		
		String n2 = in.nextLine();
		
		time2.setNome(n2);
		
		time2.setCategoria("Vôlei");
		
		int s1 = in.nextInt();
		in.nextLine();
		
		time1.setQuantSocios(s1);
		
		String h1 = in.nextLine();
		
		time1.setHistorico(h1);
		
		int a1 = in.nextInt();
		in.nextLine();
		
		time1.setAno(a1);
		
		Torcedor t1 = new Torcedor("Vandressa", "Feminino", 27);
		
		Torcedor t2 = new Torcedor();
		
		t2.setNome("Ribelton Cruz");

		t2.setSexo("Masculino");
		
		t1.setTime(time1);
		
		t2.setTime(time2);
		
		time1.contagemRegressiva();
		
		time2.calculaIdade(2021);
		
		time2.calculaReceita();
		
		Torcedor t3 = new Torcedor("André", 32);
		
		Torcedor t4 = new Torcedor("Richeli", 22);
		
		Torcedor t5 = new Torcedor("Petrúcio", 54);
		
		Time time3 = new Time("São José", "Basquete");
		
		t3.setTime(time3);
		t4.setTime(time3);
		t5.setTime(time3);
		
		t4.setNome("Rochele");
	}
}