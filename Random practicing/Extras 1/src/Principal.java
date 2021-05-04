public class Principal {

	public static void main(String[] args) {
		
		Livro l1 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937, 310, 41.99);
		Livro l2 = new Livro("O Senhor dos Anéis: A Sociedade do Anel", "J.R.R. Tolkien", 1954, 423, 44.90);
		Livro l3 = new Livro("O Mundo de Lore: Criaturas Estranhas", "Aaron Mahnke", 2019, 256, 40.73);
		
		Cliente c1 = new Cliente("Fulano Moraes", "fulano.moraes@outlook.com", "Masculino", "3123hgwh!%", 28);
		Cliente c2 = new Cliente("Fulana Souza", "fulana_souza90@gmail.com", "Feminino", "4872#!jk", 26);
		Cliente c3 = new Cliente("Fulana Machado", "fulanamachado@hotmail.com", "Feminino", "3123hgwh!%", 39);
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(l3.toString());
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
	}
}