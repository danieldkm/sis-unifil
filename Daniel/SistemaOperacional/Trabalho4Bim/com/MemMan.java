package com;

import java.io.IOException;

public class MemMan {

	public static void main(String[] args) throws IOException {
		Ex01 ex01 = new Ex01();
		Ex02 ex02 = new Ex02();
		Ex03 ex03 = new Ex03();
		Ex04 ex04 = new Ex04();
		System.out.println("Exercício " + args[0]);
		switch(args[0]){
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
		}
	}
}
