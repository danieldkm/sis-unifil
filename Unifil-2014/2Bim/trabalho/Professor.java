package trabalho;

public class Professor {

	// CREATE TABLE `professor` (
	// `id` int(255) NOT NULL AUTO_INCREMENT,
	// `nome` varchar(250) DEFAULT NULL,
	// `dtNascimento` varchar(250) DEFAULT NULL,
	// `dtAdmissao` varchar(250) DEFAULT NULL,
	// `endereco` varchar(250) DEFAULT NULL,
	// `telefone` varchar(250) DEFAULT NULL,
	// `disponibilidade` varchar(250) DEFAULT NULL,
	// `sexo` varchar(250) DEFAULT NULL,
	// `habilidades` varchar(250) DEFAULT NULL,
	// `status` varbinary(250) DEFAULT NULL,
	// PRIMARY KEY (`id`)
	// ) ENGINE=InnoDB DEFAULT CHARSET=utf8

	private int id;
	private String nome;
	private String dtNascimento;
	private String dtAdmissao;
	private String endereco;
	private String telefone;
	private String disponibilidade;
	private String sexo;
	private String habilidades;
	private String status;
	

	public Professor(int id, String nome, String dtNascimento,
			String dtAdmissao, String endereco, String telefone,
			String disponibilidade, String sexo, String habilidades,
			String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.dtAdmissao = dtAdmissao;
		this.endereco = endereco;
		this.telefone = telefone;
		this.disponibilidade = disponibilidade;
		this.sexo = sexo;
		this.habilidades = habilidades;
		this.status = status;
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

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(String dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
