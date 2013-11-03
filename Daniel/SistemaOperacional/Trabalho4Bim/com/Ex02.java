package com;

import java.io.IOException;

public class Ex02 extends Config {

	public void executar(String[] args) throws IOException{
		Processos p = new Processos(args);
		
		for (int i = 0; i < pid.length; i++) {
			if(saida[i] == 0){
				System.out.println("pid " + pid[i] + ", com " + tamanho[i] + acertarString(Integer.toString(tamanho[i]), 6) + "palavras, chegada em " + chegada[i] + acertarString(Integer.toString(chegada[i]), 3) + "e saída em " + saida[i]);
			} else {
				System.out.println("pid " + pid[i] + ", com " + tamanho[i] + acertarString(Integer.toString(tamanho[i]), 6) +"palavras, chegada em " + chegada[i]);
			}
		}
	}
}
