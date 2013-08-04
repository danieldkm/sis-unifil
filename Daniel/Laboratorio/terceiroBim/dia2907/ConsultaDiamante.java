package dia2907;

public class ConsultaDiamante extends Consulta {
	
	public ConsultaDiamante() {
		super();
	}

	public double getValorConsulta() {
		double desconto = super.getValorConsulta() * 0.4;
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
