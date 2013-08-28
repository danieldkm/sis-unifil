package dia2708.Funcionario;

import dia2708.DataHora.Data;

public class Funcionario0 extends Pessoa0// declaração da classe
{
	private Pessoa0 funcionario; // identificação do funcionário, dada por
									// uma instância
	public Data admissao; // data de admissão, declarada propositalmente como
							// pública
	private float salario; // salário do funcionário

	// public Funcionario0(Pessoa0 f, Data a, float s) {
	// funcionario = f;
	// admissao = a;
	// salario = s;
	// }

	public Funcionario0(String nome, int i, Data d, Pessoa0 f, Data a, float s) {
		super(nome, i, d);
		funcionario = f;
		admissao = a;
		salario = s;
	}

	public String toString() {
		String resultado;
		resultado = funcionario + "\n"; // chamada implícita ao método
										// toString
										// da classe Pessoa
		resultado = resultado + "Data de admiss�o:" + admissao + "\n";
		resultado = resultado + "Sal�rio:" + salario + "\n";
		return resultado;
	}

	public void modificaNome(String nome) {
//		funcionario.setNome(nome);
		funcionario.nome = nome;
	
	}

}
