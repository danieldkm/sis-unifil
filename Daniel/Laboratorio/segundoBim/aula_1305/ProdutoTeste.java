package aula_1305;

public class ProdutoTeste {
	public static void main(String[] args) {
		Produto produto1 = new Produto("Mouse");
		Produto produto2 = new Produto("Teclado");
		
//		Produto.cotacaoDolar = 2.04f;
//		Produto.setCotacaoDolar(2.04F);
		produto2.setCotacaoDolar(2.10F);
		
		
		produto1.setPrecoUnitario(4);
		produto2.setPrecoUnitario(10);
		
		System.out.println(produto1.getValorReal());
		System.out.println(produto2.getValorReal());
		
	}
}
