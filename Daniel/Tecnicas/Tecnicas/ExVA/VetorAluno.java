package ExVA;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class VetorAluno {

	private Aluno[] alunos = new Aluno[tamanho_vetor];

	private static int tamanho_vetor = 10;

	private int contAluno = 0;

	public Aluno inicio;

	public Aluno[] getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

	public static int getTamanho_vetor() {
		return tamanho_vetor;
	}

	public static void setTamanho_vetor(int tamanho_vetor) {
		VetorAluno.tamanho_vetor = tamanho_vetor;
	}

	public int getContAluno() {
		return contAluno;
	}

	public void setContAluno(int contAluno) {
		this.contAluno = contAluno;
	}

	public void adiciona(String nome, int pontuacao) {
		// Aluno auxiliar = inicio;
		// if (inicio == null) {
		//Aluno aux = inicio.proximo;
		if (contAluno == 0) {
			inicio = new Aluno(nome, pontuacao);
		} else {
			Aluno proximo = inicio;
			while (proximo.proximo != null) {
				proximo = proximo.proximo;
			}
//			inicio = inicio.proximo;
			proximo.proximo = new Aluno(nome, pontuacao);
		}
		contAluno++;
		// } else {
		// inicio = inicio.proximo;
		// inicio = new Aluno(nome, pontuacao);
		// System.out.println(nome);
		// }

	}

	public Aluno pega(int posicao) {
		return alunos[posicao];
	}
//	public Aluno pega() {
//		return inicio.proximo;
//	}

	public void remove(int posicao) {
	}

	// public boolean contem(Aluno aluno) {
	// }

	public int tamanho() {
		return contAluno;
	}

	@Override
	public String toString() {
		return Arrays.toString(alunos);
	}

	public boolean isEmpty() {
		if (contAluno == 0) {
			return true;
		} else {
			return false;
		}
	}
}
