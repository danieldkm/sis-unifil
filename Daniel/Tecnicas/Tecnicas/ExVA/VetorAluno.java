package ExVA;

public class VetorAluno {

	private int contAluno = 0;

	public Aluno inicio;

	public int getContAluno() {
		return contAluno;
	}

	public void setContAluno(int contAluno) {
		this.contAluno = contAluno;
	}

	// public void adiciona(String nome, int pontuacao) {
	// if (contAluno == 0) {
	// inicio = new Aluno(nome, pontuacao);
	// } else {
	// Aluno proximo = inicio;
	// while (proximo.proximo != null) {
	// proximo = proximo.proximo;
	// }
	// proximo.proximo = new Aluno(nome, pontuacao);
	// }
	// contAluno++;
	// }

	public void adiciona(Aluno aluno) {
		if (inicio == null) {
			inicio = aluno;
		} else {
			Aluno aux = inicio;
			while (aux.proximo != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(aluno);
		}
		contAluno++;
	}

	public void remove(Aluno aluno) {
		// System.out.println("inicio " + inicio);
		// System.out.println("aluno " + aluno);
		if (inicio.equals(aluno)) {
			// System.out.println("inicio");
			inicio = inicio.proximo;
		} else {
			Aluno aux = inicio;
			Aluno anterior = null;
			while (aux.proximo != null) {
				if (aux.proximo.equals(aluno)) {
					anterior = aux;
					aux.setProximo(aux.getProximo().getProximo());
					// aux = aux.getProximo().getProximo();
				} else {
					anterior = aux;
					aux = aux.getProximo();
				}
			}
		}
		contAluno--;
	}

	// public void adiciona(String nome, int pontuacao, int posicao) {
	// Aluno proximo = inicio;
	// if (posicao > 0) {
	// for (int i = 0; i < posicao; i++) {
	// proximo = proximo.proximo;
	// // if(proximo == null){
	// // proximo = new Aluno("vazio" , 0);
	// // }
	// }
	// proximo.setNome(nome);
	// proximo.setPontuacao(pontuacao);
	// } else {
	// proximo.setNome(nome);
	// proximo.setPontuacao(pontuacao);
	// }
	// }

	public Aluno pega(int posicao) {
		Aluno aux = inicio;
		if (posicao > 0) {
			for (int i = 0; i < posicao; i++) {
				if (aux != null) {
					aux = aux.getProximo();
				}
			}
		}
		return aux;
	}

	public String procurarAluno(Aluno aluno) {// existe?
		if (inicio.getNome().equals(aluno.getNome())) {
			return inicio.toString();
		} else {
			Aluno aux = inicio;
			while (aux.getProximo() != null) {
				if (aux.getProximo().getNome().equals(aluno.getNome())) {
					return aux.getProximo().toString();
				} else {
					aux = aux.getProximo();
				}
			}
		}
		return "Não existe";
	}

	// public void remove(int posicao) {
	// Aluno proximo = inicio;
	// if (posicao > 0) {
	// for (int i = 0; i < posicao; i++) {
	// proximo = proximo.proximo;
	// }
	// proximo.setNome("");
	// proximo.setPontuacao(0);
	// } else {
	// proximo.setNome("");
	// proximo.setPontuacao(0);
	// }
	// }

	public void lista(String nome) {
		Aluno proximo = inicio;
		while (proximo != null) {
			if (proximo.getNome().equals(nome)) {
				System.out.println("Está na lista " + proximo);
				break;
			}
			proximo = proximo.proximo;
		}
	}

	public int tamanho() {
		return contAluno;
	}

	@Override
	public String toString() {
		return inicio.getNome();
	}

	public boolean isEmpty() {
		if (contAluno == 0) {
			return true;
		} else {
			return false;
		}
	}
}
