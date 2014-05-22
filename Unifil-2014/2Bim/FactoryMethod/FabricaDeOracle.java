package FactoryMethod;

public class FabricaDeOracle implements FabricaDeConexao {

	@Override
	public Conexao criarConexao() {
		return new OracleConexao();
	}

}
