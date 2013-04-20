package abril_20;


import javax.swing.JOptionPane;

public class testando {

	public static void main(String[] args) {
		int vetor[] = new int[5];

//		for (int i = 0; i < vetor.length; i++) {
//			vetor[i] = Integer.parseInt(JOptionPane
//					.showInputDialog("Informe o número"));
//		}

		ordenacao ord = new ordenacao();
		System.out.println("bubble");
		vetor[0] = 2;
		vetor[1] = 5;
		vetor[2] = 3;
		vetor[3] = 1;
		vetor[4] = 4;
		ord.bubble(vetor, 4);

		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		
		System.out.println("\n\n\ninsert");
		vetor[0] = 2;
		vetor[1] = 5;
		vetor[2] = 3;
		vetor[3] = 1;
		vetor[4] = 4;
		ord.inserction(vetor, 5);

		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		
		System.out.println("\n\n\nselect");
		vetor[0] = 2;
		vetor[1] = 5;
		vetor[2] = 3;
		vetor[3] = 1;
		vetor[4] = 4;
		ord.selection(vetor, 4);

		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}

	}

}
