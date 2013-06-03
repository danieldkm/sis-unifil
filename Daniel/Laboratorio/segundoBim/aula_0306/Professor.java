package aula_0306;

public class Professor{

	private String nome;
	private int matricula;
	protected int idade;
	private double salario;
	
	public Professor(int matricula, String nome, double salario) {
		System.out.println("Execucao no construtor Professor");
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
	}

	// get and set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
