package singleton;

public class SingletonNoCloneable implements Cloneable{

	private static SingletonNoCloneable singletonObject;
	int valor;
	
	private SingletonNoCloneable(){
		
	}
	
	public static SingletonNoCloneable getInstance(){
		if(singletonObject == null) singletonObject = new SingletonNoCloneable();
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
		throw new CloneNotSupportedException();
	}
}
