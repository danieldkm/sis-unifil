package slide4Ex03;

import javax.swing.JOptionPane;

public class TestDrivePilha {

	public static void main(String[] args) {
		int tamanho = 5;
		Pilha p = new Pilha(tamanho);
		for (int i = 0; i < tamanho; i++) {
			double elemento = Double.parseDouble(JOptionPane.showInputDialog("Informe o elemento"));
			p.empilha(elemento);
		}
		
		p.desenpilha(1.00);
		
		System.out.println("Topo    " + p.topo());
		
		System.out.println("Vector está cheio? " + p.estaCheia());
		System.out.println("Vector está vazio? " + p.estaVazia());
		
		p.imprimir();
		
		//**------**------**------**------**------**------**------**------**------**------**------**------**------**------
//		int tamanho = 5;
//		PilhaNormal pn = new PilhaNormal(tamanho);
//		for (int i = 0; i < tamanho; i++) {
//			double elemento = Double.parseDouble(JOptionPane.showInputDialog("Informe o elemento")); 
//			pn.empilha(i, elemento);
//		}
//		
//		pn.desenpilha(1.00);
//		
//		System.out.println("Topo    " + pn.topo());
//		
//		System.out.println("Vector está cheio? " + pn.estaCheia());
//		System.out.println("Vector está vazio? " + pn.estaVazia());
//		
//		pn.imprimir();
	}
}
