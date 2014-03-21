package singleton;

public class Singleton {

	private static Singleton singletonObject;
	int valor;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(singletonObject == null) singletonObject = new Singleton();
		return singletonObject;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}

