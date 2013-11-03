package a;


public class teste {

	public static void main(String[] args) {
//		int[] v = new int[5];
//
//		v[0] = 0;
//		v[1] = 0;
//		v[2] = 1;
//		v[3] = 1;
//		v[4] = 2;
//		for (int i = 0; i < v.length; i++) {
//			if (i == 4) {
//				System.out.print(v[i] + "]\n");
//			} else if (i == 0) {
//				System.out.print("[" + v[i] + " - ");
//			} else {
//				System.out.print(v[i] + " - ");
//			}
//		}
//
//		Ordenar bs = new Ordenar();
////
//		int[] ordenado = bs.ordenar(v);
////
//		for (int i = 0; i < ordenado.length; i++) {
//			if (i == 4) {
//				System.out.print(ordenado[i] + "] ordenar1\n");
//			} else if (i == 0) {
//				System.out.print("[" + ordenado[i] + " - ");
//			} else {
//				System.out.print(ordenado[i] + " - ");
//			}
//		}
//		
//		
//		int[] ordenado2 = bs.ordenar2();
//
//		for (int i = 0; i < ordenado2.length; i++) {
//			if (i == 4) {
//				System.out.print(ordenado2[i] + "] ordenar2\n");
//			} else if (i == 0) {
//				System.out.print("[" + ordenado2[i] + " - ");
//			} else {
//				System.out.print(ordenado2[i] + " - ");
//			}
//		}
		
		
		int[] n1 = {1001,2002,3003,4004,5005};
		int[] n2 = {2,3,0,1,4};
				
		/*1001 = 2
		 *2002 = 3 
		 *3003 = 0 
		 *4004 = 1 
		 *5005 = 4 
		 * **/
		Ordenar ordenar = new Ordenar(n1.length);
		n2 = ordenar.ordenar(n2);
		for (int i = 0; i < n2.length; i++) {
			if (i == 4) {
				System.out.print(n2[i] + "] ordenar2\n");
			} else if (i == 0) {
				System.out.print("[" + n2[i] + " - ");
			} else {
				System.out.print(n2[i] + " - ");
			}
			
		}
		
		int[] corrigir = ordenar.getOrdenar();
		int correcao = 0;
		for (int j2 = 0; j2 < corrigir.length; j2++) {
			if (corrigir[j2] != j2) {
				for (int k = j2 + 1; k < corrigir.length; k++) {
					if(corrigir[k] == j2){
						correcao = corrigir[j2];
						corrigir[j2] = corrigir[k];
						corrigir[k] = correcao;
						correcao = n1[j2];
						n1[j2] = n1[k];
						n1[k] = correcao;
					}
				}
			}
		}
		for (int i = 0; i < n1.length; i++) {
			if (i == 4) {
				System.out.print(n1[i] + "] ordenar2\n");
			} else if (i == 0) {
				System.out.print("[" + n1[i] + " - ");
			} else {
				System.out.print(n1[i] + " - ");
			}
			
		}
		
	}

}
