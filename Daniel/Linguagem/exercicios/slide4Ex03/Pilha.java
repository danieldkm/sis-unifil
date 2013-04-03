package slide4Ex03;

import java.util.Vector;

public class Pilha {
	private int tamanho = 5;
	private Vector<Double> vetor;
	private double topo;

	Pilha(int tamanho) {
		this.tamanho = tamanho;
		vetor = new Vector<Double>(tamanho);
		vetor.trimToSize();
	}

	public Vector<Double> getVetor() {
		return vetor;
	}

	public void empilha(Double elemento) {
		vetor.addElement(elemento);

	}

	public void desenpilha(Double elemento) {
		vetor.removeElement(elemento);

	}

	public double topo() {
		// System.err.println(vetor.get(4));
		// if (vetor.isEmpty()) {
		// return 0.0;
		// } else {
		// for (int i = (tamanho - 1); i >= 0; i--) {
		// System.err.println(i);
		// if (vetor.get(i).equals("")/*vetor.get(i) != 0.0 || vetor.get(i) !=
		// null || !vetor.get(i).equals("")*/ ) {
		// System.out.println("nulo");
		// }else{
		// System.out.println("aaaa  "+i);
		// return vetor.get(i);
		// }
		// }
		// return 0.0;
		// }
		if (vetor.isEmpty()) {
			return 0.0;
		} else {
			return vetor.lastElement();
		}
	}

	public boolean estaCheia() {
		// if (vetor.isEmpty()) {
		// return false;
		// } else {
		// int n=0;
		// for (int i = 0; i < tamanho; i++) {
		// if (vetor.get(i) == 0.0) {
		// n = 0;
		// break;
		// } else {
		// n = 1;
		// }
		// }
		// if(n == 1){
		// return true;
		// }
		// return false;
		// }
		if (vetor.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean estaVazia() {
		// return vetor.isEmpty();
		/*
		 * int aux = 0; for (int i = 0; i < tamanho; i++) { if(vetor.get(i) ==
		 * 0){ aux = aux + 1; } } if(aux == tamanho){ return true; }else{ return
		 * false; }
		 */
		if (vetor.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void imprimir() {
		for (int i = 0; i < vetor.size(); i++) {
			System.out.println(vetor.get(i));
		}
	}

}
