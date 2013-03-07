package aula_01;

public class TesteNumRacional {


	public static void main(String[] args) {
		NumRacional a = new NumRacional(1, 2);
		NumRacional b = new NumRacional(1, 3);

		System.out.println("Somar: " + a.somar(b));
		System.out.println("Subtrair: " + a.subtracao(b));
		System.out.println("Dividir: " + a.divisao(b));
		System.out.println("Multiplicar: " + b.multiplicacao(a));

	}

}
