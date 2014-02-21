package BIMESTRE1;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
	private static Conexao conexao; // = new Conexao();
	private static Connection c;

	public static void main(String[] args) throws SQLException {
		Connection con = Main.getInstancia();
		con.close();
	}

	public static Connection getInstancia() {
		if (c == null) {
			conexao = new Conexao();
			conexao.lerArquivo();
			return c = conexao.getConexao();
		}
		conexao.lerArquivo();
		return c;
	}
}
