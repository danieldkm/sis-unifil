package Trabalho.trabalho;

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
			lista.removerRepetidos(new Node(1));
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
	}

}
