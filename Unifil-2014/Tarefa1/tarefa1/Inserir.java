package tarefa1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Inserir {

	public static void main(String[] args) {
		new Inserir();
	}
	
	Connection conn = null;
	
	private Connection getConexao(){
		if(conn == null){
			conn = new Conexao().getConexao();
		} else {
			return conn;
		}
		return conn;
		
	}

	public Inserir() {
		Connection conn = getConexao();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(
					new File("insert_people.csv")));
			String ler;
			String[] a;
			Pessoa p = new Pessoa();
			ArrayList<Pessoa> pessoas = new ArrayList<>();
			Statement statement = conn.createStatement();
			while ((ler = br.readLine()) != null) {
				a = ler.split(";");
				for (int i = 0; i < a.length; i++) {
					if (i == 0) {
						p.setNome(a[i]);
					} else if (i == 1) {
						p.setEmail(a[i]);
					} else if (i == 2) {
						p.setCodigo(a[i]);
					} else if (i == 3) {
						p.setCpf(a[i]);
					} else if (i == 4) {
						p.setData(a[i]);
					}

				}

				pessoas.add(p);

			}

			for (Pessoa pessoa : pessoas) {
				String sql = "INSERT INTO pessoa (nome, email, codigo, cpf, data_nasc) values ('"
						+ pessoa.getNome()
						+ "','"
						+ pessoa.getEmail()
						+ "','"
						+ pessoa.getCodigo()
						+ "','"
						+ pessoa.getCpf()
						+ "','"
						+ pessoa.getData() + "');";
				System.out.println(sql);
				statement.executeUpdate(sql);
				System.out.println("Pessoa inserida com sucesso.");

			}

			br.close();

			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}