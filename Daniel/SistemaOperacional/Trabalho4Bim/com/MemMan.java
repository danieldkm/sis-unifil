package com;

import java.io.IOException;
import java.util.Scanner;

public class MemMan extends Config {

	public static void main(String[] args) throws IOException {
		Ex01 ex01 = new Ex01();
		Ex02 ex02 = new Ex02();
		Ex03 ex03 = new Ex03();
		Ex04 ex04 = new Ex04();
		Ex05 ex05 = new Ex05();
		Ex06 ex06 = new Ex06();
		Ex07 ex07 = new Ex07();
		Ex08 ex08 = new Ex08();
		System.out.println("Didite o exercicio da sequencia de 1 a 8");
		System.out.println("Exercício " + args[0]);
		boolean ok = true;
		String continuar = "";
		while (ok) {
			switch (args[0]) {
			case "ex01":
				ex01.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex02":
				ex02.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex03":
				ex03.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex04":
				ex04.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex05":
				ex05.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex06":
				ex06.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex07":
				ex07.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case "ex08":
				ex08.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			}
			System.out.println("Deseja finalizar o programa?S/N");
			continuar = scanner.nextLine().toLowerCase();
			if(continuar.equals("s")){
				ok = false;
			} else {
				System.out.println("Didite o exercicio da sequencia de 1 a 7");
				System.out.println("Exercício " + args[0]);
				args[0] = scanner.nextLine().toLowerCase();
			}
		}
	}
}
