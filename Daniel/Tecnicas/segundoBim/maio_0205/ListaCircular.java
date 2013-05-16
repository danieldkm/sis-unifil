package maio_0205;

public class ListaCircular {

	private Node inicio;

	public void adicionar(Node node) {
		if (isEmpty()) {
			this.inicio = node;
			node.setProximo(inicio);
		} else {
			Node auxiliar = this.inicio;
			while (auxiliar.getProximo() != this.inicio) {
				auxiliar = auxiliar.getProximo();
			}
			node.setProximo(inicio);
			auxiliar.setProximo(node);
		}
	}

	public void remover(Node node) {
		Node auxiliar = this.inicio;
		if (inicio.equals(node)) {
			this.inicio = auxiliar.getProximo();
		} else {
			auxiliar = this.inicio;
			while (auxiliar.getProximo() != this.inicio) {
				if (auxiliar.getProximo().equals(node)) {
					auxiliar.setProximo(auxiliar.getProximo().getProximo());
				}
				auxiliar = auxiliar.getProximo();
			}
		}
	}

	public boolean isEmpty() {
		if (inicio == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "Lista Vazia";
		} else {
			String auxString = "[";
			Node auxiliar = this.inicio;
			auxString += auxiliar;
			while (auxiliar.getProximo() != this.inicio) {
				auxiliar = auxiliar.getProximo();
				auxString += auxiliar;
			}

			auxString += "]";
			return auxString;
		}
	}

}
