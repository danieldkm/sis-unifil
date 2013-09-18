package Ex8_28;

public class Data {
	private byte dia;
	private byte mes;
	private short ano;

	public Data(byte dia, byte mes, short ano) {
		if (dia > 0 && dia < 32) {
			this.dia = dia;
		} else {
			this.dia = 1;
		}

		if (mes > 0 && mes < 13) {
			this.mes = mes;
		} else {
			this.mes = 1;
		}

		if (ano > 1969) {
			this.ano = ano;
		} else {
			this.ano = 1970;
		}
	}

	public byte getDia() {
		return dia;
	}

	public void setDia(byte dia) {
		this.dia = dia;
	}

	public byte getMes() {
		return mes;
	}

	public void setMes(byte mes) {
		this.mes = mes;
	}

	public short getAno() {
		return ano;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	public static void main(String[] args) {

		Data d = new Data((byte) 32, (byte) 12, (short) 2000);
		System.out.println(d.getDia());
		System.out.println(d.getMes());
		System.out.println(d.getAno());

	}
}
