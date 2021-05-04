public class ArrayNotPossibleException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public ArrayNotPossibleException(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public String toString() {
		return "\n!!! " + getMensagem() + " !!!\n";
	}
}