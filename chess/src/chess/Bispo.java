package chess;

public class Bispo extends Peca {

	public Bispo(int x, int y, Jogador jogador) {
		super(x, y, jogador);
		setSimbolo();
	}

	public void setSimbolo() {
		if (jogador.getCor() == Cor.BRANCA) {
			simbolo = "♗";
		} else {
			simbolo = "♝";
		}
	}

	public boolean movimentoValido(int xDestino, int yDestino) {

		if (this.x == xDestino || this.y == yDestino) {
			return false;
		}

		if (Math.abs(xDestino - this.x) != Math.abs(yDestino - this.y)) {
			return false;
		}

		int direcaoLinha, direcaoColuna;

		if (this.x < xDestino) {
			direcaoLinha = 1;
		} else {
			direcaoLinha = -1;
		}

		if (this.y < yDestino) {
			direcaoColuna = 1;
		} else {
			direcaoColuna = -1;
		}

		int y = this.y + direcaoColuna;
		for (int x = this.x + direcaoLinha; x != xDestino; x += direcaoLinha) {

			if (jogador.jogo.tabuleiro.vetorTabuleiro[x][y] != null) {
				return false;
			}

			y += direcaoColuna;
		}

		return true;

	}

	public boolean podeMover(int xDestino, int yDestino) {
		return false;
	}
}