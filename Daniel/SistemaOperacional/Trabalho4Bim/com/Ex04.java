package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Ex04 extends Config {

	private String vazio = "o";
	private String texto;
	private int tamanhoAtual = 0;
	public int aux = 0;
	private int aux2 = 0;
	private ArrayList<Processos> memoria2 = new ArrayList();
	private Processos processo;
	public boolean ex7 = false;
	public boolean ex8 = false;

	public void executar(String[] args) throws IOException {
		// primeira parte
		Ex03 _3 = new Ex03();
		_3.executar(args);
		System.out.println("Ocupação inicial:");
		texto = "";
		for (int i = 0; i <= totalChunks; i++) {
			if ((totalChunks) == i) {
				texto += "|\n";
			} else {
				texto += "|" + vazio;
			}
		}
		System.out.println(texto);

		// segunda parte
		memoria = new Vector();
		tirarBarra();
		new Processos(args);
		String tipo = "";

		for (int i = 0; i < pid.length; i++) {
			System.out.println("Deseja inserir ou remover o proximo processo?");
			tipo = scanner.nextLine().toLowerCase();
			if (tipo.equals("removido")) {
				i--;
				verificaRemover = 1;
			} else if (!tipo.equals("removido") && !tipo.equals("inserido")) {
				if (i > 0) {
					i--;
				}
			}
			aux = (int) Math.ceil(((double) tamanho[i] / chunk));
			aux2 = aux;
			if ((tamanhoAtual + aux) <= 16) {
				tamanhoAtual += aux;
			}
			novoTexto(pid[i], tipo, args);
		}
	}

	private void tirarBarra() {
		char[] tirar = texto.toCharArray();
		for (int i = 0; i < tirar.length; i++) {
			if (tirar[i] != '|') {
				memoria.add(tirar[i]);
			}
		}
	}

	public void novoTexto(char pid, String tipo, String[] args)
			throws IOException {
		aux = aux2;
		if (ex7) {
			aux = pidRemovido.get(0).getTamanhoPid();
		}
		if (verificarEspaco()) {
			inserirRemover(tipo, pid, args);
		} else {
			if (ex8) {
				tipo = "removido";
				inserirRemover(tipo, pid, args);
			} else {
				System.out.println("Memória cheia....");
				System.out.println("Tamanho do chunks " + aux);
				tipo = "removido";
				verificaRemover = 0;
				inserirRemover(tipo, pid, args);
			}
		}
	}

	private Vector memoria;
	private int verificaRemover = 0;

	private void inserirRemover(String tipo, char pid, String[] args)
			throws IOException {
		int n = 0;
		int ok = 0;
		if (tipo.equals("inserido")) {
			for (int j = 0; j < memoria.size() - 1; j++) {
				if (memoria.get(j).equals('o')) {
					for (int i = j; i < memoria.size() - 1; i++) {
						if (aux != 1) {
							if (i == 0) {
								ok++;
							} else if (memoria.get(i)
									.equals(memoria.get(i + 1))) {
								ok++;
								// System.out.println("ok " + ok + " j " + j
								// + " aux " + aux);
								if (ok >= (aux - 1)) {
									break;
								}
							} else {
								if (!memoria.get(i).equals('o')) {
									j = i + 1;
								}
								ok = 0;
							}
						} else {
							break;
						}
					}
					for (int i = j; i < memoria.size(); i++) {
						if (ok >= (aux - 1)) {
							if (n == aux) {
								break;
							} else {
								memoria.set(i, pid);
								n++;
							}
						}
					}
					break;
				}

			}
			resetarTexto(tipo, pid, args);
			verificaRemover = 1;
		} else if (tipo.equals("removido")) {
			if (ex8) {
				int taman = 0;
				int limit = 0;
				int soma = 0;
				System.out.println(processos.get(processos.size() - 1).get(0).getPidAtual());
				for (int i = (processos.size() - 1); i < processos.size(); i++) {
					for (int j = 0; j < processos.get(i).size(); j++) {
						soma += processos.get(i).get(j).getTamanhoPid();
						if (soma >= aux) {
							if(j > 0){
								taman = processos.get(i).get(0).getPosicao();
								limit = processos.get(i).get(j).getPosicao() + processos.get(i).get(j).getTamanhoPid();
							} else {
								taman = processos.get(i).get(j).getPosicao();
								limit = processos.get(i).get(j).getPosicao() + processos.get(i).get(j).getTamanhoPid();
							}
							break;
						}
					}
				}
				for (int j = taman; j < limit; j++) {
					memoria.set(j, 'o');
				}
//				for (int i = 0; i < memoria.size(); i++) {
//					System.out.println("i-> " + memoria.get(i));
//				}
				novoTexto(pid, "inserido", args);
			} else {
				System.out.println("Deseja remover qual pid?");
				char remo = scanner.nextLine().charAt(0);
				if (memoria.contains(remo)) {
					resetarTexto(tipo, remo, args);
					if (verificaRemover == 0) {
						tipo = "inserido";
						novoTexto(pid, tipo, args);
					}
				} else {
					System.out.println("Pid não encontrado");
				}
			}
		}
	}

	private boolean verificarEspaco() {
		int ok = 0;
		boolean continuar = true;
		int i = 0;
		while (continuar) {
			if (i < totalChunks) {
				if (memoria.get(i).equals('o')) {
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

	int n = 0;

	private void ultimaPosi() {
		for (int j = memoria2.size() - 1; j >= 0; j--) {
			if (memoria2.get(j).getTipoOcupacao().equals("P")) {
				memoria2.get(memoria2.size() - 1).setPosicao(
						memoria2.get(j).getPosicao()
								+ memoria2.get(j).getTamanhoPid());
				memoria2.get(memoria2.size() - 1).setTamanhoPid(
						16 - memoria2.get(memoria2.size() - 1).getPosicao());
				break;
			}
		}
	}

	private void resetarTexto(String tipo, char pid, String[] args)
			throws IOException {
		if (tipo.equals("inserido")) {
			System.out.println(tipo + " processo " + pid + ", ocupação de "
					+ aux + " chunks");
		}
		// String novoPid = pid + "";
		if (n == 0) {
			processo = new Processos(args);
			processo.setPidAtual(pid + "");
			processo.setTamanhoPid(aux);
			processo.setPosicao(0);
			processo.setTipoOcupacao("P");
			processo.setFuncao("Inserido");
			processo.setPidEscolhido(pid + "");
			memoria2.add(processo);
			processo = new Processos(args);
			processo.setPidAtual("0");
			processo.setTamanhoPid(16 - aux);
			processo.setPosicao(aux);
			processo.setTipoOcupacao("H");
			processo.setFuncao("vazio");
			processo.setPidEscolhido("o");
			memoria2.add(processo);
			processos.add(memoria2);
			n++;
		} else {
			// System.out.println("tipooooo " + tipo);
			// if (tipo.equals("inserido")) {
			memoria2 = new ArrayList<>();
			int tamanhoPid = 0;
			int inicialPid = 0;
			String qualPid = "";
			// for (int i = 0; i < memoria.size(); i++) {
			// System.out.println("memoria ox  " + memoria.get(i));
			// }
			for (int i = 0; i < memoria.size(); i++) {
				if (i == 0) {
					inicialPid = 0;
					tamanhoPid++;
					qualPid = memoria.get(i) + "";
				} else {
					if (memoria.get(i) == memoria.get(i - 1)) {
						tamanhoPid++;
					} else {
						// System.out
						// .println("qualPid " + qualPid + " pid " + pid);
						if (tipo.equals("removido") && qualPid.equals(pid + "")) {
							aux = 0;
							processo = new Processos(args);
							processo.setTipoOcupacao("H");
							for (int j = 0; j < memoria.size(); j++) {
								if (memoria.get(j).equals(pid)) {
									memoria.set(j, 'o');
									aux++;
								}
							}
							Processos p = new Processos(); // TODO
							p.setPidAtual(pid + "");
							p.setTamanhoPid(aux);
							pidRemovido.add(p);
							// System.out.println(tipo + " processo " + pid
							// + ", ocupação de " + aux + " chunks");
							qualPid = "o";
						} else {
							if (qualPid.equals("o")
									&& qualPid.equals(memoria.get(i - 1)
											.toString())) {
								processo = new Processos(args);
								processo.setTipoOcupacao("H");
							} else {
								processo = new Processos(args);
								processo.setTipoOcupacao("P");
							}
						}
						processo.setPosicao(inicialPid);
						processo.setPidEscolhido(pid + "");
						processo.setFuncao(tipo);
						processo.setPidAtual(qualPid);
						processo.setTamanhoPid(tamanhoPid);
						memoria2.add(processo);
						// System.out.println("inicialPId " + inicialPid);
						// System.out.println("qual pid " + qualPid);
						// System.out.println("tamanho pid " + tamanhoPid);
						// System.out.println("");
						qualPid = memoria.get(i) + "";
						tamanhoPid = 1;
						inicialPid = i;
					}
				}
			}
			for (int i = 0; i < memoria2.size() - 1; i++) {
				if (i > 0) {
					if (memoria2.get(i).getPidAtual()
							.equals(memoria2.get(i - 1).getPidAtual())) {
						memoria2.get(i - 1).setTamanhoPid(
								memoria2.get(i - 1).getTamanhoPid()
										+ memoria2.get(i).getTamanhoPid());
						memoria2.remove(i);
					}
				}

			}
			int soma = memoria2.get(memoria2.size() - 1).getTamanhoPid()
					+ memoria2.get(memoria2.size() - 1).getPosicao();
			if (soma < 16) {
				processo = new Processos(args);
				processo.setPosicao(memoria2.get(memoria2.size() - 1)
						.getTamanhoPid()
						+ memoria2.get(memoria2.size() - 1).getPosicao());
				processo.setTipoOcupacao("H");
				processo.setFuncao("Vazio");
				processo.setPidAtual("o");
				processo.setTamanhoPid(16 - processo.getPosicao());
				memoria2.add(processo);
			}
			processos.add(memoria2);
			n++;
		}

		// System.out.println("size vetor " + memoria.size());
		for (int i = 0; i < memoria.size(); i++) {
			if ((memoria.size()) == i) {
				System.out.print("|\n");
			} else {
				System.out.print("|" + memoria.get(i));
			}
		}
	}

}
