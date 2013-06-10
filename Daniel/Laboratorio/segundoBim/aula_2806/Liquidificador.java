package aula_2806;

public class Liquidificador {

	private int velocidadeMaxima;
	protected int velocidade;

	public Liquidificador(int velocidadeMaxima) {
//		this.velocidadeMaxima = velocidadeMaxima;
		setVelocidadeMaxima(velocidadeMaxima);
	}

	public int getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	protected void setVelocidadeMaxima(int velocidadeMaxima) {
		if (velocidadeMaxima > 0) {
			this.velocidadeMaxima = velocidadeMaxima;
			/*
			 * }else{ System.out.println("velocidade maxima é < ou = a 0");
			 */
		}
	}

	public int getVelocidade() {
		return velocidade;
	}

	protected void setVelocidade(int velocidade) {
		if (velocidade <= this.velocidadeMaxima && velocidade >= 0) {
			this.velocidade = velocidade;
			/*
			 * }else{ System.out.println(
			 * "velocidade não pode ser mais que velocidade maxima");
			 */
		}
	}

}
