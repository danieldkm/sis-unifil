package FactoryMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexao implements Conexao {

//	private static String driver = "com.mysql.jdbc.Driver";
//	private static String nomeArquivo = "config.txt";
//	private static String url = "jdbc:mysql://";
	private String driver = "com.mysql.jdbc.Driver";
	private String nomeArquivo = "config.txt";
	private String url = "jdbc:mysql://";
	private Connection conn = null;

	@Override
	public Connection getConexao() {
		if (conn == null) {
			try {
				File file = new File(nomeArquivo);
				String line;
				BufferedReader in = new BufferedReader(new FileReader(file));
				line = in.readLine();
				while (line != null) {
					String a[] = line.split("[:]");
					switch (a[0]) {
					case "url":
						url = url.concat(a[1].trim() + ":");
						break;

					case "porta":
						url = url.concat(a[1].trim() + "/");
						break;

					case "database":
						url = url.concat(a[1].trim() + "?");
						break;

					case "username":
						url = url.concat("user=" + a[1].trim() + "");
						break;

					case "password":
						url = url.concat("&password=" + a[1].trim() + "");
						break;

					default:
						break;
					}

					line = in.readLine();
				}
				in.close();
				System.out.println(url);
				System.out.println("Conex�o estabelecida.");

				Class.forName(driver);
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				System.out.println("\n--- SQLException ---\n");
				while (e != null) {
					System.out.println("Mensagem: " + e.getMessage());
					System.out.println("SQLState: " + e.getSQLState());
					System.out.println("ErrorCode: " + e.getErrorCode());
					e = e.getNextException();
					System.out.println("");
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
