package teste;

public class Selecionar {

	public int[] selecionar(int[] vetor){
		int indice = 0, aux;
		for (int i = 0; i < vetor.length; i++) {
			indice = i;
			for (int j = i+1; j < vetor.length; j++) {
				if(vetor[indice] > vetor[j]){
					indice = j;
				}
			}
			aux = vetor[i];
			vetor[i] = vetor[indice];
			vetor[indice] = aux;
		}
		return vetor;
	}
}
