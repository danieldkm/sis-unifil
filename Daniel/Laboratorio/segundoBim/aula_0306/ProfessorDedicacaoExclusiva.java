package aula_0306;

public class ProfessorDedicacaoExclusiva extends Professor {

	public ProfessorDedicacaoExclusiva(int matricula, String nome, int salario) {
		super(matricula, nome, salario);
		System.out.println("Execucao no construtor ProfessorDE");
	}
	
}
