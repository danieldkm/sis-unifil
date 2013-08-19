package dia1808;

public class ProjetoSotware extends Projeto {

	private float custoSuplimento;
	private float custoConsultoria;

	public ProjetoSotware(String descricao, float custoHora,
			float custoSuplimento, float custoConsultoria) {
		super(descricao, custoHora);
		this.custoSuplimento = custoSuplimento;
		this.custoConsultoria = custoConsultoria;
	}

	public float getCustoSuplimento() {
		return custoSuplimento;
	}

	public void setCustoSuplimento(float custoSuplimento) {
		if (custoSuplimento > 0) {
			this.custoSuplimento = custoSuplimento;
		}
	}

	public float getCustoConsultoria() {
		return custoConsultoria;
	}

	public void setCustoConsultoria(float custoConsultoria) {
		if (custoConsultoria > 0) {
			this.custoConsultoria = custoConsultoria;
		}
	}

	public float custoAtual() {
		return super.getCustoHora() * super.getQtdHora() + custoConsultoria
				+ custoSuplimento;
	}
}
