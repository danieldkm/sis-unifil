package Ex8_25;

public class Hora {
	private byte hora, minuto, segundo;
	
	public Hora(byte _hora, byte _minuto, byte _segundo) {
		hora = _hora;
		minuto = _minuto;
		segundo = _segundo;
	}
	
	public String toString(){
		return hora+":"+minuto+":"+segundo;
	}
}
