package aula_01;

import javax.swing.JOptionPane;

public class teste {

	public static void main(String[] args) {
		int confirmDialog = JOptionPane.YES_OPTION;// = 0;
		System.out.println(confirmDialog);
		/*confimeDialog bot�o sim = YES_OPTION, n�o = NO_OPTION, cancelar = CANCEL.OPTION*/
		
		while(confirmDialog == JOptionPane.YES_OPTION/* = 0*/){
			Aluno a = new Aluno();	
			a.setNota();
			a.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
			JOptionPane.showMessageDialog(null, "Aluno: " + a.getNome());
			JOptionPane.showMessageDialog(null, "M�dia: " + a.getMedia());
			if (a.getMedia() > 70) {
				JOptionPane.showMessageDialog(null, "Situa��o: " + a.getSituacao());
			} else {
				JOptionPane.showMessageDialog(null, "Situa��o: " + a.getSituacao());
				a.setExame();
			}
			JOptionPane.showMessageDialog(null, "M�dia final: " + a.getMediaFinal());
			JOptionPane.showMessageDialog(null, "Situa��o: " + a.getSituacao());
			confirmDialog = JOptionPane.showConfirmDialog(null, "Informe o proximo aluno");
		}
	}
}
