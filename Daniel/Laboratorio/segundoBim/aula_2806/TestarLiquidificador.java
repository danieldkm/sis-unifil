package aula_2806;

public class TestarLiquidificador {
	public static void main(String[] args) {

		LiquidificadorAnalogico la = new LiquidificadorAnalogico(10);
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();

		System.out.println(la.getVelocidade());
		la.diminuirVelocidade();
		la.diminuirVelocidade();
		System.out.println(la.getVelocidade());

		LiquidificadorDigital ld = new LiquidificadorDigital(10);
		ld.trocaVelocidade(10);
		System.out.println(ld.velocidade);
	}
}
