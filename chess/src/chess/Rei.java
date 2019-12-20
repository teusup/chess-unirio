package chess;

public class Rei extends Peca {

	public boolean foiMovida;

	public Rei(int x, int y, Jogador jogador) {

		super(x, y, jogador);
		setSimbolo();
		this.foiMovida = false;

	}

	public void setSimbolo() {
		if (jogador.getCor() == Cor.BRANCA) {
			simbolo = "♔";
		} else {
			simbolo = "♚";
		}
	}

	public boolean movimentoValido(int xDestino, int yDestino) {

		if (Math.abs(xDestino - this.x) > 1 || Math.abs(yDestino - this.y) > 1) {

			if (foiMovida) {
				return false;
			}

			if (yDestino - this.y == 2 && this.x == xDestino) {

				if (jogador.jogo.tabuleiro.vetorTabuleiro[xDestino][this.y + 1] != null
						|| jogador.jogo.tabuleiro.vetorTabuleiro[xDestino][this.y + 2] != null) {

					return false;
				}

			} else if (this.y - yDestino == 3 && this.x == xDestino) {
				if (jogador.jogo.tabuleiro.vetorTabuleiro[xDestino][this.y - 1] != null
						|| jogador.jogo.tabuleiro.vetorTabuleiro[xDestino][this.y - 2] != null
						|| jogador.jogo.tabuleiro.vetorTabuleiro[xDestino][this.y - 3] != null) {

					return false;
				}

			} else {

				return false;
			}

		}

		return true;
	}

	public boolean podeMover(int xDestino, int yDestino) {

		return false;
	}
}
