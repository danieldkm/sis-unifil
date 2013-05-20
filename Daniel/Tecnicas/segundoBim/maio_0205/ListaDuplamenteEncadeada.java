package maio_0205;

public class ListaDuplamenteEncadeada {
	private Node inicio;
	private Node fim;

	// Lista duplamente encadeada
	public void inserir(Node node) {
		if (isEmpty()) {
			this.inicio = node;
			this.fim = node;
		} else {
			fim.setProximo(node);
			// agora com a váriavel "fim" é possivel sempre adicionar no final
			// da lista...
			// Node auxiliar = this.inicio;
			// while (auxiliar.getProximo() != null) {
			// auxiliar = auxiliar.getProximo();
			// }
			// auxiliar.setProximo(node);
			// auxiliar.getProximo().setAnterior(auxiliar);
			this.fim = node;

		}
	}

	public void remover(Node node) {
		Node auxiliar = this.inicio;
		if (inicio.equals(node)) {
			this.inicio = auxiliar.getProximo();
		} else {
			auxiliar = inicio;
			while (auxiliar.getProximo() != null) {
				if (node.equals(auxiliar.getProximo())) {
					auxiliar.setProximo(auxiliar.getProximo().getProximo());
					break;
				}
				auxiliar = auxiliar.getProximo();
			}
		}
	}

	public void removerTodos(Node node) {
		Node auxiliar = this.inicio;
		if (inicio.equals(node)) {
			this.inicio = auxiliar.getProximo();
			while (auxiliar.getProximo() != null) {
				if (node.equals(auxiliar.getProximo())) {
					while (node.equals(auxiliar.getProximo())) {
						auxiliar.setProximo(auxiliar.getProximo().getProximo());
					}
					if (auxiliar.equals(node)) {
						inicio = auxiliar.getProximo();
					}
					// }else{
					// auxiliar.setAnterior(auxiliar);
				}
				auxiliar = auxiliar.getProximo();
				if (auxiliar == null) {
					break;
				}
			}
		} else {
			auxiliar = inicio;
			while (auxiliar.getProximo() != null) {
				if (node.equals(auxiliar.getProximo())) {
					while (node.equals(auxiliar.getProximo())) {
						auxiliar.setProximo(auxiliar.getProximo().getProximo());
					}
					if (auxiliar.equals(node)) {
						inicio = auxiliar.getProximo();
					}
					// }else{
					// auxiliar.setAnterior(auxiliar);
				}
				auxiliar = auxiliar.getProximo();
				if (auxiliar == null) {
					break;
				}
			}
		}
	}
	
	public void removerTodos() {
		inicio = null;
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

	public Node getElementoNaPosicao(int posicao) {
		if(posicao == 0){
			return inicio;
		}else{
			Node auxiliar = inicio;
			int n = 1;
			while(auxiliar.getProximo() != null){
				if(n == posicao){
					return auxiliar.getProximo();
				}
				auxiliar = auxiliar.getProximo();
			}
		}
		return null;
	}

	public boolean contem(Node node) {
		if(inicio.equals(node)){
			return true;
		}else{
			Node auxiliar = inicio;
			while(auxiliar.getProximo() != null){
				if(auxiliar.getProximo().equals(node)){
					return true;
				}
				auxiliar = auxiliar.getProximo();
			}
		}
		return false;
	}
}
