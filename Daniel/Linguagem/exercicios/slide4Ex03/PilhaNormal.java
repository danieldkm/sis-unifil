package slide4Ex03;

public class PilhaNormal {
	private static int tamanho = 5;
	private double[] vetor;
	private double topo;

	PilhaNormal(int tamanho) {
		this.tamanho = tamanho;
		vetor = new double[tamanho];
	}

	public void empilha(int posicao, Double elemento) {
		vetor[posicao] = elemento;
	}

	public void desenpilha(Double elemento) {
		for (int i = 0; i < tamanho; i++) {
			if (vetor[i] == elemento) {
				vetor[i] = 0.0;
			}
		}
	}

	public double topo() {
		for (int i = (tamanho - 1); i >= 0; i--) {
			if (vetor[i] != 0.0) {
				return vetor[i];
			}
		}
		return topo;
	}

	public boolean estaCheia() {
		int n = 0;
		for (int i = 0; i < tamanho; i++) {
			if (vetor[i] != 0.0) {
				n = n + 1;
			}

		}
		if (n == tamanho) {
			return true;
		} else {
			return false;
		}
	}

	public boolean estaVazia() {
		int n = 0;
		for (int i = 0; i < tamanho; i++) {
			if (vetor[i] == 0.0) {
				n = n + 1;
			}

		}
		if (n == tamanho) {
			return true;
		} else {
			return false;
		}
	}

	public void imprimir() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println(vetor[i]);
		}
	}

}
