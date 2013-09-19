package mergeSort;


public class teste {

	public static void main(String[] args) {
		int[] v = new int[5];
		int[] v2 = new int[5];

		v[0] = 1;
		v[1] = 20;
		v[2] = 50;
		v[3] = 6;
		v[4] = 0;
		v2[0] = 11;
		v2[1] = 12;
		v2[2] = 13;
		v2[3] = 9;
		v2[4] = 7;
		for (int i = 0; i < v.length; i++) {
			if (i == 4) {
				System.out.print(v[i] + "]\n");
			} else if (i == 0) {
				System.out.print("[" + v[i] + " - ");
			} else {
				System.out.print(v[i] + " - ");
			}
		}
		
		MergeSort bs = new MergeSort();

		int[] ordenado = bs.sort(v);

		for (int i = 0; i < ordenado.length; i++) {
			if (i == 4) {
				System.out.print(ordenado[i] + "] ordenar\n");
			} else if (i == 0) {
				System.out.print("[" + ordenado[i] + " - ");
			} else {
				System.out.print(ordenado[i] + " - ");
			}
		}
		
		int[] ordenado2 = bs.sort(v2);

		for (int i = 0; i < ordenado2.length; i++) {
			if (i == 4) {
				System.out.print(ordenado2[i] + "] ordenar2\n");
			} else if (i == 0) {
				System.out.print("[" + ordenado2[i] + " - ");
			} else {
				System.out.print(ordenado2[i] + " - ");
			}
		}
		
		
	}

}
