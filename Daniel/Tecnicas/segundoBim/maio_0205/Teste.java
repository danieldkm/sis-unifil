package maio_0205;

public class Teste {
	public static void main(String[] args) {
		Lista lista = new Lista();
		System.out.println(lista);
		
		lista.inserir(new Node(3));
		lista.inserir(new Node(5));
		lista.inserir(new Node(7));
		System.out.println(lista);
	}

}
