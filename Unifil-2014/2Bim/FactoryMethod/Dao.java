package FactoryMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Quarto;
import entidades.TipoQuarto;
import entidades.Visitante;

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
		try {
			if (conexao == null || conexao.isClosed()) {
				System.out.println("entrou");
				Conexao con = fabrica.criarConexao();
				conexao = con.getConexao();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	// INSERT
	public static void insert(Object o) {
		try {
			String sql = "";
			Connection con = getConexao(new FabricaDeMySql());
			PreparedStatement pst = null;

			if (o instanceof Quarto) {
				Quarto q = (Quarto) o;
				sql = "insert into quarto (descricaoQuarto, tipo, capacidade) values (?,?,?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, q.getDescricao());
				pst.setString(2, q.getTipo());
				pst.setInt(3, q.getCapacidade());
			} else if (o instanceof TipoQuarto) {
				TipoQuarto tq = (TipoQuarto) o;
				sql = "insert into tipo_quarto (descricao) values (?)";
				pst = con.prepareStatement(sql);
				pst.setString(1, tq.getDescricao());
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

	// UPDATE
	public static void update(Object o) {
		try {

			String sql = "";
			Connection con = getConexao(new FabricaDeMySql());
			PreparedStatement pst = null;
			if (o instanceof TipoQuarto) {
				TipoQuarto tq = (TipoQuarto) o;
				sql = "update tipo_quarto set descricao = ? where idTipo = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, tq.getDescricao());
				pst.setInt(2, tq.getId());
			} else if (o instanceof Quarto) {
				Quarto q = (Quarto) o;
				// UPDATE quarto SET descricaoQuarto = 'TesteQuarto1',
				// tipo = (SELECT idTipo FROM tipo_quarto WHERE descricao = 9),
				// capacidade = '4'
				// WHERE idQuarto = 1;
				sql = "UPDATE quarto SET descricaoQuarto = ?, "
						+ "tipo = (SELECT idTipo FROM tipo_quarto WHERE descricao = ?), "
						+ "capacidade = ? " + "WHERE idQuarto = ?;";
				pst = con.prepareStatement(sql);
				pst.setString(1, q.getDescricao());
				pst.setString(2, q.getTipo());
				pst.setInt(3, q.getCapacidade());
				pst.setInt(4, q.getId());
			}
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DELETE
	public static void delete(Object o) {
		try {
			String sql = "";
			Connection con = getConexao(new FabricaDeMySql());
			PreparedStatement pst = null;
			if (o instanceof TipoQuarto) {
				TipoQuarto tq = (TipoQuarto) o;
				sql = "DELETE FROM TIPO_QUARTO WHERE idTipo = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, tq.getId());
			} else if (o instanceof Quarto) {
				Quarto q = (Quarto) o;
				sql = "DELETE FROM QUARTO WHERE idQuarto = ?";
				pst = con.prepareStatement(sql);
				pst.setInt(1, q.getId());
			}
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// SELECT
	public static ArrayList<Object> select(Object o) {
		ArrayList<Object> lista = new ArrayList<>();
		try {
			String sql = "";
			Connection con = getConexao(new FabricaDeMySql());
			PreparedStatement pst = null;

			if (o instanceof TipoQuarto) {
				TipoQuarto tq = (TipoQuarto) o;
				sql = "select * from tipo_quarto";
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tq = new TipoQuarto(rs.getInt(1), rs.getString(2));
					lista.add(tq);
				}
				rs.close();
			} else if (o instanceof Quarto) {
				Quarto q = (Quarto) o;
				sql = "SELECT idQuarto, descricaoQuarto, (SELECT descricao FROM tipo_quarto WHERE idTipo = tipo), capacidade FROM quarto";
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					q = new Quarto(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getInt(4));
					lista.add(q);
				}
				rs.close();
			} else if (o instanceof Visitante) {
				Visitante v = (Visitante) o;
				sql = "SELECT * FROM visitante";
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					v = new Visitante(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4));
					lista.add(v);
				}
				rs.close();
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

}
