package Trabalho.trabalho;

import javax.swing.JOptionPane;

public class Teste {
	public static void main(String[] args) {
		//---------------------------------LISTA DUPLAMENTE ENCADEADA----------------------------------------------------------//		
		System.out.println("LISTA ENCADEADA");
		Lista lista = new Lista();
		
		//--Listar e verificar se est� vazio
		System.out.println("Lista atual " + lista);
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
		//--Listar e verificar se est� vazio
		System.out.println("Lista atual " + lista);
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
		//--Listar e verificar se est� vazio
		System.out.println("Lista atual " + lista);
		
		lista.removerTodos();
		
		
		System.out.println("Lista atual " + lista);
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
		System.out.println("Lista atual " + lista);
		System.out.println("Posi��o " + lista.getObject(0));
		System.out.println("Posi��o " + lista.getObject(1));
		System.out.println("Posi��o " + lista.getObject(2));
		System.out.println("Posi��o " + lista.getObject(3));
		System.out.println("Posi��o " + lista.getObject(4));
		System.out.println("Posi��o " + lista.getObject(10));
		System.out.println("Cont�m o elemento? " + lista.contem(new Node(8)));
		//---------------------------------LISTA DUPLAMENTE----------------------------------------------------------//		
		
		
		
		
		//---------------------------------LISTA DUPLAMENTE ENCADEADA----------------------------------------------------------//
		System.out.println("\n\nLISTA DUPLAMENTE ENCADEADA");
		ListaDuplamenteEncadeada listaDupla = new ListaDuplamenteEncadeada();
			
		
		//--Listar e verificar se est� vazio
		System.out.println("Lista atual " + listaDupla);
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
		//--Listar e verificar se est� vazio
		System.out.println("Lista atual " + listaDupla);
		pergunta = "";
		while(!pergunta.equals("S") && !pergunta.equals("N")){
			System.out.println(pergunta);
			pergunta = JOptionPane.showInputDialog("Deseja remover da lista dois ou mais elementos repetidos?S/N\nApenas uma vez");	
		}
		if(pergunta.equals("S")){
			System.out.println("\nRemover");
			listaDupla.removerRepetidos(new Node(1));
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
		//--Listar e verificar se est� vazio
		System.out.println("Lista atual " + listaDupla);
		
		listaDupla.removerTodos();
		for(int i = 0; i < 10; i++){
			listaDupla.inserir(new Node(i+1));
		}
		System.out.println("Lista atual " + listaDupla);
		System.out.println("Posi��o " + listaDupla.getObject(0));
		System.out.println("Posi��o " + listaDupla.getObject(1));
		System.out.println("Posi��o " + listaDupla.getObject(2));
		System.out.println("Posi��o " + listaDupla.getObject(3));
		System.out.println("Posi��o " + listaDupla.getObject(10));
		System.out.println("Cont�m " + listaDupla.contem(new Node(11)));
		System.out.println("Cont�m " + listaDupla.contem(new Node(1)));
		System.out.println("Cont�m " + listaDupla.contem(new Node(2)));
		System.out.println("Cont�m " + listaDupla.contem(new Node(9)));
		//---------------------------------LISTA DUPLAMENTE ENCADEADA----------------------------------------------------------//		

		
		
		//---------------------------------LISTA CIRCULAR----------------------------------------------------------//
		System.out.println("\n\nLISTA CIRCULAR");
		ListaCircular lc = new ListaCircular();
		System.out.println("Lista atual " + lc);
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(1));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(1));
		lc.adicionar(new Node(6));
		lc.adicionar(new Node(1));
		
		System.out.println("Lista atual " + lc);
		
		pergunta = "";
		while(!pergunta.equals("S") && !pergunta.equals("N")){
			System.out.println(pergunta);
			pergunta = JOptionPane.showInputDialog("Deseja remover da lista dois ou mais elementos repetidos?S/N\nApenas uma vez");	
		}
		if(pergunta.equals("S")){
			System.out.println("\nRemover");
			lc.removerRepetidos(new Node(1));
		}else if(pergunta.equals("N")){
			System.out.println("\nRemover");
			lc.remover(new Node(1));
		}
		System.out.println("Lista atual " + lc);
		
		System.out.println("Posi�ao " + lc.getObject(0));
		System.out.println("Posi�ao " + lc.getObject(1));
		System.out.println("Posi�ao " + lc.getObject(2));
		System.out.println("Posi�ao " + lc.getObject(3));
		System.out.println("Lista atual " + lc);
		System.out.println("Cont�m " + lc.contem(new Node(6)));
		System.out.println("Cont�m " + lc.contem(new Node(1)));
		//---------------------------------LISTA CIRCULAR----------------------------------------------------------//		
		
	}

}
