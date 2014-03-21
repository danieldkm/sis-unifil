package singleton;

public class TesteSingletonClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonNoCloneable singleton = SingletonNoCloneable.getInstance();
		singleton.setValor(1);
		
		System.out.println("singleton: " + singleton); 
		System.out.println("Singleton data value is: " + singleton.getValor());
		System.out.println("================================================");
		SingletonNoCloneable singletonClone = (SingletonNoCloneable) singleton.clone();
		System.out.println("singleton: " + singletonClone); 
		System.out.println("Singleton data value is: " + singletonClone.getValor());

	}

}
