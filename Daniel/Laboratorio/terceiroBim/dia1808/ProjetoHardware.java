package dia1808;

public class ProjetoHardware extends Projeto {

	private float custoComponente;
	private float custoPlaca;
	private float custoMecanica;
	private float custoDesign;

	public ProjetoHardware(String descricao, float custoHora,
			float custoComponente, float custoPlaca, float custoMecanica,
			float custoDesign,) {
		super(descricao, custoHora);
		this.custoComponente = custoComponente;
		this.custoPlaca = custoPlaca;
		this.custoMecanica = custoMecanica;
		this.custoDesign = custoDesign;
	}

	public float getCustoComponente() {
		return custoComponente;
	}

	public void setCustoComponente(float custoComponente) {
		this.custoComponente = custoComponente;
	}

	public float getCustoPlaca() {
		return custoPlaca;
	}

	public void setCustoPlaca(float custoPlaca) {
		this.custoPlaca = custoPlaca;
	}

	public float getCustoMecanica() {
		return custoMecanica;
	}

	public void setCustoMecanica(float custoMecanica) {
		this.custoMecanica = custoMecanica;
	}

	public float getCustoDesign() {
		return custoDesign;
	}

	public void setCustoDesign(float custoDesign) {
		this.custoDesign = custoDesign;
	}

	public float custoAtual(){
		return super.getCustoHora() * super.getQtdHora() + 
				custoComponente + custoDesign + custoMecanica + custoPlaca;
	}
}
/*d)	Crie o método getCustoAtual() para retornar o custo atual do 
 * projeto de hardware através da fórmula: custo por hora x quantidade de
horas concluídas + custo de componentes + custo de placa + custo de mecânica + 
custo de design.*/
