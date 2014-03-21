package singleton;

public class SingletonCloneable implements Cloneable{

	private static SingletonCloneable singletonObject;
	int valor;
	
	private SingletonCloneable(){
		
	}
	
	public static SingletonCloneable getInstance(){
		if(singletonObject == null) singletonObject = new SingletonCloneable();
		return singletonObject;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
