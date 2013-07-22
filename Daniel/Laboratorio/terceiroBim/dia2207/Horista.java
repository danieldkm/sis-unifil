package dia2207;

public class Horista extends Funcionario{
	private float horasTrabalhadas;
	
	public Horista(float horasTrabalhadas, String nome, double salario) {
		super(nome, salario);
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public float getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	
	public void setHorasTrabalhadas(float horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public double getGanhoMensal(){
		return super.getSalario() * horasTrabalhadas;
	}
}
