package atividade1;

public class Circulo extends ObjetoGeometrico {

	public Circulo(int centro, int raio) {
		super(centro, raio);
	}
	
	@Override
	public int calcularArea() {
		return (int) (Math.PI * super.getD1() * super.getD2());
	}
	
	@Override
	public int calcularPerimetro() {
		return (int) (2 * Math.PI * super.getD2());
	}
	
	@Override
	public String toString(){
		return "Area do Circulo é:" + calcularArea() + "\nPerimetro do Circulo é: " + calcularPerimetro();
	}
}
