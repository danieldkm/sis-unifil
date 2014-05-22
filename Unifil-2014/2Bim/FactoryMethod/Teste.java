package FactoryMethod;

import java.sql.Connection;
import java.sql.SQLException;

public class Teste {
	public static void main(String[] args) {
//		FabricaDeConexao fabrica = new FabricaDeMySql();
//		Conexao conexao = fabrica.criarConexao();
//		conexao.getConexao();
//
//		fabrica = new FabricaDeFireBird();
//		conexao = fabrica.criarConexao();
//		conexao.getConexao();
//
//		fabrica = new FabricaDeOracle();
//		conexao = fabrica.criarConexao();
//		try {
//			conexao.getConexao().close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		Teste t = new Teste();
		
		t.getConexao(new FabricaDeMySql());
		
		
		try {
			System.out.println("Conexao estabelecida? " + conexao);
			conexao.close();
			conexao = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexao = t.getConexao(new FabricaDeFireBird());
		try {
			System.out.println("Conexao estabelecida? " + conexao);
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private Teste(){
	}
	
	private static Connection conexao;
	
	
	public Connection getConexao(FabricaDeConexao fabrica) {
		if(conexao == null){
			System.out.println("entrou");
			Conexao con = fabrica.criarConexao();
			this.conexao = con.getConexao();
		}
		return conexao;
	}
	
	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public void insert(){
	}
	
	public void update(){
	}
	
	public void delete(){
		
	}
	
	
}
