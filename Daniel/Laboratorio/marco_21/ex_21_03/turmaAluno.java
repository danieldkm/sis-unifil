package ex_21_03;

import aula_01.Aluno;

public class turmaAluno {

	public static void main(String[] args) {
		Turma turma = new Turma("dadada");
		
		Aluno aluno1 = new Aluno("daniel");
		Aluno aluno2 = new Aluno("wilians");
		Aluno aluno3 = new Aluno("felipe");
		
//		System.out.println(aluno1);
		turma.adicionar(aluno1);
		turma.adicionar(aluno2);
		turma.adicionar(aluno3);

		turma.listarAlunos();
//		System.out.println(turma);
		
		turma.setN(100);
		System.out.println(turma.getN());
	}

}
