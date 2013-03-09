public class Liquidificador {
	private int velocidade;
	private int velocidadeMaxima;
	private char estado;
	
	
	public Liquidificador(){
		this.estado = 'D';
		this.velocidadeMaxima = 5;
	}
	
	public void setVelocidade(int V){
		velocidade = V;
	}
	
	public void setVelocidadeMaxima(int Vm){
		velocidadeMaxima = Vm;
	}
	
	public char getEstado(){
		return estado;
	}
	
	public void setEstado(char St){
		estado = St;
	}
	
	public int getVelocidade(){
		return velocidade;
	}
	
	public int getVelocidadeMaxima(){
		return velocidadeMaxima;
	}

}
