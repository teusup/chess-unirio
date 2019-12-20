package chess;

//import java.util.ArrayList;

public class Jogador {

	private Cor cor;
	private boolean emXeque;
	public Jogo jogo;
	boolean ehVencedor = false;

	Jogador(Cor cor, Jogo jogo) {
		setEmXeque(false);
		this.cor = cor;
		this.jogo = jogo;
	}

	public Peca selecionarPeca(int x, int y) {
		Peca pecaAtual = jogo.tabuleiro.vetorTabuleiro[x][y];
		if (pecaAtual != null) {
			if (pecaAtual.jogador.getCor().name() == getCor().name()) {
				return pecaAtual;
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public void setEmXeque(boolean emXeque) {
		this.emXeque = emXeque;
	}

	public boolean emXeque() {
		return emXeque;
	}

}