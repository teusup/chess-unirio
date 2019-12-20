package chess;

public class Tabuleiro {

	protected Peca[][] vetorTabuleiro;
	public Jogo jogo;

	Tabuleiro(Jogo jogo) {

		vetorTabuleiro = new Peca[8][8];
		this.jogo = jogo;
	}

	public Peca[][] getVetorTabuleiro() {
		return vetorTabuleiro;
	}

	public void setPecasJogador2() {

		for (int y_casa = 0; y_casa < 8; y_casa++) {
			new Peao(1, y_casa, this.jogo.jogador2);
		}

		new Torre(0, 0, this.jogo.jogador2);
		new Torre(0, 7, this.jogo.jogador2);

		new Cavalo(0, 1, this.jogo.jogador2);
		new Cavalo(0, 6, this.jogo.jogador2);

		new Bispo(0, 2, this.jogo.jogador2);
		new Bispo(0, 5, this.jogo.jogador2);

		new Rainha(0, 3, this.jogo.jogador2);

		new Rei(0, 4, this.jogo.jogador2);
	}

	public void setPecasJogador1() {

		for (int y_casa = 0; y_casa < 8; y_casa++) {
			new Peao(6, y_casa, this.jogo.jogador1);
		}

		new Torre(7, 0, this.jogo.jogador1);
		new Torre(7, 7, this.jogo.jogador1);

		new Cavalo(7, 1, this.jogo.jogador1);
		new Cavalo(7, 6, this.jogo.jogador1);

		new Bispo(7, 2, this.jogo.jogador1);
		new Bispo(7, 5, this.jogo.jogador1);

		new Rainha(7, 3, this.jogo.jogador1);

		new Rei(7, 4, this.jogo.jogador1);
	}

	public void imprimirTabuleiro() {
		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {

				if (vetorTabuleiro[i][j] != null) {
					System.out.print(vetorTabuleiro[i][j].getSimbolo() + " ");
				} else {
					System.out.print("▭ ");
				}
			}
			System.out.println(i);
		}
		System.out.println("0 1 2 3 4 5 6 7");
	}

	public void setNovaPosicaoPeca(Peca peca, int finalX, int finalY) {

		int origemX = peca.x;
		int origemY = peca.y;

		peca.x = finalX;
		peca.y = finalY;

		vetorTabuleiro[finalX][finalY] = peca;
		vetorTabuleiro[origemX][origemY] = null;
	}

}