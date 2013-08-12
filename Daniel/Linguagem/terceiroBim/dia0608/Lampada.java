package dia0608;

public class Lampada {
	private boolean estadoLampada;
	private short watts;

	public Lampada(boolean estado) {
		this.estadoLampada = estado;
	}

	public Lampada() {
		this.watts = 60;
	}

	public Lampada(short watts) {
		this.watts = watts;
	}


	public void acende() {
		this.estadoLampada = true;
	}

	public void apaga() {
		this.estadoLampada = false;
	}
	
	public void estadoAtual(){
		if(estadoLampada == true){
			System.out.println("Lampada acesa, " + " lampada de " + watts + " watts");
		} else {
			System.out.println("Lampada apagada, " + " lampada de " + watts + " watts");
		}
		
	}

	
	public static void main(String[] args) {
		Lampada l = new Lampada((short)40);
		l.acende();
		
		
		l.estadoAtual();
	}
}
