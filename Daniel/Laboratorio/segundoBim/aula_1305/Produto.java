package aula_1305;

public class Produto {

	private String descricao;
	private int quantidade;
	private float precoUnitario;
	private static float cotacaoDolar;
	
	public Produto(String descricao) {
		this.descricao = descricao;
	}
	
	public float getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public float getValorReal(){
		return this.precoUnitario * this.cotacaoDolar;
	}
	
	public static float getCotacaoDolar() {
		return cotacaoDolar;
	}
	
	public static void setCotacaoDolar(float cotacaoDolar) {
		Produto.cotacaoDolar = cotacaoDolar;
	}
}
