import java.io.IOException;
import java.text.DecimalFormat;

public class Ex07 extends FilaProntos {

	private int tempoTotal;
	private double utilizacaoCPU;
	private int tempoResposta;
	private int overhead;
	private int quantum;
	private int[] carga = null;
	private int[] pid = null;
	private Ordenar ordenar;

	public void executar(String[] args) throws IOException {

		ordenar = new Ordenar();
		pid = fifoPid(args);
		carga = fifoCarga(args);
		quantum = Integer.parseInt(args[3]);
		String texto = ordenar.mostrarPidQuantum(carga, pid, quantum);
		System.out.println(texto);

		// int[] novaCarga = null;
		// ordenar = new Ordenar();
		// overhead = Integer.parseInt(args[2]);
		// quantum = Integer.parseInt(args[3]);
		// carga = fifoCarga(args);
		// for (int i = 0; i < carga.length; i++) {
		// while (carga[i] > 0) {
		// if (carga[i] <= 0) {
		// novaCarga = ordenar.addElemento(0);
		// } else {
		// novaCarga = ordenar.addElemento(carga[i]);
		// }
		// carga[i] += -quantum;
		// }
		//
		// }
		// for (int i = 0; i < novaCarga.length; i++) {
		// if (i > 0) {
		// overhead++;
		// tempoResposta += novaCarga[i - 1] + overhead;
		// tempoResposta += overhead;
		// }
		// tempoTotal += novaCarga[i];
		// }
		// double ut = novaCarga.length + 1 + overhead;
		// utilizacaoCPU = ((novaCarga.length + 1) / ut) * 100;
		// System.out.println("Tempo Total: " + (tempoTotal + overhead));
		// DecimalFormat aproximador = new DecimalFormat("0.00");
		// System.out.println("Utilizacao de CPU: "
		// + aproximador.format(utilizacaoCPU) + "%");
		// System.out.println("Tempo de Resposta: "
		// + aproximador.format(tempoResposta / (carga.length + 1)));
	}
}
