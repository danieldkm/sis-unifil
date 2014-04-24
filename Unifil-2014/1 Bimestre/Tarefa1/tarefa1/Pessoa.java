package Tarefa1.tarefa1;

public class Pessoa {

	private String nome;
	private String email;
	private String codigo;
	private String cpf;
	private String data;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String email, String codigo, String cpf,
			String data) {
		super();
		this.nome = nome;
		this.email = email;
		this.codigo = codigo;
		this.cpf = cpf;
		this.data = data;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
