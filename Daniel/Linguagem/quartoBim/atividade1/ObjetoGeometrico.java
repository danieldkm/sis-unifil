package atividade1;

public class ObjetoGeometrico {

	private int d1;
	private int d2;

	public ObjetoGeometrico(int d1, int d2) {
		this.d1 = d1;
		this.d2 = d2;
	}
	
	public int calcularArea(){
		return 0;
	}
	
	public int calcularPerimetro(){
		return 0;
	}

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public int getD2() {
		return d2;
	}

	public void setD2(int d2) {
		this.d2 = d2;
	}
	
	@Override
	public String toString(){
		return "Valor1: " + d1 + " \nValor2:" + d2;
		
	}

}
