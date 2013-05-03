package maio_0205;

public class Node {

	private int valor;
	private Node proximo;
	private Node anterior;

	public Node(int valor) {
		this.valor = valor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			Node nodeAuxiliar = (Node) obj;
			if (nodeAuxiliar.getValor() == this.valor) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	};

	@Override
	public String toString() {
		return "(#" + this.valor + ")";
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
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
