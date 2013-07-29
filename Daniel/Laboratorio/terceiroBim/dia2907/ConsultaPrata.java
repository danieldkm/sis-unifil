package dia2907;


public class ConsultaPrata extends Consulta {
	
	private double valor;
	
	public ConsultaPrata(){
		super();
	}

	public double getValorConsulta() {
		double desconto = super.getValorConsulta() * (20/100);
		return valor - desconto;
	}


}
