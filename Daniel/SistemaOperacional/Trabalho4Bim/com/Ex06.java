package com;

import java.io.IOException;
import java.util.ArrayList;

public class Ex06 extends Config {

	public void executar(String[] args) throws IOException {
		// primeira parte
		Ex03 _3 = new Ex03();
		_3.executar(args);
		System.out.println("Ocupacao Inicial:");
		System.out.println("H|0|" + totalChunks);
		ocupacaoPid(args);
		processo = new Processos(args);
		processo.setTipoOcupacao("H");
		processo.setPosicao(0);
		processo.setTamanhoPid(totalChunks);
		processo.setPidAtual("0");
		memoria.add(0, processo);
		// do{
		// tipo = scanner.nextLine().toLowerCase();
		// System.out.println(tipo);
		// }while(tipo == "inserir" || tipo == "remover");
//		for (int i = 0; i < pid.length; i++) {
//			System.out.println("Inserido processo " + pid[i] + ", ocupação de "
//					+ ocupacao[i] + " chunks");
//		}
		iniciar(args);

	}

//	private String tipo = "";
	private String texto = "";
	private ArrayList<Processos> memoria = new ArrayList();
	private int posicao = 0;
//	private int tamanhoPid = 0;
//	private String tipoOcupacao = "";
//	private int tamanhoPidUltimo = 0;
	private Processos processo;
	private int soma = 0;

	private void iniciar(String[] args) throws IOException {
		for (int i = 0; i < pid.length; i++) {
			// System.out.println("i " + i);
			for (int j = memoria.size() - 1; j >= 0; j--) {
				if (memoria.get(j).getTipoOcupacao().equals("P")) {
					soma = memoria.get(j).getPosicao()
							+ memoria.get(j).getTamanhoPid();
					break;
				}
			}
			if ((soma + ocupacao[i]) > totalChunks) {
				System.out.println("\n"+"Inserido processo " + pid[i] + ", ocupacao de "
						+ ocupacao[i] + " chunks");
				removerPid(ocupacao[i]);// TODO
				inserir(i, args);
			} else {
				if (i == 0) {
//					tipoOcupacao = "P";
//					posicao = 0;
//					tamanhoPid = ocupacao[i];
					processo = new Processos(args);
					processo.setTipoOcupacao("P");
					processo.setTamanhoPid(ocupacao[i]);
					processo.setPosicao(0);
					processo.setPidAtual(pid[i] + "");
					memoria.add(0, processo);
					// texto = memoria.get(i).getTipoOcupacao() + "|"
					// + memoria.get(i).getPosicao() + "|"
					// + memoria.get(i).getTamanhoPid();
					imprimir(i, "Inserido");
				} else {
					inserir(i, args);
					// for (int j = memoria.size() - 1; j >= 0; j--) {
					// // System.out.println("j " + j);
					// if (memoria.get(j).getTipoOcupacao().equals("P")) {
					// posicao = memoria.get(j).getTamanhoPid()
					// + memoria.get(j).getPosicao();
					// tamanhoPid = ocupacao[i];
					// novoProcesso(j+1, "P", posicao, tamanhoPid, args);
					// // texto += " -> " + memoria.get(j+1).getTipoOcupacao()
					// // + "|" + memoria.get(j+1).getPosicao() + "|"
					// // + memoria.get(j+1).getTamanhoPid();
					// imprimir(i,"Inserir");
					// break;
					// }
					// }
				}
			}
		}
	}

	private void inserir(int i, String[] args) throws IOException {
		int n = -1;
		if (verificarContemPidVazio() != -1) {
			n = verificarContemPidVazio();
		}

		for (int j = memoria.size() - 1; j >= 0; j--) {
			if (memoria.get(j).getTipoOcupacao().equals("P")) {
				if (n != -1) {
					if(memoria.get(n).getTamanhoPid() > ocupacao[i]){
						int a = memoria.get(n).getTamanhoPid() - ocupacao[i];
						processo = new Processos(args);
						processo.setPidAtual("0");
						processo.setPosicao(ocupacao[i]);
						processo.setTamanhoPid(a);
						processo.setTipoOcupacao("H");
						memoria.add(n+1, processo);
					}
//					System.out.println("pid1 " + memoria.get(n).getPidAtual());
					memoria.get(n).setPidAtual(pid[i] + "");
//					System.out.println("pid1 " + memoria.get(n).getPidAtual());
					memoria.get(n).setTipoOcupacao("P");
					memoria.get(n).setTamanhoPid(ocupacao[i]);
//					System.out.println("nnnnnnnnnnnnnn " + n);
					imprimir(i, "Inserido");
				} else {
					posicao = memoria.get(j).getTamanhoPid()
							+ memoria.get(j).getPosicao();
//					tamanhoPid = ocupacao[i];
					novoProcesso(j + 1, "P", posicao, ocupacao[i], args);
					imprimir(i, "Inserido");
				}
				break;
			}
		}
	}

