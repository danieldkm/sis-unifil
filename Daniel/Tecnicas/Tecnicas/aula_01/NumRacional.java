package aula_01;

/*
 * Implemente as funções de subtração, multiplicação e divisão de números racionais.
 * 
 */
public class NumRacional {

	private int numerador;
	private int denominador;

	private double numerador2;
	private double denominador2;

	public NumRacional() {

	}

	public NumRacional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}

	public NumRacional(double numerador2, double denominador2) {
		this.numerador2 = numerador2;
		this.denominador2 = denominador2;
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
				- (a.getNumerador() * this.denominador));
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
		c.setNumerador2((this.numerador2 * d.getDenominador2())
				/ (d.getNumerador2() * this.denominador2));
		c.setDenominador2(this.denominador2 * d.getDenominador2());
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

	public double getNumerador2() {
		return numerador2;
	}

	public void setNumerador2(double numerador2) {
		this.numerador2 = numerador2;
	}

	public double getDenominador2() {
		return denominador2;
	}

	public void setDenominador2(double denominador2) {
		this.denominador2 = denominador2;
	}

	@Override
	public String toString() {
		if (this.numerador2 != 0) {
			return this.numerador2 + "/" + this.denominador2;
		} else {
			if (numerador == denominador) {
				return "1";
			} else if ((numerador % 2) == 0) {
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
				return numerador + "/" + denominador;
				
			}else{
				return this.numerador + "/" + this.denominador;
			}
		}
	}
}
