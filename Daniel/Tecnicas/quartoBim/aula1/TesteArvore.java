package aula1;


public class TesteArvore {

	public static void main(String[] args) {
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		
		arvoreBinaria.inserirNaArvore(10);

		arvoreBinaria.imprimir();
		
		arvoreBinaria.inserirNaArvore(5);
		arvoreBinaria.inserirNaArvore(7);
		arvoreBinaria.inserirNaArvore(4);
		arvoreBinaria.inserirNaArvore(3);
		arvoreBinaria.inserirNaArvore(6);
		arvoreBinaria.inserirNaArvore(8);
		arvoreBinaria.inserirNaArvore(13);
		arvoreBinaria.inserirNaArvore(15);
		arvoreBinaria.inserirNaArvore(11);
		
//		arvoreBinaria.inserirNaArvore(9);
//		arvoreBinaria.inserirNaArvore(7);
//		arvoreBinaria.inserirNaArvore(6);
//		arvoreBinaria.inserirNaArvore(8);
//		arvoreBinaria.inserirNaArvore(11);
//		arvoreBinaria.inserirNaArvore(16);
//		arvoreBinaria.inserirNaArvore(14);
//		arvoreBinaria.inserirNaArvore(20);
//		arvoreBinaria.inserirNaArvore(17);
//		arvoreBinaria.inserirNaArvore(13);
//		arvoreBinaria.inserirNaArvore(1);
//		arvoreBinaria.inserirNaArvore(4);
//		arvoreBinaria.inserirNaArvore(12);
//		arvoreBinaria.inserirNaArvore(5);
//		arvoreBinaria.inserirNaArvore(2);
//		arvoreBinaria.inserirNaArvore(15);
//		arvoreBinaria.inserirNaArvore(3);
//		arvoreBinaria.inserirNaArvore(18);
//		arvoreBinaria.inserirNaArvore(19);
//		arvoreBinaria.inserirNaArvore(21);
		arvoreBinaria.imprimir();
		
		System.out.println("\n\n\nRemover");
		arvoreBinaria.removerNaArvore(7);
		arvoreBinaria.imprimir();
		
		System.out.println("\n\nIs Balanced? " + arvoreBinaria.isBalanceada()+"\n");
		System.out.println("Is perfectly balanced? " + arvoreBinaria.isBalanceada()+"\n");
		arvoreBinaria.listarNodesDaArvore();
		
	}

}
