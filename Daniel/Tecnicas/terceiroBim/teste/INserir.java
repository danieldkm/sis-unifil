package teste;

public class INserir {

	public int[] inserir(int [] vetor){
		int elemento, i;
		for (int j = 0; j < vetor.length; j++) {
			elemento = vetor[j];
			i = j - 1;
			while((i >= 0) && (vetor[i] > elemento)){
				vetor[i+1] = vetor[i]; 
				vetor[i] = elemento;
				i --;
			}
		}
		return vetor;
	}
}
