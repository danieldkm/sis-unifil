package slide2Rev02;

public class DVDPlayer {
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
