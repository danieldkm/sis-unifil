package a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex08 extends FilaProntos {

	private Ordenar ordenar;
	private Scanner scanner;
	private Calculo calculo;
	private int[] pid;
	private int[] carga;
	private int[] prioridade;
	private int[] chegada;
	private double utilizacaoCPU;
	private double tempoResposta;
	private double overhead;
	private int quantum;
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

	public void executar(String[] args) {
		pid = psPid(args);
		carga = psCarga(args);
		prioridade = psPrioridade(args);
		chegada = psChegada(args);
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
		String texto = ordenar.mostrarPidQuantum(prioridade, carga, pid, quantum);
		System.out.println(texto);
		cpu();
		tempoResposta();
		
	}

	// private BufferedReader br;
	// private Ordenar oPid;
	// private Ordenar oChegada;
	// private Ordenar oCarga;
	// private Ordenar oPrioridade;
	// private int[] pid = null;
	// private int[] chegada = null;
	// private int[] carga = null;
	// private int[] prioridade = null;
	// private Ordenar ordenar;
	//
	// public Ex08(String[] args) {
	// ordenar = new Ordenar(args.length);
	// }
	//
	// public Ex08() {
	// }
	//
	// public void zerar(String[] args) {
	// pid = null;
	// chegada = null;
	// carga = null;
	// prioridade = null;
	// oPid = new Ordenar();
	// oChegada = new Ordenar();
	// oCarga = new Ordenar();
	// oPrioridade = new Ordenar();
	// }
	//
	// public void separarColuna(String[] args) throws NumberFormatException,
	// IOException {
	// br = new BufferedReader(new FileReader(args[1]));
	// String linha = "";
	// int aux = 0, posicao = 0, i = 0, j = 0;
	//
	// while ((linha = br.readLine()) != null) {
	// while (aux < 4) {
	// posicao = linha.indexOf(";");
	// if (aux == 0) {
	// pid = this.oPid.addElemento(Integer.parseInt(linha
	// .substring(0, posicao)));
	// linha = linha.substring(posicao + 1);
	// } else if (aux == 1) {
	// carga = this.oCarga.addElemento(Integer.parseInt(linha
	// .substring(0, posicao)));
	// linha = linha.substring(posicao + 1);
	// } else if (aux == 2) {
	// chegada = this.oChegada.addElemento(Integer.parseInt(linha
	// .substring(0, posicao)));
	// linha = linha.substring(posicao + 1);
	// } else if (aux == 3) {
	// prioridade = this.oPrioridade.addElemento(Integer
	// .parseInt(linha));
	// }
	// aux++;
	// }
	// aux = 0;
	// }
	// br.close();
	// }
	//
	// public void executar(String[] args) throws IOException {
	// zerar(args);
	// separarColuna(args);
	// String prontos = "";
	// for (int i = 0; i < pid.length; i++) {
	// if (i == (pid.length - 1)) {
	// prontos += "" + pid[i] + "(" + prioridade[i] + ")";
	// } else {
	// prontos += "" + pid[i] + "(" + prioridade[i] + "):";
	// }
	// }
	//
	// String texto = "", execu = "";
	// int posicao = 0, i = 0;
	// while (!prontos.equals("")) {
	// posicao = prontos.indexOf(":");
	// if (i == 0) {
	// execu = prontos.substring(0, posicao);
	// texto += "Execucao: nenhum " + "Escolhido: "
	// + prontos.substring(0, posicao) + " Prontos: "
	// + (prontos = prontos.substring(posicao + 1)) + "\n";
	// } else if (posicao == 8) {
	// texto += "Execucao: " + execu + " Escolhido: "
	// + prontos.substring(0, posicao) + " Prontos: "
	// + (prontos = prontos.substring(posicao + 1)) + "\n";
	// execu = prontos.substring(0, posicao);
	// }
	// if (posicao == -1) {
	// texto += "Execucao: " + execu + " Escolhido: " + prontos
	// + " Prontos: vazio\n";
	// texto += "Execucao: " + prontos + " Escolhido: Vazio"
	// + " Prontos: vazio";
	// prontos = "";
	// }
	// i++;
	// }
	// System.out.println(texto);
	// }
}
