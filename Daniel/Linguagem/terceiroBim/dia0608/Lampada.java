package dia0608;

public class Lampada {
	private boolean estadoLampada;
	private short watts;

	public Lampada(boolean estado) {
		this.estadoLampada = estado;
//		this();
	}

	public Lampada() {
		this.watts = 60;
//		new Lampada(true);
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

}
