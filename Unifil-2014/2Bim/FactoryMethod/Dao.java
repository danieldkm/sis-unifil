package FactoryMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Quarto;

public class Dao {
	public static void main(String[] args) {
		// FabricaDeConexao fabrica = new FabricaDeMySql();
		// Conexao conexao = fabrica.criarConexao();
		// conexao.getConexao();
		//
		// fabrica = new FabricaDeFireBird();
		// conexao = fabrica.criarConexao();
		// conexao.getConexao();
		//
		// fabrica = new FabricaDeOracle();
		// conexao = fabrica.criarConexao();
		// try {
		// conexao.getConexao().close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

		Dao t = new Dao();

		t.getConexao(new FabricaDeMySql());

		try {
			System.out.println("Conexao estabelecida? " + conexao);
			conexao.close();
			conexao = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conexao = t.getConexao(new FabricaDeFireBird());
		try {
			System.out.println("Conexao estabelecida? " + conexao);
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Dao() {
	}

	private static Connection conexao;

	public static Connection getConexao(FabricaDeConexao fabrica) {
		if (conexao == null) {
			System.out.println("entrou");
			Conexao con = fabrica.criarConexao();
			conexao = con.getConexao();
		}
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public static void insert(Object o) {
		try {
			String sql = "";
			Quarto q = null;
			Connection con = getConexao(new FabricaDeMySql());
			PreparedStatement pst = null;

			if (o instanceof Quarto) {
				q = (Quarto) o;
				sql = "insert into quarto (descricaoQuarto, tipo, capacidade) values (?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, q.getDescricao());
				pst.setInt(2, q.getTipo());
				pst.setInt(3, q.getCapacidade());
			}

			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {
	}

	public void delete() {

	}

}
