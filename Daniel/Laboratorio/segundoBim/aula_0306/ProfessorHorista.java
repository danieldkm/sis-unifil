package aula_0306;

public class ProfessorHorista extends Professor {

	private double totalHoras;

	public ProfessorHorista(int matricula, String nome, double salario,
			double totalHotas) {
		// Chamada do construtor da super-classe, extendendo outra classe no caso professor
		super(matricula, nome, salario);
		System.out.println("Execucao no construtor ProfessorHorista");
		this.totalHoras = totalHotas;
	}

	public double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(double totalHoras) {
		this.totalHoras = totalHoras;
	}
	
	public double getSalario(){
		return totalHoras * salario/*salario esta como protegido ou pode usar super.getSalario()*/;
	}

}
