package Trabalho.trabalho;

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
			this.inicio.setProximo(auxiliar.getProximo().getProximo());
		} else {
			auxiliar = this.inicio;
			while (auxiliar.getProximo() != this.inicio) {
				if (node.equals(auxiliar.getProximo())) {
					auxiliar.setProximo(auxiliar.getProximo().getProximo());
					break;
				}
				auxiliar = auxiliar.getProximo();
			}
			node.setProximo(inicio);
		}
	}
	
	public void removerRepetidos(Node node) {
		Node auxiliar = this.inicio;
		if (inicio.equals(node)) {
			this.inicio = auxiliar.getProximo();
			auxiliar = auxiliar.getProximo();
			while (auxiliar.getProximo() != this.inicio) {
				if (auxiliar.getProximo().equals(node)) {
					while(node.equals(auxiliar.getProximo())){
						auxiliar.setProximo(auxiliar.getProximo().getProximo());
					}
					if(auxiliar.equals(node)){
						inicio = auxiliar.getProximo();
					}
				}
				auxiliar = auxiliar.getProximo();
			}
			node.setProximo(inicio);
		} else {
			auxiliar = this.inicio;
			while (auxiliar.getProximo() != this.inicio) {
				if (node.equals(auxiliar.getProximo())) {
					while(node.equals(auxiliar.getProximo())){
						auxiliar.setProximo(auxiliar.getProximo().getProximo());
					}
					if(auxiliar.equals(node)){
						inicio = auxiliar.getProximo();
					}
				}
				auxiliar = auxiliar.getProximo();
			}
			node.setProximo(inicio);
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
	
	public Object getObject(int posicao) {
		if (isEmpty()) {
			return null;
		} else if (posicao == 0) {
			return this.inicio;
		} else {
			Node auxiliar = this.inicio;
			int n = 1;
			while (auxiliar.getProximo() != this.inicio) {
				auxiliar = auxiliar.getProximo();
				if (posicao == n) {
//					n--;
//					break;
					return auxiliar;
				}
				n++;
			}
			auxiliar.setProximo(this.inicio);
			if (n >= posicao) {
				System.out.println("N�o existe essa posi��o, ser� mostrado a ultima posi��o");
			}
			return null;
		}
	}
	
	public boolean contem(Node node) {
		if(inicio.equals(node)){
			return true;
		}else{
			Node auxiliar = inicio;
			while(auxiliar.getProximo() != this.inicio){
				if(auxiliar.getProximo().equals(node)){
					return true;
				}
				auxiliar = auxiliar.getProximo();
			}
			auxiliar.setProximo(inicio);
		}
		return false;
	}

}