	private int verificarContemPidVazio() {
		for (int i = 0; i < memoria.size() - 1; i++) {
			if (memoria.get(i).getTipoOcupacao().equals("H")) {
//				System.out.println("verificar " + memoria.get(i).getPidAtual()
//						+ " posicao " + i);
				return i;
			}
		}
		return -1;
	}

	private void novoProcesso(int j, String tipo, int posicao, int tamanho,
			String[] args) throws IOException {
		processo = new Processos(args);
		processo.setPosicao(posicao);
		processo.setTipoOcupacao(tipo);
		processo.setTamanhoPid(tamanho);
		processo.setPidAtual(pid[j] + "");
		memoria.add(j, processo);
	}
	private void removerPid(int ocupacao) {
		boolean ok = true;
		for (int i = 0; i < memoria.size()-1; i++) {
			if(memoria.get(i).getTamanhoPid() == ocupacao){
				memoria.get(i).setTipoOcupacao("H");
//				memoria.get(i).setPidAtual("0");
				imprimir(i, "Removido");
				ok = false;
				break;
			}
		}
		if(ok){
			int soma = 0;
			for (int i = 0; i < memoria.size()-1; i++) {
				soma += memoria.get(i).getTamanhoPid();
				if(i == 0){
					memoria.get(i).setTipoOcupacao("H");
					imprimir(i, "Removido");
					memoria.get(i).setPidAtual("0");
				} else {
					memoria.get(0).setTamanhoPid(memoria.get(0).getTamanhoPid() + memoria.get(i).getTamanhoPid());
					imprimir2(i, "Removido");
				}
				if(soma >= ocupacao){
					break;
				}
				
			}
		}
	}

	// arrumar a ultima posição da memoria ou da lista encadeada
	private String lastPosi(int i) {
		for (int j = memoria.size() - 1; j >= 0; j--) {
			if (memoria.get(j).getTipoOcupacao().equals("P")) {
				memoria.get(memoria.size() - 1).setPosicao(
						memoria.get(j).getPosicao()
								+ memoria.get(j).getTamanhoPid());
				memoria.get(memoria.size() - 1).setTamanhoPid(
						16 - memoria.get(memoria.size() - 1).getPosicao());
				break;
			}
		}
		if (memoria.get(memoria.size() - 1).getTamanhoPid() == 0) {
			return "";
		}
		return " -> " + memoria.get(memoria.size() - 1).getTipoOcupacao() + "|"
				+ memoria.get(memoria.size() - 1).getPosicao() + "|"
				+ memoria.get(memoria.size() - 1).getTamanhoPid();
	}

	private void imprimir(int i, String tipo) {
		if (tipo.equals("Inserido")) {
			System.out.println("\n"+tipo + " processo " + pid[i] + ", ocupacao de "
					+ ocupacao[i] + " chunks");
		} else if (tipo.equals("Removido")) {
			System.out.println("AVISO: Compressao de memoria");
			System.out.println(tipo + " processo " + memoria.get(i).getPidAtual() + ", liberacao de "
					+ ocupacao[i] + " chunks");
		}
		texto = "";
		for (int j = 0; j < memoria.size() - 1; j++) {
			if (j == 0) {
				texto += memoria.get(j).getTipoOcupacao() + "|"
						+ memoria.get(j).getPosicao() + "|"
						+ memoria.get(j).getTamanhoPid();
			} else {
				texto += " -> " + memoria.get(j).getTipoOcupacao() + "|"
						+ memoria.get(j).getPosicao() + "|"
						+ memoria.get(j).getTamanhoPid();

			}
		}
		System.out.println(texto + lastPosi(i));
	}
	
	private void imprimir2(int i, String tipo){
		System.out.println("AVISO: Compressao de memoria");
		System.out.println(tipo + " processo " + memoria.get(i).getPidAtual() + ", liberacao de "
				+ ocupacao[i] + " chunks");
		memoria.remove(i);
		texto = "";
		for (int j = 0; j < memoria.size() - 1; j++) {
			if (j == 0) {
				texto += memoria.get(j).getTipoOcupacao() + "|"
						+ memoria.get(j).getPosicao() + "|"
						+ memoria.get(j).getTamanhoPid();
			} else {
				texto += " -> " + memoria.get(j).getTipoOcupacao() + "|"
						+ memoria.get(j).getPosicao() + "|"
						+ memoria.get(j).getTamanhoPid();

			}
		}
		System.out.println(texto + lastPosi(i));
	}
	
}
