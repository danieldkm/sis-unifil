import javax.swing.JOptionPane;


public class testeAluno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Aluno a = new Aluno();
		

		
		a.getNome();
		a.setNota(90, 2);
		System.out.println(a.getMediaAnual());
		System.out.println(a.getSituacao());
		
		
	}

}
