package aula_1305;

public class Funcao {

	private static final double pi = 3.14 ;
	
	public static double calcularImc(double peso, double altura){
		return peso / (altura * altura);
	}
	
	public static double calcularPerimetro(double raio){
		return 2 * pi * raio;
	}
}