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
		// Verifica se o valor a ser inserido √© menor que o nodo corrente da
		// √°rovre, se sim vai para subarvore esquerda
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
			// Verifica se o valor a ser inserido √© maior que o nodo corrente
			// da √°rvore, se sim vai para subarvore direita
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
			System.out.println(valor + " j√° existe na arvore");
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

	private void imprimir2(Node node) {
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
			raiz = new Node(valor);
		} else {
			remover(raiz, valor);
		}
	}

	private void remover(Node node, int valor) {
		if (valor < node.getData()) {
			if (node.getEsquerda().getData() == valor) {
				/*
				 * se o valor da esquerda e esquerda da raiz e esquerda e
				 * direita da raiz for diferente de nulo ent„o pegar esquerda e
				 * esquerda da raiz e setar a direita com o valor da esquerda e
				 * direita da raiz logo em seguida setar a esquerda da raiz,
				 * pegando o valor da esquerda e esquerda da raiz
				 */
				if (node.getEsquerda().getEsquerda() != null
						&& node.getEsquerda().getDireita() != null) {
					System.out.println("A esquerda da raiz, Inserindo o valor "
							+ node.getEsquerda().getEsquerda().getData()
							+ " no lugar do " + valor);
					node.getEsquerda().getEsquerda()
							.setDireita(node.getEsquerda().getDireita());
					node.setEsquerda(node.getEsquerda().getEsquerda());
				} else if (node.getEsquerda().getEsquerda() != null) {
					System.out.println("A esquerda da raiz, Inserindo o valor "
							+ node.getEsquerda().getEsquerda().getData()
							+ " no lugar do " + valor);
					node.setEsquerda(node.getEsquerda().getEsquerda());
				} else if (node.getEsquerda().getDireita() != null) {
					System.out.println("A direita da raiz, Inserindo o valor "
							+ node.getEsquerda().getDireita().getData()
							+ " no lugar do " + valor);
					node.setEsquerda(node.getEsquerda().getDireita());
				} else {
					System.out.println("A esquerda e direita da raiz È nulo");
					node.setEsquerda(null);
				}
			} else {
				System.out.println("A esquerda da raiz, Valor "
						+ node.getEsquerda().getData() + " È diferente de "
						+ valor);
				remover(node.getEsquerda(), valor);
			}
		} else if (valor > node.getData()) {
			if (node.getDireita().getData() == valor) {
				if (node.getDireita().getEsquerda() != null
						&& node.getDireita().getDireita() != null) {
					System.out.println("A direita da raiz, Inserindo o valor "
							+ node.getDireita().getEsquerda().getData()
							+ " no lugar do " + valor);
					node.getDireita().getEsquerda()
							.setDireita(node.getDireita().getDireita());
					node.setDireita(node.getDireita().getEsquerda());
				} else if (node.getDireita().getEsquerda() != null) {
					System.out.println("A esquerda da raiz, Inserindo o valor "
							+ node.getDireita().getEsquerda().getData()
							+ " no lugar do " + valor);
					node.setDireita(node.getDireita().getEsquerda());
				} else if (node.getDireita().getDireita() != null) {
					System.out.println("A direita da raiz, Inserindo o valor "
							+ node.getDireita().getDireita().getData()
							+ " no lugar do " + valor);
					node.setDireita(node.getDireita().getDireita());
				} else {
					System.out.println("A esquerda e direita da raiz È nulo");
					node.setDireita(null);
				}
			} else {
				System.out.println("A direita da raiz, Valor "
						+ node.getDireita().getData() + " È diferente de "
						+ valor);
				remover(node.getDireita(), valor);
			}
		}
	}

	private int he = 0;
	private int hd = 0;

	private void per(Node no) {
		if (no.getEsquerda() != null) {
			he ++;
			per(no.getEsquerda());
		} else if (no.getDireita() != null) {
			hd ++;
			per(no.getDireita());
		}
	}

	public boolean isPerfeitamenteBalanceada() {
		Node esquerda = raiz.getEsquerda();
//		emordem(esquerda);
//		System.out.println("\n\n\n");
//		Node direita = raiz.getDireita();
//		emordem(direita);
//		System.out.println("\n\n\n");
		per(esquerda);
		System.out.println("he " + he);
		System.out.println("hd " + hd);
		return true;
	}

	public void prefixado(Node no) {
		if (no != null) {
			System.out.print(no.getData() + " ");
			prefixado(no.getEsquerda());
			prefixado(no.getDireita());
		}
	}

	public void posfixado(Node no) {
		if (no != null) {
			posfixado(no.getEsquerda());
			posfixado(no.getDireita());
			System.out.print(no.getData() + " ");
		}
	}


	public void emordem(Node no) {
		if (no != null) {
			emordem(no.getEsquerda());
			System.out.print(no.getData() + " ");
			emordem(no.getDireita());
		}
	}

	public boolean isBalanceada() {
		return true;
	}

	public void listarNodesDaArvore() {
		System.out.println("N√≥  |  Grau  |  N√≠vel ");
		System.out.println("A  |  2  |  0");
	}

}
