
public class testevetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VetorAluno aluno3 = new VetorAluno();
		
		if(aluno3.isEmpty()){
			System.out.println("Lista Vazia");
		}else{
			System.out.println("Lista não Vazia");
		}
		
		
		Aluno aluno1 = new Aluno ("A", 20);
		
		
		aluno3.adiciona(aluno1);
		
		System.out.println(aluno3);
		
	}

}
