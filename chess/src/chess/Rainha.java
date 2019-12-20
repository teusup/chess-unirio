package chess;

public class Rainha extends Peca {

	public Rainha(int x, int y, Jogador jogador) {
		super(x, y, jogador);
		setSimbolo();
	}

	public void setSimbolo() {
		if (jogador.getCor() == Cor.BRANCA) {
			simbolo = "♕";
		} else {
			simbolo = "♛";
		}
	}

	public boolean movimentoValido(int xDestino, int yDestino) {
		// A Queen's move is the same as a Rook's or a Bishop's
		return new Torre(this.x, this.y, jogador).movimentoValido(xDestino, yDestino)
				|| new Bispo(this.x, this.y, jogador).movimentoValido(xDestino, yDestino);
	}

	public boolean podeMover(int xDestino, int yDestino) {
		return false;
	}
}