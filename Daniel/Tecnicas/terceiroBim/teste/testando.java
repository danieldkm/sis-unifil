package teste;


public class testando {

	public static void main(String[] args) {
		int[] v = new int[5];
		int[] v2 = new int[5];
		System.out.println(v.length);
		v[0] = 1;
		v[1] = 3;
		v[2] = 5;
		v[3] = 2;
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
		
		Bolha b = new Bolha();

		int[] ordenado = b.bulha(v);

		for (int i = 0; i < ordenado.length; i++) {
			if (i == 4) {
				System.out.print(ordenado[i] + "] Bolha\n");
			} else if (i == 0) {
				System.out.print("[" + ordenado[i] + " - ");
			} else {
				System.out.print(ordenado[i] + " - ");
			}
		}
		
		Selecionar s = new Selecionar();
		int[] ordenado2 = s.select(v);

		for (int i = 0; i < ordenado2.length; i++) {
			if (i == 4) {
				System.out.print(ordenado2[i] + "] Selecionar\n");
			} else if (i == 0) {
				System.out.print("[" + ordenado2[i] + " - ");
			} else {
				System.out.print(ordenado2[i] + " - ");
			}
		}
		
		INserir in = new INserir();
		int[] ordenado3 = in.insert(v);

		for (int i = 0; i < ordenado3.length; i++) {
			if (i == 4) {
				System.out.print(ordenado3[i] + "] Inserir\n");
			} else if (i == 0) {
				System.out.print("[" + ordenado3[i] + " - ");
			} else {
				System.out.print(ordenado3[i] + " - ");
			}
		}

	}

}
