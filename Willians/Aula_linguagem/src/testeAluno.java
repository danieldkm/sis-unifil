
public class testeAluno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aluno aluno1 = new Aluno();
		aluno1.setNome("B");
		aluno1.setPontuacao(10);
		System.out.println(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("B");
		aluno2.setPontuacao(10);
		
		if(aluno1.equals(aluno2)){
			System.out.println("Alunos iguais");
		}else{
			System.out.println("Alunos diferentes");
		}
		
		
	}

}
