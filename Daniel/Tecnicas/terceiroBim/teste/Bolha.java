package teste;

public class Bolha {

	public int[] bolha(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				if (j < (vetor.length - 1)) {
					if (vetor[j] > vetor[j + 1]) {
						int aux = vetor[j];
						vetor[j] = vetor[j + 1];
						vetor[j + 1] = aux;
					}
				}
			}
		}
		return vetor;
	}

	public int[] bulha(int a[]) {
		int aux = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					aux = a[j];
					a[j] = a[j + 1];
					a[j + 1] = aux;
				}
			}
		}
		return a;
	}

}
