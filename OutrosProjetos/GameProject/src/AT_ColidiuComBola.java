import State_Machine_Abstraction.Comportamento_Est;
import State_Machine_Abstraction.Desenho_Est;
import State_Machine_Abstraction.Estado;
import State_Machine_Abstraction.Transicao;


public class AT_ColidiuComBola extends Transicao {
	
	public AT_ColidiuComBola(Estado<? extends Comportamento_Est, ? extends Desenho_Est> target){
		super(target, "AT Colisao" + target.getNome());
	}

	@Override
	public boolean clausula() {
		return false;
	}
	
	@Override
	public void efetuarTransicao() {
		
	}
	
	private boolean verificaCoisao(){
		int x1 = (int) colisor.getX();
		int x2 = (int) bola.getSpriteBolinha().getX();
		
		int y1 = (int) colisor.getY();
		int y2 = (int) bola.getSpriteBolinha().getY();
		
		int width1 = colisor.getImage().getWidth(null);
		int width2 = bola.getSpriteBolinha.getImage().getWidth(null);
		
		int height1 = colisor.getImage().getHeight(null);
		int height2 = bola.getSpriteBolinha.getImage().getHeight(null);
		
		if(((x1 < x2) && (x2 <(x1 + width1)) && ((y1 < y2) && (y2 < (y1 + height1))))){
			return true;
		}
		
		if(((x1 < x2 + width2) && (x2+width2 < (x1 + width1)) && ((y1 < y2) && (y2 < (y1 + height1))))){
			return true;
		}
		
		if(((x1 < x2) && (x2 < (x1 + width1))&& ((y1 < y2 + height2)&& (y2 + height2 < (y1 + height1))))){
			return true;
		}
		
		if(((x1 < x2 + width2) && (x2 + width2 < (x1 + width1)) && ((y1 < y2 + height2) && (y2 + height2 < (y1 + height1))))){
			return true;
		}
		
		if(((x2 < x1)&& (x1 < (x2 + width2))&& ((y2 < y1)&& (y1 < (y2 + height2))))){
			return true;
		}
		
		if(((x2 < x1 + width1) && (x1 + width1 < (x2 + width2))&&((y2 < y1)&&(y1 < (y2 + height2))))){
			return true;
		}
		
		if(((x2 < x1) &&( x1 < (x2+width2))&&((y2 < y1 + height1)&&(y1 + height1 < (y2 + height2))))){
			return true;
		}
		
		if(((x2 < x1 + width1) && (x1 + width1 < (x2 + width2)) && ((y2 < y1) && (y1 + height1 < (y2 + height2))))){
			return true;
		}
		
		if(((x2 < x1 + width1)&& (x1 + width1 < (x2 + width2))&&((y2 < y1)&&(y1+height1 < (y2 + height2))))){
			return true;
		}
	}
	
}
