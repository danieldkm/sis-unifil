package slide2;

public class Hobbits {
	String name;

	public static void main(String[] args) {
		Hobbits[] h = new Hobbits[4];// alterar o tamanho do vetor de 3 para 4
		int z = 0;

		while (z < 3) {// alterar z < 4 para z < 3
			z = z + 1;
			h[z] = new Hobbits();
			h[z].name = "bilbo";

			if (z == 1) {
				h[z].name = "frodo";
			}
			if (z == 2) {
				h[z].name = "sam";
			}
			System.out.println(h[z].name + " is a ");
			System.out.println("good Hobbit name");
		}
	}

}
