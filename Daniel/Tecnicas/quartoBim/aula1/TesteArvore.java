package aula1;


public class TesteArvore {

	public static void main(String[] args) {
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		
		arvoreBinaria.inserirNaArvore(10);

		arvoreBinaria.imprimir();
		
		arvoreBinaria.inserirNaArvore(9);
		arvoreBinaria.inserirNaArvore(7);
		arvoreBinaria.inserirNaArvore(6);	
		arvoreBinaria.inserirNaArvore(8);
		arvoreBinaria.inserirNaArvore(11);
		arvoreBinaria.inserirNaArvore(16);
		arvoreBinaria.inserirNaArvore(14);
		arvoreBinaria.inserirNaArvore(20);
		arvoreBinaria.inserirNaArvore(17);
		arvoreBinaria.inserirNaArvore(13);
		arvoreBinaria.imprimir();
//		System.out.println("\n\n\n\nRemover");
//		arvoreBinaria.removerNaArvore(7);
//		arvoreBinaria.imprimir();
		
		arvoreBinaria.isPerfeitamenteBalanceada();
		
	}

}
