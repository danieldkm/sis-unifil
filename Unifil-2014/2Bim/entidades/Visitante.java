package entidades;

public class Visitante {

	private int id;
	private String nome;
	private String telefone;
	private String email;
	
	public Visitante() {
		// TODO Auto-generated constructor stub
	}
	
	public Visitante(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Visitante(int id, String nome, String telefone, String email) {
		this(nome, telefone, email);
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
