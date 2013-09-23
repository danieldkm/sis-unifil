package dia2309;

import dia0909.ValorNegativoException;

/**
 * Classe para objetos do tipo Liquidificador
 * 
 * @author Edson Kaneshima
 * @version 1.0
 * @since Release 01 da aplicação
 */

public class Liquidificador {
	private int velocidade;
	private int velocidadeMaxima;
	private char estado;

	/**
	 * Inicializa a velocidade maxima com valor do parametro
	 * 
	 * @param v
	 *            int - velocidade maxima
	 */

	public Liquidificador(int v) {
		atribuirVelocidadeMaxima(v);
		desligar();
	}

	/**
	 * Inicializa a velocidade maxima com valor 2
	 */

	public Liquidificador() {
		atribuirVelocidadeMaxima(2);
		desligar();
	}

	/**
	 * Método para atribuir a velocidade maxima do liquidificador
	 * 
	 * @param v
	 *            int - velocidade maxima
	 * @return void
	 */

	public void atribuirVelocidadeMaxima(int v) {
		if (v > 0)
			velocidadeMaxima = v;
	}

	/**
	 * Método para atribuir a velocidade do liquidificador
	 * 
	 * @param v
	 *            int - velocidade
	 * @return void
	 */

	public void atribuirVelocidade(int v) {
		if (v >= 0 && v <= velocidadeMaxima && estado == 'l'){
			velocidade = v;
		} else {
			try {
				throw new ValorInvalidoException("Valor invalido");
			} catch (ValorInvalidoException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Método para ligar o liquidificador
	 * 
	 * @return void
	 */

	public void ligar() {
		estado = 'l';
	}

	/**
	 * Método para desligar o liquidificador
	 * 
	 * @return void
	 */
	public void desligar() {
		estado = 'd';
	}

	/**
	 * Método para retorno da velocidade maxima do liquidificador
	 * 
	 * @return int - velocidade maxima
	 */

	public int obterVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	/**
	 * Método para retorno da velocidade do liquidificador
	 * 
	 * @return int - velocidade
	 */

	public int obterVelocidade() {
		return velocidade;
	}

	/**
	 * Método para retorno do estado do liquidificador
	 * 
	 * @return char - estado
	 */

	public char obterEstado() {
		return estado;
	}
}