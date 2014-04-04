package Pojo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConexaoBD.Conexao;

public class Persistence {

	private static Connection con;

	public Persistence() {
		if (con == null) {
			con = getInstance();
		}
	}

	public static synchronized Connection getInstance() {
		if (con == null)
			con = new Conexao().getConexao();
		return con;
	}

	//
	// create table contatos (
	//
	// id BIGINT NOT NULL AUTO_INCREMENT,
	//
	// nome VARCHAR(255),
	//
	// email VARCHAR(255),
	//
	// endereco VARCHAR(255),
	//
	// dataNascimento DATE,
	//
	// primary key (id)
	//
	// );

	public void inserir(Contato c) {
		PreparedStatement pst;
		String sql = "INSERT INTO CONTATOS (nome, email, endereco, dataNascimento) VALUES (?, ? ,?, ?)";
		try {
			pst = con.prepareStatement(sql);
			System.out.println("nome " + c.getNome());
			System.out.println("email " + c.getEmail());
			System.out.println("endere�o " + c.getEndereco());
			System.out.println("dataNascimento " + c.getData_de_nascimento());

			pst.setString(1, c.getNome());
			pst.setString(2, c.getEmail());
			pst.setString(3, c.getEndereco());
			pst.setString(4, c.getData_de_nascimento() + "");
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("inserido");
	}

}
