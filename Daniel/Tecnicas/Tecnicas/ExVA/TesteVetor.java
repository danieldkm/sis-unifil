package ExVA;

import java.util.Vector;

import javax.swing.JOptionPane;

import abril_05.ListaDinamica;
import abril_05.NodeAluno;


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
		
		for (int i = 0; i < 3; i++) {
			lista.adiciona(JOptionPane.showInputDialog("Informa um nome"),Integer.parseInt(JOptionPane.showInputDialog("Informe uma pontuacao")));
		}
		
		Aluno auxiliar = lista.inicio;
		
		while (/*auxiliar.proximo != null ||*/ auxiliar != null) {
			System.out.println(auxiliar);
			auxiliar = auxiliar.proximo;
		}
		System.out.println(auxiliar);
		
	}
}
