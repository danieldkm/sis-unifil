package dia2907;

public class Consulta {

	/**
	 * @param args
	 */
	private String nome;
	private int matricula;
	private int numeroDepe;
	private int ano;
	private double valorConsulta;

	public Consulta(/*
					 * String nome, int matricula, int numeroDepe, // int ano,
					 * double valor
					 */) {
		// this.nome = nome;
		// this.matricula = matricula;
		// this.numeroDepe = numeroDepe;
		// this.ano = ano;
		// this.valorConsulta = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getNumeroDepe() {
		return numeroDepe;
	}

	public void setNumeroDepe(int numeroDepe) {
		this.numeroDepe = numeroDepe;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public void setInstaciar(String nome, int matricula, int numeroDepe,
			int ano, double valor) {
		this.nome = nome;
		this.matricula = matricula;
		this.numeroDepe = numeroDepe;
		this.ano = ano;
		this.valorConsulta = valor;
	}

	private int[] qtd = new int[4];

	public int getQtd(int indice) {
		return qtd[indice];
	}

	public void setQtd(int indice) {
		this.qtd[indice] += 1;
	}
}
