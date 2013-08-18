import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Ex05 {

	private BufferedReader br;
	private Ordenar oPid;
	private Ordenar oChegada;
	private Ordenar oCarga;
	private Ordenar oPrioridade;
	private int[] pid = null;
	private int[] chegada = null;
	private int[] carga = null;
	private int[] prioridade = null;
	private String textoTotal = "";
	private String textoCpu = "";
	private String textoThroughput = "";
	private String textoTurnaround = "";
	private int intTotal;
	private double doubleSomaTotal;

	public Ex05() {
	}

	public void zerar(String[] args) throws IOException {
		pid = null;
		chegada = null;
		carga = null;
		prioridade = null;
		oPid = new Ordenar();
		oChegada = new Ordenar();
		oCarga = new Ordenar();
		oPrioridade = new Ordenar();
		textoTotal = "";
		textoCpu = "";
		textoThroughput = "";
		textoTurnaround = "";
		intTotal = 0;
		doubleSomaTotal = 0;
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
		new Ex04().executar(args);
		separarColuna(args);
		double overhead = Integer.parseInt(args[2]);
		for (int i = 0; i < carga.length; i++) {
			intTotal += carga[i];
			doubleSomaTotal += overhead;
		}
		DecimalFormat aproximador = new DecimalFormat("0.0");
		doubleSomaTotal += -1 + intTotal;
		textoTotal = "Total: " + doubleSomaTotal;
		textoCpu = "CPU: " + aproximador.format((intTotal / doubleSomaTotal) * 100)
				+ "%";
		aproximador = new DecimalFormat("0.0000");
		textoThroughput = "Throughput: "
				+ aproximador.format(carga.length / doubleSomaTotal);
		aproximador = new DecimalFormat("0.00");
		double n = 0;
		doubleSomaTotal = 0;
		for (int i = 0; i < carga.length; i++) {
			if (i == 0) {
				doubleSomaTotal += carga[i];
				n += doubleSomaTotal;
			} else {
				doubleSomaTotal += overhead + carga[i] - chegada[i];
				n += doubleSomaTotal;
			}
		}
		textoTurnaround = "Turnaround: "
				+ aproximador.format(n / carga.length);
		System.out.println(textoTotal);
		System.out.println(textoCpu);
		System.out.println(textoThroughput);
		System.out.println(textoTurnaround);

	}
}
