package Trabalho.trabalho;

public class ListaDuplamenteEncadeada {
	private Node inicio;
	private Node fim;

	// Lista duplamente encadeada
	public void inserir(Node node) {
		if (isEmpty()) {
			this.inicio = node;
			this.fim = node;
		} else {
//			fim.setProximo(node);
			// agora com a v�riavel "fim" � possivel sempre adicionar no final
			// da lista...
			 Node auxiliar = this.inicio;
			 while (auxiliar.getProximo() != null) {
				 auxiliar = auxiliar.getProximo();
			 }
			 auxiliar.setAnterior(auxiliar);
			 auxiliar.setProximo(node);
			 this.fim = node;
		}
	}

	public void remover(Node node) {
		Node auxiliar = this.inicio;
		if (inicio.equals(node)) {
			this.inicio = auxiliar.getProximo();
			this.fim = auxiliar;
		} else {
			auxiliar = inicio;
			while (auxiliar.getProximo() != null) {
				if (node.equals(auxiliar.getProximo())) {
					auxiliar.setAnterior(auxiliar);
					auxiliar.setProximo(auxiliar.getProximo().getProximo());
					break;
				}
				auxiliar.setAnterior(auxiliar);
				auxiliar = auxiliar.getProximo();
			}
		}
	}

	public void removerRepetidos(Node node) {
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
				}
				auxiliar.setAnterior(auxiliar);
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
				}
				auxiliar.setAnterior(auxiliar);
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
				auxiliar.setAnterior(auxiliar);
				auxiliar = auxiliar.getProximo();
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
			while (auxiliar.getProximo() != null) {
				auxiliar.setAnterior(auxiliar);
				auxiliar = auxiliar.getProximo();
				if (posicao == n) {
					n--;
					break;
				}
				n++;
			}
			if (n >= posicao) {
				System.out.println("N�o existe essa posi��o, ser� mostrado a ultima posi��o");
			}
			return auxiliar;
		}
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
				auxiliar.setAnterior(auxiliar);
				auxiliar = auxiliar.getProximo();
			}
		}
		return false;
	}
}
