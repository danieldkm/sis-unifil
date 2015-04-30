package bim2.trab1.arvoreBin;

public class Node {
	private int data;
	private Node direita;
	private Node esquerda;
	
	public Node(int novo) {
		data = novo;
		direita = null;
		esquerda = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getDireita() {
		return direita;
	}

	public void setDireita(Node direita) {
		this.direita = direita;
	}

	public Node getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}
		
}
