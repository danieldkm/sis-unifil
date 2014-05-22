package FactoryMethod;

public class FabricaDeFireBird implements FabricaDeConexao {

	@Override
	public Conexao criarConexao() {
		return new FirebirdConexao();
	}

	
}
