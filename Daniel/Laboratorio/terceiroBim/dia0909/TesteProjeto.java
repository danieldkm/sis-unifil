package dia0909;

public class TesteProjeto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Projeto p = new Projeto("Unifil", 10f);

		System.out.println(p.getCustoHora());
		try {
			p.setCustoHora(-20);
		} catch (ValorNegativoException e) {
			System.out.println(e.getMessage());
			System.out.println("Custo não atualizado, valor negativo");
		}
		System.out.println(p.getCustoHora());

		try {
			double resultado = 20 / 0;
			System.out.println(resultado);
		} catch (ArithmeticException e) {
			System.out.println("divisao por zero");
		}

		try {
			int a[] = new int[5];
			a[10] = 10;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("erro: " + e.getMessage());
		}

	}

}
