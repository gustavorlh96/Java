import java.util.Scanner;

class Principal{
	public static void main(String[] args){
		Carro carro1 = criaCarro();
		Carro carro2 = criaCarro();
		
		testaCarro(carro1);
		testaCarro(carro2);

		carro1.imprimeRelatorioAutonomia();
		carro2.imprimeRelatorioAutonomia();
		
		testaEconomico(carro1, carro2);
  }

  public static Carro criaCarro() {
	  Scanner in = new Scanner(System.in);
	  
	  System.out.println("==================================================\nCriando carro\n==================================================");
	  System.out.println("Qual é a marca do carro? ");
	  String marca = in.nextLine();

	  System.out.println("Qual é o modelo do carro? ");
	  String modelo = in.nextLine();


	  System.out.println("Digite a velocidade máxima do carro: ");
	  double velocidadeMax = in.nextDouble();

	  Carro carro1 = new Carro(marca, modelo, velocidadeMax, criaPerfilConsumo());

	  return carro1;
  }

  public static PerfilConsumo criaPerfilConsumo() {
	  Scanner in = new Scanner(System.in);
	  
	  System.out.println("Perfil de consumo:");
	  System.out.println("\tQual é o rendimento do carro na faixa de até 60 km/h? ");
	  double rendimento1 = in.nextDouble();

	  System.out.println("\tQual é o rendimento do carro na faixa acima de 60 e até 95 km/h? ");
	  double rendimento2 = in.nextDouble();

	  System.out.println("\tQual é o rendimento do carro na faixa acima de 95 km/h? ");
	  double rendimento3 = in.nextDouble();

	  PerfilConsumo rendimentoCarro1 = new PerfilConsumo(rendimento1, rendimento2, rendimento3);
    
	  return rendimentoCarro1;    
  }

  public static void testaCarro (Carro carro){
	  System.out.println("==================================================");
	  System.out.println("Testando o carro " + carro.toString());
	  System.out.println("==================================================");
	    
	  carro.ligaCarro();
	  int i;

	  for(i = 0; i < 5; i++){
		  carro.aumentaVelocidade();
		  carro.anda(0.5);
	  }

	  for(i = 0; i < 5; i++){
		  carro.aumentaVelocidade(40.0);
		  carro.anda();
	  }
  }
  
  public static void testaEconomico(Carro carro1, Carro carro2) {
	  if (carro1.getLitrosConsumidos() > carro2.getLitrosConsumidos()) {
		  System.out.println("==================================================");
		  System.out.println("Carro mais econômico: " + carro2.toString());
		  System.out.println("==================================================");
	  }
	  else {
		  System.out.println("==================================================");
		  System.out.println("Carro mais econômico: " + carro1.toString());
		  System.out.println("==================================================");
	  }
  }
}