import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex08 {
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

	public Ex08(String[] args) {
		ordenar = new Ordenar(args.length);
	}

	public Ex08() {
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

	public void executar(String[] args) throws IOException {
		zerar(args);
		separarColuna(args);
		String prontos = "";
		for (int i = 0; i < pid.length; i++) {
			if (i == (pid.length - 1)) {
				prontos += "" + pid[i] + "(" + prioridade[i] + ")";
			} else {
				prontos += "" + pid[i] + "(" + prioridade[i] + "):";
			}
		}

		String texto = "", execu = "";
		int posicao = 0, i = 0;
		while (!prontos.equals("")) {
			posicao = prontos.indexOf(":");
			if (i == 0) {
				execu = prontos.substring(0, posicao);
				texto += "Execucao: nenhum " + "Escolhido: "
						+ prontos.substring(0, posicao) + " Prontos: "
						+ (prontos = prontos.substring(posicao + 1)) + "\n";
			} else if (posicao == 8) {
				texto += "Execucao: " + execu + " Escolhido: "
						+ prontos.substring(0, posicao) + " Prontos: "
						+ (prontos = prontos.substring(posicao + 1)) + "\n";
				execu = prontos.substring(0, posicao);
			}
			if (posicao == -1) {
				texto += "Execucao: " + execu + " Escolhido: " + prontos
						+ " Prontos: vazio\n";
				texto += "Execucao: " + prontos + " Escolhido: Vazio"
						+ " Prontos: vazio";
				prontos = "";
			}
			i++;
		}
		System.out.println(texto);
	}
}
