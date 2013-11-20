package atividade1;

public class ObjetoGeometrico {

	private int x;
	private int y;
	
	public ObjetoGeometrico() {
	}

	public ObjetoGeometrico(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int calcularArea(){
		return 0;
	}
	
	public int calcularPerimetro(){
		return 0;
	}

	public int getD1() {
		return x;
	}

	public void setD1(int d1) {
		this.x = d1;
	}

	public int getD2() {
		return y;
	}

	public void setD2(int d2) {
		this.y = d2;
	}
	
	@Override
	public String toString(){
		return "Ponto x: " + x + " \nPonto y: " + y;
		
	}

}
