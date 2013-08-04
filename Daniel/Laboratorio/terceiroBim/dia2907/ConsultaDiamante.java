package dia2907;

public class ConsultaDiamante extends Consulta {
	
	public ConsultaDiamante() {
		super();
	}

	public double getValorConsulta() {
		double desconto = super.getValorConsulta() * 0.4;
		return super.getValorConsulta() - desconto;
	}
	
}
