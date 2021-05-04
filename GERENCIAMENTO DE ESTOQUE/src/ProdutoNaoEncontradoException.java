import java.util.Scanner;

public class ProdutoNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 4522399069975816503L;
	Scanner in = new Scanner(System.in);
	private String mensagem;
	
	public ProdutoNaoEncontradoException(String mensagem) {
		this.mensagem = mensagem;
		System.out.println(toString());
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	public boolean tentarNovaBusca() {
		while (true) {
			String escolha = in.nextLine();
			
			if (escolha.equalsIgnoreCase("s"))
				return true;
			else if (escolha.equalsIgnoreCase("n"))
				return false;
			else
				System.out.println("ERRO: Entrada inválida, digite novamente.");
		}
	}
	
	public String novoNomeBusca() {
		System.out.println("Digite um novo nome para buscar: ");
		while (true) {
			String novoNome = in.nextLine();
			
			if (novoNome.equalsIgnoreCase("") || novoNome == null)
				System.out.println("ERRO: O nome não pode ser nulo, digite novamente.");
			else
				return novoNome;		
		}
	}
	
	public String toString() {
		return "\nERRO: " + getMensagem() + ". Deseja realizar uma nova busca [S/N]?\n";
	}
}