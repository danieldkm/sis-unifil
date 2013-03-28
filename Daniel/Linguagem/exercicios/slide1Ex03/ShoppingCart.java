package slide1Ex03;

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
