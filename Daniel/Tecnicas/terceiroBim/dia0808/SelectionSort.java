package dia0808;

public class SelectionSort extends Sort {

	@Override
	public int[] ordenar(int[] vetor) {
		int indiceMin = 0, aux;
		for (int i = 0; i < vetor.length; i++) {
			indiceMin = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[indiceMin]) {
					indiceMin = j;
				}
			}
			aux = vetor[i];
			vetor[i] = vetor[indiceMin];
			vetor[indiceMin] = aux;
		}
		return vetor;
	}
}
