package Trabalho;

import java.util.Vector;

/*Classe Equipe
 Atributos privados para nome da equipe e jogadores da equipe. 
 Utilize vector para armazenar os jogadores. */
public class Equipe {

	private String nomeEquipe;
	private Vector<Jogador> nomeJogadores = new Vector();

	// Construtor com parâmetro para inicializar nome da equipe.
	public Equipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}

	// Método get / set para nome da equipe.
	public void setNomeEquipe(String nome) {
		nomeEquipe = nome;
	}

	public String getNomeEquipe() {
		return nomeEquipe;
	}

	// Método para adicionar jogador na equipe, parâmetro Jogador.
	public void adicionar(Jogador jogador) {
		nomeJogadores.addElement(jogador);
		System.out.println(jogador);
	}

	// Método para remover jogador da equipe, parâmetro Jogador.
	public void remover(Jogador jogador) {
		nomeJogadores.removeElement(jogador);
		System.out.println("Jogador demitido " + jogador);
	}

	// Método listar jogadores da equipe. Retornar um String com os nomes.
	public String listar() {
		String nome = "";
		for (int i = 0; i < nomeJogadores.size(); i++) {
			if (i == 0) {
				nome = nomeJogadores.get(i).toString();
			} else {
				nome = nome + ", " + nomeJogadores.get(i).toString();
			}
		}
		return nome;
	}

	@Override
	public String toString() {
		return "Equipe " + nomeEquipe + " jogadores " + nomeJogadores;
	}
}
