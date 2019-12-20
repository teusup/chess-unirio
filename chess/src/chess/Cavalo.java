package chess;

public class Cavalo extends Peca {

	public Cavalo(int x, int y, Jogador jogador) {
		super(x, y, jogador);
		setSimbolo();
	}

	public void setSimbolo() {
		if (jogador.getCor() == Cor.BRANCA) {
			simbolo = "♘";
		} else {
			simbolo = "♞";
		}
	}

	public boolean movimentoValido(int xDestino, int yDestino) {

		if (Math.abs(xDestino - this.x) == 2 && Math.abs(yDestino - this.y) == 1) {
			return true;
		}

		if (Math.abs(xDestino - this.x) == 1 && Math.abs(yDestino - this.y) == 2) {
			return true;
		}

		return false;
	}

	public boolean podeMover(int xDestino, int yDestino) {
		return false;
	}
}