package dia2907;

import javax.swing.JOptionPane;

public class ConsultaPrata extends Consulta {

	public ConsultaPrata() {
		super();
	}

	public double getValorConsulta() {
		double desconto = super.getValorConsulta() * 0.2;
		return super.getValorConsulta() - desconto;
	}

	public void setInstaciar(String nome, int matricula, int numeroDepe,
			int ano, double valor) {
		super.setNome(nome);
		super.setMatricula(matricula);
		super.setNumeroDepe(numeroDepe);
		super.setAno(ano);
		super.setValorConsulta(valor);
	}
}
