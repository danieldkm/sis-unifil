package aula_2806;

public class TestarLiquidificador {
	public static void main(String[] args) {

		int n = 5;
		
		LiquidificadorAnalogico la = new LiquidificadorAnalogico(n);
		LiquidificadorDigital ld = new LiquidificadorDigital(n);
		
		//liquidificador analogico
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		la.aumentarVelocidade();
		System.out.println(la.getVelocidade());
//		la.diminuirVelocidade();
		la.diminuirVelocidade();
		System.out.println(la.getVelocidade());
		
		//liquidificador digital
		ld.trocaVelocidade(6);
		ld.trocaVelocidade(5);
		System.out.println(ld.velocidade);
	}
}
