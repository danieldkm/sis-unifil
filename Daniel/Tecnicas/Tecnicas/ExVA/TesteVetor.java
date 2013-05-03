package ExVA;

import javax.swing.JOptionPane;

public class TesteVetor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		VetorAluno lista = new VetorAluno();
//		lista.inicio = new Aluno("a", 1);
//		
//				
//		lista.inicio.proximo = new Aluno("B",2);//exemplo1
////		lista.inicio.proximo = aluno;//exemplo2
//		lista.inicio.proximo.proximo = new Aluno("C",3);//exemplo1
//		lista.inicio.proximo.proximo.proximo = new Aluno("D",4);//exemplo1
//		lista.inicio.proximo.proximo.proximo.proximo = new Aluno("E",5);//exemplo1
		
//		for (int i = 0; i < 3; i++) {
//			lista.adiciona(JOptionPane.showInputDialog("Informe um nome"),Integer.parseInt(JOptionPane.showInputDialog("Informe uma pontuacao")));
//		}
		
		lista.adiciona(new Aluno("a", 1));
		lista.adiciona(new Aluno("b", 2));
		lista.adiciona(new Aluno("c", 3));
		lista.adiciona(new Aluno("d", 4));
		lista.adiciona(new Aluno("e", 5));
		lista.adiciona(new Aluno("f", 6));		
	
		Aluno auxiliar = lista.inicio;
		
		while (auxiliar != null) {
			System.out.println(auxiliar);
			auxiliar = auxiliar.proximo;
		}

//		lista.adiciona("teste", 10, 2);
		System.out.println("mostrar o aluno " + lista.pega(4));
		lista.lista("b");
		System.out.println("qtds de elementos " + lista.getContAluno());
//		lista.remove(1);
		
		lista.remove(new Aluno("a", 1));	
		Aluno auxiliar2 = lista.inicio;
		while (auxiliar2 != null) {
			System.out.println(auxiliar2);
			auxiliar2 = auxiliar2.proximo;
		}
		
		System.out.println("Mostrar Aluno " + lista.procurarAluno(new Aluno("f")));
	}
}

