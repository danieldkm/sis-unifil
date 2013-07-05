package Bola;

import java.awt.Graphics2D;

import Engine.Sprites_AND_Animacoes.Sprite;
import State_Machine_Abstraction.Comportamento_Est;
import State_Machine_Abstraction.Desenho_Est;
import State_Machine_Abstraction.StateEvent;
import State_Machine_Abstraction.StateListener;

public class BD_BolaParada implements Comportamento_Est, Desenho_Est, StateListener {

	private Sprite refSpriteBola; 
	
	private boolean contRegressivaTerminada;
	
	public BD_BolaParada(Sprite spriteBola){
		this.refSpriteBola = spriteBola;
		this.contRegressivaTerminada = false;
	}
	
	@Override
	public void draw(Graphics2D g) {
		refSpriteBola.draw(g);
	}

	@Override
	public void update(long timeElapsed) {
		// não precisa atualizar neste comportamento de estado
	}
	
	@Override
	public void tratarEvento(StateEvent evento) {
		if(evento.getNomeSourceSM().contains("Placar")){
			this.contRegressivaTerminada = true;
		}
	}

	public boolean isContRegressivaTerminada() {
		return contRegressivaTerminada;
	}

	public void setContRegressivaTerminada(boolean contRegressivaTerminada) {
		this.contRegressivaTerminada = contRegressivaTerminada;
	}
}
