package atividade1;

public class Triangulo extends Retangulo {

	private int lado3;
	
	public Triangulo(int x, int y, int d1, int d2, int d3) {
		super(x, y, d1, d2);
		this.lado3 = d3;
	}

	@Override
	public int calcularArea() {
		// TODO Math.sqrt(s*(s-a)*(s-b)*(s-c))
		int s = calcularPerimetro() / 2;// metade de um triangulo
		return (int) Math.sqrt(s * (s - super.getBase()) * (s - super.getAltura()) * (s - getLado3()));
	}
	
	@Override
	public int calcularPerimetro() {
		// TODO (a+b+c)
		return super.getBase() + super.getAltura() + getLado3();
	}
	
	@Override
	public String toString() {
		return super.toString() ;
	}/*"Area do Triangulo é:" + calcularArea() + "\nPerimetro do Triangulo é: " + calcularPerimetro()*/

	public int getLado3() {
		return lado3;
	}

	public void setD3(int d3) {
		this.lado3 = d3;
	}
	
	
}
