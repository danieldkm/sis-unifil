

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionBD {
	
	private Connection conn;
	
	public ConnectionBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paf", "root", "root");  
			System.out.println("Connectado");
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados!");
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
