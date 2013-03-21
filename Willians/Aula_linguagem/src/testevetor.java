import javax.swing.JOptionPane;

public class testevetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		VetorAluno a1 = new VetorAluno();
		
		for (int i = 0; i < 3; i++) {

			Aluno a = new Aluno(JOptionPane.showInputDialog("Informe o nome:"), 
						Integer.parseInt(JOptionPane.showInputDialog( "Nota")));
			       a1.adiciona(a);
		
			       
			}
		System.out.println(a1);
		
		if (a1.isEmpty()) {
			System.out.println("Lista Vazia");
		} else {

			System.out.println("Lista não Vazia");
		}

	}

}
