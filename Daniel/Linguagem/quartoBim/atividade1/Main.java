package atividade1;

public class Main {

	public static void main(String[] args) {
		
		Circulo c = new Circulo(10, 10);
//		c.calcularArea();
//		c.calcularPerimetro();
		System.out.println(c);
		
		Retangulo r = new Retangulo(10, 10);
//		r.calcularArea();
//		r.calcularPerimetro();
		System.out.println("\n" + r);
		
		Triangulo t = new Triangulo(10, 10, 10);
//		t.calcularArea();
//		t.calcularPerimetro();
		System.out.println("\n" + t);
		
	}
}
