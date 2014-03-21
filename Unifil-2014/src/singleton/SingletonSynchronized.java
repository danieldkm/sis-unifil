package singleton;

public class SingletonSynchronized {

	private static SingletonSynchronized singletonObject;
	int valor;
	
	private SingletonSynchronized(){
		
	}
	
	public static synchronized SingletonSynchronized getInstance(){
		if(singletonObject == null) singletonObject = new SingletonSynchronized();
		return singletonObject;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
