package dia1808;

import javax.swing.JOptionPane;

public class ProjetoControle {

	private Projeto[] projetos = new Projeto[10];
	private int aux;

	public ProjetoControle() {
		// for (int i = 0; i < 10; i++) {
		// projetos[i] = new Projeto();
		// }
	}

	public void setProjeto(Projeto projeto) {
		projetos[aux++] = projeto;
	}

	public void setProjeto(String descricao, float custoHora,
			float custoSuplimento, float custoConsultoria) {
		ProjetoSotware ps = new ProjetoSotware(descricao, custoHora,
				custoSuplimento, custoConsultoria);
		projetos[aux++] = ps;
	}

	public void setProjeto(String descricao, float custoHora,
			float custoComponente, float custoPlaca, float custoMecanica,
			float custoDesign) {
		ProjetoHardware ph = new ProjetoHardware(descricao, custoHora,
				custoComponente, custoPlaca, custoMecanica, custoDesign);
		projetos[aux++] = ph;
	}

	public int qtdHoras(String descricao, int horas) {
		for (int i = 0; i < projetos.length; i++) {
			if (projetos[i] != null) {

				// System.out.println();
				// if (projetos[i].getClass().toString().substring(21)
				// .equals(descricao)) {
				// projetos[i].registrarHora(horas);
				// return projetos[i].getQtdHora();
				// }
				if (projetos[i].getDescricao().equals(descricao)) {
					projetos[i].registrarHora(horas);
					return projetos[i].getQtdHora();
				}
			}
		}
		return -1;
	}

	public float exibirCustoAtual(String tipo) {
		for (int i = 0; i < projetos.length; i++) {
			if (projetos[i] != null) {

				if (projetos[i].getDescricao().equals(tipo)) {
					// JOptionPane.showMessageDialog(
					// null,
					// "Custo Atual desse projeto é de: \n"
					// + projetos[i].custoAtual());
					return projetos[i].custoAtual();
				}
			}
		}
		return -1;
	}

	public void exibirProjetos() {
		for (int i = 0; i < projetos.length; i++) {
			if (projetos[i] != null) {
				JOptionPane.showMessageDialog(
						null,
						"Custo: "
								+ projetos[i].getCustoHora()
								+ "\nHoras trabalhadas: "
								+ projetos[i].getQtdHora()
								+ "\nCusto Atual: "
								+ +projetos[i].custoAtual()
								+ "\nDescrição / Tipo Projeto: "
								+ projetos[i].getDescricao()
								+ "\nTipo do Projeto: "
								+ projetos[i].getClass().getSimpleName()
										.substring(7));
			}
		}
	}

	public void exibirProjetoEspecifico(String projeto) {
		ProjetoSotware ps;
		ProjetoHardware ph;
		String texto = "";

		for (int i = 0; i < projetos.length; i++) {
			if (projetos[i] != null) {
				if (projeto.equals("1")) {
					if (projetos[i].getClass().getSimpleName().substring(7)
							.toUpperCase().equals("HARDWARE")) {
						ph = (ProjetoHardware) projetos[i];
						texto += "Descrição: " + ph.getDescricao() +
								"\nQtd horas: " + ph.getQtdHora() + 
								"\nCusto Hora: " + ph.getCustoHora() + 
								"\nCusto Placa: " + ph.getCustoPlaca() +
								"\nCusto Componente: " + ph.getCustoComponente() + 
								"\nCusto Design: " + ph.getCustoDesign() + 
								"\nCusto Mecanica: " + ph.getCustoMecanica()+ "\n\n"; 
						
					}

				} else if (projeto.equals("1")) {
					if (projetos[i].getClass().getSimpleName().substring(7)
							.toUpperCase().equals("SOFTWARE")) {
						ps = (ProjetoSotware) projetos[i];
						
						texto += "Descrição: " + ps.getDescricao() + 
								"\nQtd Horas: " + ps.getQtdHora() +
								"\nCusto Horas: " + ps.getCustoHora() + 
								"\nCusto Consultoria: " + ps.getCustoConsultoria() + 
								"\nCusto Suplemento: " + ps.getCustoSuplimento() + "\n\n"; 
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, texto);

	}
}
