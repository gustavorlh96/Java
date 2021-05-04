public class Carro {
	
	private String marca, modelo;
	private double velocidade, velocidadeMax, distPercorrida, horasDeUso;
	private PerfilConsumo perfilConsumo;
	private boolean ligado;
	
	public Carro(String marca, String modelo, double velocidadeMax, PerfilConsumo perfilConsumo) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadeMax = velocidadeMax;
		this.perfilConsumo = perfilConsumo;
		this.velocidade = 0;
		this.distPercorrida = 0;
		this.horasDeUso = 0;
		this.ligado = false;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public double getDistPercorrida() {
		return distPercorrida;
	}

	public double getHorasDeUso() {
		return horasDeUso;
	}
	
	public double getLitrosConsumidos() {
		double litros = perfilConsumo.getLitrosConsumidos();
		litros = Math.round(litros * 100.0) / 100.0; // Arredonda o resultado para dois digitos!
		return litros;
	}
	
	public double getConsumoMedio() {
		double consumoMedio = (this.distPercorrida / getLitrosConsumidos());
		consumoMedio = Math.round(consumoMedio * 100.0) / 100.0;
		if (consumoMedio == 0) {
			return 0;
		}
		else {
		return consumoMedio;
		}
	}
	
	public void ligaCarro() {
		if (this.ligado == true) {
			return;
		}
		else {
			this.velocidade = 20;
			this.ligado = true;
		}
	}
	
	// M�todo aumentaVelocidade sem assinatura. Chama o m�todo aumentaVelocidade que tem assinatura (double percentual) atrav�s do valor 20.
	public void aumentaVelocidade() {
		aumentaVelocidade(20);
	}

	// M�todo aumentaVelocidade com assinatura.
	public void aumentaVelocidade(double percentual) {


		if (this.velocidade < this.velocidadeMax) {
			this.velocidade = (this.velocidade * (1 + percentual / 100));
	        
			if (this.velocidade > this.velocidadeMax) {
				this.velocidade = this.velocidadeMax;
				System.out.println("Velocidade m�xima alcan�ada! Velocidade atual: " + this.velocidade + " km/h");
				return;
				}
			
			double velocidadeAtualTemp = this.velocidade; // Aqui criei uma var�avel tempor�ria para mostrar a velocidade atual sem interferir na precis�o do c�lculo!
			velocidadeAtualTemp = Math.round(velocidadeAtualTemp * 100.0) / 100.0;
			System.out.println("Velocidade atual: " + velocidadeAtualTemp + " km/h");
			}
		else if (this.velocidade == this.velocidadeMax) {
			System.out.println("N�o � poss�vel andar mais r�pido! Velocidade atual: " + this.velocidade + " km/h");
			return;
			}
	    
		if (this.ligado == false) {
			System.out.println("Carro desligado!");
			return;
			}
		}

	// M�todo anda sem assinatura. Chama o m�todo anda que tem assinatura (double horas) atrav�s do valor 1.0.
	public void anda() {
		anda(1.0);
	}

	// M�todo anda com assinatura.
	public void anda(double horas) {
		double distancia = this.velocidade * horas;
		this.distPercorrida += distancia;
		this.horasDeUso += horas;
	  
		perfilConsumo.atualizaConsumo(this.velocidade, horas);
	}

	public void imprimeRelatorioAutonomia() {
	  
		this.distPercorrida = Math.round(this.distPercorrida * 100.0) / 100.0; // Arredonda o resultado para dois digitos!
		this.horasDeUso = Math.round(this.horasDeUso * 100.0) / 100.0;
		System.out.println("==================================================");
		System.out.println("Relat�rio de consumo do " + toString());
		System.out.println("==================================================");
		System.out.println("Dist�ncia percorrida: " + this.distPercorrida + " km");
		System.out.println("Tempo de uso: " + this.horasDeUso + " horas");
		System.out.println("Consumo m�dio: " + getConsumoMedio() + " km/l");
		System.out.println("Consumo total: " + getLitrosConsumidos() + " litros");
	}
	
	public String toString() {
		return this.marca + " " + this.modelo;
	}
}