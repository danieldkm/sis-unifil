import State_Machine_Abstraction.StateEvent;
import State_Machine_Abstraction.Transicao;

public class EventoPontoFeito extends StateEvent {
	
	private char ladoPalhetaQuePontuou;
	public EventoPontoFeito(Transicao src, String nomeAlvo, String nomeSrcSM, char ladoPalhetaQuePontuou) {
		super(src, nomeAlvo, nomeSrcSM);
		this.ladoPalhetaQuePontuou = ladoPalhetaQuePontuou;
	}
	
	public char getLadoPalhetaQuePontuou(){
		return this.ladoPalhetaQuePontuou;
	}
}
