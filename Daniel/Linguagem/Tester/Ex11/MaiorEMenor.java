package Ex11;

public class MaiorEMenor {
	private static int a;
	private static int b;
	private static int c;
	private static int d;
	private static int e;

	public MaiorEMenor() {
	}

	public MaiorEMenor(int a, int b, int c, int d, int e) {
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

	// Metodos - funções - para maior número
	public static int maiorDois() {
		if (a > b) {
			return a;
		} else if (a == b) {
			return a;
		} else {
			return b;
		}
	}

	public static int maiorTres() {
		if (maiorDois() > c) {
			return maiorDois();
		} else if (maiorDois() == c) {
			return maiorDois();
		} else {
			return c;
		}
	}

	public static int maiorQuatro() {
		if (maiorTres() > d) {
			return maiorTres();
		} else if (maiorTres() == d) {
			return maiorTres();
		} else {
			return d;
		}
	}
	
	public static int maiorCinco() {
		if (maiorQuatro() > e) {
			return maiorQuatro();
		} else if (maiorQuatro() == e) {
			return maiorQuatro();
		} else {
			return e;
		}
	}
	// para menor numero
	public static int menorDois() {
		if (a < b) {
			return a;
		} else if (a == b) {
			return a;
		} else {
			return b;
		}
	}

	public static int menorTres() {
		if (menorDois() < c) {
			return menorDois();
		} else if (menorDois() == c) {
			return menorDois();
		} else {
			return c;
		}
	}

	public static int menorQuatro() {
		if (menorTres() < d) {
			return menorTres();
		} else if (menorTres() == d) {
			return menorTres();
		} else {
			return d;
		}
	}
	
	public static int menorCinco() {
		if (menorQuatro() < e) {
			return menorQuatro();
		} else if (menorQuatro() == e) {
			return menorQuatro();
		} else {
			return e;
		}
	}
	
}
