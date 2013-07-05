package Bola;

import java.awt.Graphics2D;

import Engine.ProvedorDeServicos;
import Engine.Sprites_AND_Animacoes.Sprite;
import State_Machine_Abstraction.Comportamento_Est;
import State_Machine_Abstraction.Desenho_Est;
import State_Machine_Abstraction.StateEvent;
import State_Machine_Abstraction.StateListener;

public class BD_BolaMovimento implements Comportamento_Est, Desenho_Est,
		StateListener {

	private Sprite refSpriteBola;

	public BD_BolaMovimento(Sprite spriteBola) {
		this.refSpriteBola = spriteBola;
	}

	@Override
	public void update(long timeElapsed) {
		if(this.refSpriteBola.getAcelY() < 0){
			if(this.refSpriteBola.getVelocY() < 0){
				this.refSpriteBola.setVelocY(- this.refSpriteBola.getAcelY());
			}
		} else if(this.refSpriteBola.getY() + this.refSpriteBola.getImage().getHeight(null) > ProvedorDeServicos.getTelaY()){
			if(this.refSpriteBola.getVelocY() > 0){
				this.refSpriteBola.setVelocY(- this.refSpriteBola.getAcelY());
			}
		}
	}

	@Override
	public void draw(Graphics2D g) {
		this.refSpriteBola.draw(g);
	}

	@Override
	public void tratarEvento(StateEvent evento) {
		if(evento.getNomeSourceSM().contains("Palheta")){
			this.refSpriteBola.setVelocX(- this.refSpriteBola.getVelocX());
		}
	}
}
