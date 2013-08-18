import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex02 {
	private File arquivo;
	private BufferedReader br;

	public void lerArquivo(String[] args) throws IOException {
		arquivo = new File(args[1]);
		if (!arquivo.exists()) {
			System.out.println("Arquivo nao existe executando exercicio 01");
			new Ex01().executar(args);
		}
	}

	public void executar(String[] args) throws IOException {
		lerArquivo(args);
		/** biblioteca para abrir o arquivo */
		// FileReader fr = new FileReader(args[0]); //
		/** biblioteca para ler o arquivo */
		br = new BufferedReader(new FileReader(args[1]));
		/** String "linha" recebe a linha lida pelo BufferedReader */
		String linha = "";
		/** String "texto" montar o texto. */
		String texto = "";
		int posicao = 0, aux = 0;
		/***
		 * loop para percorrer enquanto for diferente de nulo, ler todas as
		 * linhas do arquivo
		 ***/
		while ((linha = br.readLine()) != null) {
			/** enquanto aux for menor que 4 faz interação */
			while (aux < 4) {
				/** "posicao" recebe indice do caractere ";" */
				posicao = linha.indexOf(";");
				if (aux == 0) {
					/** texto recebe "linha" até o caracter ";" */
					texto += "pid " + linha.substring(0, posicao) + ", ";
					/**
					 * linha retira a primeira coluna ou seja até o caracter ";"
					 */
					linha = linha.substring(posicao + 1);
				} else if (aux == 1) {
					texto += "com carga " + linha.substring(0, posicao) + ", ";
					linha = linha.substring(posicao + 1);
				} else if (aux == 2) {
					texto += "chegada em " + linha.substring(0, posicao)
							+ " e ";
					linha = linha.substring(posicao + 1);
				} else if (aux == 3) {
					texto += "prioridade " + linha + "\n";
				}
				aux++; // soma "aux"
			}
			aux = 0; // zera "aux"
		}
		System.out.println(texto);
		br.close();
	}
}
