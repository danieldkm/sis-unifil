package dia0108;

public class BubbleSort extends Sort {

	private boolean troca = true;
	private int aux = 0;

	@Override
	public int[] ordenar(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				if (j + 1 < vetor.length) {
					if (vetor[j] > vetor[j + 1]) {
						aux = vetor[j];
						vetor[j] = vetor[j + 1];
						vetor[j + 1] = aux;
					}
				}
			}
		}
		return vetor;
	}

	@Override
	public int[] ordenar2(int[] vetor) {
		while (troca) {
			troca = false;
			for (int j = 0; j < vetor.length; j++) {
				if (j + 1 < vetor.length) {
					if (vetor[j] > vetor[j + 1]) {
						aux = vetor[j];
						vetor[j] = vetor[j + 1];
						vetor[j + 1] = aux;
						troca = true;
					}
				}
			}
		}
		return vetor;
	}

}
