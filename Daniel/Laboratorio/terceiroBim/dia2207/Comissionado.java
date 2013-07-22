package dia2207;

public class Comissionado extends Funcionario{
	private double comissao;
	private int quantidadeVenda;
	
	public Comissionado(double comissao, int qtdVenda, String nome, double salario) {
		super(nome, salario);
		this.comissao = comissao;
		this.quantidadeVenda = qtdVenda;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}

	public void setQuantidadeVenda(int quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}
	
	public double getGanhoMensal(){
		return comissao * quantidadeVenda + super.getSalario();
	}
	
	
}
