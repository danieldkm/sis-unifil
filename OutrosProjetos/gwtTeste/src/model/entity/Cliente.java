package model.entity;

import java.io.Serializable;
import java.util.Date;

//classe cliente terá como atributos os campos da tabela Cliente
public class Cliente implements Comparable<Cliente>, Serializable {
	private long id;
	private String dataCadastro;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String celular;
	private String sexo;
	private String naturalidade;
	private String estadoCivil;

	// public Cliente() {
	// }
	//
	// public Cliente(long id, String dataCadastro, String nome,
	// Date dataNascimento, String cpf, String rg, String endereco,
	// String bairro, String cidade, String estado, String cep,
	// String telefone, String celular, String sexo, String naturalidade,
	// String estadoCivil) {
	// this.id = id;
	// this.dataCadastro = dataCadastro;
	// this.nome = nome;
	// this.dataNascimento = dataNascimento;
	// this.cpf = cpf;
	// this.rg = rg;
	// this.endereco = endereco;
	// this.bairro = bairro;
	// this.cidade = cidade;
	// this.estado = estado;
	// this.cep = cep;
	// this.telefone = telefone;
	// this.celular = celular;
	// this.sexo = sexo;
	// this.naturalidade = naturalidade;
	// this.estadoCivil = estadoCivil;
	// }

	// Get and Set
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public int compareTo(Cliente o) {
		return nome.compareTo(o.nome) != 0 ? nome.compareTo(o.nome)
				: (id - o.id) != 0 ? 0
						: cpf.compareTo(o.cpf) != 0 ? cpf.compareTo(o.cpf)
								: rg.compareTo(o.rg) != 0 ? rg.compareTo(o.rg)
										: dataCadastro
												.compareTo(o.dataCadastro) != 0 ? dataCadastro
												.compareTo(o.dataCadastro)
												: dataNascimento
														.compareTo(o.dataNascimento) != 0 ? dataNascimento
														.compareTo(o.dataNascimento)
														: endereco
																.compareTo(o.endereco) != 0 ? endereco
																.compareTo(o.endereco)
																: bairro.compareTo(o.bairro) != 0 ? bairro
																		.compareTo(o.bairro)
																		: cep.compareTo(o.cep) != 0 ? cep
																				.compareTo(o.cep)
																				: naturalidade
																						.compareTo(o.naturalidade) != 0 ? naturalidade
																						.compareTo(o.naturalidade)
																						: sexo.compareTo(o.sexo) != 0 ? sexo
																								.compareTo(o.sexo)
																								: cidade.compareTo(o.cidade) != 0 ? cidade
																										.compareTo(o.cidade)
																										: estado.compareTo(o.estado) != 0 ? estado
																												.compareTo(o.estado)
																												: estadoCivil
																														.compareTo(o.estadoCivil) != 0 ? estadoCivil
																														.compareTo(estadoCivil)
																														: celular
																																.compareTo(o.celular) != 0 ? celular
																																.compareTo(o.celular)
																																: telefone
																																		.compareTo(o.telefone);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result	+ ((celular == null) ? 0 : celular.hashCode());
		result = prime * result	+ ((cep == null) ? 0 : cep.hashCode());
		result = prime * result	+ ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result	+ ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result	+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result	+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result	+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result	+ ((estado == null) ? 0 : estado.hashCode());
		result = prime * result	+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result	+ ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result	+ ((rg == null) ? 0 : rg.hashCode());
		result = prime * result	+ ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result	+ ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || obj instanceof Cliente) {
			return false;
		}
		Cliente other = (Cliente) obj;
		return nome.equals(other.nome) && bairro.equals(other.bairro)
				&& celular.equals(other.celular)&& cep.equals(other.cep)
				&& cidade.equals(other.cidade)&& cpf.equals(other.cpf)
				&& dataCadastro.equals(other.dataCadastro)&& dataNascimento.equals(other.dataNascimento)
				&& endereco.equals(other.endereco)&& estado.equals(other.estado)
				&& estadoCivil.equals(other.estadoCivil)&& id == other.id
				&& naturalidade.equals(other.naturalidade)&& rg.equals(other.rg)
				&& sexo.equals(other.sexo)&& telefone.equals(other.telefone);
	}
}
