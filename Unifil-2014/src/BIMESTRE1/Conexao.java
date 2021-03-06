package BIMESTRE1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	// url: 192.168.10.21
	// username: lab3
	// password: 1234

	private String ip="localhost:3306";
	private String user="root";
	private String senha="root";
	private String camanhoArquivo = "src/Arquivo de configuração.txt";

	private java.sql.Connection con;

	public java.sql.Connection getConexao() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:mysql://" + ip,
					user, senha);
			System.out.println("Conectado");
		} catch (ClassNotFoundException e) {
			System.out.println("nao Conectado");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.out.println("nao Conectado");
			e.printStackTrace();
			return null;
		}
		return con;
	}

	public void lerArquivo() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(camanhoArquivo)));
			String next;
			next = br.readLine();
			ip = next.substring(5, next.length());
//			System.out.println("IP:" + ip);
			next = br.readLine();
			user = next.substring(10, next.length());;
//			System.out.println("USER:" + user);
			next = br.readLine();
			senha = next.substring(10, next.length());;
//			System.out.println("Senha:" + senha);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
