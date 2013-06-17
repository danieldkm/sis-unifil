package aula_2806;

public class LiquidificadorAnalogico extends Liquidificador {

	public LiquidificadorAnalogico(int velocidadeMaxima) {
		super(velocidadeMaxima);
	}

	public void aumentarVelocidade() {
//		if (super.getVelocidadeMaxima() > velocidade) {
//			velocidade++;
//		} else {
//			System.out.println("Impossivel, velocidade já está no máximo");
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
		// fazendo a verificação do atributo velocidade maxima
	}
}
