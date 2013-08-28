package dia2708.Lampada;
public class LampadaFluorescente extends Lampada{
	private int comprimentoLampada;

	public LampadaFluorescente(int comprimento, boolean estado, short watts) {
		super(estado, watts);
		comprimentoLampada = comprimento;
	}

	public int getComprimentoLampada() {
		return comprimentoLampada;
	}

	public void setComprimentoLampada(int comprimentoLampada) {
		this.comprimentoLampada = comprimentoLampada;
	}
	
	public String toString(){
		return "Comprimento: " + comprimentoLampada + " Estado: " + super.estadoAtual();
	}

}
