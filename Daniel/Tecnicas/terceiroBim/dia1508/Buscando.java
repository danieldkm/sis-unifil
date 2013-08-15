package dia1508;

public class Buscando extends Buscar {

	@Override
	public int buscaSequencial(int[] vetor, int elemento) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == elemento) {
				return vetor[i];
			}
		}
		return -1;
	}

	@Override
	public int buscaBinaria(int[] vetor, int elemento) {
		int esquerda = 0, direita = (vetor.length - 1), meio = 0;
		while (esquerda <= direita) {
			meio = esquerda + ((direita - esquerda) / 2);
			System.out.println("???? " + meio);
			if (vetor[meio] < elemento) {
				esquerda = meio + 1;
			} else if (vetor[meio] > elemento) {
				direita = meio - 1;
			} else {
				return vetor[meio];
			}
		}
		return -1;
	}

}
