import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Banco {

	private static Connection con;

	public Banco() {
		if (con == null) {
			con = getInstance();
		}
	}

	public static synchronized Connection getInstance() {
		if (con == null)
			con = new Conexao().getConexao();
		return con;
	}

	public ArrayList<Pessoa> consultaPessoa() {
		ArrayList<Pessoa> ob = new ArrayList<>();
		Pessoa p = null;
		try {
			PreparedStatement pst = con
					.prepareStatement("SELECT * FROM PESSOA");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p = new Pessoa();
				p.setId(rs.getInt(1));
				p.setNome(rs.getString(2));
				p.setEmail(rs.getString(3));
				p.setCodigo(rs.getString(4));
				p.setCpf(rs.getString(5));
				p.setData(rs.getString(6));
				ob.add(p);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ob;
	}

	public void inserirPessoa(Pessoa p) {
		PreparedStatement pst;
		try {
			String sql = "INSERT INTO PESSOA (nome, email, codigo, cpf, data_nasc) VALUES (?, ? ,?, ?, ?)";
			pst = con.prepareStatement(sql);
			System.out.println("nome " + p.getNome());
			System.out.println("email " + p.getEmail());
			System.out.println("codigo " + p.getCodigo());
			System.out.println("cpf " + p.getCpf());
			System.out.println("data " + p.getData());
			pst.setString(1, p.getNome());
			pst.setString(2, p.getEmail());
			pst.setString(3, p.getCodigo());
			pst.setString(4, p.getCpf());
			pst.setString(5, p.getData());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarPessoa(Pessoa p) {
		try {
			String sql = "UPDATE PESSOA SET NOME = ?, EMAIL = ?, CODIGO = ?, CPF = ?, DATA_NASC = ? WHERE id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, p.getNome());
			pst.setString(2, p.getEmail());
			pst.setString(3, p.getCodigo());
			pst.setString(4, p.getCpf());
			pst.setString(5, p.getData());
			pst.setInt(6, p.getId());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerPessoa(Pessoa p) {
		try {

			String sql = "delete from pessoa where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, p.getId());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
