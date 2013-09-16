import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Daniel K. Morita
 * */
public class Ex01 extends Arquivo{
	
	private BufferedWriter bw; 
	private boolean continuar; 
	private String pergunta;
	private Scanner scanner;
	
	/** Zerar os atributos
	 * @param recebe os argumentos
	 * */
	public void zerar(String[] args) throws IOException {
		continuar = true;
		pergunta = "";
		scanner = new Scanner(System.in);
	}
	
	/** Metodo responsavel para executar o ex 01
	 * @param recebe os argumentos
	 * @throws IOException - lança esssa excessão caso der erro ao ler o arquivo
	 * */
	public void executar(String[] args) throws IOException {
		editarArquivo(args);
		zerar(args);
		bw = new BufferedWriter(new FileWriter(args[1]));
		continuar = true;

		while (continuar) {
			System.out.println("Deseja digitar? \nSIM[S] / NÃO[N]");
			pergunta();
		}

		if (pergunta.equals("S")) {
			continuar = true;
			while (continuar) {
				System.out.println("Informe o PID");
				bw.write(scanner.nextLine() + ";");
				System.out.println("Informe a CARGA");
				bw.write(scanner.nextLine() + ";");
				System.out.println("Informe a CHEGADA");
				bw.write(scanner.nextLine() + ";");
				System.out.println("Informe a PRIORIDADE");
				bw.write(scanner.nextLine());
				bw.newLine();
				System.out
						.println("Deseja digitar a proximo processo? \nSIM[S] / NÃO[N]");
				pergunta();
			}
		} else if (pergunta.equals("N")) {
			bw.write("1001;18;0;70");
			bw.newLine();
			bw.write("1102;4;0;50");
			bw.newLine();
			bw.write("1003;22;0;50");
			bw.newLine();
			bw.write("1014;3;3;70");
			bw.newLine();
			bw.write("1061;8;3;50");
			bw.newLine();
			bw.write("1002;7;15;50");
			bw.newLine();
			bw.write("1203;2;15;30");
			bw.newLine();
			bw.write("1304;13;15;70");
			bw.newLine();
		}
		bw.close();
	}
	
	/**
	 * Metodo para saber se o usuário deseja continuar digitando o proximo processo
	 * */
	public void pergunta() {
		if (pergunta.equals("")) {
			pergunta = scanner.nextLine().toUpperCase();
			if (pergunta.equals("S") || pergunta.equals("N")) {
				continuar = false;
			} else {
				System.out.println("Erro");
				continuar = true;
			}
		} else {
			pergunta = scanner.nextLine().toUpperCase();
			if (pergunta.equals("S") || pergunta.equals("N")) {
				if (pergunta.equals("N")) {
					continuar = false;
				} else if (pergunta.equals("S")) {
					continuar = true;
				}
			} else {
				System.out.println("Erro");
				continuar = true;
				System.out
						.println("Deseja digitar a proximo processo? \nSIM[S] / NAO[N]");
				pergunta();
			}
		}
	}
}
