package tarefa2;

import java.util.Arrays;

public class ListaPessoa {

	private Pessoa[] listaPessoa = new Pessoa[40];

	public void adicionarPessoa(Pessoa pessoa) {
		for (int i = 0; i < listaPessoa.length; i++) {
			if (listaPessoa[i] == null) {
				listaPessoa[i] = pessoa;
				break;
			}
		}
	}

	public void adicionarPessoa(Pessoa pessoa, int posicao) {
		listaPessoa[posicao] = pessoa;
	}

	public Pessoa pega(int posicao) {
		return listaPessoa[posicao];
	}

	public void remove(int posicao) {
		listaPessoa[posicao] = null;
	}

	public int contem(Pessoa pessoa) {
		for (int i = 0; i < listaPessoa.length; i++) {
			if(listaPessoa[i] == pessoa){
				return 0;
			}
		}
		return -1;
	}

	public int tamanho() {
		return 40;
	}

	public Pessoa[] getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(Pessoa[] listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	@Override
	public String toString() {
		return "ListaPessoa [listaPessoa=" + Arrays.toString(listaPessoa) + "]";
	}

}
