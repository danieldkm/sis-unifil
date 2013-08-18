import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex03 {
	private BufferedReader br;
	private File arquivo;
	private Ordenar oPid;
	private Ordenar oChegada;
	private Ordenar oCarga;
	private Ordenar oPrioridade;
	private Ordenar ordenar;
	private int[] pid = null;
	private int[] chegada = null;
	private int[] carga = null;
	private int[] prioridade = null;

	public void zerar(String[] args) throws IOException {
		pid = null;
		chegada = null;
		carga = null;
		prioridade = null;
		oPid = new Ordenar();
		oChegada = new Ordenar();
		oCarga = new Ordenar();
		oPrioridade = new Ordenar();
		ordenar = new Ordenar(args.length);
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

	public void lerArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		if (!arquivo.exists()) {
			System.out.println("Arquivo não existe executando ex 01");
			new Ex01().executar(args);
		}
	}

	public void executar(String[] args) throws IOException {
		lerArquivo(args);
		zerar(args);
		separarColuna(args);
		ordenar.ordenar(chegada);
		int[] corrigir = ordenar.ordenar2();
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
		for (int k = 0; k < pid.length; k++) {
			if (k == (pid.length - 1)) {
				System.out.print(pid[k] + "\n");
			} else if (k == 0) {
				System.out.print("PID - " + pid[k] + ":");
			} else {
				System.out.print(pid[k] + ":");
			}
		}
	}
}
