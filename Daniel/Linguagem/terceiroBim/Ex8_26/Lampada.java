package Ex8_26;

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
	
	public Lampada(boolean estado, short watts) {
		this.watts = watts;
		this.estadoLampada = estado;
	}


	public void acende() {
		this.estadoLampada = true;
	}

	public void apaga() {
		this.estadoLampada = false;
	}
	
	public String estadoAtual(){
		if(estadoLampada == true){
//			System.out.println("Lampada acesa, " + " lampada de " + watts + " watts");
			return "Lampada acesa, " + " lampada de " + watts + " watts";
		} else {
//			System.out.println("Lampada apagada, " + " lampada de " + watts + " watts");
			return "Lampada apagada, " + " lampada de " + watts + " watts";
		}
		
	}

	
	public static void main(String[] args) {
		Lampada l = new Lampada((short)40);
		l.acende();
		
		
		l.estadoAtual();
	}
}
