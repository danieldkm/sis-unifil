package dia1208;

public class TV {

	private int canal;
	private int volume;
	private boolean ligada;

	/**
	 * Defina construtores na classe TV para iniciarlizar todos os atributos,
	 * faça sobrecarga de construtores:
	 * 
	 * TV(); TV(canal, volume); TV(ligada); TV(canal, volume, ligada);
	 * */

	public TV() {
	}

	public TV(int canal, int volume) {
		this.canal = canal;
		this.volume = volume;
	}

	public TV(boolean ligada) {
		this.ligada = ligada;
	}

	public TV(int canal, int volume, boolean ligada) {
		this.canal = canal;
		this.volume = volume;
		this.ligada = ligada;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isLigada() {
		return ligada;
	}

	public void setLigada(boolean ligada) {
		this.ligada = ligada;
	}
}
