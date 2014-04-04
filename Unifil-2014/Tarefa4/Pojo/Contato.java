package Pojo;

import java.io.Serializable;
import java.sql.Date;

public class Contato implements Serializable {

	private int id;
	private String nome;
	private String email;
	private String endereco;
	private Date data_de_nascimento;
	
	public Contato() {
	}
	
	public Contato(String nome, String email, String endereco,
			Date data_de_nascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.data_de_nascimento = data_de_nascimento;
	}
	
	public Contato(int id, String nome, String email, String endereco,
			Date data_de_nascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.data_de_nascimento = data_de_nascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}

	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

}
