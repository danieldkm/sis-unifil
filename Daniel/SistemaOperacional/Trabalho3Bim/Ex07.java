import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Ex07 {
	private BufferedReader br;
	private Ordenar oPid;
	private Ordenar oChegada;
	private Ordenar oCarga;
	private Ordenar oPrioridade;
	private int[] pid = null;
	private int[] chegada = null;
	private int[] carga = null;
	private int[] prioridade = null;
	private Ordenar ordenar;

	public Ex07(String[] args) {
		ordenar = new Ordenar(args.length);
		tempoTotal = 0;
		utilizacaoCPU = 0;
		tempoResposta = 0;
		overhead = 0;
		quantum = 0;
	}
	
	public Ex07() {
	}
	
	public void zerar(String[] args) {
		pid = null;
		chegada = null;
		carga = null;
		prioridade = null;
		oPid = new Ordenar();
		oChegada = new Ordenar();
		oCarga = new Ordenar();
		oPrioridade = new Ordenar();
	}

	public void separarColuna(String[] args) throws NumberFormatException,
			IOException {
		br = new BufferedReader(new FileReader(args[1]));
		String linha = "";
		int aux = 0, posicao = 0, i = 0, j = 0;

		while ((linha = br.readLine()) != null) {
			while (aux < 4) {
				posicao = linha.indexOf(";");
				if (aux == 0) {
					pid = this.oPid.addElemento(Integer.parseInt(linha
							.substring(0, posicao)));
					linha = linha.substring(posicao + 1);
				} else if (aux == 1) {
					carga = this.oCarga.addElemento(Integer.parseInt(linha
							.substring(0, posicao)));
					linha = linha.substring(posicao + 1);
				} else if (aux == 2) {
					chegada = this.oChegada.addElemento(Integer.parseInt(linha
							.substring(0, posicao)));
					linha = linha.substring(posicao + 1);
				} else if (aux == 3) {
					prioridade = this.oPrioridade.addElemento(Integer
							.parseInt(linha));
				}
				aux++;
			}
			aux = 0;
		}
		br.close();
	}

	private int tempoTotal;
	private double utilizacaoCPU;
	private int tempoResposta;
	private int overhead;
	private int quantum;
	
	public void executar(String[] args) throws IOException{
		zerar(args);
		new Ex04().executar(args);
		separarColuna(args);
		int[] novaCarga = null;
		overhead = Integer.parseInt(args[2]);
		quantum = Integer.parseInt(args[3]);
		for (int i = 0; i < carga.length; i++) {
			while(carga[i] > 0){
				if(carga[i] <= 0){
					novaCarga = ordenar.addElemento(0);
				}else{
					novaCarga = ordenar.addElemento(carga[i]);
				}
				carga[i] += - quantum;
			}
			
		}
		for (int i = 0; i < novaCarga.length; i++) {
			if(i > 0){
				overhead ++; 
				tempoResposta += novaCarga[i-1] + overhead;
				tempoResposta += overhead;
			}
			tempoTotal += novaCarga[i];
		}
		double ut = novaCarga.length + 1 + overhead;
		utilizacaoCPU = ((novaCarga.length + 1) / ut) * 100;
		System.out.println("Tempo Total: " + (tempoTotal + overhead));
		DecimalFormat aproximador = new DecimalFormat("0.00");
		System.out.println("Utilização de CPU: " + aproximador.format(utilizacaoCPU) + "%");
		System.out.println("Tempo de Resposta: " + aproximador.format(tempoResposta / (carga.length + 1)));
	}
}
