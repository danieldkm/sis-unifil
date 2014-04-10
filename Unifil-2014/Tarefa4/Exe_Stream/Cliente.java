package Exe_Stream;

import java.io.Serializable;

public class Cliente implements Serializable {

	private String nome;

	private char sexo;

	private String cpf;

	public Cliente() {

	}

	public Cliente(String nome, char sexo, String cpf) {

		super();

		this.nome = nome;

		this.sexo = sexo;

		this.cpf = cpf;

	}

	public String getCpf() {

		return cpf;

	}

	public void setCpf(String cpf) {

		this.cpf = cpf;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public char getSexo() {

		return sexo;

	}

	public void setSexo(char sexo) {

		this.sexo = sexo;

	}

	public String toString() {

		return this.nome + " / " + "Sexo: " + this.sexo + "\n" + "CPF: "
				+ this.cpf;

	}
}