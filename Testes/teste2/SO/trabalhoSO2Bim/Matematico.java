package trabalhoSO2Bim;

/*
 * 	Modificar o programa Matematico.java para utilizar 5 threads ao mesmo
 tempo, ao inv�s de apenas uma. O trabalho dever� ser dividido igualmente entre as
 threads. Relatar:
 (a) Transcrever partes do c�digo que foram modificadas;
 (b) Transcrever resultado obtido da execu��o do programa modificado;
 * */
public class Matematico {
	public static void main(String[] args) {
		int limite = 1000;
		MutableInteger compartilhado = new MutableInteger();
		for (int i = 0; i < 5; i++) {
			compartilhado.setValor(i);
			new Somatorio(limite, compartilhado).start();
			System.out.println("A soma de " + limite + " é "
					+ compartilhado.getValor());
		}
//		for (int i = 0; i < 5; i++) {
//		compartilhado.setValor(i);
//
//
//			Thread somador = new Thread(new Somatorio(limite, compartilhado));
//			somador.start();
//			try {
//				somador.join();
//				System.out.println("A soma de " + limite + " é "
//						+ compartilhado.getValor());
//			} catch (InterruptedException e) {
//				System.out.println("Ocorreu o seguinte erro em threads: "
//						+ e.toString());
//			}
//		}
	}
}

class Somatorio extends Thread/*implements Runnable*/ {
	public Somatorio(int limite, MutableInteger valorSoma) {
		this.limite = limite;
		this.valorSoma = valorSoma;
	}

	public void run() {
//		 for(int x = 0; x < 100; x++){  
//			 System.out.println("Meu nome �: " + Thread.currentThread().getName() + " e x = " + x);
//		 }
		int soma = 0;
		for (int i = 0; i < limite; i++) {
			soma += i;
		}
		valorSoma.setValor(soma);
	}

	private int limite;
	private MutableInteger valorSoma;
}

class MutableInteger {
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	private int valor;
}