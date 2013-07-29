package dia2907;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		/*
		 * Crie a classe Principal com o método main, onde deve ser instanciado
		 * o Controle e deve ter como opções de menu: Inserir consulta Exibir
		 * dados de consulta de um determinado plano. Exibir o total de
		 * consultas de um determinado plano. Exibir o valor total de consultas
		 * de um determinado plano.
		 */
		Controle c = new Controle();
		boolean con = true;
		while (true) {

			int opcao = Integer
					.parseInt(JOptionPane
							.showInputDialog("Selecione uma das opções abaixo: \n"
									+ "1-Inserir consulta \n"
									+ "2-Exibir dados de consulta de um determinado plano.\n"
									+ "3-Exibir o total de consultas de um determinado plano.\n"
									+ "4-Exibir o valor total de consultas de um determinado plano.\n"));

			switch (opcao) {
			case 1:
				c.incluir(JOptionPane.showInputDialog("Informe o tipo").toUpperCase(),
						JOptionPane.showInputDialog("Informe o nome"),
						Integer.parseInt(JOptionPane
								.showInputDialog("Informe a matricula")),
						Integer.parseInt(JOptionPane
								.showInputDialog("Informe qtd dependentes")),
						Integer.parseInt(JOptionPane
								.showInputDialog("Informe o ano")), Double
								.parseDouble(JOptionPane
										.showInputDialog("Informe o valor")));
				break;
			case 2:
				c.exibir();
				break;
			case 3:
				c.totalConsulta();
				break;
			case 4:
				c.valorTotal();
				break;
			}

			int n = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
			if (JOptionPane.NO_OPTION == n) {
				con = false;
			}
		}

	}
}
