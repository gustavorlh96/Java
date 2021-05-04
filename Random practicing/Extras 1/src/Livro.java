public class Livro {
	
	private String titulo, autor;
	private int anoPub, pags;
	private double preco;
	
	public Livro(String _titulo, String _autor, int _anoPub, int _pags, double _preco) {
		this.titulo = _titulo;
		this.autor = _autor;
		this.anoPub = _anoPub;
		this.pags = _pags;
		this.preco = _preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoPub() {
		return anoPub;
	}

	public void setAnoPub(int anoPub) {
		this.anoPub = anoPub;
	}

	public int getPags() {
		return pags;
	}

	public void setPags(int pags) {
		this.pags = pags;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPub=" + anoPub + ", pags=" + pags + ", preco="
				+ preco + "]";
	}
}