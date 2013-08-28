package dia2708.DataHora;

public class DataHora // declaração da classe
{
	private Data estaData; // uma referência à instância da classe Data
							// representa
							// o dia, mês e ano
	private Hora estaHora; // uma referência à instância da classe Hora
							// representa
							// a hora, minuto e segundo

	public DataHora(byte hora, byte minuto, byte segundo, byte dia, byte mes, short ano) {
		estaData = new Data(dia, mes, ano);
		estaHora = new Hora(hora, minuto, segundo);
	}

	DataHora(byte dia, byte mes, short ano) {
		estaData = new Data(dia, mes, ano);
		estaHora = new Hora((byte) 0, (byte) 0, (byte) 0); // cast necessário
	}

	public boolean eIgual(DataHora dataHora) {
		if (estaData.eIgual(dataHora.getEstaData())
				&& estaHora.eIgual(dataHora.getEstaHora())) {
			return true;
		} else {
			return false;
		}
	}

	public Data getEstaData() {
		return estaData;
	}

	public Hora getEstaHora() {
		return estaHora;
	}

	public String toString() {
		return estaData + " " + estaHora;
	}

}