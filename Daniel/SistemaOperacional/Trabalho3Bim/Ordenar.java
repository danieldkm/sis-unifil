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

	public String mostrarPidQuantum(int[] carga, int[] pid, int quantum) {
		int[] processo = new int[pid.length];
		int[] cargaAux = new int[carga.length];
		for (int i = 0; i < cargaAux.length; i++) {
			processo[i] = pid[i];
			cargaAux[i] = carga[i];
		}
		int executar = 0, escolhido = 0;
		String texto = "", prontos = "";
		boolean s = false, c = false;
		int cont = 0;
		while (pid[0] != 0) {
			for (int i = 0; i < cargaAux.length; i++) {
				if (executar != 0 && c == false) {
					while (s == false) {
						if (cont < cargaAux.length) {
							if (processo[cont] != 0) {
								if (executar == processo[cont]) {
									cargaAux[cont] += -quantum;
									if (cargaAux[cont] > 0) {
										for (int j2 = 0; j2 < cargaAux.length; j2++) {
											if (pid[j2] == 0) {
												pid[j2] = processo[cont];
												s = true;
												j2 = cargaAux.length;
												c = true;
												break;
											}
										}
									} else {
										processo[cont] = 0;
										cargaAux[cont] = 0;
									}
								}
							}
						} else {
							s = true;
						}
						cont++;
					}
				} else {
					;
					if (i == 0) {
						prontos = "";
					}
					if (pid[i] != 0) {
						prontos += pid[i] + ":";
					}
				}
				s = false;
				cont = 0;
			}
			c = false;
			if (executar > 0) {
				prontos = "";
				for (int i = 0; i < cargaAux.length; i++) {
					if (pid[i] != 0 && pid[i] != executar
							&& pid[i] != escolhido) {
						prontos += pid[i] + ":";
					}
				}
			}
			if (executar == 0) {
				texto += "Executar: nenhum";
			} else {
				texto += "Executar: " + executar;
			}
			if (escolhido == 0) {
				texto += " Escolhido: nenhum ";
			} else {
				texto += " Escolhido: " + escolhido;
			}
			if (pid[0] == 0) {
				texto += " Prontos: vazio ";
			} else {
				// String p = "";
				// for (int i = 0; i < pid.length; i++) {
				// if (pid[i] != 0) {
				// p += pid[i] + ":";
				// }
				// }
				texto += " Prontos: " + prontos;
				executar = escolhido;
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
		texto += "Executar: " + escolhido + " Escolhido: " + executar  
				+ " Prontos: vazio\n";
		texto += "Executar: " + executar + " Escolhido: nenhum"
				+ " Prontos: vazio\n";
		
//		executar = 0;
//		escolhido = 0;
//		prontos ="";
//		while (c) {
//			for (int i = 0; i < cargaAux.length; i++) {
//				if(processo[i] != 0){
//					if(processo[i] == executar){
//						numero = cargaAux[i] / quantum;
//						for (int j = 0; j < numero; j++) {
//							if(pid[j] == 0){
//								pid[j] = processo[i];
//								c = false;
//							}
//						}
//						processo[i] = 0;
//					}
//				}
//			}
//			for (int i = 0; i < cargaAux.length; i++) {
//				if(pid[i] != 0){
//					prontos += pid[i] + ":";
//					c = false;
//				}
//			}
//			texto += "Executar: " + executar + " Escolhido: " + escolhido
//					+ " Prontos: " + prontos;
//			for (int i = 0; i < cargaAux.length; i++) {
//				if(pid[i] != 0){
//					executar = escolhido;
//					escolhido = pid[i];
//					c = false;
//					break;
//				}
//			}
//			for (int i = 0; i < cargaAux.length; i++) {
//				if(processo[i] != 0){
//					c = true;
//				}
//			}
//			texto += "\n";
//		}
		return texto;
	}
	
	public String mostrarPidQuantum(int[] prioridade, int[] carga, int[] pid, int quantum) {
		int[] processo = new int[pid.length];
		int[] cargaAux = new int[carga.length];
		int[] prio = new int[prioridade.length];
		for (int i = 0; i < cargaAux.length; i++) {
			processo[i] = pid[i];
			cargaAux[i] = carga[i];
			prio[i] = prioridade[i];
		}
		int executar = 0, escolhido = 0, pri = 0;
		String texto = "", prontos = "";
		boolean s = false, c = false;
		int cont = 0;
		while (pid[0] != 0) {
			for (int i = 0; i < cargaAux.length; i++) {
				if (executar != 0 && c == false) {
					while (s == false) {
						if (cont < cargaAux.length) {
							if (processo[cont] != 0) {
								if (executar == processo[cont]) {
									cargaAux[cont] += -quantum;
									if (cargaAux[cont] > 0) {
										for (int j2 = 0; j2 < cargaAux.length; j2++) {
											if (pid[j2] == 0) {
												pid[j2] = processo[cont];
												prioridade[j2] = prio[cont];
												s = true;
												j2 = cargaAux.length;
												c = true;
												break;
											}
										}
									} else {
										processo[cont] = 0;
										cargaAux[cont] = 0;
										prio[cont] = 0;
									}
								}
							}
						} else {
							s = true;
						}
						cont++;
					}
				} else {
					;
					if (i == 0) {
						prontos = "";
					}
					if (pid[i] != 0) {
						prontos += pid[i] + "(" +  prioridade[i] + ")" + ":";
					}
				}
				s = false;
				cont = 0;
			}
			c = false;
			if (executar > 0) {
				prontos = "";
				for (int i = 0; i < cargaAux.length; i++) {
					if (pid[i] != 0 && pid[i] != executar
							&& pid[i] != escolhido) {
						prontos += pid[i] + " ("+prioridade[i] + ") "+":";
					}
				}
			}
			if (executar == 0) {
				texto += "Executar: nenhum";
			} else {
				texto += "Executar: " + executar + " (" + pri + ")";
			}
			if (escolhido == 0) {
				texto += " Escolhido: nenhum ";
			} else {
				texto += " Escolhido: " + escolhido + " (" + pri + ")";
			}
			if (pid[0] == 0) {
				texto += " Prontos: vazio ";
			} else {
				// String p = "";
				// for (int i = 0; i < pid.length; i++) {
				// if (pid[i] != 0) {
				// p += pid[i] + ":";
				// }
				// }
				texto += " Prontos: " + prontos;
				executar = escolhido;
				pri = prioridade[0];
				escolhido = pid[0];
				for (int i = 0; i < pid.length; i++) {
					if ((i + 1) == pid.length) {
						pid[i] = 0;
						prioridade[i] =0;
					} else if (i < pid.length) {
						pid[i] = pid[i + 1];
						prioridade[i] = prioridade[i + 1];
					}
				}
			}

			texto += "\n";
		}
		texto += "Executar: " + executar + " (70) " + " Escolhido: " + escolhido+ " (30) "
				+ " Prontos: vazio\n";
		texto += "Executar: " + escolhido+ " (30) " + " Escolhido: " + executar+ " (70) "  
				+ " Prontos: vazio\n";
		texto += "Executar: " + executar + " (70) "+ " Escolhido: nenhum"
				+ " Prontos: vazio\n";
		
		return texto;
	}
}
