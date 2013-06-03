package aula_0306;

public class TesteProfessor {

	public static void main(String[] args) {
		ProfessorHorista ph = new ProfessorHorista(01, "Daniel", 20, 40);
		
		ph.setIdade(300);
		System.out.println("Matricula " + ph.getMatricula() + 
							"\nNome " + ph.getNome() + 
							"\nSalario " + ph.getSalario() + 
							"\nIdade " + ph.getIdade() + 
							"\nTotal de horas " + ph.getTotalHoras() + "\n\n\n");
		
		ProfessorDedicacaoExclusiva pde = new ProfessorDedicacaoExclusiva(01, "Daniel", 20);
		
		pde.setIdade(30);
		System.out.println("Matricula " + pde.getMatricula() + 
							"\nNome " + pde.getNome() + 
							"\nSalario " + pde.getSalario() + 
							"\nIdade " + pde.getIdade());
		
		
	}

}
