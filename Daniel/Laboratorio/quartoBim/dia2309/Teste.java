package dia2309;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.IfInstruction;

public class Teste {

	private int A;
	private int B;

	public Teste(int a, int b) {
		A = a;
		B = b;
	}

	public int getA() {
		return A;
	}

	public int getB() {
		return B;
	}

	public static void main(String[] args) {
//		Teste t = new Teste(Integer.parseInt(JOptionPane
//				.showInputDialog("Informe o valor de A")),
//				Integer.parseInt(JOptionPane
//						.showInputDialog("Informe o valor de B")));
//		int A = t.getA();
//		int B = t.getB();
//		int n = 0;
//		try {
//			String resultado = "" + (A / B);
//			n = Integer.parseInt(resultado);
//		} catch (NumberFormatException e2) {
//			System.err.println("Erro -> converter String para int");
//			e2.printStackTrace();
//		} catch (ArithmeticException e) {
//			System.err.println("Erro -> Divisao por zero");
//			e.printStackTrace();
//		} finally{
//			System.out.println("valor " + n);
//		}
		
		Liquidificador l = new Liquidificador();
		l.atribuirVelocidade(10);

	}

}
