package bim2.trab1.arvoreBin;


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
		System.out.print("Parenteses aninhados: ");
		 arvoreBinaria.imprimir();
		
//		System.out.println("\n\n\nRemover");
//		arvoreBinaria.removerNaArvore(7);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(13);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(21);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(8);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(9);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(4);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(15);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(19);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(6);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(11);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(5);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(14);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(3);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(16);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(1);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(18);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(2);
//		System.out.println();
//		arvoreBinaria.removerNaArvore(20);
//		System.out.println();
		arvoreBinaria.imprimir();
		
		System.out.println("\n\nIs Balanced? " + arvoreBinaria.isBalanceada()+"\n");
//		System.out.println("Is perfectly balanced? " + arvoreBinaria.isBalanceada()+"\n");
		arvoreBinaria.listarNodesDaArvore();
		
	}

}
