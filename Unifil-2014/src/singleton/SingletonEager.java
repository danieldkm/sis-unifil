package singleton;

public class SingletonEager {
	private static SingletonEager singletonObject = new SingletonEager();
	int valor;
	
	private SingletonEager() {
	
	}
	
	public static SingletonEager getInstance(){
		return singletonObject;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
