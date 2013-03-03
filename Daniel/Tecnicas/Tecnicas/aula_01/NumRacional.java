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
		c.setNumerador((this.numerador * a.getDenominador()) + (a.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * a.getDenominador());
		System.out.println(c);
		return c;
	}
	
	public NumRacional subtracao(NumRacional s){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * s.getDenominador()) - (s.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * s.getDenominador());
		return c;
	}
	
	public NumRacional divisao(NumRacional d){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * d.getDenominador()) / (d.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * d.getDenominador());
		return c;
	}
	
	public NumRacional multiplicacao(NumRacional m){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * m.getDenominador()) * (m.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * m.getDenominador());
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
		return this.numerador + "/" + this.denominador;
	}

}
