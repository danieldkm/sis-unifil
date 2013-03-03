package aula_01;

import javax.swing.JOptionPane;

public class teste {

	public static void main(String[] args) {
		int confirmDialog = JOptionPane.YES_OPTION;// = 0;
		System.out.println(confirmDialog);
		/*confimeDialog botão sim = YES_OPTION, não = NO_OPTION, cancelar = CANCEL.OPTION*/
		
		while(confirmDialog == JOptionPane.YES_OPTION/* = 0*/){
			Aluno a = new Aluno();	
			a.setNota();
			a.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
			JOptionPane.showMessageDialog(null, "Aluno: " + a.getNome());
			JOptionPane.showMessageDialog(null, "Média: " + a.getMedia());
			if (a.getMedia() > 70) {
				JOptionPane.showMessageDialog(null, "Situação: " + a.getSituacao());
			} else {
				JOptionPane.showMessageDialog(null, "Situação: " + a.getSituacao());
				a.setExame();
			}
			JOptionPane.showMessageDialog(null, "Média final: " + a.getMediaFinal());
			JOptionPane.showMessageDialog(null, "Situação: " + a.getSituacao());
			confirmDialog = JOptionPane.showConfirmDialog(null, "Informe o proximo aluno");
		}
	}
}
