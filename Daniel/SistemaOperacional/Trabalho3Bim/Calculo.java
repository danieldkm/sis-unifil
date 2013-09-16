import java.io.IOException;
import java.text.DecimalFormat;

public class Calculo {

	private int[] carga;
	private Processos processos;

	public int total(String[] args) {
		try {
			processos = new Processos(args);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		carga = processos.getCarga();
		int n = 0;
		for (int i = 0; i < args.length; i++) {
			n += carga[i];
		}
		return n;
	}

	public double total(int[] carga, double overhead) {
		double n = 0;
		for (int i = 0; i < carga.length; i++) {
			n += carga[i];
			if (i > 0) {
				n += overhead;
			}
		}
		return n;
	}

	public double cpu(int[] carga, double overhead, int quantum) {
		double n = 0;
		double o = 0;
		int q = 0;
		int[] c = new int[carga.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = carga[i];
		}
		for (int i = 0; i < c.length; i++) {
			while (c[i] > 0) {
				c[i] += -quantum;
				if (c[i] > 0) {
					q += overhead;
				}
			}
		}
		for (int i = 0; i < carga.length; i++) {
			n += carga[i];
			if (i > 0) {
				o += overhead;
			}
		}
		// System.out.println(n);
		// System.out.println((o + q));
		return (o / (o + q)) * 100;
	}

	public double cpu(int[] carga, double total) {
		double n = 0.0;
		for (int i = 0; i < carga.length; i++) {
			n += carga[i];
		}
		double cpu = (n / total) * 100;
		return cpu;
	}

	public double throughput(int[] carga, double total) {
		double throughput = carga.length;
		return throughput / total;
	}

	public double turnaround(double overhead, int[] carga, int[] chegada) {
		double turn = 0.0;
		double aux = 0.0;
		for (int i = 0; i < carga.length; i++) {
			if (i == 0) {
				turn = carga[i];
			} else if (i > 0) {
				for (int j = 0; j <= i; j++) {
					if (j > 0) {
						aux += carga[j] + overhead - chegada[j];
					} else {
						aux += carga[j];
					}
				}
				// System.out.println(aux);
				// System.out.println("-----------------");
				turn += aux;
				aux = 0;
			}
		}
		return turn / carga.length;
	}

	public double tempoResposta(int quantum, double overhead, int[] carga,
			int[] chegada) {
		double soma = 0;
		int vezes = 0;
		for (int i = 0; i < carga.length; i++) {
			if (i > 0) {
				if (carga[i - 1] >= 10) {
					while (carga[i - 1] >= 10) {
						soma += (carga[i - 1] + overhead) - chegada[i - 1];
						vezes++;
						carga[i - 1] += -quantum;
					}
				} else {
					soma += (carga[i - 1] + overhead) - chegada[i - 1];
					vezes++;
				}
			}
		}

		return soma / vezes;
	}

}
