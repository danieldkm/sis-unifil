package maio_0205;

public class Lista {

	private Node inicio;

	public void inserir(Node node) {
		if (isEmpty()) {
			this.inicio = node;
		} else {
			Node auxiliar = this.inicio;
			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}
			auxiliar.setProximo(node);
		}
	}

	public void remover() {

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
			while (auxiliar != null) {
				auxString += auxiliar;
				auxiliar = auxiliar.getProximo();
			}
			auxString += "]";
			return auxString;
		}
	}

	public Node getElementoNaposicao(int posicao) {
		return null;
	}

	public boolean contem(Node node) {
		return false;
	}
}
