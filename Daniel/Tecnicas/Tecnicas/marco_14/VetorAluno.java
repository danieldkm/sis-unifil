package marco_14;

import java.util.Arrays;

public class VetorAluno {

	private Aluno[] alunos = new Aluno[tamanho_vetor];

	private static int tamanho_vetor = 10;

	private int contAluno = 0;

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

	public void adiciona(Aluno aluno) {
		int n = 0;
		for (int i = 0; i < alunos.length; i++) {
			if (alunos[i] == null) {
				for (int j = 0; j < contAluno; j++) {
					if (aluno.equals(alunos[j])) {
						n = 1;
						break;
					}
				}
				if (n == 1) {
					break;
				} else if (n == 0) {
					alunos[i] = aluno;
					contAluno = contAluno + 1;
					break;
				}
			}
		}
	}

	public void adiciona(int posicao, Aluno aluno) {
		alunos[posicao] = aluno;
	}

	public Aluno pega(int posicao) {
		return alunos[posicao];
	}

	public void remove(int posicao) {
		alunos[posicao] = null;
	}

	public boolean contem(Aluno aluno) {
		int n = 0;
		for (int i = 0; i < tamanho_vetor; i++) {
			if (aluno.equals(alunos[i])) {
				n = 1;
				break;
			}
		}
		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int tamanho() {
		return 0;
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
