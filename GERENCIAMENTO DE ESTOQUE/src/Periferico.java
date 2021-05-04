public class Periferico extends Produto {
	
	private String serial, id;
	
	public Periferico(String _nome, String _descricao, double _preco, String serial, String id) {
		super(_nome, _descricao, _preco);
		this.serial = serial;
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		return "[Periférico]\nNome: " + getNome() + "\nDescrição: " + getDescricao() + "\nPreço: R$ " + getPreco()
				+ " reais\nCódigo serial: " + getSerial() + "\nID: " + getId();
	}
}