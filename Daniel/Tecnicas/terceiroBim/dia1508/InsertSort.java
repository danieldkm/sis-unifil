package dia1508;

public class InsertSort extends Sort {
	int elemento = 0 , i = 0;

	@Override
	public int[] insertSort(int[] vetor) {
		for (int j = 0; j < vetor.length; j++) {
			elemento = vetor[j];
			i = j - 1;
			while ((i >= 0) && (vetor[i] > elemento)) {
				vetor[i+1] = vetor[i];
				vetor[i] = elemento;
				i = i - 1;
			}
		}
		return vetor;
	}

}
