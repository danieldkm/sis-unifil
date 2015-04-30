package bim2.trab1;

import java.io.File;

public class Main {

	public static void main(String[] args){
		LerArquivo l = new ArquivoTxt();
//		System.out.println(l.lerArquivo(new File("input.txt")));
		char[] te = l.lerArquivo(new File("input.txt")).toCharArray();
		for (int i = 0; i < te.length; i++) {
			for (int j = i + 1; j < te.length; j++) {
				if(te[i] == te[j]){
					System.out.println(te[i]);
				}
			}
		}
		
	}
}
