import java.io.File;
import java.io.IOException;

/**
 * @author Daniel K. Morita
 * */
public class Arquivo {
	
	private File arquivo;
	
	/**
	 * @param args - vetor de processos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void lerArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		if (!arquivo.exists()) {
			System.out.println("Arquivo nao existe executando ex 01");
			new Ex01().executar(args);
		}
	}
	
	/**
	 * @param args - vetor de processos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void editarArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		if (arquivo.exists()) {
			arquivo.delete();
			arquivo.createNewFile();
		}
	}
}
