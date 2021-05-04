public class Teste {
	
	public static void main(String[] args) {
		
		Administrativo a1 = new Administrativo("Wallace Breen", 2850.70, 199817, "noite", 200);
		Tecnico t1 = new Tecnico("Gordon Freeman", 1970.50, 200498, 379.95);
		
		System.out.println(a1.exibeDados());
		System.out.println(t1.exibeDados());
	}
}