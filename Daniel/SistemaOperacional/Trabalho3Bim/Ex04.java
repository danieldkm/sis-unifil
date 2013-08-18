import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex04 {

	private BufferedReader br;
	private File arquivo;
	private Ordenar oPid;
	private Ordenar oChegada;
	private Ordenar oCarga;
	private Ordenar oPrioridade;
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
		String texto = "";
		String prontos = "";

		int[] pronto = filaProntoEx4();
		int[] prox = new int[pid.length];
		int[] resta = new int[pid.length];
		int j = 0;
		for (int i = 0; i < pronto.length; i++) {
			if (pronto[i] != 0) {
				if (i == (pronto.length - 1)) {
					prontos += "" + pronto[i];
				} else {
					prontos += "" + pronto[i] + ":";
				}
			} else {
				resta[j++] = i;
			}
		}

		int i = 0, posicao = 0;
		String execu = "";
		while (!prontos.equals("")) {
			posicao = prontos.indexOf(":");
			if (i == 0) {
				execu = prontos.substring(0, posicao);
				texto += "Execução: nenhum " + "Escolhido: "
						+ prontos.substring(0, posicao) + " Prontos: "
						+ (prontos = prontos.substring(posicao + 1)) + "\n";
			} else if (posicao == 4) {
				texto += "Execução: " + execu + " Escolhido: "
						+ prontos.substring(0, posicao) + " Prontos: "
						+ (prontos = prontos.substring(posicao + 1)) + "\n";
				execu = prontos.substring(0, posicao);
			}
			if (posicao == -1) {
				texto += "Execução: " + execu + " Escolhido: " + prontos
						+ " Prontos: vazio\n";
				texto += "Execução: " + prontos + " Escolhido: vazio" 
						+ " Prontos: vazio\n";
				prontos = "";
			}
			i++;

		}
		System.out.println(texto);
	}

	public int[] filaProntoEx4() {
		int soma = 0;
		int[] pronto = new int[pid.length];
		int j = 0, h = 0, w = 0;
		int[] sobra = new int[pid.length];
		int[] q = new int[pid.length];
		for (int i = 0; i < pronto.length; i++) {
			if (chegada[i] == 0) {
				pronto[j++] = pid[i];
				soma += carga[i];
			} else if (soma > carga[i]) {
				pronto[j++] = pid[i];
				soma += carga[i];
			} else {
				sobra[h++] = pid[i];
				q[w++] = carga[i];
			}

		}

		for (int i = 0; i < q.length; i++) {
			if (sobra[i] != 0) {
				if (soma > q[i]) {
					pronto[j++] = sobra[i];
				}
				soma += q[i];
			} else {
				break;
			}
		}

		return pronto;
	}
}
