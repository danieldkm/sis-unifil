package dia0909;

public class Projeto {
	private String nomeProjeto;
	private float custoHora;
	private int horasExecutadas;
	
	public Projeto(String n, float c){
		nomeProjeto = n;
		custoHora = c;
	}

	public float getCustoAtual(){
		return custoHora * horasExecutadas;
	}
	
	public String getNome(){
		return nomeProjeto;
	}
	
	public float getCustoHora(){
		return custoHora;
	}
	
	public int getHoras(){
		return horasExecutadas;
	}

	public void registrarHoras(int horas){
		horasExecutadas += horas;
	}

	public void setCustoHora(float custoHora) /*throws ValorNegativoException*/{
		if(custoHora >= 0){
			this.custoHora = custoHora;
		}else{
				throw new ValorNegativoException("valor negativo");
		}
	}
}
