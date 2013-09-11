package Ex8_25;

public class Data {

	private byte dia,mes;
	private short ano;
	
	public Data(byte _dia, byte _mes, short _ano) {
		dia = _dia;
		mes = _mes;
		ano = _ano;
	}
	
	@Override
	public String toString(){
		return dia+"/"+mes+"/"+ano;
	}
}
