
public class Alarm {

	private int[][] horaAtual ;
	private int horaProgramada;
	
	public Alarm(){
		
	}
	
	public void setHoraAtual(int ha[][]){
		this.horaAtual = ha;
	}
	
	public void setProgramaHora(int hp){
		this.horaProgramada = hp;
	}
	
	public int getHoraAtual(){
		int cronometro[][]= new int [59][59];
		
		for(int i = 0 ; i<= 59; i++){
			for(int j=0; i<= 59;i++){
				System.out.println(cronometro[i][j]); 
			}
		}
		for(int i = 0 ; i<= 59; i++){
			for(int j= 0; i<= 59;i++){
				cronometro[i][j]= i+j;
		this.horaAtual[i][j] = cronometro[i][j];
		return horaAtual[i][j];
				}
		}
		return horaProgramada;
	}
	
	public int getProgramaHora(){
		return horaProgramada;
	}
	
	
	
}
