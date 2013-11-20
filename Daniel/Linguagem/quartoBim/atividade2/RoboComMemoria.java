package atividade2;

public class RoboComMemoria extends RoboAbstrato {

	int passos;
	short direcao;

	RoboComMemoria(String n, int px, int py, short d) {
		super(n, px, py, d);
	}

	@Override
	public void move(int passos) {
		direcao = qualDirecaoAtual();
		this.passos = passos;
		if(direcao % 2 != 0){
			if(direcao < 90){
				moveX(+passos);       
				moveY(+passos);
			} else if(direcao > 90 && direcao < 180){
				moveX(+passos);       
				moveY(-passos);
			} else if(direcao > 180 && direcao < 270){
				moveX(-passos);       
				moveY(-passos);
			} else if(direcao > 270 && direcao < 320){
				moveX(-passos);       
				moveY(+passos);
			}
		}
	}

	public void retornaÀOrigem() {
		if(direcao % 2 != 0){
			if(direcao < 90){
				moveX(-passos);       
				moveY(-passos);
			} else if(direcao > 90 && direcao < 180){
				moveX(-passos);       
				moveY(+passos);
			} else if(direcao > 180 && direcao < 270){
				moveX(+passos);       
				moveY(+passos);
			} else if(direcao > 270 && direcao < 320){
				moveX(+passos);       
				moveY(-passos);
			}
		}
	}

}
