package FactoryMethod;

import java.sql.Connection;

public class OracleConexao implements Conexao{

	@Override
	public Connection getConexao() {
		System.out.println("Criar conexao com o banco oracle");
		return null;
	}

}
