package BIMESTRE1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexao {

	// url: 192.168.10.21
	// username: lab3
	// password: 1234

	private String ip;
	private String user;
	private String senha;

	private java.sql.Connection con;

	public java.sql.Connection getConexao() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// Class.forName("com.mysql.jdbc.Driver");
			// "jdbc:mysql://localhost/fj21", "root", "");
			System.out.println("jdbc:mysql://" + ip + ":3306/"+user+","+senha);
			con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/",
					user, senha);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}

	public void lerArquivo() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("src/conexao.txt")));
			String next;
			next = br.readLine();
			ip = next;
			System.out.println("IP: " + ip);
			next = br.readLine();
			user = next;
			System.out.println("USER: " + user);
			next = br.readLine();
			senha = next;
			System.out.println("Senha: " + senha);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
