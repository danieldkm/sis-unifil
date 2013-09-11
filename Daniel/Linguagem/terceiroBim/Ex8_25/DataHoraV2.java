package Ex8_25;

public class DataHoraV2 extends Hora{

	private Data data;
	
	public DataHoraV2(byte dia, byte mes, short ano, byte hora, byte minuto, byte segundo) {
		super(hora, minuto, segundo);
		data = new Data(dia, mes, ano);
	}
	
	public String toString(){
		return super.toString() + "\n" + data;
	}
}
