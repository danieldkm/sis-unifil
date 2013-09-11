package Ex8_25;

public class DataHoraV1 extends Data{
	
	private Hora horas;
	
	public DataHoraV1(byte dia, byte mes, short ano, byte hora, byte minuto, byte segundo) {
		super(dia, mes, ano);
		horas = new Hora(hora, minuto, segundo);
	}
	
	public String toString(){
		return super.toString() + "\n" + horas;
	}

}
