package aula20032014;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Mainnnn {

	
	public static void main(String[] args) {
		Connection conn = new Singleton().getInstance();
		Thread thread1 = new Thread((Runnable) conn);
		thread1.start();
		Thread thread2 = new Thread((Runnable) conn);
		thread2.start();
		
//		
//		
//		try {
//			Statement st = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
		
	}
}
