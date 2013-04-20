package abril_20;

public class ordenacao {

	
	//percorre n(tamanho) vezes dependendo do tamanho do vetor
	//Bubble Sort
	void bubble(int[] v, int tamanho) {//ordenação por bolha 
		int k, j, aux;
		for (int i = 0; i < tamanho; i++) {
			j = 0;
			while (j < tamanho) {
				System.out.println("indice " + j + " atual " + v[j]
						+ " comparar com  " + v[j + 1]);
				if (v[j] > v[j + 1]) {
					aux = v[j];
					v[j] = v[j + 1];
					v[j + 1] = aux;
				}
				j++;
			}
		}
	}

	//percorrendo o vetor e procurando por valor maior q o esperado e faz a troca
	//Insert Sort
	void inserction(int[] vetor, int tamanho) {//ordenação por inserção
		int i, j, elemento;
		for (i = 1; i < tamanho; i++) {
			System.out.println("a " + vetor[i]);
			elemento = vetor[i];
			j = i - 1;
			while (j >= 0 && vetor[j] > elemento) {
				System.out.println("b " + vetor[j]);
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j + 1] = elemento;
		}
	}

	//percorre o vetor a cada posição procura um valor menor e joga na posição correta
	//Selection Sort
	void selection(int v[], int tamanho) {//ordenação por seleção
		int aux, menor;
		for (int i = 0; i < tamanho; i++) {
			menor = i;
			for (int j = (i + 1); j < tamanho + 1; j++) {
				if (v[menor] > v[j]) {
					menor = j;
				}
			}
			if (menor != i) {
				aux = v[menor];
				v[menor] = v[i];
				v[i] = aux;
			}
		}
	}
}
