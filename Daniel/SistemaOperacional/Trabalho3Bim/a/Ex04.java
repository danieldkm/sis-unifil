package a;
import java.io.IOException;

public class Ex04 extends FilaProntos {

	/**
	 * @param args vetor de processos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void executar(String[] args) {
		try {
			lerArquivo(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ordenar or = new Ordenar();
		int[] prontos = filaProntos(args);
		String texto = or.mostrarPids(prontos);;
		System.out.println(texto);
	}
}
