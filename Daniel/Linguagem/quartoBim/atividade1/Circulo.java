package atividade1;

public class Circulo extends ObjetoGeometrico {

	private int centro;
	private int raio;
	private int z;
	private Ponto2D p2D;

	public Circulo(int x, int y, int centro, int raio) {
		super(x, y);
		this.centro = centro;
		this.raio = raio;
	}

	public Circulo(Ponto2D _2D, int z) {
		p2D = _2D;
		this.z = z;
	}

	@Override
	public int calcularArea() {
		return (int) (Math.PI * centro * raio);
	}

	@Override
	public int calcularPerimetro() {
		return (int) (2 * Math.PI * raio);
	}

	@Override
	public String toString() {
		return super.toString() + "\nArea do Circulo é:" + calcularArea()
				+ "\nPerimetro do Circulo é: " + calcularPerimetro();
	}
}
