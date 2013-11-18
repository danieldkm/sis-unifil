package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Daniel K. Morita
 * */
public class Ex01 extends Config {

	/**
	 * Metodo responsavel para executar o ex 01
	 * 
	 * @param recebe
	 *            os argumentos
	 * @throws IOException
	 *             - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void executar(String[] args) throws IOException {
		File f = new File("processos.csv");//onde colocar isso é importante
		FileWriter fw = new FileWriter(f);  
        BufferedWriter bw = new BufferedWriter(fw);
		
		
		editarArquivo(args);

		bw.write("A;9417;1;0");
		bw.newLine();
		bw.write("B;5652;2;12");
		bw.newLine();
		bw.write("C;11560;3;6");
		bw.newLine();
		bw.write("D;3890;4;0");
		bw.newLine();
		bw.write("E;2505;5;7");
		bw.newLine();
		bw.write("F;8012;8;0");
		bw.newLine();
		bw.write("G;515;9;0");
		bw.newLine();
		bw.write("H;6000;10;0");
		bw.newLine();
		bw.write("I;4873;11;0");
		bw.newLine();
		bw.write("J;14200;15;0");
		bw.newLine();
		bw.write("K;4000;13;0");
		bw.newLine();
		bw.write("L;2931;14;16");
		bw.newLine();
		bw.close();
		lerArquivo(args);
	}

	@Override
	public void lerArquivo(String[] args) throws IOException {
		Processos p = new Processos(args);
//		char[] pid = p.getPid();
//		int[] t = p.getTamanho();
//		int[] c = p.getChegada();
//		int[] s = p.getSaida();
		System.out.println("____________________________________");
		System.out.println("Pid    tamanho     chegada     saida");
		System.out.println("____________________________________");
		for (int i = 0; i < saida.length; i++) {
			System.out.println(" " + pid[i] + "      " + tamanho[i]
					+ acertarString(Integer.toString(tamanho[i]), 14) + chegada[i]
					+ acertarString(Integer.toString(chegada[i]), 10) + saida[i]);

		}
		System.out.println("____________________________________");
	}

}
