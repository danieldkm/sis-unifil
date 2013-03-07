

public class NumRacional {

	private int numerador;
	private int denominador;
	
	public NumRacional() {
		
	}
	
	public NumRacional(int numerador, int denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public NumRacional somar(NumRacional a){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * a.getDenominador()) + (a.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * a.getDenominador());
		System.out.println(c);
		return c;
	}
	
	public NumRacional subtrair(NumRacional a){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * a.getDenominador()) - (a.getNumerador() * this.denominador));
		c.setDenominador(this.denominador * a.getDenominador());
		System.out.println(c);
		return c;
		
	}
	
	public NumRacional dividir(NumRacional a){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * a.getDenominador()));
		c.setDenominador(this.denominador *this.numerador);
		System.out.println(c);
		return c;
	}
	public NumRacional multiplicar(NumRacional a){
		NumRacional c = new NumRacional();
		c.setNumerador((this.numerador * a.getNumerador() ));
		c.setDenominador(this.denominador * a.getDenominador());
		System.out.println(c);
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
