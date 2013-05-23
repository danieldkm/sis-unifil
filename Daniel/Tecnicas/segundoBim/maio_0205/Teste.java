package maio_0205;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		System.out.println("LISTA NORMAL");
		Lista lista = new Lista();
		
		//--Listar e verificar se está vazio
		System.out.println(lista);
		System.out.println("Inserir");
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(1));
		lista.inserir(new Node(10));
		//--Listar e verificar se está vazio
		System.out.println(lista);
		String pergunta = "";
		while(!pergunta.equals("S") && !pergunta.equals("N")){
			System.out.println(pergunta);
			pergunta = JOptionPane.showInputDialog("Deseja remover da lista dois ou mais elementos repetidos?S/N\nApenas uma vez");	
		}
		if(pergunta.equals("S")){
			System.out.println("\nRemover");
			lista.removerTodos(new Node(1));
		}else if(pergunta.equals("N")){
			System.out.println("\nRemover");
			lista.remover(new Node(1));
//			lista.remover(new Node(2));
//			lista.remover(new Node(3));
//			lista.remover(new Node(4));
//			lista.remover(new Node(5));
//			lista.remover(new Node(6));
//		lista.remover(new Node(7));
//		lista.remover(new Node(8));
//		lista.remover(new Node(9));
//		lista.remover(new Node(10));
//		lista.remover(new Node(10));
			
			
		}
		//--Listar e verificar se está vazio
		System.out.println(lista);
		
		lista.removerTodos();
		
		System.out.println(lista);
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
		System.out.println(lista.getElementoNaPosicao(0));
		System.out.println(lista.getElementoNaPosicao(1));
		System.out.println(lista.getElementoNaPosicao(2));
		System.out.println(lista.getElementoNaPosicao(3));
		System.out.println(lista.getElementoNaPosicao(4));
		System.out.println(lista.getElementoNaPosicao(10));
		System.out.println("Contém o elemento? " + lista.contem(new Node(8)));
		
		
		System.out.println("\n\nLISTA DUPLAMENTE ENCADEADA");
		ListaDuplamenteEncadeada listaDupla = new ListaDuplamenteEncadeada();
			
		
		//--Listar e verificar se está vazio
		System.out.println(listaDupla);
		System.out.println("Inserir");
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(1));
		listaDupla.inserir(new Node(10));
		//--Listar e verificar se está vazio
		System.out.println(listaDupla);
		pergunta = "";
		while(!pergunta.equals("S") && !pergunta.equals("N")){
			System.out.println(pergunta);
			pergunta = JOptionPane.showInputDialog("Deseja remover da lista dois ou mais elementos repetidos?S/N\nApenas uma vez");	
		}
		if(pergunta.equals("S")){
			System.out.println("\nRemover");
			listaDupla.removerTodos(new Node(1));
		}else if(pergunta.equals("N")){
			System.out.println("\nRemover");
			listaDupla.remover(new Node(1));
//			lista.remover(new Node(2));
//			lista.remover(new Node(3));
//			lista.remover(new Node(4));
//			lista.remover(new Node(5));
//			lista.remover(new Node(6));
//		lista.remover(new Node(7));
//		lista.remover(new Node(8));
//		lista.remover(new Node(9));
//		lista.remover(new Node(10));
//		lista.remover(new Node(10));
		}
		//--Listar e verificar se está vazio
		System.out.println(listaDupla);
		
		listaDupla.removerTodos();
		for(int i = 0; i < 10; i++){
			listaDupla.inserir(new Node(i+1));
		}
		System.out.println("Nova lista\n"+listaDupla);
		System.out.println(listaDupla.getElementoNaPosicao(10));
		System.out.println(listaDupla.contem(new Node(0)));
		

		
		
		
		System.out.println("\n\nLISTA CIRCULAR");
		ListaCircular lc = new ListaCircular();
		System.out.println(lc);
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(1));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(1));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(1));
		
		System.out.println("Ciruclar " + lc);
		
		pergunta = "";
		while(!pergunta.equals("S") && !pergunta.equals("N")){
			System.out.println(pergunta);
			pergunta = JOptionPane.showInputDialog("Deseja remover da lista dois ou mais elementos repetidos?S/N\nApenas uma vez");	
		}
		if(pergunta.equals("S")){
			System.out.println("\nRemover");
			lc.removerTodos(new Node(1));
		}else if(pergunta.equals("N")){
			System.out.println("\nRemover");
			lc.remover(new Node(1));
		}
		System.out.println("Ciruclar " + lc);
		
		
	}

}
