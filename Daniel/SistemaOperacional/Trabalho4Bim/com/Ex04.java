package com;

import java.io.IOException;
import java.util.Vector;

public class Ex04 extends Config {

	private String vazio = "o";
	private String texto = "";
	private int tamanhoAtual = 0;
	private int aux = 0;

	public void executar(String[] args) throws IOException {
		// primeira parte
		Ex03 _3 = new Ex03();
		_3.executar(args);
		System.out.println("Ocupação inicial:");
		for (int i = 0; i <= totalChunks; i++) {
			if ((totalChunks) == i) {
				texto += "|\n";
			} else {
				texto += "|" + vazio;
			}
		}
		System.out.println(texto);

		// segunda parte
		teste = new Vector();
		tirarBarra();
		new Processos(args);
		String tipo = "";
		for (int i = 0; i < pid.length; i++) {
			System.out.println("Deseja inserir ou remover?");
			tipo = scanner.nextLine().toLowerCase();
			if (tipo.equals("remover")) {
				i--;
			} else if (!tipo.equals("remover") && !tipo.equals("inserir")) {
				if (i > 0) {
					i--;
				}
			}
			aux = (int) Math.ceil(((double) tamanho[i] / chunk));
			if ((tamanhoAtual + aux) <= 16) {
				tamanhoAtual += aux;
			}
			novoTexto(pid[i], tipo);
		}
	}

	private void tirarBarra() {
		char[] tirar = texto.toCharArray();
		for (int i = 0; i < tirar.length; i++) {
			if (tirar[i] != '|') {
				teste.add(tirar[i]);
			}
		}
	}

	private void novoTexto(char pid, String tipo) {
		if (verificarEspaco()) {
			inserirRemover(tipo, pid);
			resetarTexto(tipo, pid);
		} else {
			System.out.println("Memória cheia....realocando");
			System.out.println("Tamanho do chunks " + aux);
			realocar(pid);
			inserirRemover(tipo, pid);
			resetarTexto(tipo, pid);
		}
	}

	private Vector teste;

	private void realocar(char pid2) {
		boolean continuar = true;
		int cont = 0;
		int ok = 0;
		char tirar = 0;
		int marcar = 0;
		while (continuar) {
			if (cont < (teste.size() - 1)) {
				if (teste.get(cont).equals(teste.get(cont + 1))
						|| teste.get(cont).equals('o')) {
					ok++;
					tirar = teste.get(cont).toString().charAt(0);
					if (ok == aux) {
						for (int i = 0; i < teste.size(); i++) {
							if (teste.get(i).equals(tirar)) {
								teste.set(i, 'o');
							}
						}
						marcar = 0;
						break;
					}
					marcar = 1;
				} else {
					marcar = 1;
					ok = 0;
				}
			} else {
				marcar = 1;
				continuar = false;
			}
			cont++;
		}

		if (marcar == 1) {
			cont = 0;
			ok = 0;
			tirar = 0;
			continuar = true;
			while (continuar) {
				if (cont < (teste.size() - 1)) {
					cont++;
					if (cont == aux) {
						for (int i = 0; i < teste.size(); i++) {
							if (teste.get(cont - 1).equals(teste.get(cont))) {
								cont++;
							}
						}
						System.out.println(teste.get(cont));
						for (int i = 0; i < cont; i++) {
							teste.set(i, 'o');
						}
						break;
					}
				} else {
					continuar = false;
				}
			}
		}
	}

	private void inserirRemover(String tipo, char pid) {
		int n = 0;
		if (tipo.equals("inserir")) {
			for (int j = 0; j < teste.size(); j++) {
				if (teste.get(j).equals('o')) {
					if (n == aux) {
						break;
					} else {
						teste.set(j, pid);
						n++;
					}
				}
			}
		} else if (tipo.equals("remover")) {
			System.out.println("Deseja remover qual pid?");
			char removerPid = scanner.nextLine().charAt(0);
			if (teste.contains(removerPid)) {
				for (int j = 0; j < teste.size(); j++) {
					if (teste.get(j).equals(removerPid)) {
						teste.set(j, 'o');
					}
				}
			} else {
				System.out.println("Pid não encontrado");
			}
		}
	}

	private boolean verificarEspaco() {
		int ok = 0;
		boolean continuar = true;
		int i = 0;
		while (continuar) {
			if (i < totalChunks) {
				if (teste.get(i).equals('o')) {
					ok++;
					if (ok >= aux) {
						return true;
					}
				} else {
					ok = 0;
				}
			} else {
				continuar = false;
			}
			i++;
		}
		return false;
	}

	private void resetarTexto(String tipo, char pid) {
		System.out.println(tipo + " processo " + pid + ", ocupação de " + aux
				+ " chunks");
		for (int i = 0; i < teste.size(); i++) {
			if ((teste.size()) == i) {
				System.out.print("|\n");
			} else {
				System.out.print("|" + teste.get(i));
			}
		}
	}

}
