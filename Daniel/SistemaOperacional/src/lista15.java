
public class lista15 {
	
	public static void main(String[] args) {
		int x[] = new int [4000];
		int passo = 1024;
		int n = 0;
		System.out.println(x.length);
		for (int i = 0; i < x.length; i += passo) {
			x[i] += + 1; 
			System.out.println(x[i] + " n " + n++ + " tamanho " + i);
		}
	}
}
