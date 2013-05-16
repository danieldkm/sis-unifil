package maio_0205;

public class Teste {
	public static void main(String[] args) {
//		Lista lista = new Lista();
//		
//		//--Listar e verificar se está vazio
//		System.out.println(lista);
//		System.out.println("Inserir");
//		lista.inserirNoFinal(new Node(1));
//		lista.inserirNoFinal(new Node(2));
//		lista.inserirNoFinal(new Node(3));
//		lista.inserirNoFinal(new Node(4));
//		lista.inserirNoFinal(new Node(5));
//		lista.inserirNoFinal(new Node(6));
//		lista.inserirNoFinal(new Node(7));
//		lista.inserirNoFinal(new Node(8));
//		lista.inserirNoFinal(new Node(9));
//		lista.inserirNoFinal(new Node(10));
//		//--Listar e verificar se está vazio
//		System.out.println(lista);
//		System.out.println("\nRemover");
//		lista.remover(new Node(1));
////		lista.remover(new Node(2));
////		lista.remover(new Node(3));
////		lista.remover(new Node(4));
////		lista.remover(new Node(5));
////		lista.remover(new Node(6));
////		lista.remover(new Node(7));
////		lista.remover(new Node(8));
////		lista.remover(new Node(9));
////		lista.remover(new Node(10));
////		lista.remover(new Node(10));
//		
//		//--Listar e verificar se está vazio
//		System.out.println(lista);
		
		
		
		ListaCircular lc = new ListaCircular();
		
		lc.adicionar(new Node(1));
		lc.adicionar(new Node(2));
		lc.adicionar(new Node(3));
		lc.adicionar(new Node(4));
		lc.adicionar(new Node(5));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(7));
		
		System.out.println("Ciruclar " + lc);
		lc.remover(new Node(2));
		System.out.println("Ciruclar " + lc);
		
		
	}

}
