package aula1;

public class ArvoreBinaria {
	Node raiz;

	public ArvoreBinaria() {
		raiz = null;
	}

	public void inserirNaArvore(int valor) {
		if (raiz == null) {
			raiz = new Node(valor);
		} else {
			inserir(raiz, valor);
		}
	}

	private void inserir(Node node, int valor) {
		// Verifica se o valor a ser inserido é menor que o nodo corrente da
		// árovre, se sim vai para subarvore esquerda
		if (valor < node.getData()) {
			// Se tiver elemento no nodo esquerdo continua a busca
			if (node.getEsquerda() != null) {
				inserir(node.getEsquerda(), valor);
				System.out.println("node esquerda tem valor "
						+ node.getEsquerda().getData());
			} else {
				// Se nodo esquerdo vazio insere o novo nodo aqui
				System.out.println("  Inserindo " + valor + " a esquerda de "
						+ node.getData());
				node.setEsquerda(new Node(valor));
			}
			// Verifica se o valor a ser inserido é maior que o nodo corrente
			// da árvore, se sim vai para subarvore direita
		} else if (valor > node.getData()) {
			// Se tiver elemento no nodo direito continua a busca
			if (node.getDireita() != null) {
				inserir(node.getDireita(), valor);
				System.out.println("node direita tem valor "
						+ node.getDireita().getData());
			} else {
				// Se nodo direito vazio insere o novo nodo aqui
				System.out.println("  Inserindo " + valor + " a direita de "
						+ node.getData());
				node.setDireita(new Node(valor));
			}
		} else {
			System.out.println(valor + " já existe na arvore");
		}
	}

	public void imprimir() {
		imprimir(raiz);
		System.out.println();
	}

	private void imprimir(Node node) {
		if (node != null) {
			System.out.print("(");
			imprimir(node.getEsquerda());
			System.out.print(node.getData());
			imprimir(node.getDireita());
			System.out.print(")");
		}
	}

	public void removerNaArvore(int valor) {
		if (raiz == null) {
			System.out.println("N�o tem nenhuma arvore para remover um valor" + raiz.getData());
		} else {
//			remover(raiz, valor);
			teste(raiz);
		}
	}
	
	private void teste(Node node){
		if(node != null){
			System.out.println("1");
			System.out.println("tanta remover E " + node.getEsquerda().getData());
			System.out.println("tanta remover E " + node.getDireita().getData());
		}
	}

	private void remover(Node node, int valor) {
	}

	public boolean isPerfeitamenteBalanceada() {
		return true;
	}

	public boolean isBalanceada() {
		return true;
	}

	public void listarNodesDaArvore() {
		System.out.println("Nó  |  Grau  |  Nível ");
		System.out.println("A  |  2  |  0");
	}

}
