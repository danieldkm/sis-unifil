package Ex08;

public class ConversaoDeUnidadesDeTempo {
	public static double minutoConverterSegundos(int m) {
		short s = 60;
		return s * m;
	}

	public static double horaConverterMinutos(int h) {
		short m = 60;
		return m * h;
	}

	public static double diaConverterHora(int d) {
		short h = 24;
		return h * d;
	}

	public static double semanaConverterDia(int s) {
		short d = 7;
		return d * s;
	}

	public static double mesConverterDia(int m) {
		short d = 30;
		return d * m;
	}

	public static double anoConverterDia(int a) {
		float d = 365.25f;
		return d * a;
	}
}
