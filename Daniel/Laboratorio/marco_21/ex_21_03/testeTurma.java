package ex_21_03;

import javax.swing.JOptionPane;

public class testeTurma {

	public static void main(String[] args) {
		Turma turma = new Turma("Sis");
		
//		turma.setNomeTurma(JOptionPane.showInputDialog("Turma"));
//		turma.setNomeTurno(JOptionPane.showInputDialog("Turno"));
//		JOptionPane.showMessageDialog(null, turma.getNomeTurma());
//		JOptionPane.showMessageDialog(null, turma.getNomeTurno());

		int n = JOptionPane.YES_OPTION;
		
		while(n == JOptionPane.YES_OPTION){
			turma.adicionar(JOptionPane.showInputDialog("Nome do Aluno"));
			n = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		}
		
		n = JOptionPane.YES_OPTION;
		
		while(n == JOptionPane.YES_OPTION){
			turma.cancelarMatricula(JOptionPane.showInputDialog("Informe o aluno a ser excluido/cancelando"));
			n = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		}
		
		turma.quantidadeAlunos();
		turma.listarAlunos();
		
	}

}
