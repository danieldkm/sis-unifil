package slide1Ex03;

public class testanto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Song s = new Song();
		ShoppingCart sc = new ShoppingCart();
		Button b = new Button();
		Alarm a = new Alarm();
		
		s.play();
		s.setArtist("Daniel");
		
		sc.addToCart("livro");
		sc.removeFromCart();
		System.out.println(sc.checkout());
		
		b.setLabel("aaaa");
		b.setColor("azurl");
		b.dePress();
		b.unPress();
		
		a.setHoras("12:00");
		System.out.println(a.getHoras());
		a.setDipertar("trrrrimmmmm!");
		System.out.println(a.getDipertar());

	}

}
