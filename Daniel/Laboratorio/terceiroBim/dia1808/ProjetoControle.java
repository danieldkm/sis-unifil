package dia1808;

import javax.swing.JOptionPane;

public class ProjetoControle {

	private Projeto[] projetos = new Projeto[10];
	private int aux;

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

	public int qtdHoras(String descricao,int horas ) {
		for (int i = 0; i < projetos.length; i++) {
			if (projetos[i].getDescricao().equals(descricao)) {
				projetos[i].registrarHora(horas);
				return projetos[i].getQtdHora();
			}
		}
		return -1;
	}

	public float exibirCustoAtual(String tipo) {
		for (int i = 0; i < projetos.length; i++) {
			if (projetos[i].getDescricao().equals(tipo)) {
				// JOptionPane.showMessageDialog(
				// null,
				// "Custo Atual desse projeto é de: \n"
				// + projetos[i].custoAtual());
				return projetos[i].custoAtual();
			}
		}
		return -1;
	}

	public void exibirProjetos() {
		for (int i = 0; i < projetos.length; i++) {
			JOptionPane.showMessageDialog(
					null,
					"Custo: " + projetos[i].getCustoHora()
							+ "\nHoras trabalhadas: "
							+ projetos[i].getQtdHora() + "\nCusto Atual: "
							+ +projetos[i].custoAtual()
							+ "\nDescrição / Tipo Projeto: "
							+ projetos[i].getDescricao());
		}
	}

}
