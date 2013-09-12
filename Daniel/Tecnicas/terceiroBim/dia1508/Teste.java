package dia1508;

public class Teste {

	public static void main(String[] args) {
		int[] v = new int[5];

		v[0] = 4;
		v[1] = 20;
		v[2] = 50;
		v[3] = 6;
		v[4] = 1;

		for (int i = 0; i < v.length; i++) {
			if (i == 4) {
				System.out.print(v[i] + "]\n");
			} else if (i == 0) {
				System.out.print("[" + v[i] + " - ");
			} else {
				System.out.print(v[i] + " - ");
			}
		}

		InsertSort bs = new InsertSort();

		int[] ordenado = bs.insertSort(v);

		for (int i = 0; i < ordenado.length; i++) {
			if (i == 4) {
				System.out.print(ordenado[i] + "] ordenar1\n");
			} else if (i == 0) {
				System.out.print("[" + ordenado[i] + " - ");
			} else {
				System.out.print(ordenado[i] + " - ");
			}
		}

		// ------------------------------ Buscar
		// -----------------------------------------------******
		System.out.println("\n Buscar numero");
		Buscando b = new Buscando();
		System.out.println("Busca sequencial: " + b.buscaSequencial(v, 50));
		System.out.println("Busca binaria: " + b.buscaBinaria(v, 6));

	}
}
