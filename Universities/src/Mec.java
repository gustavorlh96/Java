public class Mec {
	private Universidade[] universidades;
	
	public Mec() {
		this.universidades = new Universidade[10];
	}
	
	public boolean credenciaUniversidade(Universidade regUni) {
		boolean verif = false;
		for (int i = 0; i < universidades.length; i++) {
			if (universidades[i] == null) {
				universidades[i] = regUni;
				verif = true;
				return verif;
			}
			else {
				verif = false;
				continue;
			}
		}
		return verif;
	}
	
	public boolean descredenciaUniversidade(Universidade delUni) {
		boolean verif = false;
		for (int i = 0; i < universidades.length; i++) {
			if (universidades[i] != null) {
				if (universidades[i].getNome().equals(delUni.getNome())) {
					universidades[i] = null;
					verif = true;
					return verif;
					}
				else {
					verif = false;
					continue;
					}
				}
			}
		return verif;
	}
	
	public void imprimeUniversidades() {
		System.out.println("\t==== *** Universidades credenciadas *** ====");
		System.out.println("============================================");
		for (int i = 0; i < universidades.length; i++) {
			if (universidades[i] != null) {
				if (universidades[i] instanceof UnivPublica) {
					System.out.println(((UnivPublica)universidades[i]).toString()); // Conversão!
				}
				else if (universidades[i] instanceof UnivPrivada) {
					System.out.println(((UnivPrivada)universidades[i]).toString());
				}
			}
		}
		System.out.println("============================================");
	}
	
	public void universidadeMaisCara() {
		double maiorMens = 0;
		Universidade maisCara = null;
		for (int i = 0; i < universidades.length; i++) {
			if (universidades[i] != null) {
				if (universidades[i] instanceof UnivPrivada) {
					if (((UnivPrivada)universidades[i]).getValorMensalidade() > 0) {
						if (((UnivPrivada)universidades[i]).getValorMensalidade() > maiorMens) {
							maiorMens = ((UnivPrivada)universidades[i]).getValorMensalidade();
							maisCara = (UnivPrivada)universidades[i];
						}
					}
				}
			}
		}
		if (maiorMens != 0) {
			System.out.println("\t==== A universidade mais cara é: ====");
			System.out.println(maisCara.toString());
			System.out.println("=========================================");
		}
		else {
			System.out.println("============================================");
			System.out.println("Não foram encontradas universidades privadas!");
			System.out.println("============================================");
		}
	}
	
	public void universidadesDoSul() {
		boolean verif = false;
		System.out.println("\t==== Universidades do sul do Brasil: ====");
		for (int i = 0; i < universidades.length; i++) {
			if (universidades[i] != null) {
				if (universidades[i] instanceof UnivPublica) {
					String estadoSul = ((UnivPublica)universidades[i]).getEstado();
					if (estadoSul.equals("RS") || estadoSul.equals("SC") || estadoSul.equals("PR")) {
						verif = true;
						System.out.println(((UnivPublica)universidades[i]).toString());
						}
					}
				}
			}
		if (verif == false) {
			System.out.println("============================================");
			System.out.println("Não foram encontradas universidades públicas no sul do Brasil!");
			System.out.println("============================================");
		}
	}
}