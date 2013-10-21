package dia2110.projeto;

import javax.swing.JOptionPane;

import dia2110.Exemplo1Agenda;

public class teste {

	public static void main(String[] args) {
		Projeto p = new Projeto("Sis", 1030);
		Exemplo1Agenda log = new Exemplo1Agenda();
		log.setArquivo("Inicio: ");
		String descricao = "";
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
				descricao = JOptionPane.showInputDialog(null,
						"Informe o tipo/descricao");
				pc.setProjeto(descricao, Float.parseFloat(JOptionPane
						.showInputDialog(null, "Informe o Custo por Hora")),
						Float.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Componente")), Float
								.parseFloat(JOptionPane.showInputDialog(null,
										"Informe o Custo por Placa")), Float
								.parseFloat(JOptionPane.showInputDialog(null,
										"Informe o Custo por Mecanica")), Float
								.parseFloat(JOptionPane.showInputDialog(null,
										"Informe o Custo por Design")));
				// continuar = JOptionPane.showConfirmDialog(null,
				// "Deseja continuar?");
				log.setArquivo("Inclusao: " + descricao);
				if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
					sair = true;
				} else {
					sair = false;
				}
				break;
			case 2:
				descricao = JOptionPane.showInputDialog(null,
						"Informe o tipo/descricao");
				pc.setProjeto(descricao, Float.parseFloat(JOptionPane
						.showInputDialog(null, "Informe o Custo por Hora")),
						Float.parseFloat(JOptionPane.showInputDialog(null,
								"Informe o Custo por Suplemento")), Float
								.parseFloat(JOptionPane.showInputDialog(null,
										"Informe o Custo por Consultoria")));
				sair = false;
				log.setArquivo("Inclusao: " + descricao);
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
			descricao = JOptionPane
					.showInputDialog("Para registrar as Horas trabalhas de um projeto\nInforme a descrição para o tipo de projeto");
			tipoCadastro = pc.qtdHoras(descricao, Integer.parseInt(JOptionPane
					.showInputDialog("Informe a hora trabalhada")));
			sair = false;
			log.setArquivo("Registro horas: " + descricao);
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
			descricao = JOptionPane
					.showInputDialog("Para consulta os dados projeto\nInforme a descrição");
			eca = pc.exibirCustoAtual(descricao);
			if (eca > 0) {
				JOptionPane.showMessageDialog(null,
						"Dados do projeto consultado: " + eca + " custo atual");
			}
			log.setArquivo("Consulta: " + descricao);
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
			descricao = JOptionPane
					.showInputDialog("Informe um projeto especifico?\n1 - Hardware\n2 - Software");
			pc.exibirProjetoEspecifico(descricao);
			if (JOptionPane.showConfirmDialog(null, "Deseja continuar?") == 0) {
				sair = true;
				log.setArquivo("Consulta Geral: ");
			} else {
				sair = false;
				log.setArquivo("Fim: ");
				log.fecharArquivo();
			}
		}

	}

}
