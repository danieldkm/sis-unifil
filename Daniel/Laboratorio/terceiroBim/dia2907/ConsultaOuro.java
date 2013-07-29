package dia2907;

public class ConsultaOuro extends Consulta {
	private double valor;

	public ConsultaOuro() {
		super();
	}

	public double getValorConsulta() {
		if (super.getAno() <= 2000) {
			return valor;
		} else {
			double desconto = super.getValorConsulta() * (20 / 100);
			return valor - desconto;
		}
	}

}
