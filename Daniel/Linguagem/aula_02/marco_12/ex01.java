package marco_12;

public class ex01 {
	boolean canRecord = false;
	
	void playTape(){
		System.out.println("tape playing");
	}
	
	void recordTape(){
		System.out.println("tape recording");
	}
	
	boolean cannotRecord(){
		return canRecord;
	}
	
}
