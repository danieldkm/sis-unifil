package exercicio_01;

public class ShoppingCart {
	private String carContents;
	
	public void addToCart(String contem){
		this.carContents = contem;
	}
	
	public void removeFromCart(){
		this.carContents = "";
	}
	
	public String checkout(){
		return carContents;
	}
	
}
