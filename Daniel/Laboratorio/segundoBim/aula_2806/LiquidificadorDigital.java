package aula_2806;

public class LiquidificadorDigital extends Liquidificador{
	
	public LiquidificadorDigital(int velocidadeMaxima){
		super(velocidadeMaxima);
	}
	
	public void trocaVelocidade(int velocidade){
		if(super.getVelocidadeMaxima() >= velocidade){
			super.velocidade = velocidade;
		}else{
			System.out.println("velocidade informada não pode ser maior que a velocidade maxima");
		}
	}
}
