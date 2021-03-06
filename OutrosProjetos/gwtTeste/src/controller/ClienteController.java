package controller;

import javax.swing.*;

import dao.ClienteDao;
import entity.Cliente;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// classe ClienteController faz a comunicação entre o banco de dados e a interface
public class ClienteController {

	private String dataAtual() {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
		String dataAtual = formatarDate.format(data);
		System.out.println(dataAtual);
		return dataAtual;
	}

	private String formatarDataInv(String data) {
		if (data.contains("-")) {
			int ano = Integer.parseInt(data.substring(0, 4));
			int mes = Integer.parseInt(data.substring(3, 5));
			int dia = Integer.parseInt(data.substring(6, 8));
			data = ano + "-" + mes + "-" + dia;
			System.out.println("com ----");
		} else {
			int dia = Integer.parseInt(data.substring(0, 2));
			int mes = Integer.parseInt(data.substring(3, 5));
			int ano = Integer.parseInt(data.substring(6, 10));
			data = ano + "-" + mes + "-" + dia;
			System.out.println("com /////");
		}
		return data;
	}

	public void salvar(String nome, String dataNascimento, String cpf,
			String rg, String endereco, String bairro, String cidade,
			String estado, String cep, String telefone, String celular,
			String sexo, String naturalidade, String estadoCivil, String profissao)
			throws SQLException, ParseException {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setDataCadastro(dataAtual());
		cliente.setDataUltimaAlteracao(dataAtual());
		cliente.setDataNascimento(formatarDataInv(dataNascimento));
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
		cliente.setProfissao(profissao);

		new ClienteDao().salvar(cliente);
	}

	public void salvarFull(long id, String dataCadastro, String nome,
			String dataNascimento, String cpf, String rg, String endereco,
			String bairro, String cidade, String estado, String cep,
			String telefone, String celular, String sexo, String naturalidade,
			String estadoCivil, String profissao) throws SQLException, ParseException {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setDataCadastro(dataAtual());
		cliente.setDataUltimaAlteracao(dataAtual());
		cliente.setNome(nome);
		cliente.setDataNascimento(formatarDataInv(dataNascimento));
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
		cliente.setProfissao(profissao);
		new ClienteDao().salvar(cliente);
	}

	public void alterarNome(long id, String nome, String dataNascimento,
			String cpf) throws ParseException, SQLException {

		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		new ClienteDao().alterar(cliente);
	}

	public void alterar(long id, String nome, String dataNascimento,
			String cpf, String rg, String endereco, String bairro,
			String cidade, String estado, String cep, String telefone,
			String celular, String sexo, String naturalidade, String estadoCivil, String profissao)
			throws ParseException, SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setDataUltimaAlteracao(dataAtual());
		cliente.setDataNascimento(formatarDataInv(dataNascimento));
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
		cliente.setProfissao(profissao);
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

	public void excluir(Object id) throws SQLException {
		new ClienteDao().excluir(id);
	}

	// public Cliente buscaClientePorNome(String nome) throws SQLException {
	// ClienteDao dao = new ClienteDao();
	// return dao.findByName(nome);
	// }

	public Cliente buscaClientePorId(int id) throws SQLException {
		ClienteDao dao = new ClienteDao();
		return dao.findById(id);
	}

	public Cliente buscaClientePorCpf(String cpf) {
		Cliente cliente = null;
		ClienteDao dao = new ClienteDao();
		try {
			if (dao.findByCpf(cpf) == null) {
				return cliente;
			} else {
				return dao.findByCpf(cpf);
			}
		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "eeeeeee?????" + cliente.getCpf());
			e.printStackTrace();
		}
		return null;
	}

}
