package a;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex07 extends FilaProntos {

	private double tempoTotal;
	private double utilizacaoCPU;
	private double tempoResposta;
	private double overhead;
	private double throughput;
	private double turnaround;
	private int quantum;
	private int[] carga = null;
	private int[] pid = null;
	private int[] chegada = null;
	private Ordenar ordenar;
	private Scanner scanner;
	private Calculo calculo;
	private DecimalFormat aproximador;

	private void cpu() {
		aproximador = new DecimalFormat("0.0");
		utilizacaoCPU = calculo.cpu(carga, overhead, quantum);
		System.out.println("Utillização de CPU: " + aproximador.format(utilizacaoCPU) + "%");
	}

	private void tempoResposta(){
		tempoResposta = calculo.tempoResposta(quantum, overhead, carga, chegada);
		System.out.println("Tempo de Resposta: " + tempoResposta);
	}

	public void executar(String[] args) throws IOException {
		calculo = new Calculo();
		scanner = new Scanner(System.in);
		ordenar = new Ordenar();
		pid = fifoPid(args);
		carga = fifoCarga(args);
		if (args[3] == null) {
			System.out.println("Informe o quantum para este exercício");
			quantum = scanner.nextInt();
		} else {
			quantum = Integer.parseInt(args[3]);
		}
		if (args[2] == null) {
			System.out.println("Informe o overhead para este exercício");
			overhead = scanner.nextDouble();
		} else {
			overhead = Double.parseDouble(args[2]);
		}
		String texto = ordenar.mostrarPidQuantum(carga, pid, quantum);
		System.out.println(texto);
		carga = fifoCarga(args);
		chegada = fifoChegada(args);
		pid = fifoPid(args);
		cpu();
		tempoResposta();
	}
}
