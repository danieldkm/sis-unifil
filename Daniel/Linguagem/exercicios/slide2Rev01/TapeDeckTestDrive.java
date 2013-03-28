package slide2Rev01;

public class TapeDeckTestDrive {

	public static void main(String[] args) {
		TapeDeck t = new TapeDeck();//faltou instancia a classe TapeDeck
		t.canRecord = true;
		t.playTape();
		
		if(t.canRecord == true){//não existia o metodo canRecord
			t.recordTape();
		}

	}

}
