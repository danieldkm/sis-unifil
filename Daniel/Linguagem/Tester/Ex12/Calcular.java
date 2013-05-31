package Ex12;

import java.util.Scanner;

import javax.lang.model.element.NestingKind;

public class Calcular {
	private static int a;
	private static int b;
	private static int c;
	private static int d;
	private static int e;
	public static Calcular ca;

	public Calcular() {
	}

	public Calcular(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public Calcular(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Calcular(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Calcular(int a, int b, int c, int d, int e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
	}

	// //Geters and Seters
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	// Calcular media
	public static void doisVerificar() {
		Scanner s = new Scanner(System.in);
		if (a == 0) {
			System.out
					.println("o primeiro valor está zerada, informar o valor");
			a = s.nextInt();
		} 
		if (b == 0) {
			System.out.println("o segundo valor está zerada, informar o valor");
			b = s.nextInt();
		}
	}

	public static double doisMedia() {
		doisVerificar();
		return doisSoma() / 2;
	}

	public static void tresVerificar() {
		doisVerificar();
		if (c == 0) {
			System.out
					.println("o terceiro valor está zerada, informar o terceiro valor");
			Scanner s = new Scanner(System.in);
			c = s.nextInt();
		}
	}

	public static double tresMedia() {
		tresVerificar();
		return tresSoma() / 3;
	}

	public static void quatroVerificar() {
		tresVerificar();
		if (d == 0) {
			System.out
					.println("o quarto valor está zerada, informar o quarto valor");
			Scanner s = new Scanner(System.in);
			d = s.nextInt();
		}
	}

	public static double quatroMedia() {
		quatroVerificar();
		return quatroSoma() / 4;
	}

	public static void cincoVerificar() {
		quatroVerificar();
		if (e == 0) {
			System.out
					.println("o quinto valor está zerada, informar o quinto valor");
			Scanner s = new Scanner(System.in);
			e = s.nextInt();
		}
	}

	public static double cincoMedia() {
		cincoVerificar();
		return cincoSoma() / 5;
	}

	// Calcular soma
	public static double doisSoma() {
		doisVerificar();
		return a + b;
	}

	public static double tresSoma() {
		tresVerificar();
		return a + b + c;
	}

	public static double quatroSoma() {
		quatroVerificar();
		return a + b + c + d;
	}

	public static double cincoSoma() {
		cincoVerificar();
		return a + b + c + d + e;
	}

}
