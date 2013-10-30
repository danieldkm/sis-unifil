package atividade1;

public class Circulo extends ObjetoGeometrico {

	private int centro;
	private int raio;
	
	public Circulo(int x, int y, int centro, int raio) {
		super(x, y);
		this.centro = centro;
		this.raio = raio;
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
	public String toString(){
		return super.toString()+ "\nArea do Circulo é:" + calcularArea() + "\nPerimetro do Circulo é: " + calcularPerimetro();
	}
}
