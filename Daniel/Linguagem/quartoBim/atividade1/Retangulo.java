package atividade1;

public class Retangulo extends ObjetoGeometrico {

	public Retangulo(int base, int altura) {
		super(base, altura);
	}

	@Override
	public int calcularArea() {
		return super.getD1() * super.getD2();
	}

	@Override
	public int calcularPerimetro() {
		// TODO  2*b+2*h
		return 2 * super.getD1() + 2 * super.getD2();
	}

	@Override
	public String toString() {
		return "Area do Retangulo é:" + calcularArea() + "\nPerimetro do Retangulo é: " + calcularPerimetro();
	}

}
