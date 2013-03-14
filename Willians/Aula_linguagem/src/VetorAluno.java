import java.util.Arrays;


public class VetorAluno {
	
	public int contAluno = 0;

	private static int tamanho_vetor = 10;
	
	private Aluno[] alunos = new Aluno[tamanho_vetor];

	public void adiciona(Aluno aluno){
	
		int aux = 0;
		for(int i=0; i< tamanho_vetor; i++){
			if (alunos[i] == null){
				alunos[i] = aluno;
		}
			
	}
	
	}

	
	public void adiciona(int posicao, Aluno aluno) {
		// implementação
	}

	public Aluno pega(int posicao) {
		return null;
		// implementação
	}
	
	public void remove(int posicao) {
		// implementação
	}
	
	public boolean contem(Aluno aluno) {
		return false;
		// implementação
	}
	
	
	
	public int tamanho() {
		return 0;
		// implementação
	}
	
	// imprimir tudo que está dentro do objeto
	public String toString() {
		return Arrays.toString(alunos);
	}
	
	//metodo para verificar se está vazio
	
	public boolean isEmpty(){
		if(contAluno==0){
			return true; 
		}else{ 
			return false;
		}
	}
	
}


