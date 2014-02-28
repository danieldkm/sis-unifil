package BIMESTRE1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploInsercao {
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String nomeArquivo = "config.txt";
		String url = "jdbc:mysql://";
		String line;
		File file = new File(nomeArquivo);
		Connection conn = null;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			line = in.readLine();
			while (line != null){
				String a[] = line.split("[:]");
				switch (a[0]) {
				case "url":
					url = url.concat(a[1].trim()+":");	
					break;

				case "porta":
					url = url.concat(a[1].trim()+"/");	
					break;
				
				case "database":
					url = url.concat(a[1].trim()+"?");	
					break;
					
				case "username":
					url = url.concat("user="+a[1].trim()+"");	
					break;
					
				case "password":
					url = url.concat("&password="+a[1].trim()+"");	
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
			conn = DriverManager.getConnection(url);
			
			//
			Statement statement = conn.createStatement();
			String sql = "INSERT INTO pessoa (nome, email) "
					+ "VALUES ('Mario','mario@mail.com')";
			statement.executeUpdate(sql);
			System.out.println("Pessoa inserida com sucesso.");
			statement.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
