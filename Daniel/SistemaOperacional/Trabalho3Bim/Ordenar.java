import java.util.ArrayList;

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
					// troca = ordenar[i];
					// ordenar[i] = ordenar[j];
					// ordenar[j] = troca;
				}
			}
		}
		return vetor;
	}
	
	public int[] ordenar2(int[] vetor) {
		int aux = 0;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[i] < vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					// troca = ordenar[i];
					// ordenar[i] = ordenar[j];
					// ordenar[j] = troca;
				}
			}
		}
		return vetor;
	}

	public int[] ordenar(int[] vetor, int[] vetor2) {
		int aux = 0;
		for (int i = 0; i < vetor.length; i++) {
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[i] > vetor[j]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;

					aux = vetor2[i];
					vetor2[i] = vetor2[j];
					vetor2[j] = aux;
				}
			}
		}
		return vetor2;
	}

	public int[] getOrdenar() {
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

	public String mostrarPids(int[] pid) {
		String texto = "";
		int executar = 0, escolhido = 0;
		while (pid[0] != 0) {
			if (executar == 0) {
				texto += "Executar: nenhum";
			} else {
				texto += "Executar: " + executar;
			}
			if (escolhido == 0) {
				texto += " Escolhido: nenhum ";
			} else {
				texto += " Escolhido: " + escolhido;
				executar = escolhido;
			}
			if (pid[0] == 0) {
				texto += " Prontos: vazio ";
			} else {
				String p = "";
				for (int i = 0; i < pid.length; i++) {
					if (pid[i] != 0) {
						p += pid[i] + ":";
					}
				}
				texto += " Prontos: " + p;
				escolhido = pid[0];
				for (int i = 0; i < pid.length; i++) {
					if ((i + 1) == pid.length) {
						pid[i] = 0;
					} else if (i < pid.length) {
						pid[i] = pid[i + 1];
					}
				}
			}
			texto += "\n";
		}
		texto += "Executar: " + executar + " Escolhido: " + escolhido
				+ " Prontos: vazio\n";
		texto += "Executar: " + escolhido + " Escolhido: nenhum"
				+ " Prontos: vazio\n";
		return texto;
	}

	private int escolhido;
	private int executar;

	public String mostrarPidQuantum(int[] carga, int[] pid, int quantum) {
		String texto = "";
		int executar = 0, escolhido = 0;
		int[] pro = new int[pid.length];
		pro = pid;
		while (pid[0] != 0) {
			if (executar == 0) {
				texto += "Executar: nenhum";
			} else {
				texto += "Executar: " + executar;
			}
			if (escolhido == 0) {
				texto += " Escolhido: nenhum ";
			} else {
				texto += " Escolhido: " + escolhido;
				if(executar != 0){
					for (int i = 0; i < pro.length; i++) {
						if(executar == pro[i]){
							carga[i] += - quantum;
							if(carga[i] > 0){
								for (int j = 0; j < pid.length; j++) {
									if(pid[j] == 0){
										pid[j] = executar;
									}
								}
							}
						}
					}
				}
				for (int i = 0; i < pid.length; i++) {
					System.out.println(pid[i]);
				}
				executar = escolhido;
			}
			if (pid[0] == 0) {
				texto += " Prontos: vazio ";
			} else {
				String p = "";
				for (int i = 0; i < pid.length; i++) {
					if (pid[i] != 0) {
						p += pid[i] + ":";
					}
				}
				texto += " Prontos: " + p;
				escolhido = pid[0];
				for (int i = 0; i < pid.length; i++) {
					if ((i + 1) == pid.length) {
						pid[i] = 0;
					} else if (i < pid.length) {
						pid[i] = pid[i + 1];
					}
				}
			}
			texto += "\n";
		}
		texto += "Executar: " + executar + " Escolhido: " + escolhido
				+ " Prontos: vazio\n";
		texto += "Executar: " + escolhido + " Escolhido: nenhum"
				+ " Prontos: vazio\n";
		return texto;
	}
	
}
