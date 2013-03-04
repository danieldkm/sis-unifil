package aula_01;

public class TesteNumRacional {


	public static void main(String[] args) {
		NumRacional a = new NumRacional(1, 2);
		NumRacional b = new NumRacional(1, 3);
		NumRacional a2 = new NumRacional(1.0, 2.0);
		NumRacional b2 = new NumRacional(1.0, 3.0);
		System.out.println(a);
		System.out.println("Somar: " + a.somar(b));
		System.out.println("Subtrair: " + a.subtracao(b));
		System.out.println("Dividir: " + a2.divisao(b2));
		System.out.println("Multiplicar: " + b.multiplicacao(a));

	}

}
