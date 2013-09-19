package teste;

public class busca {

	public int binaria(int[] vetor, int elemento) {
		int esquerda = 0, direita = vetor.length - 1, meio = 0;
		while(esquerda <= direita){
			meio = esquerda + ((direita - esquerda) / 2);
			if(vetor[meio] < elemento){
				esquerda = meio + 1;
			} else if (vetor[meio] > elemento){
				esquerda = meio - 1;
			} else {
				return vetor[meio];
			}
		}
		return -1;
	}
}
