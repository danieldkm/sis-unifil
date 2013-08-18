import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Ex01 {
	private File arquivo;
	private BufferedWriter bw;
	private boolean continuar;
	private String pergunta;
	private Scanner scanner;
	
	public void zerar(String[] args) throws IOException {
//		bw = new BufferedWriter(new FileWriter(args[1]));
		// arquivo = new File(args[1]);
		continuar = true;
		pergunta = "";
		scanner = new Scanner(System.in);
//		pid = null;
//		chegada = null;
//		carga = null;
//		prioridade = null;
	}
	
	public void editarArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		if (arquivo.exists()) {
			arquivo.delete();
			arquivo.createNewFile();
		}
	}
	
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
						.println("Deseja digitar a proxima linha? \nSIM[S] / NÃO[N]");
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
						.println("Deseja digitar a proxima linha? \nSIM[S] / NÃO[N]");
				pergunta();
			}
		}
	}
}
