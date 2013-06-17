package aula_2806;

public class LiquidificadorAnalogico extends Liquidificador {

	public LiquidificadorAnalogico(int velocidadeMaxima) {
		super(velocidadeMaxima);
	}

	public void aumentarVelocidade() {
//		if (super.getVelocidadeMaxima() > velocidade) {
//			velocidade++;
//		} else {
//			System.out.println("Impossivel, velocidade j� est� no m�ximo");
//		}
		setVelocidade(velocidade + 1);
	}

	public void diminuirVelocidade() {
		if (velocidade > 0) {
			velocidade--;
//		} else {
//			System.out.println("Impossivel, velocidade ja esta no zero");
		}
		// ou setVelocidade(velocidade - 1); // na classe liquidificador ja esta
		// fazendo a verifica��o do atributo velocidade maxima
	}
}
