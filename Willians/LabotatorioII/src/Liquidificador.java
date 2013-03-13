
public class Liquidificador {

	private int velocidade;
	private int velocidadeMaxima = 5;
	private String estado = "Desligado";
	
	public Liquidificador(){
		
	}
	
	public void setVelocidade(int v){
		this.velocidade = v;
	}
	
	public void setVelocidadeMaxima(int vm){
		this.velocidadeMaxima = vm;
	}
	
	public void desligar(){
		this.estado = "Desligado";
		velocidade = 0;
		
	}
	
	public void ligar(){
		this.estado = "Ligado";
		velocidade = 1;
		
	}
	
	public String getEstado(String estado1){
		estado1 = this.estado;
		return this.estado;
			
	}
	
	public int getVelocidade(){
		return velocidade;
	}
	
	public int getVelocidadeMaxima(){
		return velocidadeMaxima;
	}
	
}

