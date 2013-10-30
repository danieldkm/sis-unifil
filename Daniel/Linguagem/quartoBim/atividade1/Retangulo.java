package atividade1;

public class Retangulo extends ObjetoGeometrico {

	private int base;
	private int altura;

	public Retangulo(int x, int y, int base, int altura) {
		super(x, y);
		this.base = base;
		this.altura = altura;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public int calcularArea() {
		return base * altura;
	}

	@Override
	public int calcularPerimetro() {
		// TODO 2*b+2*h
		return 2 * base + 2 * altura;
	}

	@Override
	public String toString() {
		return super.toString() + "\nArea é:" + calcularArea()
				+ "\nPerimetro é: " + calcularPerimetro();
	}

}
