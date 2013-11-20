package atividade1;

public class Retangulo extends ObjetoGeometrico {

	private int base;
	private int altura;
	private Ponto2D p2D_1;
	private Ponto2D p2D_2;
	
	public Retangulo(int x, int y, int base, int altura) {
		super(x, y);
		this.base = base;
		this.altura = altura;
	}
	
	public Retangulo(Ponto2D _2D_1, Ponto2D _2D_2) {
		p2D_1 = _2D_1;
		p2D_2 = _2D_2;
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
