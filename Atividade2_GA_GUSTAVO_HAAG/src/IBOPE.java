public class IBOPE {
	
	public Candidato candidatoMelhorColocado(Candidato[] array) {
		try {
			for (int i = 0; i < array.length; i++)
				if (array[i] == null) throw new ArrayNotPossibleException("ERRO: O array é nulo.");
		} catch (ArrayNotPossibleException e) {
			System.out.println(e.toString());
			return new Candidato(null, null, null);
		}
		return candidatoMelhorColocado(array, null, 0, 0);
	}
	
	private Candidato candidatoMelhorColocado(Candidato[] array, Candidato c, int maiorIntencao, int i) {
		if (i >= array.length - 2) {
			System.out.println("\n***** Candidato(a) com maior intenção de votos segundo a pesquisa do IBOPE: *****\n" + c.toString() + "\n------------------------------");
			return c;
		}
		return array[i].getIntencaoVotos() > maiorIntencao ? candidatoMelhorColocado(array, c = array[i], maiorIntencao = array[i].getIntencaoVotos(), ++i) : candidatoMelhorColocado(array, c, maiorIntencao, ++i);
	}
}