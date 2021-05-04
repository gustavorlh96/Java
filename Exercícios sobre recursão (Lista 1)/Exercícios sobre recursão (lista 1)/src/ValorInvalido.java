public class ValorInvalido extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String erro;
	
	public ValorInvalido(String erro) {
		this.erro = erro;
		System.out.println(toString());
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public String toString() {
		return "\n" + getErro();
	}
}