package aula20032014;

import java.sql.Connection;

import BIMESTRE1.Conexao;

public class Singleton {
	
	private static Connection singleConexao;
	
	public Singleton() {
		singleConexao = getInstance();
	}
	
	
	public static synchronized Connection getInstance(){
		if(singleConexao == null) singleConexao = new Conexao().getConexao();
		return singleConexao;
	}

}
