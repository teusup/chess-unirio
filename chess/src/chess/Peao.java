package chess;

public class Peao extends Peca {

	boolean foiMovida = false;

	Peao(int x, int y, Jogador jogador) {
		super(x, y, jogador);
		setSimbolo();

	}

	public void setSimbolo() {
		if (jogador.getCor() == Cor.BRANCA) {
			simbolo = "♙";
		} else {
			simbolo = "♟";
		}
	}

	public boolean podeMover(int xDestino, int yDestino) {

		Peca[][] tabuleiro = jogador.jogo.tabuleiro.vetorTabuleiro;

		if (andarDuasCasas(xDestino, yDestino)) {
			return true;
		}

		if (this.y != yDestino) {
			if (jogador.getCor() == Cor.BRANCA && this.x >= xDestino
					|| (jogador.getCor() == Cor.PRETA && this.x <= xDestino)) {
				return true;
			} else {
				return false;
			}
		}

		if ((Math.abs(xDestino - this.x) == 1)
				&& (jogador.getCor() == Cor.BRANCA && tabuleiro[this.x - 1][this.y] == null)
				|| (jogador.getCor() == Cor.PRETA && tabuleiro[this.x + 1][this.y] == null)) {
			return true;
		} else
			return false;

	}

	public boolean andarDuasCasas(int xDestino, int yDestino) {

		int xDiferenca = Math.abs(xDestino - this.x);
		Peca[][] tabuleiro = jogador.jogo.tabuleiro.vetorTabuleiro;

		if (xDiferenca == 2) {

			if (tabuleiro[xDestino][yDestino] == null) {

				if ((this.x == 6 && (jogador.getCor() == Cor.BRANCA && tabuleiro[this.x - 1][this.y] == null))
						|| (this.x == 1 && (jogador.getCor() == Cor.PRETA && tabuleiro[this.x + 1][this.y] == null))) {
					return true;
				}
				return false;
			}
			return false;
		} else
			return false;
	}

}