public class PerfilConsumo {
	
	private double rendimentoFaixa1, rendimentoFaixa2, rendimentoFaixa3, litrosConsumidos, mediaConsumo;
	
	public PerfilConsumo(double rendimentoFaixa1, double rendimentoFaixa2, double rendimentoFaixa3) {
		this.rendimentoFaixa1 = rendimentoFaixa1;
		this.rendimentoFaixa2 = rendimentoFaixa2;
		this.rendimentoFaixa3 = rendimentoFaixa3;
		this.litrosConsumidos = 0;
		this.mediaConsumo = 0;
	}

	public double getLitrosConsumidos() {
		return litrosConsumidos;
	}
	
	public double calculaRendimento(double velocidade) {
		
		if (velocidade <= 60) {
			return this.rendimentoFaixa1;
		}
		else if (velocidade > 60 && velocidade <= 95) {
			return this.rendimentoFaixa2;
		}
		else {
			return this.rendimentoFaixa3;
		}
	}
	
	public void atualizaConsumo(double velocidade, double tempo) {
		
		this.mediaConsumo = (velocidade * tempo) / calculaRendimento(velocidade);
		this.litrosConsumidos += this.mediaConsumo;
	}
}