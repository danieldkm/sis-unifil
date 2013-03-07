

public class TesteNumRacional {


	public static void main(String[] args) {
		NumRacional a = new NumRacional(1,2);
		NumRacional b = new NumRacional(1,3);
		
		System.out.println(a.somar(b));
		
		System.out.println(a.subtrair(b));
		
		System.out.println(a.dividir(b));
		
		System.out.println(a.multiplicar(b));
		
		
	}

}
