package dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;
//Criamos a classe GenericDao para ser herdadas pelos demais dao’s, assim, 
//vamos agora criar a classe ClienteDao, onde terão os métodos mais específicos da classe

public class ClienteDao extends GenericDao {

	// System.out.print(formatarDate.format(data));

	public String formatarDataAtual() {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
		String dataAtual = formatarDate.format(data);
		String dataA = dataAtual.replace('/', '-');
		String dataInv = "";
		dataInv = "" + dataA.substring(6, 10) + dataA.substring(2, 6)
				+ dataA.substring(0, 2);
		return dataInv;
	}

	public String formatarDataString(String data) {
		String dataA = data.replace('-', '/');
		String dataInv = "";
		dataInv = dataA.substring(8, 10) + "/" 
				+ dataA.substring(5, 7) + "/" + dataA.substring(0, 4);
		return dataInv;
	}
	
	public void salvar(Cliente cliente) {
		try {
			String insert = "INSERT INTO CLIENTE(data_cadastro, nome, data_nasc, cpf, rg, endereco, bairro, cidade, cep, telefone, "
					+ "celular, sexo, naturalidade, est_civil, estado) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			save(insert, formatarDataAtual(), cliente.getNome(),
					cliente.getDataNascimento(), cliente.getCpf(),
					cliente.getRg(), cliente.getEndereco(),
					cliente.getBairro(), cliente.getCidade(), cliente.getCep(),
					cliente.getTelefone(), cliente.getCelular(),
					cliente.getSexo(), cliente.getNaturalidade(),
					cliente.getEstadoCivil(), cliente.getEstado());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(Cliente cliente) {
		try {
			String update = "UPDATE CLIENTE "
					+ "SET data_cadastro = ?, nome = ?, data_nasc = ?, cpf = ?, rg = ?, "
					+ "endereco = ?, bairro = ?, cidade = ?, cep = ?, telefone = ?, "
					+ "celular = ?, sexo = ?, naturalidade = ?, est_civil = ?, estado = ? "
					+ "WHERE cod_cliente = ?";
			update(update, cliente.getId(), formatarDataAtual(), cliente.getNome(),
					cliente.getDataNascimento(), cliente.getCpf(),
					cliente.getRg(), cliente.getEndereco(),
					cliente.getBairro(), cliente.getCidade(), cliente.getCep(),
					cliente.getTelefone(), cliente.getCelular(),
					cliente.getSexo(), cliente.getNaturalidade(),
					cliente.getEstadoCivil(), cliente.getEstado());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(long id) {
		try {
			String delete = "DELETE FROM CLIENTE WHERE cod_cliente = ?";
			delete(delete, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> findClientes() throws SQLException {
		List<Cliente> clientes = new ArrayList<Cliente>();

		String select = "SELECT * FROM CLIENTE";

		PreparedStatement stmt = getConnection().prepareStatement(select);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getLong("cod_cliente"));
			cliente.setNome(rs.getString("nome"));
			cliente.setDataCadastro(formatarDataString(rs.getString("data_cadastro")));
			cliente.setDataNascimento(formatarDataString(rs.getString("data_nasc")));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setRg(rs.getString("rg"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setCep(rs.getString("cep"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setSexo(rs.getString("sexo"));
			cliente.setNaturalidade(rs.getString("naturalidade"));
			cliente.setEstadoCivil(rs.getString("est_civil"));
			cliente.setEstado(rs.getString("estado"));

			clientes.add(cliente);
		}

		rs.close();
		stmt.close();

		return clientes;
	}

	public Cliente findByName(String nome) throws SQLException {
		String select = "SELECT * FROM CLIENTE WHERE nome = ?";
		Cliente cliente = null;
		PreparedStatement stmt = getConnection().prepareStatement(select);

		stmt.setString(1, nome);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getLong("cod_cliente"));
			cliente.setNome(rs.getString("nome"));
			cliente.setDataCadastro(rs.getString("data_cadastro"));
			cliente.setDataNascimento(rs.getString("data_nasc"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setRg(rs.getString("rg"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setCep(rs.getString("cep"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setSexo(rs.getString("sexo"));
			cliente.setNaturalidade(rs.getString("naturalidade"));
			cliente.setEstadoCivil(rs.getString("est_civil"));
			cliente.setEstado(rs.getString("estado"));
		}

		rs.close();
		stmt.close();
		return cliente;
	}
}
