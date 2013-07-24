package controller;

import javax.swing.*;

import dao.ClienteDao;

import model.Cliente;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

// classe ClienteController faz a comunicação entre o banco de dados e a interface
public class ClienteController {

	private Date formatarData(String data) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return new Date(formatter.parse(data).getTime());
	}

	public void salvarNome(String nome, String dataNascimento)
			throws SQLException, ParseException {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);

		new ClienteDao().salvar(cliente);
	}

	public void salvar(String dataCadastro, String nome, String dataNascimento,
			String cpf, String rg, String endereco, String bairro,
			String cidade, String estado, String cep, String telefone,
			String celular, String sexo, String naturalidade, String estadoCivil)
			throws SQLException, ParseException {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setDataCadastro(dataCadastro);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setEndereco(endereco);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setCep(cep);
		cliente.setTelefone(telefone);
		cliente.setCelular(celular);
		cliente.setSexo(sexo);
		cliente.setNaturalidade(naturalidade);
		cliente.setEstadoCivil(estadoCivil);
		cliente.setEstado(estado);

		new ClienteDao().salvar(cliente);
	}

	public void alterarNome(long id, String nome, String dataNascimento)
			throws ParseException, SQLException {

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);
		new ClienteDao().alterar(cliente);
	}

	public void alterar(long id, String dataCadastro, String nome,
			String dataNascimento, String cpf, String rg, String endereco,
			String bairro, String cidade, String estado, String cep,
			String telefone, String celular, String sexo, String naturalidade,
			String estadoCivil) throws ParseException, SQLException {

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setDataCadastro(dataCadastro);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setEndereco(endereco);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setCep(cep);
		cliente.setTelefone(telefone);
		cliente.setCelular(celular);
		cliente.setSexo(sexo);
		cliente.setNaturalidade(naturalidade);
		cliente.setEstadoCivil(estadoCivil);
		cliente.setEstado(estado);

		new ClienteDao().alterar(cliente);
	}

	public List<Cliente> listaClientes() {
		ClienteDao dao = new ClienteDao();
		try {
			return dao.findClientes();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Problemas ao localizar Cliente" + e.getLocalizedMessage());
		}
		return null;
	}

	public void excluir(long id) throws SQLException {
		new ClienteDao().excluir(id);
	}

	public Cliente buscaClientePorNome(String nome) throws SQLException {
		ClienteDao dao = new ClienteDao();
		return dao.findByName(nome);
	}
}
