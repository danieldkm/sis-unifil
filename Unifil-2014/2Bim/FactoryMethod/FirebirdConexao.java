package FactoryMethod;

import java.sql.Connection;

public class FirebirdConexao implements Conexao {

	private Connection conexao;
	
	@Override
	public Connection getConexao() {
		System.out.println("Criar conex�o com banco FireBird");
		return conexao;
	}

}
