package a;
import java.io.IOException;

public class FilaProntos extends Arquivo{
	
	private Processos processos;
	private Ordenar ordenar;

	public FilaProntos() {
	}
	
	public FilaProntos(String[] args) {
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
	}
	
	protected int[] psPrioridade(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar2(processos.getPrioridade());
		return corrigir;
	}
	
	protected int[] psPid(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getPrioridade(), processos.getPid());
		return corrigir;
	}
	
	protected int[] psChegada(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getPrioridade(), processos.getChegada());
		return corrigir;
	}
	
	protected int[] psCarga(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getPrioridade(), processos.getCarga());
		return corrigir;
	}
	
	protected int[] sjfPid(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getPrioridade(), processos.getPid());
//		for (int i = 0; i < corrigir.length; i++) {
//			System.out.println(corrigir[i]);
//		}
		return corrigir;
	}
	
	protected int[] sjfChegada(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		int[] corrigir = ordenar.ordenar(processos.getCarga(), processos.getChegada());
		return corrigir;
	}
	
	protected int[] sjfCarga(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		int[] corrigir = ordenar.ordenar(processos.getCarga());
		return corrigir;
	}
	
	protected int[] fifoPid(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getChegada());
		int[] pid = processos.getPid();
		int correcao = 0;
		for (int j2 = 0; j2 < corrigir.length; j2++) {
			if (corrigir[j2] != j2) {
				for (int k = j2 + 1; k < corrigir.length; k++) {
					if (corrigir[k] == j2) {
						correcao = corrigir[j2];
						corrigir[j2] = corrigir[k];
						corrigir[k] = correcao;
						correcao = pid[j2];
						pid[j2] = pid[k];
						pid[k] = correcao;
					}
				}
			}
		}
		return pid;
	}
	
	protected int[] fifoCarga(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getChegada());
		int[] carga = processos.getCarga();
		int correcao = 0;
		for (int j2 = 0; j2 < corrigir.length; j2++) {
			if (corrigir[j2] != j2) {
				for (int k = j2 + 1; k < corrigir.length; k++) {
					if (corrigir[k] == j2) {
						correcao = corrigir[j2];
						corrigir[j2] = corrigir[k];
						corrigir[k] = correcao;
						correcao = carga[j2];
						carga[j2] = carga[k];
						carga[k] = correcao;
					}
				}
			}
		}
		return carga;
	}
	
	protected int[] fifoChegada(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getChegada());
		int correcao = 0;
		for (int j2 = 0; j2 < corrigir.length; j2++) {
			if (corrigir[j2] != j2) {
				for (int k = j2 + 1; k < corrigir.length; k++) {
					if (corrigir[k] == j2) {
						correcao = corrigir[j2];
						corrigir[j2] = corrigir[k];
						corrigir[k] = correcao;
					}
				}
			}
		}
		return corrigir;
	}
	
	protected int[] filaProntos(String[] args){
		ordenar = new Ordenar();
		try {
			processos = new Processos(args);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("Erro Processos");
		}
		
		int[] corrigir = ordenar.ordenar(processos.getChegada());
		int[] pid = processos.getPid();
		int correcao = 0;
		for (int j2 = 0; j2 < corrigir.length; j2++) {
			if (corrigir[j2] != j2) {
				for (int k = j2 + 1; k < corrigir.length; k++) {
					if (corrigir[k] == j2) {
						correcao = corrigir[j2];
						corrigir[j2] = corrigir[k];
						corrigir[k] = correcao;
						correcao = pid[j2];
						pid[j2] = pid[k];
						pid[k] = correcao;
					}
				}
			}
		}
		
		return pid;
	}
	
	
	
	/**
	 * 		int[] corrigir = ordenar.ordenar(chegada);
		
		int correcao = 0;
		for (int j2 = 0; j2 < corrigir.length; j2++) {
			if (corrigir[j2] != j2) {
				for (int k = j2 + 1; k < corrigir.length; k++) {
					if (corrigir[k] == j2) {
						correcao = corrigir[j2];
						corrigir[j2] = corrigir[k];
						corrigir[k] = correcao;
						correcao = pid[j2];
						pid[j2] = pid[k];
						pid[k] = correcao;
					}
				}
			}
		}
	 * */
	
//	protected BufferedReader br;
//	protected int[] pid;
//	protected Ordenar oPid;
//	protected Ordenar oChegada;
//	protected Ordenar oCarga;
//	protected Ordenar oPrioridade;
//	protected Ordenar ordenar;
//	protected int[] chegada = null;
//	protected int[] carga = null;
//	protected int[] prioridade = null;
	
	
//	public FilaProntos() {
//		pid = null;
//		chegada = null;
//		carga = null;
//		prioridade = null;
//		oPid = new Ordenar();
//		oChegada = new Ordenar();
//		oCarga = new Ordenar();
//		oPrioridade = new Ordenar();
//	}
//	
//	protected void zerar(String[] args){
//		pid = null;
//		chegada = null;
//		carga = null;
//		prioridade = null;
//		oPid = new Ordenar();
//		oChegada = new Ordenar();
//		oCarga = new Ordenar();
//		oPrioridade = new Ordenar();
//		ordenar = new Ordenar(args.length);
//	}
//	
//	public void filaProntos(String[] args) throws NumberFormatException,
//			IOException {
////		zerar(args);
//		br = new BufferedReader(new FileReader(args[1]));
//		String linha = "";
//		int aux = 0, posicao = 0, i = 0, j = 0;
//
//		while ((linha = br.readLine()) != null) {
//			while (aux < 4) {
//				posicao = linha.indexOf(";");
//				if (aux == 0) {
//					pid = this.oPid.addElemento(Integer.parseInt(linha
//							.substring(0, posicao)));
//					linha = linha.substring(posicao + 1);
//				} else if (aux == 1) {
//					carga = this.oCarga.addElemento(Integer.parseInt(linha
//							.substring(0, posicao)));
//					linha = linha.substring(posicao + 1);
//				} else if (aux == 2) {
//					chegada = this.oChegada.addElemento(Integer.parseInt(linha
//							.substring(0, posicao)));
//					linha = linha.substring(posicao + 1);
//				} else if (aux == 3) {
//					prioridade = this.oPrioridade.addElemento(Integer
//							.parseInt(linha));
//				}
//				aux++;
//			}
//			aux = 0;
//		}
//		br.close();
//	}
}
