import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalIBOPE {

	public static void main(String[] args) throws IOException, ArrayNotPossibleException {
		String[] arrayNomes = new String[contaLinhas("listanomes")];
		String[] arraySobrenomes = new String[contaLinhas("listasobrenomes")];
		String[] arrayPartidos = new String[contaLinhas("listapartidos")];
		arrayNomes = preencheArrays("listanomes", arrayNomes);
		arraySobrenomes = preencheArrays("listasobrenomes", arraySobrenomes);
		arrayPartidos = preencheArrays("listapartidos", arrayPartidos);
		
		int quantidadeCandidatos = (int) ((Math.random() * 1000) + 1);
		Candidato[] arrayCandidatos = new Candidato[quantidadeCandidatos + 2];
		registraCandidatosRealizaPesquisa(arrayCandidatos, arrayNomes, arraySobrenomes, arrayPartidos);
		imprimeCandidatos(arrayCandidatos);
	}
	
	public static Candidato[] registraCandidatosRealizaPesquisa(Candidato[] arrayCandidatos, String[] arrayNomes, String[] arraySobrenomes, String[] arrayPartidos) {
		int eleitores = (int)((Math.random() * 2000) + 1500);
		int votosBrancos = (int)((Math.random() * (eleitores + 1)) * 1/3);
		eleitores -= votosBrancos;
		int indecisos = (int)((Math.random() * (eleitores + 1)) * 1/3);
		eleitores -= indecisos;
		
		if (eleitores <= 0)
			eleitores = 0;
		
		arrayCandidatos[arrayCandidatos.length - 1] = new Candidato("Branco", "Branco", "Branco");
		arrayCandidatos[arrayCandidatos.length - 1].setIntencaoVotos(votosBrancos);
		arrayCandidatos[arrayCandidatos.length - 2] = new Candidato("Indeciso", "Indeciso", "Indeciso");
		arrayCandidatos[arrayCandidatos.length - 2].setIntencaoVotos(indecisos);
		for (int i = 0; i < arrayCandidatos.length; i++)
			if (arrayCandidatos[i] == null) {
				arrayCandidatos[i] = new Candidato(arrayNomes[(int)(Math.random() * arrayNomes.length)], arraySobrenomes[(int)(Math.random() * arraySobrenomes.length)], arrayPartidos[(int)(Math.random() * arrayPartidos.length)]);
				if (eleitores <= 0)
					arrayCandidatos[i].setIntencaoVotos(0);
				else {
					int intencaoVotos = (int)((Math.random() * (eleitores + 1)) * 1/3);
					arrayCandidatos[i].setIntencaoVotos(intencaoVotos);
					eleitores -= intencaoVotos;
				}
			}
		return arrayCandidatos;
	}
	
	public static String[] preencheArrays(String nomeDoArquivo, String[] array) throws IOException {
		FileReader fr = new FileReader(nomeDoArquivo + ".txt");
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		
		for (int i = 0; i < array.length; i++) {
			if (linha != null)
				array[i] = linha.trim();
			linha = br.readLine();
		}
		br.close();
		return array;
	}
	
	public static Candidato[] insercaoDiretaNome(Candidato[] arrayCandidatos) {
		for (int i = 1; i < arrayCandidatos.length - 2; i++) {
			int j = i;
			Candidato candidatoTemp = arrayCandidatos[i];
			String nomeTemp = candidatoTemp.getNome();
			String sobrenomeTemp = candidatoTemp.getSobrenome();
			String partidoTemp = candidatoTemp.getPartido();
			int intencoesVotoTemp = candidatoTemp.getIntencaoVotos();
			if (arrayCandidatos[j - 1].getNome().equalsIgnoreCase(nomeTemp) && arrayCandidatos[j - 1].getSobrenome().equalsIgnoreCase(sobrenomeTemp) && arrayCandidatos[j - 1].getIntencaoVotos() == intencoesVotoTemp) {
				while ((j > 0) && (arrayCandidatos[j - 1].getPartido().compareToIgnoreCase(partidoTemp) > 0)) {
					arrayCandidatos[j] = arrayCandidatos[j - 1];
					j--;
					}
			}
			else if (arrayCandidatos[j - 1].getNome().equalsIgnoreCase(nomeTemp) && arrayCandidatos[j - 1].getSobrenome().equalsIgnoreCase(sobrenomeTemp)) {
				while ((j > 0) && (arrayCandidatos[j - 1].getIntencaoVotos() > intencoesVotoTemp)) {
					arrayCandidatos[j] = arrayCandidatos[j - 1];
					j--;
					}
			}
			else if (arrayCandidatos[j - 1].getNome().equalsIgnoreCase(nomeTemp)) {
				while ((j > 0) && (arrayCandidatos[j - 1].getSobrenome().compareToIgnoreCase(sobrenomeTemp) > 0)) {
					arrayCandidatos[j] = arrayCandidatos[j - 1];
					j--;
					}
			}
			else {
				while ((j > 0) && (arrayCandidatos[j - 1].getNome().compareToIgnoreCase(nomeTemp) > 0)) {
					arrayCandidatos[j] = arrayCandidatos[j - 1];
					j--;
					}
			}
			arrayCandidatos[j] = candidatoTemp;
		}
		return arrayCandidatos;
	}
	
	public static void imprimeCandidatos(Candidato[] arrayCandidatos) throws ArrayNotPossibleException {
		arrayCandidatos = insercaoDiretaNome(arrayCandidatos);
		
		for (int i = 0; i < arrayCandidatos.length; i++) {
			if (arrayCandidatos[i] != null)
				System.out.println(arrayCandidatos[i].toString());
				if (i == arrayCandidatos.length - 1)
					System.out.println("------------------------------");
		}
		new IBOPE().candidatoMelhorColocado(arrayCandidatos);
	}
	
	public static int contaLinhas(String nomeDoArquivo) throws IOException {
		int contador = 0;
		FileReader fr = new FileReader(nomeDoArquivo + ".txt");
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		
		while (linha != null) {
			contador++;
			linha = br.readLine();
		}
		br.close();
		return contador;
	}
}