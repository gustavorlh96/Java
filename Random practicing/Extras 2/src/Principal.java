public class Principal {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		
		a1.setNome("Brandamente Brasil");
		a1.setMatricula("1585248");
		a1.setNotaA(5);
		a1.setNotaB(9);
		
		Aluno a2 = new Aluno();
		
		a2.setNome("Radigunda Cercen�");
		a2.setMatricula("2254879");
		a2.setNotaA(8);
		a2.setNotaB(2);
		
		Aluno a3 = new Aluno();
		
		a3.setNome("Vitimado Jos� Ara�jo");
		a3.setMatricula("0085994");
		a3.setNotaA(7);
		a3.setNotaB(1);
		
		a1.imprimeInfo();
		a2.imprimeInfo();
		a3.imprimeInfo();
		
		a2.setNotaA(9);
		
		System.out.println("" + a2.calculaMediaFinal());
		
		System.out.println("" + a3.getMatricula());
		
		a1.setMatricula("1585228");
		
		Pessoa p1 = new Pessoa("Excelsa", "Feminino", 19);
		Pessoa p2 = new Pessoa("Pac�fico", "Masculino", 102);
		
		p1.aumentaIdade();
		
		p1.imprimeInfo();
		p2.imprimeInfo();
	}
}