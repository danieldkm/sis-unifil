package Tarefa4.Pojo;

import java.sql.Date;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		java.util.Date dtAtual = new java.util.Date();
		Contato c = new Contato("Kmelo3", "felipe@kmelo.com.br",
				"Rua dos kmelo, 222", new Date(dtAtual.getTime()));
		Persistence p = new Persistence();
		p.inserir(c);
		try {
			if (p.getInstance() != null) {
				p.getInstance().close();
			}
			System.out.println("Fechando conexão");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
