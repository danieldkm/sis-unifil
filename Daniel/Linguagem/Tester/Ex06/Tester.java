package Ex06;


public class Tester {

	public static void main(String[] args) {
		//milha para metro
		double aux = ConversaoDeUnidadesDeArea.milhaQuadradoAcre(1);
		double n = aux;
		System.out.println("n " + n + " aux " + aux);
		aux = ConversaoDeUnidadesDeArea.acreQuadradoPes(n);
		n = aux;
		System.out.println("n " + n + " aux " + aux);
		aux = ConversaoDeUnidadesDeArea.pesQuadradoCentimetro(n);
		System.out.println("n " + n + " aux " + aux);
		System.out.println(aux);
		System.out.println(aux / 1000);
	}

}
