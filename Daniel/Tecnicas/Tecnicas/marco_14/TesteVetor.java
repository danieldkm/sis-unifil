package marco_14;

public class TesteVetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VetorAluno va = new VetorAluno();

		if (va.isEmpty()) {
			System.out.println("Lista Vazia");
		}else{
			System.out.println("Lista não vazia");
		}
		
		Aluno aluno1 = new Aluno("A", 10);
		Aluno aluno2 = new Aluno("B", 10);
		Aluno aluno3 = new Aluno("A", 10);
		Aluno aluno31 = new Aluno("A", 10);
		Aluno aluno32 = new Aluno("A", 10);
		Aluno aluno33 = new Aluno("A", 10);
		Aluno aluno34 = new Aluno("A", 10);
		Aluno aluno4 = new Aluno("B", 10);
		
		va.adiciona(aluno1);
		va.adiciona(aluno2);
		va.adiciona(aluno3);
		va.adiciona(aluno31);
		va.adiciona(aluno32);
		va.adiciona(aluno33);
		va.adiciona(aluno34);
		va.adiciona(aluno4);
		
		System.out.println(va);
		
		
		if (va.isEmpty()) {
			System.out.println("Lista Vazia");
		}else{
			System.out.println("Lista não vazia, contém " + va.getContAluno() + " Alunos");
		}
	}

}
