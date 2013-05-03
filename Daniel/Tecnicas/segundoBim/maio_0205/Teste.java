package maio_0205;

public class Teste {
	public static void main(String[] args) {
		Lista lista = new Lista();
		System.out.println(lista);
		System.out.println("Inserir");
		lista.inserir(new Node(1));
		lista.inserir(new Node(2));
		lista.inserir(new Node(3));
		lista.inserir(new Node(4));
		lista.inserir(new Node(5));
		lista.inserir(new Node(6));
		lista.inserir(new Node(7));
		lista.inserir(new Node(8));
		lista.inserir(new Node(9));
		lista.inserir(new Node(10));
		System.out.println(lista);
		System.out.println("\nRemover");
		lista.remover(new Node(1));
//		lista.remover(new Node(2));
//		lista.remover(new Node(3));
//		lista.remover(new Node(4));
//		lista.remover(new Node(5));
//		lista.remover(new Node(6));
//		lista.remover(new Node(7));
//		lista.remover(new Node(8));
		lista.remover(new Node(9));
//		lista.remover(new Node(10));
		System.out.println(lista);
	}

}
