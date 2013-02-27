
public class aluno {

	
	private int exame;
	private int nota[];
	private String nome ="Willians";
	
	
	//Construtores
	public aluno(){
		
	
	}
	
	public aluno(String nome){
		this.nome=nome;
	}
	
	// Metodos
	
	public int ExibExame(){
		
		return exame;
		
	}
	
	public String AlteraNome(){
		return nome;
	
	}
	
	public void AlteraNota (int nota[]){
		this.nota= nota;
		
	}
	
	
	}
