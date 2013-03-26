package ex_21_03;

import javax.swing.JOptionPane;

import aula_01.Aluno;

public class turmaAluno {

	public static void main(String[] args) {
		Turma turma = new Turma("dadada");

		// Aluno aluno1 = new Aluno("daniel");
		// Aluno aluno2 = new Aluno("wilians");
		// Aluno aluno3 = new Aluno("felipe");

		// System.out.println(aluno1);
		// turma.adicionar(aluno1);
		// turma.adicionar(aluno2);
		// turma.adicionar(aluno3);

		int continuar = JOptionPane.YES_OPTION;

		while (continuar == 0) {
			String nome = (JOptionPane
					.showInputDialog("Informe o nome do aluno"));
			Aluno aluno = new Aluno(nome);
			turma.adicionar(aluno);
			turma.adicionar(nome);
			continuar = JOptionPane
					.showConfirmDialog(null, "Deseja continuar?");
		}

		turma.listarAlunos();
		// System.out.println(turma);

		continuar = JOptionPane.showConfirmDialog(null,
				"Deseja informar a nota do aluno?");
		while (continuar == 0) {
			turma.procurarAluno();
			continuar = JOptionPane.showConfirmDialog(null,
					"Deseja informar a nota do aluno?");
		}
		// System.out.println(turma);

		// testando atributo static final
		// System.out.println(turma.getN());
	}

}
