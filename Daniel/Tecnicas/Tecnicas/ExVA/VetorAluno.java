package ExVA;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class VetorAluno {

	private int contAluno = 0;

	public Aluno inicio = new Aluno();

	public int getContAluno() {
		return contAluno;
	}

	public void setContAluno(int contAluno) {
		this.contAluno = contAluno;
	}

	public void adiciona(String nome, int pontuacao) {
		if (contAluno == 0) {
			inicio = new Aluno(nome, pontuacao);
		} else {
			Aluno proximo = inicio;
			while (proximo.proximo != null) {
				proximo = proximo.proximo;
			}
			proximo.proximo = new Aluno(nome, pontuacao);
		}
		contAluno++;
	}

	public void adiciona(String nome, int pontuacao, int posicao) {
		Aluno proximo = inicio;
		if (posicao > 0) {
			for (int i = 0; i < posicao; i++) {
				proximo = proximo.proximo;
//				if(proximo == null){
//					proximo = new Aluno("vazio" , 0);
//				}
			}
			proximo.setNome(nome);
			proximo.setPontuacao(pontuacao);
		} else {
			proximo.setNome(nome);
			proximo.setPontuacao(pontuacao);
		}
	}

	public Aluno pega(int posicao) {
		Aluno proximo = inicio;
		if (posicao > 0) {
			for (int i = 0; i < posicao; i++) {
				if (proximo != null) {
					proximo = proximo.proximo;
				}
			}
		}
		return proximo;
	}

	public void remove(int posicao) {
		Aluno proximo = inicio;
		if (posicao > 0) {
			for (int i = 0; i < posicao; i++) {
				proximo = proximo.proximo;
			}
			proximo.setNome("");
			proximo.setPontuacao(0);
		} else {
			proximo.setNome("");
			proximo.setPontuacao(0);
		}
	}

	public void lista(String nome) {
		Aluno proximo = inicio;
		while (proximo != null) {
			if (proximo.getNome().equals(nome)) {
				System.out.println("Está na lista " + proximo);
				break;
			}
			proximo = proximo.proximo;
		}
	}

	public int tamanho() {
		return contAluno;
	}

	@Override
	public String toString() {
		return inicio.getNome();
	}

	public boolean isEmpty() {
		if (contAluno == 0) {
			return true;
		} else {
			return false;
		}
	}
}
