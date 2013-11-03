package a;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Daniel
 * */
public class Processos {
	
	protected BufferedReader br;
	protected int[] pid;
	protected Ordenar oPid;
	protected Ordenar oChegada;
	protected Ordenar oCarga;
	protected Ordenar oPrioridade;
	protected Ordenar ordenar;
	protected int[] chegada = null;
	protected int[] carga = null;
	protected int[] prioridade = null;
	
	/** Metodo para zerar os atributos ou inicializar
	 * @param args vetor de processos
	 * 
	 * */
	protected void zerar(String[] args){
		pid = null;
		chegada = null;
		carga = null;
		prioridade = null;
//		oPid = new Ordenar();
//		oChegada = new Ordenar();
//		oCarga = new Ordenar();
//		oPrioridade = new Ordenar();
//		ordenar = new Ordenar(args.length);
	}
	
	/**
	 * @return int[] - vetor de pid
	 * */
	protected int[] getPid(){
		return pid;
	}
	
	/**
	 * @return int[] - vetor de chegada
	 * */
	protected int[] getChegada(){
		return chegada;
	}
	
	/**
	 * @return int[] - vetor de carga
	 * */
	protected int[] getCarga(){
		return carga;
	}
	
	/**
	 * @return int[] - vetor de prioridade
	 * */
	protected int[] getPrioridade(){
		return prioridade;
	}
	
	/**
	 * @param args - vetor de processos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public Processos(final String[] args) throws IOException {
		zerar(args);
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
}
