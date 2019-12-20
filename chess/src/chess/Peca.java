package chess;

public abstract class Peca {

	protected int x, y;
	public Jogador jogador;
	protected String nomePeca;
	protected String simbolo;

	Peca(int x, int y, Jogador jogador) {
		this.x = x;
		this.y = y;
		this.jogador = jogador;
		this.jogador.jogo.tabuleiro.vetorTabuleiro[x][y] = this;
	}

	public abstract boolean podeMover(int xDestino, int yDestino);

	public boolean movimentoValido(int xDestino, int yDestino) {
		if (podeMover(xDestino, yDestino) && (x >= 0 || x <= 7 || y >= 0 || y <= 7)) {
			return true;
		} else
			return false;
	}

	public boolean estaNoTabuleiro(int x, int y) {
		if ((x < 0 || x > 7) || (y < 0 || y > 7)) {
			return false;
		} else
			return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nomePeca;
	}

}
