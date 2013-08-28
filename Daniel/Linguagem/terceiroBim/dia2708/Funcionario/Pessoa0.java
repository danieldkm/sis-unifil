package dia2708.Funcionario;

import dia2708.DataHora.Data;

public class Pessoa0 // declaração da classe
{
	public String nome; // o nome da pessoa - declarado público
						// propositadamente
	private int identidade; // o número da identidade da pessoa
	private Data nascimento; // a data de nascimento da pessoa

	public Pessoa0(String n, int i, Data d) {
		nome = n;
		identidade = i;
		nascimento = d;
	}

	public String toString() {
		return "Nome: " + nome + "\nIdentidade:" + identidade
				+ "\nData de Nascimento:" + nascimento;
	}
	
//	public void setNome(String nome) {
//		this.nome = nome;
//	}

} // fim da classe Pessoa0
