package a;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Ex05 extends Ex04{
	
	private double cpu;
	private double total;
	private double throughput;
	private double turnaround;
	private double overhead;
	private int[] carga;
	private int[] chegada;
	private Calculo calculo;
	private Scanner scanner;
	private DecimalFormat aproximador;
	
	private void total(String[] args){
		if(args[2] == null){
			System.out.println("Informe o overhead para este exercício");
			overhead = scanner.nextDouble();
		} else {
			overhead = Double.parseDouble(args[2]);
		}
		int[] carga = fifoCarga(args);
		total = calculo.total(carga, overhead);
		System.out.println("Total: " + total);
	}
	
	private void cpu(){
		aproximador = new DecimalFormat("0.0");
		cpu = calculo.cpu(carga, total);
		System.out.println("CPU: " + aproximador.format(cpu) + "%");
	}
	
	private void throughput (){
		throughput = calculo.throughput(carga, total);
		aproximador = new DecimalFormat("0.0000");
		System.out.println("Throughput: " + aproximador.format(throughput) );
	}
	
	private void turnaround(){
		turnaround = calculo.turnaround(overhead, carga, chegada);
		System.out.println("Turnaround: " + turnaround);
	}
	
	public void executar(String[] args){
		super.executar(args);
		calculo = new Calculo();
		scanner = new Scanner(System.in);
		carga = fifoCarga(args);
		chegada = fifoChegada(args);
		
		total(args);
		cpu();
		throughput();
		turnaround();
	}
}
