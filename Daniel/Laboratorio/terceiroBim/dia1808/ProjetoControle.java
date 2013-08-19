package dia1808;

import javax.swing.JOptionPane;

public class ProjetoControle {
	private Projeto projeto1;
	private Projeto projeto2;

	public void setProjeto(String tipo, String descricao, float custoHora,
			int qtdHora, float custoSuplimento, float custoConsultoria) {
		ProjetoSotware ps = new ProjetoSotware(descricao, custoHora,
				custoSuplimento, custoConsultoria);
		projeto1 = ps;
	}

	public void setProjeto(String tipo, String descricao, float custoHora,
			int qtdHora, float custoComponente, float custoPlaca,
			float custoMecanica, float custoDesign) {
		ProjetoHardware ph = new ProjetoHardware(descricao, custoHora,
				custoComponente, custoPlaca, custoMecanica, custoDesign);
		projeto2 = ph;
	}

	public void exibir(String tipo) {
		if(tipo.toUpperCase().equals("sotware")){
			JOptionPane.showMessageDialog(null, "Descrição: ");
		}
	}

}
