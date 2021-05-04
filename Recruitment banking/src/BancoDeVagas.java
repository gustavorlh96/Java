public class BancoDeVagas {
	
	private Vaga[] vagas;
	private Candidato[] candidatos;
	private Funcionario[] funcionarios;
	
	// Método construtor padrão da classe BancoDeVagas;
	public BancoDeVagas() {
		this.vagas = new Vaga[100];
		this.candidatos = new Candidato[100];
		this.funcionarios = new Funcionario[100];
	}
	
	// Método que recebe uma vaga e verifica se ela já existe;
	// Se sim: Retorna mensagem que ela já existe;
	// Se não: Adiciona a vaga para o array de vagas da classe
	// e retorna mensagem de confirmação;
	public boolean adicionaVaga(Vaga vaga) {
		boolean verif = false;
		
		System.out.println("***                  Adição de vagas                 ***");
		System.out.println("========================================================");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				if (vagas[i].equals(vaga)) {
					System.out.println("Vaga já existente!");
					System.out.println("========================================================\n");
					return verif;
				}
			}
		}
		
		if (verif == false) {
			for (int i = 0; i < vagas.length; i++) {
				if (vagas[i] == null) {
					vagas[i] = vaga;
					verif = true;
					System.out.println("A vaga " + vaga.getDescricao() + " foi adicionada com sucesso!");
					System.out.println("========================================================\n");
					return verif;
				}
			}
		}
		return verif;
	}
	
	// Método que recebe um candidato e verifica se ele já existe;
	// Se sim: Retorna mensagem que ele já existe;
	// Se não: Adiciona o candidato para o array de candidatos da classe
	// e retorna mensagem de confirmação;
	public boolean adicionaCandidato(Candidato candidato) {
		boolean flag = false;
		
		System.out.println("***               Adição de candidatos               ***");
		System.out.println("========================================================");
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] != null) {
				if (candidatos[i].getNome() == candidato.getNome() && candidatos[i].getId() == candidato.getId()) {
					System.out.println("Candidato(a) " + candidato.getNome() + " já está cadastrado!");
					System.out.println("========================================================\n");
					return flag;
				}
			}
		}
		
		if (flag == false) {
			for (int i = 0; i < candidatos.length; i++) {
				if (candidatos[i] == null) {
					candidatos[i] = candidato;
					System.out.println("Candidato(a) " + candidato.getNome() + " foi adicionado com sucesso!");
					flag = true;
					System.out.println("========================================================\n");
					return flag;
				}
				else if (candidatos[i] != null && i == 99) {
					System.out.println("A capacidade máxima de candidatos foi atingido!");
				}
			}
		}
		System.out.println("========================================================\n");
		return flag;
	}
	
	// Este método recebe um ID de uma vaga e de um candidato, com o objetivo
	// de "contratar" um candidato em uma vaga específica;
	// Aqui a flag tem um diferente objetivo dos anteriores, servindo para
	// verificar se o ID da vaga ou candidato de fato existe de acordo com
	// o processo de inserção;
	// Se sim: Retorna uma mensagem com o nome do contratado;
	// Se não: Retorna uma mensagem de erro;
	// Importante ressaltar: A partir daqui, essa classe utiliza flags como
	// neste método: Apenas para verificar se de fato a ação ocorreu;
	public boolean contratarCandidato(int idVaga, int idCandidato) {
		boolean flag = false;
		
		Funcionario contratado = null;
		
		System.out.println("***             Contratador de candidatos            ***");
		System.out.println("========================================================");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				if (vagas[i].getId() == idVaga) {
					for (int j = 0; j < candidatos.length; j++) {
						if (candidatos[j] != null) {
							if (candidatos[j].getId() == idCandidato) {
								contratado = new Funcionario(candidatos[j].getNome(), candidatos[j].getDataNascimento(), vagas[i].getDescricao(), vagas[i].getSalario());
								for (int k = 0; k < funcionarios.length; k++) {
									if (funcionarios[k] == null) {
										funcionarios[k] = contratado;
										vagas[i] = null;
										candidatos[j] = null;
										flag = true;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (flag == false) {
			System.out.println("ID de vaga/candidato inválido!");
			System.out.println("========================================================\n");
			return flag;
		}
		else {
			System.out.println("Candidato(a) " + contratado.getNome() + " foi contratado(a)!");
			System.out.println("========================================================\n");
			return flag;
		}
	}
	
	// Método que lista as vagas que combinam com as competências e níveis
	// do candidato, recebendo o ID dele para buscar;
	// Retorna lista se as competências forem compatíveis ou mensagem
	// caso não encontre nada;
	public void listaVagasParaCandidato(int idCandidato) {
		boolean flag = false;
		
		Candidato tempCandidato = null;
		Vaga[] tempVagas = new Vaga[100];
		
		System.out.println("*** Lista de vagas (De acordo com o ID do candidato) ***");
		System.out.println("========================================================");
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] != null) {
				if (candidatos[i].getId() == idCandidato) {
					tempCandidato = candidatos[i]; // Guardar "Candidato" para facilitar futuros laços!
					break;
				}
			}
		}
		
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null && tempCandidato != null) {
				if (vagas[i].getSalario() >= tempCandidato.getExpSalario()) {
					if (vagas[i] instanceof VagaDesenvolvedor) {
						VagaDesenvolvedor vagaDev = (VagaDesenvolvedor)vagas[i];
						for (int j = 0; j < vagaDev.getReqLinguagens().length; j++) {
							for (int k = 0; k < tempCandidato.getCompetencias().length; k++) {
								if (vagaDev.getReqLinguagens()[j].getCompetencia() == tempCandidato.getCompetencias()[k].getCompetencia()
									&& vagaDev.getReqLinguagens()[j].getNivel() <= tempCandidato.getCompetencias()[k].getNivel()) {
									flag = true;
									tempVagas[i] = vagas[i];
									break;
								}
							}
							break;
						}
						
						if (flag == false) {
							for (int j = 0; j < vagaDev.getReqBancosDeDados().length; j++) {
								for (int k = 0; k < tempCandidato.getCompetencias().length; k++) {
									if (vagaDev.getReqBancosDeDados()[j].getCompetencia() == tempCandidato.getCompetencias()[k].getCompetencia()
										&& vagaDev.getReqLinguagens()[j].getNivel() <= tempCandidato.getCompetencias()[k].getNivel()) {
										flag = true;
										tempVagas[i] = vagas[i];
										break;
									}
								}
								break;
							}
						}
						
						
					}
					else if (vagas[i] instanceof VagaGestor) {
						VagaGestor vagaGest = (VagaGestor)vagas[i];
						for (int j = 0; j < vagaGest.getReqMetodologias().length; j++) {
							for (int k = 0; k < tempCandidato.getCompetencias().length; k++) {
								if (vagaGest.getReqMetodologias()[j].getCompetencia() == tempCandidato.getCompetencias()[k].getCompetencia()
									&& vagaGest.getReqMetodologias()[j].getNivel() <= tempCandidato.getCompetencias()[k].getNivel()) {
									flag = true;
									tempVagas[i] = vagas[i];
									break;
								}
								break;
							}
						}
					}
				}
			}
		}
		
		if (flag == false) {
			System.out.println("Não foi encontrada vagas!");
		}
		else {
			for (int i = 0; i < tempVagas.length; i++) {
				if (tempVagas[i] != null) {
					System.out.println(tempVagas[i].toString());
				}
			}
		}
		System.out.println("========================================================\n");
	}
	
	// Neste método ocorre o oposto do último: Recebe ID de uma vaga e verifica quais
	// candidatos são compatíveis!
	// Retorna lista se os candidatos forem compatíveis com a vaga ou mensagem
	// caso não encontre nada;
	public void listaCandidatosParaVaga(int idVaga) {
		boolean flag = false;
		
		Vaga tempVaga = null;
		Candidato[] tempCandidatos = new Candidato[100];
		
		System.out.println("*** Lista de candidatos (De acordo com o ID da vaga) ***");
		System.out.println("========================================================");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				if (vagas[i].getId() == idVaga) {
					tempVaga = vagas[i];
					System.out.println(tempVaga.toString());
					break;
				}
			}
		}
		
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] != null && tempVaga != null) {
				if (candidatos[i].getExpSalario() <= tempVaga.getSalario()) {
					if (tempVaga instanceof VagaDesenvolvedor) {
						VagaDesenvolvedor vagaDev = (VagaDesenvolvedor)tempVaga;
						for (int j = 0; j < vagaDev.getReqLinguagens().length; j++) {
							for (int k = 0; k < candidatos[i].getCompetencias().length; k++) {
								if (vagaDev.getReqLinguagens()[j].getCompetencia() == candidatos[i].getCompetencias()[k].getCompetencia()
									&& vagaDev.getReqLinguagens()[j].getNivel() <= candidatos[i].getCompetencias()[k].getNivel()) {
									flag = true;
									tempCandidatos[i] = candidatos[i];
									break;
								}
							}
							break;
						}
						
						if (flag == false) {
							for (int j = 0; j < vagaDev.getReqBancosDeDados().length; j++) {
								for (int k = 0; k < candidatos[i].getCompetencias().length; k++) {
									if (vagaDev.getReqBancosDeDados()[j].getCompetencia() == candidatos[i].getCompetencias()[k].getCompetencia()
										&& vagaDev.getReqLinguagens()[j].getNivel() <= candidatos[i].getCompetencias()[k].getNivel()) {
										flag = true;
										tempCandidatos[i] = candidatos[i];
										break;
									}
								}
								break;
							}
						}
						
						
					}
					else if (tempVaga instanceof VagaGestor) {
						VagaGestor vagaGest = (VagaGestor)tempVaga;
						for (int j = 0; j < vagaGest.getReqMetodologias().length; j++) {
							for (int k = 0; k < candidatos[i].getCompetencias().length; k++) {
								if (vagaGest.getReqMetodologias()[j].getCompetencia() == candidatos[i].getCompetencias()[k].getCompetencia()
									&& vagaGest.getReqMetodologias()[j].getNivel() <= candidatos[i].getCompetencias()[k].getNivel()) {
									flag = true;
									tempCandidatos[i] = candidatos[i];
									break;
								}
								break;
							}
						}
					}
				}
			}
		}
		
		if (flag == false) {
			System.out.println("Não foi encontrado candidatos!");
		}
		else {
			for (int i = 0; i < tempCandidatos.length; i++) {
				if (tempCandidatos[i] != null) {
					System.out.println(tempCandidatos[i].toString());
				}
			}
		}
		System.out.println("========================================================\n");
	}
	
	// Este método lista vagas que forem compatíveis com candidatos que tem expectativas
	// salariais menores ou iguais a remuneração das vagas!
	// Retorna mensagem caso não encontre vagas;
	public void listaVagasFiltro(double expSalarial) {
		boolean flag = false;
		
		System.out.println("*** Lista de vagas (Compatíveis com a exp. salarial) ***");
		System.out.println("========================================================");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null && vagas[i].getSalario() >= expSalarial) {
				if (vagas[i] instanceof VagaDesenvolvedor) {
					flag = true;
					VagaDesenvolvedor vagaDev = (VagaDesenvolvedor)vagas[i];
					System.out.println(vagaDev.toString());
				}
				
				else if (vagas[i] instanceof VagaGestor) {
					flag = true;
					VagaGestor vagaGest = (VagaGestor)vagas[i];
					System.out.println(vagaGest.toString());
				}
			}
		}
		
		if (flag == false) {
			System.out.println("Nenhuma vaga compatível foi encontrada!");
		} 
		System.out.println("========================================================\n");
	}
	
	// Parecido com o método anterior, mas este rece uma competência e lista as vagas
	// que forem compatíveis;
	// Retorna mensagem caso não encontre vagas;
	public void listaVagasFiltro(Competencia competencia) {
		boolean flag = false;
		
		Vaga[] tempVagas = new Vaga[100];
		
		System.out.println("*** Lista de vagas (Compatíveis com a competência) ***");
		System.out.println("========================================================");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				if (vagas[i] instanceof VagaDesenvolvedor) {
					VagaDesenvolvedor vagaDev = (VagaDesenvolvedor)vagas[i];
					
					for (int j = 0; j < vagaDev.getReqLinguagens().length; j++) {
						if (competencia.getCompetencia() == vagaDev.getReqLinguagens()[j].getCompetencia()
							&& competencia.getNivel() == vagaDev.getReqLinguagens()[j].getNivel()) {
							flag = true;
							tempVagas[i] = vagas[i];
							break;
						}
					}
					
					if (flag == false) {
						for (int j = 0; j < vagaDev.getReqBancosDeDados().length; j++) {
							if (competencia.getCompetencia() == vagaDev.getReqBancosDeDados()[j].getCompetencia()
								&& competencia.getNivel() == vagaDev.getReqBancosDeDados()[j].getNivel()) {
								flag = true;
								tempVagas[i] = vagas[i];
								break;
							}
						}
					}
				}
				
				else if (vagas[i] instanceof VagaGestor) {
					VagaGestor vagaGest = (VagaGestor)vagas[i];
					
			        for (int j = 0; j < vagaGest.getReqMetodologias().length; j++) {
			             if (competencia.getCompetencia() == vagaGest.getReqMetodologias()[j].getCompetencia()
			            	 && competencia.getNivel() == vagaGest.getReqMetodologias()[j].getNivel()) {
			            	 flag = true;
			            	 tempVagas[i] = vagas[i];
			                 break;
			             }
			        }
				}
			}
		}
		
		if (flag == false) {
			System.out.println("Não foi possível encontrar as vagas!");
		}
		else {
			for (int i = 0; i < tempVagas.length; i++) {
				if (tempVagas[i] != null) {
					System.out.println(tempVagas[i].toString());
				}
			}
		}
		System.out.println("========================================================\n");
	}
	
	// Este método lista todas as vagas registradas;
	// Caso não encontre nenhuma vaga, retorna mensagem;
	public void listaVagas() {
		boolean flag = false;
		
		System.out.println("***                  Lista de vagas                  ***");
		System.out.println("========================================================");
		for (int i = 0; i < vagas.length; i++) {
			if (vagas[i] != null) {
				if (vagas[i] instanceof VagaDesenvolvedor) {
					flag = true;
					VagaDesenvolvedor vagaDev = (VagaDesenvolvedor)vagas[i];
					System.out.println(vagaDev.toString());
				}
				else if (vagas[i] instanceof VagaGestor) {
					flag = true;
					VagaGestor vagaGest = (VagaGestor)vagas[i];
					System.out.println(vagaGest.toString());
				}
			}
		}
		
		if (flag == false) {
			System.out.println("Nenhuma vaga foi adicionada!");
		}
		System.out.println("========================================================\n");
	}
	
	// Este método lista todos os candidatos;
	// Caso não encontre nenhum, retorna mensagem;
	public void listaCandidatos() {
		boolean flag = false;
		
		System.out.println("***             Lista de candidatos(as)              ***");
		System.out.println("========================================================");
		for (int i = 0; i < candidatos.length; i++) {
			if (candidatos[i] != null) {
				flag = true;
				System.out.println(candidatos[i].toString());
			}
		}
		
		if (flag == false) {
			System.out.println("Nenhum candidato(a) foi adicionado(a)!");
		} 
		System.out.println("========================================================\n");
	}
	
	// Este método lista todos os funcionários, ou seja, candidatos que foram
	// contratados;
	// Caso não encontre nenhum, retorna mensagem;
	public void listaFuncionarios() {
		boolean flag = false;
		
		System.out.println("***           Lista de funcionários(as)              ***");
		System.out.println("========================================================");
		for (int i = 0; i < funcionarios.length; i++) {
			if (funcionarios[i] != null) {
				flag = true;
				System.out.println(funcionarios[i].toString());
			}
		}
		
		if (flag == false) {
			System.out.println("Nenhum funcionário(a) foi contratado(a)!");
		} 
		System.out.println("========================================================\n");
	}
	
	// Este toString não é utilizado em momento algum, só está
	// aqui pois estava descrito no UML;
	public String toString() {
		return "";
	}
}