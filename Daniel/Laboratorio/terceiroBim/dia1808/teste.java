package dia1808;

import javax.swing.JOptionPane;

public class teste {

	public static void main(String[] args) {
		Projeto p = new Projeto("Sis", 1030);
		// p.registrarHora(2);
		// System.out.println(p.custoAtual());
		//
		// ProjetoHardware ph = new ProjetoHardware("SIS Hardware", 1000, 90,
		// 80, 70, 60);
		// ph.registrarHora(1);
		// System.out.println(ph.custoAtual());
		//
		// ProjetoSotware ps = new ProjetoSotware("SIS Software", 900, 90, 80);
		// ps.registrarHora(1);
		// System.out.println(ps.custoAtual());
		int tipoCadastro = 0;
		boolean sair = true;
		ProjetoControle pc = new ProjetoControle();
		while (sair) {
			tipoCadastro = Integer
					.parseInt(JOptionPane
							.showInputDialog("Informe o tipo de cadastro\n1 - Hardware \n2 - Software"));
			switch (tipoCadastro) {
			case 1:
				pc.setProjeto(JOptionPane.showInputDialog(null,
						"Informe o tipo/descricao"), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Hora")), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Componente")), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Placa")), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Mecanica")), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Design")));
				// continuar = JOptionPane.showConfirmDialog(null,
				// "Deseja continuar?");
				if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
					sair = true;
				} else {
					sair = false;
				}
				break;
			case 2:
				pc.setProjeto(JOptionPane.showInputDialog(null,
						"Informe o tipo/descricao"), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Hora")), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Suplemento")), Float
						.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Consultoria")));
				sair = false;
				if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
					sair = true;
				} else {
					sair = false;
				}
				break;
			default:
				JOptionPane.showMessageDialog(null,
						"Erro, Informe o tipo 1 ou 2");
			}
		}
		sair = true;
		while (sair) {
			tipoCadastro = pc
					.qtdHoras(
							JOptionPane
									.showInputDialog("Para registrar as Horas trabalhas de um projeto\nInforme a descrição para o tipo de projeto"),
							Integer.parseInt(JOptionPane
									.showInputDialog("Informe a hora trabalhada")));
			sair = false;
			if (tipoCadastro < 0) {
				sair = true;
			} else if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
				sair = true;
			} else {
				sair = false;
			}
		}

		sair = true;
		float eca = 0;
		while (sair) {
			eca = pc.exibirCustoAtual(JOptionPane
					.showInputDialog("Para consulta os dados projeto\nInforme a descrição"));
			if (eca > 0) {
				JOptionPane.showMessageDialog(null,
						"Dados do projeto consultado: " + eca + " custo atual");
			}
			if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
				sair = true;
			} else {
				sair = false;
			}
		}

		sair = true;
		while (sair) {
			pc.exibirProjetos();
			if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
				sair = true;
			} else {
				sair = false;
			}
		}
		
		sair = true;
		while (sair) {
			pc.exibirProjetoEspecifico(JOptionPane.showInputDialog("Informe um projeto especifico?\n1 - Hardware\n2 - Software"));
			if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
				sair = true;
			} else {
				sair = false;
			}
		}
		
		
	}

}
