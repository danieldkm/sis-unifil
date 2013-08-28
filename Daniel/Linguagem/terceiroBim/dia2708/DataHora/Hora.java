package dia2708.DataHora;

public class Hora {
	private byte hora;
	private byte minuto;
	private byte segundo;

	public Hora(byte hora, byte minuto, byte segundo) {
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
	}

	public boolean eIgual(Hora hora) {
		if (this.hora == hora.getHora() && minuto == hora.getMinuto()
				&& segundo == hora.getSegundo()) {
			return true;
		} else {
			return false;
		}
	}

	public byte getHora() {
		return hora;
	}

	public void setHora(byte hora) {
		this.hora = hora;
	}

	public byte getMinuto() {
		return minuto;
	}

	public void setMinuto(byte minuto) {
		this.minuto = minuto;
	}

	public byte getSegundo() {
		return segundo;
	}

	public void setSegundo(byte segundo) {
		this.segundo = segundo;
	}

}
