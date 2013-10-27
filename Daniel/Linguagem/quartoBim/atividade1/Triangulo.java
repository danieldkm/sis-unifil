package atividade1;

public class Triangulo extends ObjetoGeometrico {

	private int d3;
	
	public Triangulo(int d1, int d2, int d3) {
		super(d1, d2);
		this.d3 = d3;
	}

	@Override
	public int calcularArea() {
		// TODO Math.sqrt(s*(s-a)*(s-b)*(s-c))
		int s = calcularPerimetro() / 2;// metade de um triangulo
		return (int) Math.sqrt(s * (s - super.getD1()) * (s - super.getD2()) * (s - getD3()));
	}
	
	@Override
	public int calcularPerimetro() {
		// TODO (a+b+c)
		return super.getD1() + super.getD2() + getD3();
	}
	
	@Override
	public String toString() {
		return "Area do Triangulo é:" + calcularArea() + "\nPerimetro do Triangulo é: " + calcularPerimetro();
	}

	public int getD3() {
		return d3;
	}

	public void setD3(int d3) {
		this.d3 = d3;
	}
	
	
}
