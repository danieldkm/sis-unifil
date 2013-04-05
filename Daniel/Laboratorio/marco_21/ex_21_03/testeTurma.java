package ex_21_03;

import javax.swing.JOptionPane;

import aula_01.Aluno;

public class testeTurma {

	public static void main(String[] args) {
		Turma turma = new Turma("Sis");
		
//		turma.setNomeTurma(JOptionPane.showInputDialog("Turma"));
//		turma.setNomeTurno(JOptionPane.showInputDialog("Turno"));
//		JOptionPane.showMessageDialog(null, turma.getNomeTurma());
//		JOptionPane.showMessageDialog(null, turma.getNomeTurno());

//		int n = JOptionPane.YES_OPTION;
//		
//		while(n == JOptionPane.YES_OPTION){
//			turma.adicionar(JOptionPane.showInputDialog("Nome do Aluno"));
//			n = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
//		}
//		
//		n = JOptionPane.YES_OPTION;
//		
//		while(n == JOptionPane.YES_OPTION){
//			turma.cancelarMatricula(JOptionPane.showInputDialog("Informe o aluno a ser excluido/cancelando"));
//			n = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
//		}
//		
//		turma.quantidadeAlunos();
//		turma.listarAlunos();
		
		
		
//		////FOrma 1********************************
//		turma.adicionar("jose");
//		turma.adicionar("Maria");
//		turma.adicionar("joao");
//		turma.adicionar("joaquin");
//		
//		turma.listar2();
////		turma.listar();
//		
//		Aluno alunoGet = turma.getAluno("Maria");
////		turma.getAluno("Maria");
//		
//		System.out.println(alunoGet.getNome());
//		String s = alunoGet.getNome();
//		
//		if(turma.cancelar(s)){
//			System.out.println("Aluno removido");
//		}else{
//			System.out.println("Problema na remocao");
//		}		
//		turma.listar2();
		
		
//		////FOrma 2********************************
		turma.adicionar(new Aluno("jose"));
		turma.adicionar(new Aluno("Maria"));
		turma.adicionar(new Aluno("joao"));
		turma.adicionar(new Aluno("joaquin"));
		
		turma.listar2();
//		turma.listar();
		
		Aluno alunoGet = turma.getAluno("Maria");
//		turma.getAluno("Maria");
		
		System.out.println("Remover Aluno " + alunoGet.getNome());
		
		if(turma.cancelar(alunoGet)){
			System.out.println("Aluno removido");
		}else{
			System.out.println("Problema na remocao");
		}		
		turma.listar2();
	}

}
