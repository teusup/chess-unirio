package chess;

public class Torre extends Peca {

	Torre(int x, int y, Jogador jogador) {
		super(x, y, jogador);
		setSimbolo();
	}

	public void setSimbolo() {
		if (jogador.getCor() == Cor.BRANCA) {
			simbolo = "♖";
		} else {
			simbolo = "♜";
		}
	}

	public boolean podeMover(int xDestino, int yDestino) {

		if (this.x != xDestino && this.y != yDestino) {

			return false;
		}

		int direcao;

		if (this.x != xDestino) {
			if (this.x < xDestino) {
				direcao = 1;
			} else {
				direcao = -1;
			}

			for (int x = this.x + direcao; x != xDestino; x += direcao) {
				if (jogador.jogo.tabuleiro.vetorTabuleiro[x][this.y] != null) {
					return false;
				}
			}
		}

		if (this.y != yDestino) {
			if (this.y < yDestino) {
				direcao = 1;
			} else {
				direcao = -1;
			}

			for (int x = this.y + direcao; x != yDestino; x += direcao) {
				if (jogador.jogo.tabuleiro.vetorTabuleiro[this.x][x] != null) {
					return false;
				}
			}
		}

		return true;
	}

}