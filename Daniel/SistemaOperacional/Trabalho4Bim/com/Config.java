package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Config extends Processos{
	
	protected static int totalChunks = 0;
	protected static int memoria;
	protected static int chunk;
	protected static Scanner scanner = new Scanner(System.in);
	protected static int[] ocupacao;
	protected static ArrayList<ArrayList<Processos>> processos = new ArrayList<>();
	protected static ArrayList<Processos> pidRemovido = new ArrayList<>();
	
	protected void ocupacaoPid(String[] args) throws IOException{
		new Processos(args);
		ocupacao = new int[12];
		for (int i = 0; i < pid.length; i++) {
			ocupacao[i] = (int) Math.ceil(((double) tamanho[i] / chunk));
		}
	}
	
	protected String acertarString(String tam, int t) {
		String vol = "";
		int n = t - tam.length();
		for (int i = 0; i < n; i++) {
			vol += " ";
		}

		return vol;
	}
	
	protected static File arquivo;
	protected BufferedWriter bw;
	protected static BufferedReader br;

	/**
	 * @param args
	 *            - vetor de processos
	 * @throws IOException
	 *             - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void lerArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		br = new BufferedReader(new FileReader(arquivo));
		if (!arquivo.exists()) {
			System.out.println("Arquivo nao existe executando ex 01");
			new Ex01().executar(args);
		}
	}

	/**
	 * @param args
	 *            - vetor de processos
	 * @throws IOException
	 *             - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	protected void editarArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		bw = new BufferedWriter(new FileWriter(arquivo));
		if (arquivo.exists()) {
			arquivo.delete();
			arquivo.createNewFile();
		}
	}
}
