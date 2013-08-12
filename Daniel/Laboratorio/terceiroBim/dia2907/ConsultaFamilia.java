package dia2907;

public class ConsultaFamilia extends Consulta {

	public ConsultaFamilia() {
		super();
	}

	@Override
	public double getValorConsulta() {
		if(super.getNumeroDepe() > 2){
			double desconto = super.getValorConsulta() * 0.5;
			return super.getValorConsulta() - desconto;
		}else{
			return super.getValorConsulta();
		}
	}

}
