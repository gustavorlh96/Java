public class Financiamento {
	
	private double valorFinanciado, taxaJurosMes, parcelaFixa, valorFinal;
	private int prazo;
	
	public Financiamento(double _valorFinanciado, double _taxaJurosMes, int _prazo) {
		this.valorFinanciado = _valorFinanciado;
		this.taxaJurosMes = _taxaJurosMes;
		this.prazo = _prazo;
		this.parcelaFixa = 0;
		this.valorFinal = 0;
	}

	public double getValorFinanciado() {
		return valorFinanciado;
	}

	public double getTaxaJurosMes() {
		return taxaJurosMes;
	}

	public double getParcelaFixa() {
		return parcelaFixa;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public int getPrazo() {
		return prazo;
	}
	
	public void calculaValorParcela() {
		double juroSimplesTotal = getPrazo() * getTaxaJurosMes();
		this.valorFinal = getValorFinanciado() * (100 + juroSimplesTotal);
		this.parcelaFixa = getValorFinal() / getPrazo();
	}
	
	public String toString() {
		System.out.println("Dados do financiamento: ");
		
		return "\nValor financiado: R$ " + getValorFinanciado() + "\nPrazo: " + getPrazo() + " meses\nTaxa de juros: "
				+ getTaxaJurosMes() + "% ao mês\nValor da parcela: R$ " + getParcelaFixa() + "\nValor total final: R$ "
				+ getValorFinal();
	}
}