package singleton;

public class TesteThreadSingletonEager {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(){
			public void run() {
				SingletonEager singleton = SingletonEager.getInstance();
				singleton.setValor(1);
				System.out.println("singleton: " + singleton); 
				System.out.println("Singleton data value is: " + singleton.getValor());
			};
		};
		
		Thread thread2 = new Thread(){
			public void run() {
				SingletonEager singleton = SingletonEager.getInstance();
				singleton.setValor(2);
				System.out.println("singleton: " + singleton); 
				System.out.println("Singleton data value is: " + singleton.getValor());
			};
		};
		
		thread1.start();
		thread2.start();

	}

}
