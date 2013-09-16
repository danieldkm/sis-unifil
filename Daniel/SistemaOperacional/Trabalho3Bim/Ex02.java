import java.io.IOException;

/**
 * @author Daniel
 * */
public class Ex02 extends Arquivo {

	private Processos processos;

	/**
	 * Metodo responsavel pela execução do ex 02
	 * 
	 * @param args vetor de processos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void executar(String[] args) throws IOException {
		String texto = "";
		processos = new Processos(args);
		int[] pid = processos.getPid(), carga = processos.getCarga(), chegada = processos
				.getChegada(), prioridade = processos.getPrioridade();
		for (int i = 0; i < pid.length; i++) {
			texto += "Pid " + pid[i] + " com carga " + carga[i]
					+ ", chegada em " + chegada[i] + " e " + prioridade[i]
					+ "\n";
		}
		System.out.println(texto);
	}
}
