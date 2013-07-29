package dia2907;

public class ConsultaDiamante extends Consulta {
	
	private double valor;

	public ConsultaDiamante() {
		super();
	}

	public double getValorConsulta() {
		double desconto = super.getValorConsulta() * (40 / 100);
		return valor - desconto;
	}

}
