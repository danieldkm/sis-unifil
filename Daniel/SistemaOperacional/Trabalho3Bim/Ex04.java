import java.io.IOException;

public class Ex04 extends FilaProntos {

	/**
	 * @param args vetor de processos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void executar(String[] args) throws IOException {
		lerArquivo(args);
		Ordenar or = new Ordenar();
		int[] prontos = filaProntos(args);
		String texto = or.mostrarPids(prontos);;
		System.out.println(texto);
	}
}
