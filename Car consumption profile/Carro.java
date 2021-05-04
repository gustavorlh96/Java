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
	
	// Método aumentaVelocidade sem assinatura. Chama o método aumentaVelocidade que tem assinatura (double percentual) através do valor 20.
	public void aumentaVelocidade() {
		aumentaVelocidade(20);
	}

	// Método aumentaVelocidade com assinatura.
	public void aumentaVelocidade(double percentual) {


		if (this.velocidade < this.velocidadeMax) {
			this.velocidade = (this.velocidade * (1 + percentual / 100));
	        
			if (this.velocidade > this.velocidadeMax) {
				this.velocidade = this.velocidadeMax;
				System.out.println("Velocidade máxima alcançada! Velocidade atual: " + this.velocidade + " km/h");
				return;
				}
			
			double velocidadeAtualTemp = this.velocidade; // Aqui criei uma varíavel temporária para mostrar a velocidade atual sem interferir na precisão do cálculo!
			velocidadeAtualTemp = Math.round(velocidadeAtualTemp * 100.0) / 100.0;
			System.out.println("Velocidade atual: " + velocidadeAtualTemp + " km/h");
			}
		else if (this.velocidade == this.velocidadeMax) {
			System.out.println("Não é possível andar mais rápido! Velocidade atual: " + this.velocidade + " km/h");
			return;
			}
	    
		if (this.ligado == false) {
			System.out.println("Carro desligado!");
			return;
			}
		}

	// Método anda sem assinatura. Chama o método anda que tem assinatura (double horas) através do valor 1.0.
	public void anda() {
		anda(1.0);
	}

	// Método anda com assinatura.
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
		System.out.println("Relatório de consumo do " + toString());
		System.out.println("==================================================");
		System.out.println("Distância percorrida: " + this.distPercorrida + " km");
		System.out.println("Tempo de uso: " + this.horasDeUso + " horas");
		System.out.println("Consumo médio: " + getConsumoMedio() + " km/l");
		System.out.println("Consumo total: " + getLitrosConsumidos() + " litros");
	}
	
	public String toString() {
		return this.marca + " " + this.modelo;
	}
}