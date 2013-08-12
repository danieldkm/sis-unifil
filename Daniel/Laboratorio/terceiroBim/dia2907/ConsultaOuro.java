package dia2907;

public class ConsultaOuro extends Consulta {

	public ConsultaOuro() {
		super();
	}

	@Override
	public double getValorConsulta() {
		if (super.getAno() <= 2000) {
			return super.getValorConsulta();
		} else {
			double desconto = super.getValorConsulta() * 0.2;
			return super.getValorConsulta() - desconto;
		}
	}

}
