public class Ordenar {
	private int[] ordenar = null;
	private int troca;

	public Ordenar() {
	}

	public Ordenar(int qtd) {
		ordenar = new int[qtd];
		for (int i = 0; i < qtd; i++) {
			ordenar[i] = i;
		}
	}

	public int[] ordenar(int[] vetor) {
		int aux = 0;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[i] > vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					troca = ordenar[i];
					ordenar[i] = ordenar[j];
					ordenar[j] = troca;
				}
			}
		}
		return vetor;
	}

	public int[] ordenar2() {
		return ordenar;
	}

	private int[] s = new int[1];

	private int quantidade = 1; // quantidade de elementos;
	private int posicao = 0; // posição dos elementos

	public int[] addElemento(int elemento) {

		// cria um novo array conforme vai add elementos
		int[] temp = new int[quantidade];

		// add os elementos de s no novo array
		for (int i = 0; i < s.length; i++) {

			temp[i] = s[i];
		}

		// add o o novo elemento
		temp[posicao] = elemento;

		// repassa para s o novo array
		s = temp;

		quantidade++;
		posicao++;

		return temp;
	}

	// Mostra os elementos
	public void mostarElementos() {

		for (int i = 0; i < s.length; i++) {

			System.out.println(s[i]);
		}
	}
}
