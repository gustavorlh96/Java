public class Computador {
	
	private double preco;
	private int ano;
	private String marca, estado;
	
	public Computador(double _preco, int _ano, String _marca, String _estado) {
		this.preco = _preco;
		this.ano = _ano;
		this.marca = _marca;
		this.estado = _estado;
	}

	public double getPreco() {
		return preco;
	}

	public int getAno() {
		return ano;
	}

	public String getMarca() {
		return marca;
	}

	public String getEstado() {
		return estado;
	}
	
	public void imprimeInfo() {
		System.out.println("---------Informa��es do computador---------");
		System.out.println("Pre�o: " + getPreco());
		System.out.println("Ano de fabrica��o: " + getAno());
		System.out.println("Marca: " + getMarca());
		System.out.println("Estado: " + getEstado());
		System.out.println("-------------------------------------------");
	}
}