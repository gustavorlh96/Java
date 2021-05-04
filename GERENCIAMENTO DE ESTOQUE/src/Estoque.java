import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings({ "unused", "resource" })
public class Estoque {

	private Produto[] estoque;

	public Produto[] getEstoque() {
		return estoque;
	}

	public void setEstoque(Produto[] estoque) {
		this.estoque = estoque;
	}
	
	public void cadastraProduto(Produto novoProduto, String nomeDoArquivo) throws IOException {
		File f = new File(nomeDoArquivo + ".txt");
		FileWriter fw = new FileWriter(f, true);
		PrintWriter out = new PrintWriter(fw);
		
		if (novoProduto instanceof Processador)
			out.println(novoProduto.getNome() + " * " + novoProduto.getDescricao() + " * " + novoProduto.getPreco() + " * Processador * "
						+ ((Processador) novoProduto).getQuantNucleos() + " * " + ((Processador) novoProduto).getFreqGhz());
		else if (novoProduto instanceof MemoriaRam)
			out.println(novoProduto.getNome() + " * " + novoProduto.getDescricao() + " * " + novoProduto.getPreco() + " * MemoriaRam * "
						+ ((MemoriaRam) novoProduto).getCapacidade() + " * " + ((MemoriaRam) novoProduto).getFreqMhz());
		else if (novoProduto instanceof PlacaDeVideo)
			out.println(novoProduto.getNome() + " * " + novoProduto.getDescricao() + " * " + novoProduto.getPreco() + " * PlacaDeVideo * "
						+ ((PlacaDeVideo) novoProduto).getVram() + " * " + ((PlacaDeVideo) novoProduto).getArquitetura());
		else if (novoProduto instanceof PlacaMae)
			out.println(novoProduto.getNome() + " * " + novoProduto.getDescricao() + " * " + novoProduto.getPreco() + " * PlacaMae * "
						+ ((PlacaMae) novoProduto).getSoquete() + " * " + ((PlacaMae) novoProduto).getChipset());	
		else if (novoProduto instanceof Fonte)
			out.println(novoProduto.getNome() + " * " + novoProduto.getDescricao() + " * " + novoProduto.getPreco() + " * Fonte * "
						+ ((Fonte) novoProduto).getPotencia() + " * " + ((Fonte) novoProduto).getCertificacao());		
		else
			out.println(novoProduto.getNome() + " * " + novoProduto.getDescricao() + " * " + novoProduto.getPreco() + " * Periferico * "
						+ ((Periferico) novoProduto).getSerial() + " * " + ((Periferico) novoProduto).getId());
		out.close();
		preencheEstoque(nomeDoArquivo);
		ordenaEstoque(nomeDoArquivo);
	}
	
	public void preencheEstoque(String nomeDoArquivo) throws IllegalArgumentException, IOException {
		estoque = new Produto[contaLinhas(nomeDoArquivo)];
		int posicaoEstoque = 0;
		
		FileReader fr = new FileReader(nomeDoArquivo + ".txt");
		BufferedReader br = new BufferedReader(fr);
		String linha = br.readLine();
		
		while (linha != null) {
			String[] linhaSeparada = linha.split("\\*");
			if (linhaSeparada.length != 1) {
				String nome = linhaSeparada[0].trim();
				String descricao = linhaSeparada[1].trim();
				double preco = Double.parseDouble(linhaSeparada[2].trim());
				String tipo = linhaSeparada[3].trim();
				if (tipo.equalsIgnoreCase("processador"))
						estoque[posicaoEstoque++] = new Processador(nome, descricao, preco, Integer.parseInt(linhaSeparada[4].trim()), Double.parseDouble(linhaSeparada[5].trim()));
				else if (tipo.equalsIgnoreCase("memoriaram"))
						estoque[posicaoEstoque++] = new MemoriaRam(nome, descricao, preco, Integer.parseInt(linhaSeparada[4].trim()), Integer.parseInt(linhaSeparada[5].trim()));
				else if (tipo.equalsIgnoreCase("placadevideo"))
						estoque[posicaoEstoque++] = new PlacaDeVideo(nome, descricao, preco, Integer.parseInt(linhaSeparada[4].trim()), linhaSeparada[5].trim());
				else if (tipo.equalsIgnoreCase("placamae"))
						estoque[posicaoEstoque++] = new PlacaMae(nome, descricao, preco, linhaSeparada[4].trim(), linhaSeparada[5].trim());
				else if (tipo.equalsIgnoreCase("fonte"))
						estoque[posicaoEstoque++] = new Fonte(nome, descricao, preco, Integer.parseInt(linhaSeparada[4].trim()), linhaSeparada[5].trim());
				else
						estoque[posicaoEstoque++] = new Periferico(nome, descricao, preco, linhaSeparada[4].trim(), linhaSeparada[5].trim());
			}
			linha = br.readLine();
		}
		br.close();
	}
	
