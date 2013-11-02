package aula1;


public class TesteArvore {

	public static void main(String[] args) {
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		
		arvoreBinaria.inserirNaArvore(10);

		arvoreBinaria.imprimir();
		
		arvoreBinaria.inserirNaArvore(5);
		arvoreBinaria.inserirNaArvore(7);
		arvoreBinaria.inserirNaArvore(6);	
		arvoreBinaria.inserirNaArvore(16);
		arvoreBinaria.inserirNaArvore(12);
		arvoreBinaria.imprimir();
		
		arvoreBinaria.removerNaArvore(10);
		arvoreBinaria.imprimir();
		
		
	}

}
