package chess;

import java.util.Scanner;

public class Jogo {

	public Tabuleiro tabuleiro;
	public Jogador jogador1, jogador2;
	public int turno;

	Jogo() {

		tabuleiro = new Tabuleiro(this);
		setJogadores();
		tabuleiro.setPecasJogador1();
		tabuleiro.setPecasJogador2();
		turno = 1;
	}

	public void setJogadores() {
		jogador1 = new Jogador(Cor.BRANCA, this);
		jogador2 = new Jogador(Cor.PRETA, this);

		jogador1.jogo = this;
		jogador2.jogo = this;
	}

	public Jogador defineVezJogador() {
		System.out.println();
		if (turno % 2 == 1) {
			System.out.println("� a vez do jogador 1 (PE�AS BRANCAS):");
			return jogador1;
		} else {
			System.out.println("� a vez do jogador 2 (PE�AS PRETAS):");
			return jogador2;
		}
	}

	public void gameLoop() {
		Scanner entrada = new Scanner(System.in);
		int x, y;
		Jogador jogadorAtual;
		Peca pecaAtual;

		while (jogador1.ehVencedor == false && jogador2.ehVencedor == false) {
			System.out.println();
			this.tabuleiro.imprimirTabuleiro();

			jogadorAtual = defineVezJogador();

			do {
				System.out.print("\nDigite o n�mero da linha da pe�a que deseja mover:");
				x = entrada.nextInt();
				System.out.println("--------------------------------------------------------");
				System.out.print("Digite o n�mero da coluna da pe�a que deseja mover:");
				y = entrada.nextInt();
				System.out.println("--------------------------------------------------------");

				if ((x < 0 || x > 7) || (y < 0 || y > 7)) {
					System.out.println("\n#######################################################");
					System.out.println("SELE��O INV�LIDA! POR FAVOR, INSIRA UMA POSI��O V�LIDA!");
					System.out.println("#######################################################\n");

				} else {
					pecaAtual = jogadorAtual.selecionarPeca(x, y);
					if (pecaAtual == null) {
						System.out.println("\n#######################################################");
						System.out.println("SELE��O INV�LIDA! POR FAVOR, INSIRA UMA POSI��O V�LIDA!");
						System.out.println("#######################################################\n");
						continue;
					} else
						break;
				}

			} while (true);

			System.out.println("~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-");

			do {
				System.out.print("Digite o n�mero da linha de destino da pe�a escolhida:");
				x = entrada.nextInt();
				System.out.println("--------------------------------------------------------");
				System.out.print("Digite o n�mero da coluna de destino da pe�a escolhida:");
				y = entrada.nextInt();
				System.out.println("--------------------------------------------------------");

				if ((x < 0 || x > 7) || (y < 0 || y > 7)) {
					System.out.println("\n#######################################################");
					System.out.println("DESTINO INV�LIDO! POR FAVOR, INSIRA UMA POSI��O V�LIDA!");
					System.out.println("#######################################################\n");
				} else {
					if (pecaAtual.movimentoValido(x, y)) {
						break;
					}
					System.out.println("\n#######################################################");
					System.out.println("DESTINO INV�LIDO! POR FAVOR, INSIRA UMA POSI��O V�LIDA!");
					System.out.println("#######################################################\n");
					continue;
				}

			} while (true);

			this.tabuleiro.setNovaPosicaoPeca(pecaAtual, x, y);

			turno++;

		}
		entrada.close();
	}
}