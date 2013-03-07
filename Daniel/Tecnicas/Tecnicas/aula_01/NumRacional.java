package aula_01;

/*
 * Implemente as funções de subtração, multiplicação e divisão de números racionais.
 * 
 */
public class NumRacional {

	private int numerador;
	private int denominador;

	public NumRacional() {

	}

	public NumRacional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public NumRacional somar(NumRacional a) {
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * a.getDenominador())
				+ (a.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * a.getDenominador());
		return c;
	}

	public NumRacional subtracao(NumRacional s){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * s.getDenominador())
				- (s.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * s.getDenominador());
		return c;
	}
	
	public NumRacional multiplicacao(NumRacional m){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * m.getNumerador()));
		c.setDenominador(this.denominador * m.getDenominador());
		return c;
	}

	public NumRacional divisao(NumRacional d) {
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * d.getDenominador()));
		c.setDenominador(this.denominador * d.getNumerador());
		return c;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	@Override
	public String toString() {
		if((numerador % denominador) == 0){
			return numerador / denominador + "";
		}
		if ((numerador % 2) == 0) {
			while((numerador % 2) == 0 && (denominador % 2) == 0){
				numerador = numerador / 2;
				denominador = denominador / 2;
			}
			while((numerador % 3) == 0 && (denominador % 3) == 0){
				numerador = numerador / 3;
				denominador = denominador / 3;
			}
			while((numerador % 5) == 0 && (denominador % 5) == 0){
				numerador = numerador / 5;
				denominador = denominador / 5;
			}
		}
			
		return this.numerador + "/" + this.denominador;

	}
}
