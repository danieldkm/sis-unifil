package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Daniel
 * */
public class Processos {

	private String pidAtual;
	private String tipoOcupacao;
	private int posicao;
	private int tamanhoPid;
	private String funcao;
	private String pidEscolhido;
	protected BufferedReader br;
	protected Ordenar oPid;
	protected Ordenar oChegada;
	protected Ordenar oCarga;
	protected Ordenar oPrioridade;
	protected Ordenar ordenar;
	protected static char[] pid;
	protected static int[] tamanho;
	protected static int[] chegada;
	protected static int[] saida;
	
	
	
	public String getPidEscolhido() {
		return pidEscolhido;
	}

	public void setPidEscolhido(String pidEscolhido) {
		this.pidEscolhido = pidEscolhido;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getPidAtual() {
		return pidAtual;
	}

	public void setPidAtual(String pidAtual) {
		this.pidAtual = pidAtual;
	}

	public String getTipoOcupacao() {
		return tipoOcupacao;
	}

	public void setTipoOcupacao(String tipoOcupacao) {
		this.tipoOcupacao = tipoOcupacao;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getTamanhoPid() {
		return tamanhoPid;
	}

	public void setTamanhoPid(int tamanhoPid) {
		this.tamanhoPid = tamanhoPid;
	}

	public Processos() {
		pid = null;
		chegada = null;
		tamanho = null;
		saida = null;
	}

	/**
	 * Metodo para zerar os atributos ou inicializar
	 * 
	 * @param args
	 *            vetor de processos
	 * 
	 * */
	protected void zerar() {
		pid = new char[12];
		chegada = new int[12];
		tamanho = new int[12];
		saida = new int[12];
	}

	/**
	 * @return int[] - vetor de pid
	 * */
	protected char[] getPid() {
		return pid;
	}

	/**
	 * @return int[] - vetor de chegada
	 * */
	protected int[] getChegada() {
		return chegada;
	}

	/**
	 * @return int[] - vetor de tamanho
	 * */
	protected int[] getTamanho() {
		return tamanho;
	}

	/**
	 * @return int[] - vetor de prioridade
	 * */
	protected int[] getSaida() {
		return saida;
	}

	/**
	 * @param args
	 *            - vetor de processos
	 * @throws IOException
	 *             - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	/*
	 * pid = null; chegada = null; tamanho = null; saida = null;
	 */
	public Processos(final String[] args) throws IOException {
		zerar();
		br = new BufferedReader(new FileReader(args[1]));
		String linha = "";
		int aux = 0, posicao = 0;
		int n = 0;
		while ((linha = br.readLine()) != null) {
			while (aux < 4) {
				posicao = linha.indexOf(";");
				if (aux == 0) {
					pid[n] = linha.substring(0, posicao).charAt(0);
					linha = linha.substring(posicao + 1);
				} else if (aux == 1) {
					tamanho[n] = Integer.parseInt(linha.substring(0, posicao));
					linha = linha.substring(posicao + 1);
				} else if (aux == 2) {
					chegada[n] = Integer.parseInt(linha.substring(0, posicao));
					linha = linha.substring(posicao + 1);
				} else if (aux == 3) {
					if(!linha.equals("0")){
						saida[n] = Integer.parseInt(linha);
					}
				}
				aux++;
			}
			n++;
			aux = 0;
		}
		br.close();
	}
}