	public void removeProduto(String nome, String nomeDoArquivo) throws IOException {
		boolean tentarNovamente = true;
		
		File arquivoOriginal = new File(nomeDoArquivo + ".txt");
		BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal));
		String linha = br.readLine();
		
		File arquivoTemp = new File("temp.txt");
		FileWriter fw = new FileWriter(arquivoTemp, true);
		PrintWriter out = new PrintWriter(fw);
		
		do {
			try {
				boolean produtoEncontrado = false;
				while (linha != null) {
					String[] linhaSeparada = linha.split("\\*");
					String nomeLinhaAtual = linhaSeparada[0].trim();
					if (nomeLinhaAtual.equalsIgnoreCase(nome)) {
						System.out.println("Produto removido com sucesso!");
						produtoEncontrado = true;
						tentarNovamente = false;
						linha = br.readLine();
					}
					else {
						out.println(linha);
						linha = br.readLine();
					}
				}
				out.close();
				br.close();
				
				arquivoOriginal.delete();
				arquivoTemp.renameTo(arquivoOriginal);
			
				if (produtoEncontrado == false)
					throw new ProdutoNaoEncontradoException("Produto não encontrado");
			} catch (ProdutoNaoEncontradoException e) {
				tentarNovamente = e.tentarNovaBusca();
				if (tentarNovamente == true)
					nome = e.novoNomeBusca();
			}
		} while (tentarNovamente == true);
		preencheEstoque(nomeDoArquivo);
	}
	
	public void ordenaEstoque(String nomeDoArquivo) throws IllegalArgumentException, IOException {
		for (int i = 1; i < estoque.length; i++) {
			int j = i;
			Produto produto = estoque[i];
			String nome = estoque[i].getNome();
			while ((j > 0) && (estoque[j - 1].getNome().compareToIgnoreCase(nome) > 0)) {
				estoque[j] = estoque[j - 1];
				j--;
			}
			estoque[j] = produto;
		}
		
		File arquivoOriginal = new File(nomeDoArquivo + ".txt");
		
		File arquivoTemp = new File("temp.txt");
		FileWriter fw = new FileWriter(arquivoTemp, true);
		PrintWriter out = new PrintWriter(fw);
		
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] instanceof Processador)
				out.println(estoque[i].getNome() + " * " + estoque[i].getDescricao() + " * " + estoque[i].getPreco() + " * Processador * "
							+ ((Processador) estoque[i]).getQuantNucleos() + " * " + ((Processador) estoque[i]).getFreqGhz());
			else if (estoque[i] instanceof MemoriaRam)
				out.println(estoque[i].getNome() + " * " + estoque[i].getDescricao() + " * " + estoque[i].getPreco() + " * MemoriaRam * "
							+ ((MemoriaRam) estoque[i]).getCapacidade() + " * " + ((MemoriaRam) estoque[i]).getFreqMhz());
			else if (estoque[i] instanceof PlacaDeVideo)
				out.println(estoque[i].getNome() + " * " + estoque[i].getDescricao() + " * " + estoque[i].getPreco() + " * PlacaDeVideo * "
							+ ((PlacaDeVideo) estoque[i]).getVram() + " * " + ((PlacaDeVideo) estoque[i]).getArquitetura());
			else if (estoque[i] instanceof PlacaMae)
				out.println(estoque[i].getNome() + " * " + estoque[i].getDescricao() + " * " + estoque[i].getPreco() + " * PlacaMae * "
							+ ((PlacaMae) estoque[i]).getSoquete() + " * " + ((PlacaMae) estoque[i]).getChipset());	
			else if (estoque[i] instanceof Fonte)
				out.println(estoque[i].getNome() + " * " + estoque[i].getDescricao() + " * " + estoque[i].getPreco() + " * Fonte * "
							+ ((Fonte) estoque[i]).getPotencia() + " * " + ((Fonte) estoque[i]).getCertificacao());		
			else
				out.println(estoque[i].getNome() + " * " + estoque[i].getDescricao() + " * " + estoque[i].getPreco() + " * Periferico * "
							+ ((Periferico) estoque[i]).getSerial() + " * " + ((Periferico) estoque[i]).getId());
			}
		out.close();
		
		arquivoOriginal.delete();
		arquivoTemp.renameTo(arquivoOriginal);
		preencheEstoque(nomeDoArquivo);
	}
	
	public void buscaProduto(String nomeDoProduto, String nomeDoArquivo) throws IllegalArgumentException, IOException {
		boolean tentarNovamente = true;
		
		do {
			try {
				boolean produtoEncontrado = false;
				int inf = 0, sup = getEstoque().length - 1;
				while (inf <= sup) {
					int media = (inf + sup) / 2;
					if (getEstoque()[media].getNome().equalsIgnoreCase(nomeDoProduto)) {
						if (getEstoque()[media] instanceof Processador)
							getEstoque()[media] = atualizaProcessador(getEstoque()[media]);
						else if (getEstoque()[media] instanceof MemoriaRam)
							getEstoque()[media] = atualizaMemoriaRam(getEstoque()[media]);
						else if (getEstoque()[media] instanceof PlacaDeVideo)
							getEstoque()[media] = atualizaPlacaDeVideo(getEstoque()[media]);
						else if (getEstoque()[media] instanceof PlacaMae)
							getEstoque()[media] = atualizaPlacaMae(getEstoque()[media]);
						else if (getEstoque()[media] instanceof Fonte)
							getEstoque()[media] = atualizaFonte(getEstoque()[media]);
						else
							getEstoque()[media] = atualizaPeriferico(getEstoque()[media]);
						produtoEncontrado = true;
						tentarNovamente = false;
						break;
					}
					else if (getEstoque()[media].getNome().compareToIgnoreCase(nomeDoProduto) > 0)
						sup = media - 1;
					else
						inf = media + 1;
				}
	
				if (!produtoEncontrado)
					throw new ProdutoNaoEncontradoException("Produto não encontrado");
			} catch (ProdutoNaoEncontradoException e) {
				tentarNovamente = e.tentarNovaBusca();
				if (tentarNovamente)
					nomeDoProduto = e.novoNomeBusca();
			}
		} while (tentarNovamente);
		ordenaEstoque(nomeDoArquivo);
	}

	private Produto atualizaProcessador(Produto produto) {
		Scanner in = new Scanner(System.in);
		boolean atualizou = false;
		System.out.println("+==========================================atualizar processador+");
		System.out.println("| 1 - Atualizar o nome                                          |");
		System.out.println("| 2 - Atualizar a descrição                                     |");
		System.out.println("| 3 - Atualizar o preço                                         |");
		System.out.println("| 4 - Atualizar a quantidade de núcleos                         |");
		System.out.println("| 5 - Atualizar a frequência                                    |");
		System.out.println("| 6 - Sair                                                      |");
		System.out.println("+===============================================================+");
		int escolha = in.nextInt();
		in.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Digite o novo nome para o processador: ");
			String novoNome = in.nextLine().trim();
			if (novoNome != null || novoNome != "")
				produto.setNome(novoNome);
			else
				produto.setNome("Sem nome");
			atualizou = true;
			break;
		case 2:
			System.out.println("Digite a nova descrição para o processador: ");
			String novaDescricao = in.nextLine().trim();
			if (novaDescricao != null || novaDescricao != "")
				produto.setDescricao(novaDescricao);
			else
				produto.setDescricao("Sem descricao");
			atualizou = true;
			break;
		case 3:
			System.out.println("Digite o novo preço para o processador: ");
			double novoPreco = in.nextDouble();
			in.nextLine();
			if (novoPreco >= 0.01)
				produto.setPreco(novoPreco);
			else
				produto.setPreco(0.01);
			atualizou = true;
			break;
		case 4:
			System.out.println("Digite a nova quantidade de núcleos do processador: ");
			int novosNucleos = in.nextInt();
			in.nextLine();
			if (novosNucleos >= 1)
				((Processador) produto).setQuantNucleos(novosNucleos);
			else
				((Processador) produto).setQuantNucleos(1);
			atualizou = true;
			break;
		case 5:
			System.out.println("Digite a nova frequência (em GHz) do processador: ");
			double novaFreq = in.nextDouble();
			in.nextLine();
			if (novaFreq >= 0.1)
				((Processador) produto).setFreqGhz(novaFreq);
			else
				((Processador) produto).setFreqGhz(0.1);
			atualizou = true;
			break;
		default:
			saindoMenu();
			break;
		}
		if (atualizou == true)
			System.out.println("Produto atualizado com sucesso!");
		return produto;
	}
	
	private Produto atualizaMemoriaRam(Produto produto) {
		Scanner in = new Scanner(System.in);
		boolean atualizou = false;
		System.out.println("+==========================================atualizar memória RAM+");
		System.out.println("| 1 - Atualizar o nome                                          |");
		System.out.println("| 2 - Atualizar a descrição                                     |");
		System.out.println("| 3 - Atualizar o preço                                         |");
		System.out.println("| 4 - Atualizar a capacidade                                    |");
		System.out.println("| 5 - Atualizar a frequência                                    |");
		System.out.println("| 6 - Sair                                                      |");
		System.out.println("+===============================================================+");
		int escolha = in.nextInt();
		in.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Digite o novo nome para a RAM: ");
			String novoNome = in.nextLine().trim();
			if (novoNome != null || novoNome != "")
				produto.setNome(novoNome);
			else
				produto.setNome("Sem nome");
			atualizou = true;
			break;
		case 2:
			System.out.println("Digite a nova descrição para a RAM: ");
			String novaDescricao = in.nextLine().trim();
			if (novaDescricao != null || novaDescricao != "")
				produto.setDescricao(novaDescricao);
			else
				produto.setDescricao("Sem descricao");
			atualizou = true;
			break;
		case 3:
			System.out.println("Digite o novo preço para a RAM: ");
			double novoPreco = in.nextDouble();
			in.nextLine();
			if (novoPreco >= 0.01)
				produto.setPreco(novoPreco);
			else
				produto.setPreco(0.01);
			atualizou = true;
			break;
		case 4:
			System.out.println("Digite a nova capacidade da RAM: ");
			int novaCapacidade = in.nextInt();
			in.nextLine();
			if (novaCapacidade >= 1)
				((MemoriaRam) produto).setCapacidade(novaCapacidade);
			else
				((MemoriaRam) produto).setCapacidade(1);
			atualizou = true;
			break;
		case 5:
			System.out.println("Digite a nova frequência (em MHz) da RAM: ");
			int novaFreq = in.nextInt();
			in.nextLine();
			if (novaFreq >= 1600)
				((MemoriaRam) produto).setFreqMhz(novaFreq);
			else
				((MemoriaRam) produto).setFreqMhz(1600);
			atualizou = true;
			break;
		default:
			saindoMenu();
			break;
		}
		if (atualizou == true)
			System.out.println("Produto atualizado com sucesso!");
		return produto;
	}
	
	private Produto atualizaPlacaDeVideo(Produto produto) {
		Scanner in = new Scanner(System.in);
		boolean atualizou = false;
		System.out.println("+=======================================atualizar placa de vídeo+");
		System.out.println("| 1 - Atualizar o nome                                          |");
		System.out.println("| 2 - Atualizar a descrição                                     |");
		System.out.println("| 3 - Atualizar o preço                                         |");
		System.out.println("| 4 - Atualizar a memória de vídeo                              |");
		System.out.println("| 5 - Atualizar a arquitetura                                   |");
		System.out.println("| 6 - Sair                                                      |");
		System.out.println("+===============================================================+");
		int escolha = in.nextInt();
		in.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Digite o novo nome para a placa de vídeo: ");
			String novoNome = in.nextLine().trim();
			if (novoNome != null || novoNome != "")
				produto.setNome(novoNome);
			else
				produto.setNome("Sem nome");
			atualizou = true;
			break;
		case 2:
			System.out.println("Digite a nova descrição para a placa de vídeo: ");
			String novaDescricao = in.nextLine().trim();
			if (novaDescricao != null || novaDescricao != "")
				produto.setDescricao(novaDescricao);
			else
				produto.setDescricao("Sem descricao");
			atualizou = true;
			break;
		case 3:
			System.out.println("Digite o novo preço para a placa de vídeo: ");
			double novoPreco = in.nextDouble();
			in.nextLine();
			if (novoPreco >= 0.01)
				produto.setPreco(novoPreco);
			else
				produto.setPreco(0.01);
			atualizou = true;
			break;
		case 4:
			System.out.println("Digite a nova VRAM da placa de vídeo: ");
			int novaVRAM = in.nextInt();
			in.nextLine();
			if (novaVRAM >= 1)
				((PlacaDeVideo) produto).setVram(novaVRAM);
			else
				((PlacaDeVideo) produto).setVram(1);
			atualizou = true;
			break;
		case 5:
			System.out.println("Digite a nova arquitetura da placa de vídeo: ");
			String novaArq = in.nextLine();
			if (novaArq != null || novaArq != "")
				((PlacaDeVideo) produto).setArquitetura(novaArq);
			else
				((PlacaDeVideo) produto).setArquitetura("N/A");
			atualizou = true;
			break;
		default:
			saindoMenu();
			break;
		}
		if (atualizou == true)
			System.out.println("Produto atualizado com sucesso!");
		return produto;
	}
	
	private Produto atualizaPlacaMae(Produto produto) {
		Scanner in = new Scanner(System.in);
		boolean atualizou = false;
		System.out.println("+============================================atualizar placa mãe+");
		System.out.println("| 1 - Atualizar o nome                                          |");
		System.out.println("| 2 - Atualizar a descrição                                     |");
		System.out.println("| 3 - Atualizar o preço                                         |");
		System.out.println("| 4 - Atualizar o soquete                                       |");
		System.out.println("| 5 - Atualizar o chipset                                       |");
		System.out.println("| 6 - Sair                                                      |");
		System.out.println("+===============================================================+");
		int escolha = in.nextInt();
		in.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Digite o novo nome para a placa mãe: ");
			String novoNome = in.nextLine().trim();
			if (novoNome != null || novoNome != "")
				produto.setNome(novoNome);
			else
				produto.setNome("Sem nome");
			atualizou = true;
			break;
		case 2:
			System.out.println("Digite a nova descrição para a placa mãe: ");
			String novaDescricao = in.nextLine().trim();
			if (novaDescricao != null || novaDescricao != "")
				produto.setDescricao(novaDescricao);
			else
				produto.setDescricao("Sem descricao");
			atualizou = true;
			break;
		case 3:
			System.out.println("Digite o novo preço para a placa mãe: ");
			double novoPreco = in.nextDouble();
			in.nextLine();
			if (novoPreco >= 0.01)
				produto.setPreco(novoPreco);
			else
				produto.setPreco(0.01);
			atualizou = true;
			break;
		case 4:
			System.out.println("Digite o novo soquete da placa mãe: ");
			String novoSoquete = in.nextLine();
			if (novoSoquete != null || novoSoquete != "")
				((PlacaMae) produto).setSoquete(novoSoquete);
			else
				((PlacaMae) produto).setSoquete("N/A");
			atualizou = true;
			break;
		case 5:
			System.out.println("Digite o novo chipset da placa mãe: ");
			String novoChipset = in.nextLine();
			if (novoChipset != null || novoChipset != "")
				((PlacaMae) produto).setChipset(novoChipset);
			else
				((PlacaMae) produto).setChipset("N/A");
			atualizou = true;
			break;
		default:
			saindoMenu();
			break;
		}
		if (atualizou == true)
			System.out.println("Produto atualizado com sucesso!");
		return produto;
	}
	
	private Produto atualizaFonte(Produto produto) {
		Scanner in = new Scanner(System.in);
		boolean atualizou = false;
		System.out.println("+================================================atualizar fonte+");
		System.out.println("| 1 - Atualizar o nome                                          |");
		System.out.println("| 2 - Atualizar a descrição                                     |");
		System.out.println("| 3 - Atualizar o preço                                         |");
		System.out.println("| 4 - Atualizar a potência                                      |");
		System.out.println("| 5 - Atualizar a certificação                                  |");
		System.out.println("| 6 - Sair                                                      |");
		System.out.println("+===============================================================+");
		int escolha = in.nextInt();
		in.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Digite o novo nome para a fonte: ");
			String novoNome = in.nextLine().trim();
			if (novoNome != null || novoNome != "")
				produto.setNome(novoNome);
			else
				produto.setNome("Sem nome");
			atualizou = true;
			break;
		case 2:
			System.out.println("Digite a nova descrição para a fonte: ");
			String novaDescricao = in.nextLine().trim();
			if (novaDescricao != null || novaDescricao != "")
				produto.setDescricao(novaDescricao);
			else
				produto.setDescricao("Sem descricao");
			atualizou = true;
			break;
		case 3:
			System.out.println("Digite o novo preço para a fonte: ");
			double novoPreco = in.nextDouble();
			in.nextLine();
			if (novoPreco >= 0.01)
				produto.setPreco(novoPreco);
			else
				produto.setPreco(0.01);
			atualizou = true;
			break;
		case 4:
			System.out.println("Digite a nova potência (em watts) da fonte: ");
			int novaPotencia = in.nextInt();
			in.nextLine();
			if (novaPotencia >= 75)
				((Fonte) produto).setPotencia(novaPotencia);
			else
				((Fonte) produto).setPotencia(75);
			atualizou = true;
			break;
		case 5:
			System.out.println("Digite a nova certificação da fonte: ");
			String novaCertificacao = in.nextLine();
			if (novaCertificacao != null || novaCertificacao != "")
				((Fonte) produto).setCertificacao(novaCertificacao);
			else
				((Fonte) produto).setCertificacao("N/A");
			atualizou = true;
			break;
		default:
			saindoMenu();
			break;
		}
		if (atualizou == true)
			System.out.println("Produto atualizado com sucesso!");
		return produto;
	}
	
	private Produto atualizaPeriferico(Produto produto) {
		Scanner in = new Scanner(System.in);
		boolean atualizou = false;
		System.out.println("+===========================================atualizar periférico+");
		System.out.println("| 1 - Atualizar o nome                                          |");
		System.out.println("| 2 - Atualizar a descrição                                     |");
		System.out.println("| 3 - Atualizar o preço                                         |");
		System.out.println("| 4 - Atualizar o código serial                                 |");
		System.out.println("| 5 - Atualizar a ID                                            |");
		System.out.println("| 6 - Sair                                                      |");
		System.out.println("+===============================================================+");
		int escolha = in.nextInt();
		in.nextLine();
		switch (escolha) {
		case 1:
			System.out.println("Digite o novo nome para o periférico: ");
			String novoNome = in.nextLine().trim();
			if (novoNome != null || novoNome != "")
				produto.setNome(novoNome);
			else
				produto.setNome("Sem nome");
			atualizou = true;
			break;
		case 2:
			System.out.println("Digite a nova descrição para o periférico: ");
			String novaDescricao = in.nextLine().trim();
			if (novaDescricao != null || novaDescricao != "")
				produto.setDescricao(novaDescricao);
			else
				produto.setDescricao("Sem descricao");
			atualizou = true;
			break;
		case 3:
			System.out.println("Digite o novo preço para o periférico: ");
			double novoPreco = in.nextDouble();
			in.nextLine();
			if (novoPreco >= 0.01)
				produto.setPreco(novoPreco);
			else
				produto.setPreco(0.01);
			atualizou = true;
			break;
		case 4:
			System.out.println("Digite o novo serial do periférico: ");
			String novoSerial = in.nextLine();
			in.nextLine();
			if (novoSerial != null || novoSerial != "")
				((Periferico) produto).setSerial(novoSerial);
			else
				((Periferico) produto).setSerial("N/A");
			atualizou = true;
			break;
		case 5:
			System.out.println("Digite a nova ID do periférico: ");
			String novaID = in.nextLine();
			if (novaID != null || novaID != "")
				((Periferico) produto).setId(novaID);
			else
				((Periferico) produto).setId("N/A");
			atualizou = true;
			break;
		default:
			saindoMenu();
			break;
		}
		if (atualizou == true)
			System.out.println("Produto atualizado com sucesso!");
		return produto;
	}
	
	public int contaLinhas(String nomeDoArquivo) throws IllegalArgumentException, IOException {
		if (nomeDoArquivo == null) throw new IllegalArgumentException();
		try {
			FileReader fr = new FileReader(nomeDoArquivo + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = br.readLine();
			return contaLinhas(fr, br, linha, 0);
		} catch (FileNotFoundException e) {
			new File(nomeDoArquivo + ".txt").createNewFile();
			return 0;
		}
	}
	
	private int contaLinhas(FileReader fr, BufferedReader br, String linha, int contador) throws IOException {
		if (linha == null) {
			br.close();
			return contador;
		}
		return contaLinhas(fr, br, linha = br.readLine(), ++contador);
	}
	
	public void listaCadastrados() {
		try {
		if (getEstoque()[0].equals(null))
			System.out.println("O estoque está vazio.\n+============================================================================+");
		else
			for (int i = 0; i < getEstoque().length; i++) {
				System.out.println(getEstoque()[i].toString());
				System.out.println("+============================================================================+");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("O estoque está vazio.\n+============================================================================+");
		}
	}
	
	public void limpaLista(String nomeDoArquivo) throws IOException {
		File arquivoOriginal = new File(nomeDoArquivo + ".txt");
		File arquivoTemp = new File("temp.txt");
		arquivoOriginal.delete();
		arquivoTemp.renameTo(arquivoOriginal);
		preencheEstoque(nomeDoArquivo);
	}
	
	public void saindoMenu() {
		System.out.print("Saindo do menu em ");
		for (int i = 4; i > 1; i--) {
			try {
				Thread.sleep(1000);
				} catch (Exception e) {}
			System.out.print(i - 1 + "...");
		}
	}
}