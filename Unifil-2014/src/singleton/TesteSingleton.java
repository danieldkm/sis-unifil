package singleton;

public class TesteSingleton {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.setValor(1);
		
		System.out.println("singleton: " + singleton); 
		System.out.println("Singleton data value is: " + singleton.getValor());
		System.out.println("================================================");
		singleton = null;
		singleton = Singleton.getInstance();
		
		System.out.println("singleton: " + singleton); 
		System.out.println("Singleton data value is: " + singleton.getValor());

	}

}
