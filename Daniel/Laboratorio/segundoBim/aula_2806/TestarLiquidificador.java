package aula_2806;

import javax.swing.JOptionPane;

public class TestarLiquidificador {
	public static void main(String[] args) {

		int n = 5;

		LiquidificadorAnalogico la = new LiquidificadorAnalogico(n);
		LiquidificadorDigital ld = new LiquidificadorDigital(n);

		// liquidificador analogico
		int[] nu = new int[5];
		for (int i : nu) {
			la.aumentarVelocidade();
			System.out.println("velocidade atual: " + la.getVelocidade());
			if (la.getVelocidade() == la.getVelocidadeMaxima()) {
				System.out.println("velocidade já esta no máximo");
			}
		}

		for (int i : nu) {
			la.diminuirVelocidade();
			System.out.println("velocidade atual: " + la.getVelocidade());
			if (la.getVelocidade() == 0) {
				System.out.println("velocidade já esta no minimo");
			}
		}



		//
		// //liquidificador digital
		int in;
		for (int i : nu) {
			ld.trocaVelocidade(in = Integer.parseInt(JOptionPane
					.showInputDialog("Trocar a velocidade!!!")));
			System.out.println(ld.velocidade);
			if(in > ld.getVelocidadeMaxima()){
				System.out.println("Maior que velocidade maxima");
			}
		}
	}
}
