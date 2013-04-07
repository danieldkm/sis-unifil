package Trabalho;

import java.util.Vector;

import javax.swing.JOptionPane;

/*Classe Controle
 Atributos privados para jogadores e equipes. Utilize vector. Construtor.*/
public class Controle {

	private Vector<Jogador> jogadores;
	private Vector<Equipe> equipes;

	public Controle() {
		jogadores = new Vector();
		equipes = new Vector();
	}

	// Método para cadastrar jogador, parâmetros nome e posição.
	public void cadastrarJogador(String nome, int posicao) {
		Jogador aux = new Jogador(nome, posicao);
		jogadores.addElement(aux);
		System.out.println(aux);
	}

	// Método para cadastrar equipe, parâmetro nome da equipe.
	public void cadastrarEquipe(String nome) {
		Equipe aux = new Equipe(nome);
		equipes.addElement(aux);
		System.out.println(aux);
	}

	/*
	 * Método para contratar jogador, parâmetros nome da equipe e nome do
	 * jogador.
	 */
	public void contratarJogador(String nomeEquipe, String nomeJogador) {
		int auxEquipe = -1;
		int auxJogador = -1;
		for (int i = 0; i < equipes.size(); i++) {
			if (equipes.get(i).getNomeEquipe().equals(nomeEquipe)) {
				auxEquipe = i;
				System.out.println("posicao e " + i);
				break;
			}
		}

		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getNome().equals(nomeJogador)) {
				auxJogador = i;
				System.out.println("posicao j " + i);
				break;
			}
		}

		if (auxEquipe < 0 || auxJogador < 0) {
			JOptionPane.showMessageDialog(null, "Equipe ou Jogador não existe");
			System.out.println("jogador " + jogadores.get(auxJogador));
			System.out.println("equipe " + equipes.get(auxEquipe));
		} else {
			System.out.println(equipes.get(auxEquipe));
			Jogador j = jogadores.get(auxJogador);
			equipes.get(auxEquipe).adicionar(j);
		}
	}

	// Método para demitir jogador, parâmetros nome da equipe e nome do jogador.
	public void demitirJogador(String nomeEquipe, String nomeJogador) {
		int auxEquipe = -1;
		int auxJogador = -1;
		for (int i = 0; i < equipes.size(); i++) {
			if (equipes.get(i).getNomeEquipe().equals(nomeEquipe)) {
				auxEquipe = i;
				break;
			}
		}
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getNome().equals(nomeJogador)) {
				auxJogador = i;
				break;
			}
		}
		if (auxEquipe < 0 || auxJogador < 0) {
			JOptionPane.showMessageDialog(null, "Equipe ou Jogador não existe");
			System.out.println("jogador " + jogadores.get(auxJogador));
			System.out.println("equipe " + equipes.get(auxEquipe));
		} else {
			equipes.get(auxEquipe).remover(jogadores.get(auxJogador));
		}
	}

	// Método para mostrar jogadores de uma equipe, parâmetro nome da equipe.
	public void mostrarJogadoresEquipe(String nomeEquipe) {
		for (int i = 0; i < equipes.size(); i++) {
			if (equipes.get(i).getNomeEquipe().equals(nomeEquipe)) {
				System.out.println(nomeEquipe + " " + equipes.get(i).listar());
				break;
			}
		}
	}

	// Método para mostrar jogadores que atuam na mesma posição, parâmetro
	// posição.
	public void mostrarPosicaoJogador(int posicao) {
		for (int i = 0; i < jogadores.size(); i++) {
			if (jogadores.get(i).getPocisao() == posicao) {
				System.out.println(jogadores.get(i));
			}
		}

	}
}
