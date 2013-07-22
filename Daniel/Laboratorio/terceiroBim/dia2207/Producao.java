package dia2207;

public class Producao extends Funcionario{
	private int quantidadeProduzida;

	public Producao(int qtdProduzida, String nome, double salario) {
		super(nome, salario);
		this.quantidadeProduzida = qtdProduzida;
	}

	public int getQuantidadeProduzida() {
		return quantidadeProduzida;
	}

	public void setQuantidadeProduzida(int quantidadeProduzida) {
		this.quantidadeProduzida = quantidadeProduzida;
	}
	
	public double getGanhoMensal(){
		return super.getSalario() * quantidadeProduzida;
	}
}
