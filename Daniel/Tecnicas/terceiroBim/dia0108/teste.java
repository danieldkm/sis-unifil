package dia0108;

public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] v = new int[5];
		
		v[0] = 4;
		v[1] = 20;
		v[2] = 50;
		v[3] = 6;
		v[4] = 1;
		for (int i = 0; i < v.length; i++) {
			if(i == 4){
				System.out.print(v[i] + "]\n");	
			} else if (i == 0){
				System.out.print("[" + v[i] + " - ");
			} else{
				System.out.print(v[i] + " - ");
			}
		}
		BubbleSort bs = new BubbleSort();
		
		
		int[] ordenado = bs.ordenar2(v);
		
		for (int i = 0; i < ordenado.length; i++) {
			if(i == 4){
				System.out.print(ordenado[i] + "]");	
			} else if (i == 0){
				System.out.print("[" + ordenado[i] + " - ");
			} else{
				System.out.print(ordenado[i] + " - ");
			}
		}
	
	
	}

}
