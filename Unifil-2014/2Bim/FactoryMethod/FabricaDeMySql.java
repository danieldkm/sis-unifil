package FactoryMethod;


public class FabricaDeMySql implements FabricaDeConexao {

	@Override
	public Conexao criarConexao() {
		return new MySqlConexao();
	}

}
