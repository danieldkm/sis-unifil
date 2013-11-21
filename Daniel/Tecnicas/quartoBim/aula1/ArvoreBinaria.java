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
				 * se o node pela esquerda.esquerda dele for diferente de nullo
				 * e o node pela esquerda.direita dele for diferente de nullo
				 * ent„o: criar dois nodes esquerda e direita, recebendo seus
				 * nodes correspondentes e o node pela esquerda recebe valor
				 * nullo chama o metodo inserir2 para realocar os nodes esquerda
				 * e direita novamente
				 */
				if (node.getEsquerda().getEsquerda() != null
						&& node.getEsquerda().getDireita() != null) {
					Node esquerda = node.getEsquerda().getEsquerda();
					Node direita = node.getEsquerda().getDireita();
					node.setEsquerda(null);
					inserir2(raiz, esquerda);
					inserir2(raiz, direita);
				} else if (node.getEsquerda().getEsquerda() != null) {
					/*
					 * se apenas o node pela esquerda.esquerda for nullo ent„o
					 * fazer os mesmos passos do anteriror porem apenas para o
					 * node da esquerda.esquerda!
					 */
					Node esquerda = node.getEsquerda().getEsquerda();
					node.setEsquerda(null);
					inserir2(raiz, esquerda);
				} else if (node.getEsquerda().getDireita() != null) {
					/*
					 * se apenas o node pela esquerda.direita for nullo ent„o
					 * fazer os mesmos passos do primeiro if porem apenas para o
					 * node da esquerda.direita!
					 */
					Node direita = node.getEsquerda().getDireita();
					node.setEsquerda(null);
					inserir2(raiz, direita);
				} else { // caso for nullo para os ambos os lados, simplesmente
							// setar nullo
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
					Node esquerda = node.getDireita().getEsquerda();
					Node direita = node.getDireita().getDireita();
					node.setDireita(null);
					inserir2(raiz, esquerda);
					inserir2(raiz, direita);
				} else if (node.getDireita().getEsquerda() != null) {
					Node esquerda = node.getDireita().getEsquerda();
					node.setDireita(null);
					inserir2(raiz, esquerda);
				} else if (node.getDireita().getDireita() != null) {
					Node direita = node.getDireita().getDireita();
					node.setDireita(null);
					inserir2(raiz, direita);
				} else {
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

	private void inserir2(Node node, Node valor) {
		if (valor.getData() < node.getData()) {
			if (node.getEsquerda() != null) {
				inserir2(node.getEsquerda(), valor);
				System.out.println("node esquerda tem valor "
						+ node.getEsquerda().getData());
			} else {
				System.out.println("  Inserindo node " + valor.getData()
						+ " a esquerda de " + node.getData());
				node.setEsquerda(valor);
			}
		} else if (valor.getData() > node.getData()) {
			if (node.getDireita() != null) {
				inserir2(node.getDireita(), valor);
				System.out.println("node direita tem valor "
						+ node.getDireita().getData());
			} else {
				System.out.println("  Inserindo node " + valor.getData()
						+ " a direita de " + node.getData());
				node.setDireita(valor);
			}
		} else {
			System.out.println(valor + " j· existe na arvore");
		}
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

	public boolean isPerfeitamenteBalanceada() {
		Node aux = raiz;
		percorreRaiz(aux);
		return perfeitamenteBalanceada;
	}

	public boolean isBalanceada() {
		setPercorrer(raiz.getEsquerda());
		setPercorrer(raiz.getDireita());
		return balanceada;
	}

	int esquerda = 0;
	int direita = 0;
	int pEsquerda = 0;
	int pDireita = 0;

	private void setPercorrer(Node no) {
		if (no != null) {
			System.out.println(no.getData() + " valor do no");
			if (no.getEsquerda() != null) {
				esquerda = height(no.getEsquerda());
				setPercorrer(no.getEsquerda());
			}
			if (no.getDireita() != null) {
				direita = height(no.getDireita());
				setPercorrer(no.getDireita());
			}
			System.out.println("Es " + esquerda + " dir" + direita + " soma " + (esquerda - direita));
			if ((esquerda - direita) > 1 || (esquerda - direita) < -1) {
				if (balanceada) {
					balanceada = false;
				}
			}
		}
	}

	private int height(Node n) {
		int u, v;
		if (n == null)
			return -1;
		u = height(n.getEsquerda());
		v = height(n.getDireita());
		if (u > v)
			return u + 1;
		else
			return v + 1;
	}

	public void percorreRaiz(Node no) {
		// System.out.println("valor do " + no.getData());
		if (no != null) {
			if (no.getEsquerda() != null) {
				verificaRaiz(no.getEsquerda());
				percorreRaiz(no.getEsquerda());
				pEsquerda++;
			}
			if (no.getDireita() != null) {
				verificaRaiz(no.getDireita());
				percorreRaiz(no.getDireita());
				pDireita++;
			}
		}

		if ((pEsquerda - pDireita) > 1 || (pEsquerda - pDireita) < -1) {
			perfeitamenteBalanceada = false;
		}
	}

	boolean balanceada = true;
	boolean perfeitamenteBalanceada = true;

	private void verificaRaiz(Node no) {
		Node a = no;
		esquerda = 0;
		direita = 0;
		while (a != null) {
			if (a.getEsquerda() != null) {
				esquerda++;
				a = a.getEsquerda();
			} else {
				if (a.getDireita() != null) {
					a = a.getDireita();
				} else {
					a = a.getEsquerda();
				}
			}
		}

		a = no;
		while (a != null) {
			if (a.getDireita() != null) {
				direita++;
				a = a.getDireita();
			} else {
				if (a.getEsquerda() != null) {
					a = a.getEsquerda();
				} else {
					a = a.getDireita();
				}
			}
		}

		if ((esquerda - direita) > 1 || (esquerda - direita) < -1) {
			balanceada = false;
		}

	}

	public void listarNodesDaArvore() {
		System.out.println("NÛ  |  Grau  |  NÌvel ");
		if (raiz.getDireita() != null) {
			grau++;
		}
		if (raiz.getEsquerda() != null) {
			grau++;
		}
		System.out.println(raiz.getData() + "  |  " + grau + "     |   "
				+ nivel);
		grau = 0;

		percorreNodesDaAvore(raiz);
	}

	int grau = 0;
	int nivel = 0;

	private void getNivelDaArvore(Node no, int valor) {
		if (no.getData() != valor) {
			if (valor < no.getData()) {
				nivel++;
				getNivelDaArvore(no.getEsquerda(), valor);
			} else if (valor > no.getData()) {
				nivel++;
				getNivelDaArvore(no.getDireita(), valor);
			}
		}
	}

	private void percorreNodesDaAvore(Node no) {
		if (no != null) {
			if (no.getEsquerda() != null) {
				if (no.getEsquerda().getEsquerda() != null) {
					grau++;
				}
				if (no.getEsquerda().getDireita() != null) {
					grau++;
				}
				getNivelDaArvore(raiz, no.getEsquerda().getData());
				System.out.println(no.getEsquerda().getData() + "  |  " + grau
						+ "     |   " + nivel);
				nivel = 0;
				grau = 0;
				percorreNodesDaAvore(no.getEsquerda());
			}

			if (no.getDireita() != null) {
				if (no.getDireita().getDireita() != null) {
					grau++;
				}
				if (no.getDireita().getEsquerda() != null) {
					grau++;
				}
				getNivelDaArvore(raiz, no.getDireita().getData());
				System.out.println(no.getDireita().getData() + "  |  " + grau
						+ "     |   " + nivel);
				nivel = 0;
				grau = 0;
				percorreNodesDaAvore(no.getDireita());
			}
		}
	}

}

