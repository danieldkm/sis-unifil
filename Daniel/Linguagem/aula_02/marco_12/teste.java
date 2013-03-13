package marco_12;

public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ex01 t = new ex01();
		t.canRecord = true;
		t.playTape();
		
		if(t.canRecord == true){
			t.recordTape();
		}
		
		
//		ex02 d = new ex02();
//		d.canRecord = true;
//		d.playDVD();
//		
//		if(d.canRecord() == true){
//			d.recordDVD();
//		}

	}

}
