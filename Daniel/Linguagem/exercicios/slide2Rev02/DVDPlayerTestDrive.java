package slide2Rev02;


public class DVDPlayerTestDrive {

	public static void main(String[] args) {
		DVDPlayer d = new DVDPlayer();
		d.canRecord = true;
		d.playDVD();//n�o existia esse metodo playDVD
		
		if(d.canRecord() == true){//n�o existia esse metodo canRecord
			d.recordDVD();
		}
	}

}
