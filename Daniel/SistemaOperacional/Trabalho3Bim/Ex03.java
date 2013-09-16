import java.io.IOException;

/**
 * @author Daniel
 * */
public class Ex03 extends FilaProntos{
	
	/**
	 * @param args vetor de processos
	 * */
	public void executar(String[] args) throws IOException {
		lerArquivo(args); // caso o arquivo .csv não exista é executado o ex01 para ser criado!!
		int[] pid = filaProntos(args);
		for (int k = 0; k < pid.length; k++) {
			if (k == (pid.length - 1)) {
				System.out.print(pid[k] + "\n");
			} else if (k == 0) {
				System.out.print("PID - " + pid[k] + ":");
			} else {
				System.out.print(pid[k] + ":");
			}
		}
	}
}
