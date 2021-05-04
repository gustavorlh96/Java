import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
	
	static String nome;
	static boolean flagGeral = false, flagConfirma;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {	
		
		System.out.println("\t\t*** Verificador de grafia ***\nDigite o seu nome: ");
		nome = in.nextLine().replaceAll("[\\\\,.?!@(){}\\[\\]/]", "");
		
		do {
			digitaTexto();
			
			System.out.println("Deseja continuar [S/N]?");
			do {
				flagConfirma = false;
				String confirma = in.nextLine();
				
				if (confirma.equalsIgnoreCase("S"))
					flagConfirma = true;
				else if (confirma.equalsIgnoreCase("N")) {
					flagConfirma = true;
					flagGeral = true;
				}
				else
					System.out.println("Entrada inválida, digite novamente.");
			} while (flagConfirma == false);
		} while (flagGeral == false);
	}
	
	public static void digitaTexto() {
		System.out.println("Digite o texto: ");
		String texto = in.nextLine();
		verificaTexto(texto);
	}
	
	public static void verificaTexto(String textoDigitado) {
		boolean existeErros = false;
		String textoAjustado = textoDigitado.replaceAll("[\\\\,.?!:;@(){}\\[\\]/]", "");
		
		try {
			FileReader fr = new FileReader("palavras/palavras.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String linha = br.readLine();
			
			String[] palavrasTexto = textoAjustado.trim().split("\\s");
			String[] palavrasCertasTexto = new String[palavrasTexto.length];
			
			while (linha != null) {
				for (int i = 0; i < palavrasTexto.length; i++)
					if (palavrasTexto[i] != null)
						if (palavrasTexto[i].equalsIgnoreCase(linha)) {
							palavrasCertasTexto[i] = palavrasTexto[i];
							palavrasTexto[i] = null;
						}				
				linha = br.readLine();
			}
			br.close();
			
			for (int i = 0; i < palavrasTexto.length; i++)
				if (palavrasTexto[i] != null)
					existeErros = true;
			
			if (existeErros == true) {
				System.out.println("Verifique a grafia das seguintes palavras:");
				for (int i = 0; i < palavrasTexto.length; i++)
					if (palavrasTexto[i] != null)
						System.out.println(palavrasTexto[i]);
			} else
				System.out.println("Não há erros de grafia no texto.");
			
			existeErros = false;
			
			File f = new File (nome + ".txt");
			FileWriter fw = new FileWriter (f, true);
			PrintWriter out = new PrintWriter (fw);
			
			if (textoDigitado != null) {
				out.println("[TEXTO] " + textoDigitado + "\n[ERROS]");
				
				for (int i = 0; i < palavrasTexto.length; i++) 
					if (palavrasTexto[i] != null) {
						existeErros = true;
						out.println(palavrasTexto[i]);
					}
				
				if (existeErros == false)
					out.println("Não há erros de grafia no texto.");
			}	
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
