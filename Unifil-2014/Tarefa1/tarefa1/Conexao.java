package tarefa1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	String driver = "com.mysql.jdbc.Driver";
	String nomeArquivo = "config.txt";
	String url = "jdbc:mysql://";
	String line;
	File file = new File(nomeArquivo);
	Connection conn = null;

	public Connection getConexao() {
		try {
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
			System.out.println("Conexão estabelecida.");

			Class.forName(driver);
			return conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
