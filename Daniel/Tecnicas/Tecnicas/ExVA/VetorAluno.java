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

	public void adiciona(String nome, int pontuacao, int i) {
		// Aluno auxiliar = inicio;
		if (inicio == null) {
			if(i == 0){
				inicio = inicio;
			}else{
				inicio = inicio.proximo;
			}
		} else {
			inicio = inicio.proximo;
			adiciona(nome, pontuacao, i);
		}
		System.out.println(nome);
		inicio = new Aluno(nome, pontuacao);

	}

	public Aluno pega(int posicao) {
		return alunos[posicao];
	}

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
