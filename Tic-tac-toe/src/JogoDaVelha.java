public class JogoDaVelha {
	
	private int dimensaoTabuleiro;
	private char[][] tabuleiro;
	
	public JogoDaVelha(int _dimensaoTabuleiro) {
		this.dimensaoTabuleiro = _dimensaoTabuleiro;
		this.tabuleiro = new char[dimensaoTabuleiro][dimensaoTabuleiro];
	}

	public int getDimensaoTabuleiro() {
		return dimensaoTabuleiro;
	}

	public void setDimensaoTabuleiro(int dimensaoTabuleiro) {
		this.dimensaoTabuleiro = dimensaoTabuleiro;
	}

	public char[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(char[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public boolean realizaJogada(int lin, int col, char jogada) {
		boolean preenchido = false;
		
		lin--; col--;
		
		if (getTabuleiro()[lin][col] == '\0') {
			getTabuleiro()[lin][col] = jogada;
			preenchido = true;
		}
		return preenchido ? true : false;
	}
	
	public boolean verificaGanhador() {
		int contadorX;
		int contadorO;
		
		// Verifica linhas
		for (int i = 0; i < getTabuleiro().length; i++) {
			contadorX = 0;
			contadorO = 0;
			for (int j = 0; j < getTabuleiro()[i].length; j++) {
				if (getTabuleiro()[i][j] == 'X')
					contadorX++;
				else if (getTabuleiro()[i][j] == 'O')
					contadorO++;
				
				if (contadorX == getDimensaoTabuleiro() || contadorO == getDimensaoTabuleiro())
					return true;
			}
		}
			
		// Verifica colunas,
		for (int i = 0; i < getTabuleiro().length; i++) {
			contadorX = 0;
			contadorO = 0;
			for (int j = 0; j < getTabuleiro()[i].length; j++) {
				if (getTabuleiro()[j][i] == 'X')
					contadorX++;
				else if (getTabuleiro()[j][i] == 'O')
					contadorO++;
				
				if (contadorX == getDimensaoTabuleiro() || contadorO == getDimensaoTabuleiro())
					return true;
			}
		}
		
		// Verifica diagonal
		contadorX = 0;
		contadorO = 0;
		for (int i = 0; i < getTabuleiro().length; i++) {
			for (int j = 0; j < getTabuleiro()[i].length; j++) {
				if (i == j && getTabuleiro()[i][j] == 'X')
					contadorX++;
				else if (i == j && getTabuleiro()[i][j] == 'O')
					contadorO++;
				
				if (contadorX == getDimensaoTabuleiro() || contadorO == getDimensaoTabuleiro())
					return true;
			}
		}
		
		// Verifica diagonal secundária
		contadorX = 0;
		contadorO = 0;
		for (int i = 0; i < getTabuleiro().length; i++) {
			for (int j = 0; j < getTabuleiro()[i].length; j++) {
				if (((i + j) == (dimensaoTabuleiro - 1)) && getTabuleiro()[i][j] == 'X')
					contadorX++;
				else if (((i + j) == (dimensaoTabuleiro - 1)) && getTabuleiro()[i][j] == 'O')
					contadorO++;
				
				if (contadorX == getDimensaoTabuleiro() || contadorO == getDimensaoTabuleiro())
					return true;
			}
		}
		return false;
	}
	
	public boolean verificaEmpate() {
		int contadorPosicoesLivres = 0;
		
		for (int i = 0; i < getTabuleiro().length; i++)
			for (int j = 0; j < getTabuleiro()[i].length; j++)
				if (getTabuleiro()[i][j] == '\0')
					contadorPosicoesLivres++;
			
		return contadorPosicoesLivres != '\0' ? false : true;
	}
	
	public String toString() {
		String retornoTabuleiro = "\n";
		
		 for (int i = 0; i < getTabuleiro().length; i++) {
			 for (int j = 0; j < getTabuleiro()[i].length; j++) {
				 if (j == getTabuleiro()[i].length - 1 && getTabuleiro()[i][j] == '\0')
					 retornoTabuleiro += "   ";
				 else if (j == getTabuleiro()[i].length - 1)
					 retornoTabuleiro += getTabuleiro()[i][j];
				 else
					 retornoTabuleiro += getTabuleiro()[i][j] + " | ";
			 }
			 retornoTabuleiro += "\n";
		 }	 
		return retornoTabuleiro;
	}
}
