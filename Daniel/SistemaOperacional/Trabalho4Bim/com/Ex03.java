package com;

import java.util.Scanner;

public class Ex03 extends Config {

	public void executar(String[] args){
		if(args.length < 3){
			String[] novo = new String[4];
			novo[0] = args[0];
			novo[1] = args[1];
			System.out.println("Informe a quantidade de Memoria");
			novo[2] = Integer.toString(scanner.nextInt());
			System.out.println("Informe o tamanho do  chunk");
			novo[3] = Integer.toString(scanner.nextInt());
			args = novo;
		}
		if(args.length < 4){
			String[] novo = new String[4];
			novo[0] = args[0];
			novo[1] = args[1];
			novo[2] = args[2];
			System.out.println("Informe o tamanho do  chunk");
			novo[3] = scanner.nextLine();
			args = novo;
		}
		memoria = Integer.parseInt(args[2]);
		chunk = Integer.parseInt(args[3]);
		totalChunks = memoria / chunk;
		System.out.println("Memoria fisica: " + memoria + " palavras");
		System.out.println("Chunk swpping: " + chunk);
		System.out.println("Total chunks: " + (memoria / chunk));
		
		
	}
}

