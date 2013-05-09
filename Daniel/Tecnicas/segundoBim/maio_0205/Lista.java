package maio_0205;

public class Lista {

	private Node inicio;
	private Node fim;

	// lista encadeada
//	public void inserir(Node node) {
//		if (isEmpty()) {
//			this.inicio = node;
//		} else {
//			Node auxiliar = this.inicio;
//			while (auxiliar.getProximo() != null) {
//				auxiliar = auxiliar.getProximo();
//			}
//			auxiliar.setProximo(node);
//		}
//	}
	
	//Lista duplamente encadeada 
	public void inserirNoFinal(Node node) {
		if (isEmpty()) {
			this.inicio = node;
			this.fim = node;
		} else {
			Node auxiliar = this.inicio;
			while (auxiliar.getProximo() != null) {
				auxiliar = auxiliar.getProximo();
			}
			auxiliar.setProximo(node);
			auxiliar.getProximo().setAnterior(auxiliar);
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
				if(node.equals(auxiliar.getProximo())){
					auxiliar.setProximo(auxiliar.getProximo().getProximo());
				}else{
					auxiliar.setAnterior(auxiliar);
				}				
				auxiliar = auxiliar.getProximo();
				if(auxiliar == null){
					break;
				}
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
			while (auxiliar != null) {
				auxString += auxiliar;
				auxiliar = auxiliar.getProximo();
			}
			auxString += "]";
			return auxString;
		}
	}

	public Node getElementoNaPosicao(int posicao) {
		return null;
	}

	public boolean contem(Node node) {
		return false;
	}
}
