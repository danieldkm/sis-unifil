package dia2907;

public class ConsultaOuro extends Consulta {

	public ConsultaOuro() {
		super();
	}

	public double getValorConsulta() {
		if (super.getAno() <= 2000) {
			return super.getValorConsulta();
		} else {
			double desconto = super.getValorConsulta() * 0.2;
			return super.getValorConsulta() - desconto;
		}
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
