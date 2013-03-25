package marco_14;



import javax.swing.JOptionPane;


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
		
//		Aluno aluno1 = 	new Aluno("A", 10);
//		Aluno aluno2 = 	new Aluno("B", 10);
//		Aluno aluno3 = 	new Aluno("A", 10);
//		Aluno aluno31 = new Aluno("A", 10);
//		Aluno aluno32 = new Aluno("A3", 10);
//		Aluno aluno33 = new Aluno("A2", 10);
//		Aluno aluno34 = new Aluno("A1", 11);
//		Aluno aluno4 =	new Aluno("B", 10);
//		
//		va.adiciona(aluno1);
//		va.adiciona(aluno2);
//		va.adiciona(aluno3);
//		va.adiciona(aluno31);
//		va.adiciona(aluno32);
//		va.adiciona(aluno33);
//		va.adiciona(aluno34);
//		va.adiciona(aluno4);
//		
//		System.out.println(va);
		
		for (int i = 0; i < 3; i++) {
			Aluno aluno10 = new Aluno(JOptionPane.showInputDialog("Nome: "), Integer.parseInt(JOptionPane.showInputDialog("Valor: ")));
			va.adiciona(aluno10);
		}
		
		System.out.println(va);
		
		va.adiciona(4, new Aluno("A", 3));
		System.out.println(va);
		
		va.adiciona(9, new Aluno("posicao10", 10000));
		
//		va.remove(2);
//		System.out.println(va);
		
		if (va.isEmpty()) {
			System.out.println("Lista Vazia");
		}else{
			System.out.println("Lista não vazia, contém " + va.getContAluno() + " Alunos");
		}
		
//		va.organizar();
//		
//		System.out.println("Organizado " + va);
		
		System.out.println("Contém o elemento " + va.contem(new Aluno("daniel", 10)));
		
	}
}
