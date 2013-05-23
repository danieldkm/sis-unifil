package Trabalho.trabalho;

public class Node {

//	private int valor;
	private Object object;
	private Node proximo;
	private Node anterior;

	public Node(Object object) {
		this.object = object;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			Node nodeAuxiliar = (Node) obj;
			if (nodeAuxiliar.getObject() == this.object) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	};

	@Override
	public String toString() {
		return "(#" + this.object + ")";
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Node getProximo() {
		return proximo;
	}

	public void setProximo(Node proximo) {
		this.proximo = proximo;
	}

	public Node getAnterior() {
		return anterior;
	}

	public void setAnterior(Node anterior) {
		this.anterior = anterior;
	}

}
