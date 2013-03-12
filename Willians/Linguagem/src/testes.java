
public class testes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int cronometro[][]= new int [59][900];
		
		
		for(int i = 0 ; i<= 12; i++){
			for(int j= 0; j<= 59 ;i++){
				cronometro[i][j]= (i)+(j);
		 System.out.println(cronometro[i][j]);
	
				}
		}
		
	}

}
