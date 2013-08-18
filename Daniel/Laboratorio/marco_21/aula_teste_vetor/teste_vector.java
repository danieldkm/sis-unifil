package aula_teste_vetor;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JOptionPane;

public class teste_vector {
	public static void main(String[] args) {
		// Vector v = new Vector();
		// v.addElement("a");
		// v.addElement("b");
		// v.addElement("c");
		// v.addElement("d");
		// v.addElement("daniel");
		// // v.removeElement("a");
		// System.out.println(v.firstElement());//mostra o primeiro elemento
		// System.out.println(v.lastElement());//mostra o ultimo elemento
		// System.out.println(v.isEmpty()); // verificar se esta vazio se sim
		// retorno true
		// System.out.println(v.contains("daniel")); // procura exatamento a
		// palavra no vector
		// System.out.println(v.indexOf("daniel"));//mostra o indice do elemento
		// desejado
		// System.out.println(v.size());// mostra o tamanho atual do vector
		// System.out.println(v.capacity());// mostra a capacidade de indices do
		// vetctor
		// v.trimToSize();//reduz a capacidade do vetor para o tamanho atual ***
		// size()
		// System.out.println(v.capacity());
		//
		//
		// System.out.println("--------------------------");
		// Enumeration enume = v.elements();
		// System.out.println(enume.nextElement());// mostra o próximo elemento
		// System.out.println(enume.hasMoreElements());// mostra a quantidade de
		// elementos

		/*
		 * 　Escreva um programa em java que simule exatamente a saída :　 Entre
		 * com esses dados, utilize “sair” para encerrar o programa: 　　 maçã 　　
		 * laranja 　　 banana uva 　　 limão 　　 sair 　　
		 * 
		 * Numero de linhas: 5
		 * 
		 * 　　 Linhas em ordem inversa: 　　
		 * 
		 * limão 　　 uva 　　 banana laranja 　　 maça
		 */

		Vector vetor = new Vector();
		Enumeration enume = vetor.elements();
		JOptionPane
				.showMessageDialog(null,
						"Entre com esses dados, utilize “sair” para encerrar o programa:");
		System.out.println("Entre com esses dados, utilize “sair” para encerrar o programa:");
		for (int i = 0; i < 10000; i++) {
			vetor.addElement(JOptionPane.showInputDialog(""));
			System.out.println(enume.nextElement());
			if (vetor.contains("sair")) {
				break;
			}
		}
		vetor.removeElement(vetor.lastElement());
		JOptionPane
				.showMessageDialog(null, "Número de linhas: " + vetor.size());
		System.out.println("Número de linhas: " + vetor.size());
		JOptionPane.showMessageDialog(null, "Linhas em ordem inversa: ");
		System.out.println("Linhas em ordem inversa: ");
		
		for (int i = 0; i < vetor.capacity(); i++) {
//			System.out.println(vetor.size() + " i " + i);
			try {
				JOptionPane.showMessageDialog(null, vetor.lastElement());
				System.out.println(vetor.lastElement());
				vetor.remove(vetor.lastElement());
				
			} catch (Exception e) {
				System.out.println("Acabou elementos do vector");
				vetor.trimToSize();
			}
		}
	}
}
