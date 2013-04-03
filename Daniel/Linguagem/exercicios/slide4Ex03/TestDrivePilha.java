package slide4Ex03;

import javax.swing.JOptionPane;

public class TestDrivePilha {

	public static void main(String[] args) {
//		int tamanho = 5;
//		Pilha p = new Pilha(tamanho);
//		for (int i = 0; i < tamanho; i++) {
//			double elemento = Double.parseDouble(JOptionPane.showInputDialog("Informe o elemento"));
//			System.out.println("elemento " + elemento);
//			p.empilha(elemento);
//		}
//		
////		p.empilha(1.0);
////		p.empilha(3.0);
////		p.empilha(4.0);
//		
//		p.imprimir();
//		p.desenpilha(1.0);
//		
//		System.out.println("Topo    " + p.topo());
//		
//		System.out.println("Vector está cheio? " + p.estaCheia());
//		System.out.println("Vector está vazio? " + p.estaVazia());
//		
//		p.imprimir();
		
		//**------**------**------**------**------**------**------**------**------**------**------**------**------**------
		int tamanho = 5;
		PilhaNormal pn = new PilhaNormal(tamanho);
		for (int i = 0; i < tamanho; i++) {
			double elemento = Double.parseDouble(JOptionPane.showInputDialog("Informe o elemento")); 
			pn.empilha(i, elemento);
		}
		
		pn.desenpilha(1.00);
		
		System.out.println("Topo    " + pn.topo());
		
		System.out.println("Vector está cheio? " + pn.estaCheia());
		System.out.println("Vector está vazio? " + pn.estaVazia());
		
		pn.imprimir();
	}
}
