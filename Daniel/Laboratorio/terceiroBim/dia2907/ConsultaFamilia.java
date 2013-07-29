package dia2907;

public class ConsultaFamilia extends Consulta {
	private double valor;

	public ConsultaFamilia() {
		super();
	}

	public double getValorConsulta() {
		if(super.getNumeroDepe() > 2){
			double desconto = super.getValorConsulta() * (50 / 100);
			return valor - desconto;
		}else{
			return valor;
		}
	}

}
