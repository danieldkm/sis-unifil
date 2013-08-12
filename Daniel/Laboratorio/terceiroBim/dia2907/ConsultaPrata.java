package dia2907;

import javax.swing.JOptionPane;

public class ConsultaPrata extends Consulta {

	public ConsultaPrata() {
		super();
	}

	@Override
	public double getValorConsulta() {
		double desconto = super.getValorConsulta() * 0.2;
		return super.getValorConsulta() - desconto;
	}

}
