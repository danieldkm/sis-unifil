package singleton;

public class TesteClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonCloneable singleton = SingletonCloneable.getInstance();
		singleton.setValor(1);
		
		System.out.println("singleton: " + singleton); 
		System.out.println("Singleton data value is: " + singleton.getValor());
		System.out.println("================================================");
		SingletonCloneable singletonClone = (SingletonCloneable) singleton.clone();
		System.out.println("singleton: " + singletonClone); 
		System.out.println("Singleton data value is: " + singletonClone.getValor());

	}

}
