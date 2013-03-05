package aula_01;

public class testeCorrecao {
	public static void main(String[] args) {
		AlunoCorrecao aluno = new AlunoCorrecao("Jean666");
		String nome = aluno.getNome();
		aluno.setNota(80, 1);
		aluno.setNota(90, 2);
		aluno.setNota(70, 3);
		aluno.setNota(60, 4);
		String situacao = aluno.getSituacao();
		System.out.println(nome + " " + situacao);
	}
}
