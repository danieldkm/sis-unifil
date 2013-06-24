package trabalhoSO2bim2;
/*8. (30 pontos bônus) Ainda sobre Matematico.java, o programa apresenta uma região
crítica, fazendo o programa possuir uma condição de corrida. Identiﬁcar qual é a
região e sincronizar o acesso das threads a ela utilizando a técnica de monitores
(synchronized em Java). Relatar:
(a) Qual trecho do código é a região crítica, e explicar;
(b) Transcrever trecho de código modiﬁcado;
(c) Transcrever resultado obtido da execução do programa modiﬁcado;*/
public class Matematico {
	public static void main(String[] args) {
		int limite = 1000;
		MutableInteger compartilhado = new MutableInteger();
		for (int i = 0; i < 5; i++) {
			compartilhado.setValor(i);
			new Somatorio(limite, compartilhado).start();
			System.out.println("A soma de " + limite + " Ã© "
					+ compartilhado.getValor());
		}
	}
}

class Somatorio extends Thread/*implements Runnable*/ {
	public Somatorio(int limite, MutableInteger valorSoma) {
		this.limite = limite;
		this.valorSoma = valorSoma;
	}

	public synchronized void run() {
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
	public synchronized int getValor() {
		return valor;
	}

	public synchronized void setValor(int valor) {
		this.valor = valor;
	}

	private int valor;
}
