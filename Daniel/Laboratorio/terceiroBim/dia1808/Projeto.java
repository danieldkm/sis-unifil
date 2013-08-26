package dia1808;

public class Projeto {

	private String descricao;
	private float custoHora;
	private int qtdHora;

	public Projeto(String descricao, float custoHora) {
		super();
		this.descricao = descricao;
		this.custoHora = custoHora;
	}

	public void registrarHora(int hora) {
		this.qtdHora = hora;
	}

	public float custoAtual() {
		return getCustoHora() * getQtdHora();
	}

	public int getQtdHora() {
		return qtdHora;
	}

	public float getCustoHora() {
		return custoHora;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
