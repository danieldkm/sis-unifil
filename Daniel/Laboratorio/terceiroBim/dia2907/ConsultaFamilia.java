package dia2907;

public class ConsultaFamilia extends Consulta {

	public ConsultaFamilia() {
		super();
	}

	public double getValorConsulta() {
		if(super.getNumeroDepe() > 2){
			double desconto = super.getValorConsulta() * 0.5;
			return super.getValorConsulta() - desconto;
		}else{
			return super.getValorConsulta();
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
