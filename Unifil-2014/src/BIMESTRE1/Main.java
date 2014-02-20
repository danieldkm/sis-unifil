package BIMESTRE1;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		Conexao conexao = new Conexao();
		conexao.lerArquivo();
		Connection c = conexao.getConexao();
		System.out.println("conexao " + c);
		if(c == null){
			System.out.println("não conectado com BD");
		} else {
			System.out.println("conectado com BD");
		}
	}
}
