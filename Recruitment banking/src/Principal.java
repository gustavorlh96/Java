public class Principal {
	
	// Método main: Aqui são inicializadas e armazenadas diversas pessoas, vagas
	// e competências, com fins de teste;
	public static void main(String[] args) {
		BancoDeVagas b1 = new BancoDeVagas();
		
		Data dataLilia = new Data(25, 4, 1999);
		Data dataMaria = new Data(10, 9, 1990);
		Data dataJulio = new Data(4, 11, 1989);
		Data dataVanessa = new Data(29, 12, 1988);
		
		Competencia compLilia1 = new Competencia("Java", 9);
		Competencia compLilia2 = new Competencia("C", 6);
		Competencia compLilia3 = new Competencia("Python", 7);
		Competencia compLilia4 = new Competencia("Ruby", 4);
		Competencia compLilia5 = new Competencia("JavaScript", 8);
		Competencia compLilia6 = new Competencia("HTML5", 6);
		
		Competencia compMaria1 = new Competencia("Python", 6);
		Competencia compMaria2 = new Competencia("JavaScript", 10);
		Competencia compMaria3 = new Competencia("jQuery", 8);
		Competencia compMaria4 = new Competencia("HTML5", 10);
		Competencia compMaria5 = new Competencia("PostgreSQL", 6);
		Competencia compMaria6 = new Competencia("MySQL", 8);
		
		Competencia compJulio1 = new Competencia("CSS", 8);
		Competencia compJulio2 = new Competencia("JavaScript", 10);
		Competencia compJulio3 = new Competencia("jQuery", 8);
		Competencia compJulio4 = new Competencia("HTML5", 7);
		Competencia compJulio5 = new Competencia("Sass", 6);
		Competencia compJulio6 = new Competencia("Bootstrap", 5);
		
		Competencia compVanessa1 = new Competencia("Scrum", 10);
		Competencia compVanessa2 = new Competencia("Kanban", 10);
		Competencia compVanessa3 = new Competencia("MySQL", 8);
		Competencia compVanessa4 = new Competencia("Lean", 7);
		Competencia compVanessa5 = new Competencia("Java", 6);
		Competencia compVanessa6 = new Competencia("Cascata", 8);
		Competencia compVanessa7 = new Competencia("PRINCE2", 6);
		
		Competencia[] arrayCompLilia = {compLilia1, compLilia2, compLilia3, compLilia4, compLilia5, compLilia6};
		Competencia[] arrayCompMaria = {compMaria1, compMaria2, compMaria3, compMaria4, compMaria5, compMaria6};
		Competencia[] arrayCompJulio = {compJulio1, compJulio2, compJulio3, compJulio4, compJulio5, compJulio6};
		Competencia[] arrayCompVanes = {compVanessa1, compVanessa2, compVanessa3, compVanessa4, compVanessa5, compVanessa6, compVanessa7};
		
		b1.listaCandidatos(); // Testa a lista antes de adicionar candidatos!
		
		Candidato lilia = new Candidato("Lilia", dataLilia, arrayCompLilia, 2750);
		Candidato maria = new Candidato("Maria", dataMaria, arrayCompMaria, 3750);
		Candidato julio = new Candidato("Julio", dataJulio, arrayCompJulio, 2000);
		Candidato vanessa = new Candidato("Vanessa", dataVanessa, arrayCompVanes, 5000);
		
		b1.adicionaCandidato(lilia);
		b1.adicionaCandidato(maria);
		b1.adicionaCandidato(julio);
		b1.adicionaCandidato(vanessa);
		
		b1.adicionaCandidato(julio);
		
		b1.listaCandidatos();
		
		Competencia comp1 = new Competencia("Java", 7);
		Competencia comp2 = new Competencia("C", 4);
		Competencia comp3 = new Competencia("Python", 8);
		Competencia comp4 = new Competencia("Ruby", 5);
		Competencia comp5 = new Competencia("JavaScript", 6);
		Competencia comp6 = new Competencia("HTML5", 5);
		Competencia comp7 = new Competencia("jQuery", 5);
		Competencia comp8 = new Competencia("PostgreSQL", 8);
		Competencia comp9 = new Competencia("MySQL", 8);
		Competencia comp10 = new Competencia("CSS", 7);
		Competencia comp11 = new Competencia("Sass", 5);
		Competencia comp12 = new Competencia("Bootstrap", 5);
		Competencia comp13 = new Competencia("Photoshop", 8);
		Competencia comp14 = new Competencia("Scrum", 8);
		Competencia comp15 = new Competencia("Cascata", 6);
		Competencia comp16 = new Competencia("Kanban", 8);
		Competencia comp17 = new Competencia("Lean", 6);
		Competencia comp18 = new Competencia("PRINCE2", 8);
		
		Competencia[] compDevBack = {comp1, comp2, comp3, comp4};
		Competencia[] compBanco = {comp8, comp9};
		Competencia[] compDevFront = {comp5, comp6, comp7, comp10};
		Competencia[] compGestor = {comp18, comp17, comp16, comp15, comp14, comp12, comp11};
		
		VagaDesenvolvedor vaga1 = new VagaDesenvolvedor("Programador Back-End", 4500.25, compDevBack, compBanco);
		VagaDesenvolvedor vaga2 = new VagaDesenvolvedor("Programador Front-End", 3500.60, compDevFront, compBanco);
		VagaGestor vaga3 = new VagaGestor("Gestor de Desenvolvimento", 5275.20, compGestor);
		
		vaga3.alteraReqMetodologias(comp17);
		vaga2.alteraReqLinguagens(comp13);
		
		b1.listaVagas(); // Testa a lista antes de adicionar vagas!
		
		b1.adicionaVaga(vaga1);
		b1.adicionaVaga(vaga2);
		b1.adicionaVaga(vaga3);
		
		b1.listaVagas();
		
		b1.listaVagasFiltro(4500);
		
	    b1.listaVagasParaCandidato(1);
		
		b1.listaCandidatosParaVaga(2);
		
		b1.listaVagasFiltro(comp16);
		
		b1.listaFuncionarios(); // Testa a lista antes de contratar alguém!
		
		b1.contratarCandidato(3, 4);
		
		b1.listaFuncionarios();
	}
	
	// Decidi não implementar os extras para ter mais tempo
	// de desenvolver e aprimorar as principais!
	public static Competencia geraCompetenciaAleatoria() {
		return null;
	}
	
	public static Vaga geraVagaAleatoria() {
		return null;
	}
	
	public static Candidato geraCandidatoAleatorio() {
		return null;
	}

}
