package marco_12;

public class ex02 {
	boolean canRecord = false;
	
	void recordDVD(){
		System.out.println("DVD recording");
	}
	
	void playDVD(){
		canRecord = true;
	}
	
	boolean canRecord(){
		return canRecord;
	}
	
}
