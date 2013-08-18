import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimProc {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		Ex01 ex01 = new Ex01();
		Ex02 ex02 = new Ex02();
		Ex03 ex03 = new Ex03();
		Ex04 ex04 = new Ex04();
		Ex05 ex05 = new Ex05();
		Ex06 ex06 = new Ex06();
		Ex07 ex07 = new Ex07(args);
		Ex08 ex08 = new Ex08(args);
		boolean con = true;
		int exercicio = 0;
		System.out.println("Exercício " + args[0]);
		// switch (args[0]) {
		// case "ex1":
		// sp.ex01(args);
		// break;
		// case "ex2":
		// sp.ex02(args);
		// break;
		// case "ex3":
		// break;
		// case "ex4":
		// break;
		// case "ex5":
		// break;
		// case "ex6":
		// break;
		// case "ex7":
		// break;
		// case "ex8":
		// break;
		// }

		do {
			System.out.println("Informe qual exercício deseja executar [1-8]");
			try {
				exercicio = s.nextInt();
				if (exercicio <= 0 || exercicio > 8) {
					con = true;
					System.out.println("Exercício incorreto");
				} else {
					con = false;
				}
			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("Erro");
				con = true;
				s.nextLine();
			}

		} while (con);

		con = true;
		String p = "";
		while (con) {
			switch (exercicio) {
			case 1:
				ex01.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 2:
				ex02.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 3:
				ex03.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 4:
				ex04.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 5:
				ex05.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 6:
				ex06.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 7:
				ex07.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			case 8:
				ex08.executar(args);
				System.out.println("Execução Completada.\n");
				break;
			}
			System.out.println("Finalizar programa? SIM[S] NÃO[N]");
			p = s.next().toUpperCase();
			if (p.equals("S") || p.equals("N")) {
				if (p.equals("N")) {
					exercicio = 0;
					do {
						System.out
								.println("Informe qual exercício deseja executar [1-8]?");
						con = true;
						try {
							exercicio = s.nextInt();
							if (exercicio <= 0 || exercicio > 8) {
								con = false;
								System.out.println("Exercício incorreto");
							} else {
								con = true;
							}
						} catch (Exception e) {
							// e.printStackTrace();
							System.out.println("Erro");
							con = false;
							s.nextLine();
						}
					} while (con == false);
					con = true;
				} else if (p.equals("S")) {
					con = false;
				}
			} else {
				System.out.println("Erro 1");
				exercicio = 0;
				con = true;
			}
		}
	}
}
