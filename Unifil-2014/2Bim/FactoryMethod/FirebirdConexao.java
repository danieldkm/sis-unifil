package FactoryMethod;

import java.sql.Connection;

public class FirebirdConexao implements Conexao {

	private Connection conexao;
	
	@Override
	public Connection getConexao() {
		System.out.println("Criar conexão com banco FireBird");
		return conexao;
	}

}
