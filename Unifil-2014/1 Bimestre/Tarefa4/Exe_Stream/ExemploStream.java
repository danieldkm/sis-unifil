package Tarefa4.Exe_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExemploStream {

	public static void main(String[] args) {

		// Cria o objeto serializado

		Cliente cliente = new Cliente("Mario Adaniya", 'M', "0000000001");

		try {

			// Gera o arquivo para armazenar o objeto

			FileOutputStream arquivoGrav = new FileOutputStream("C:/Users/npi/Documents/saida.dat");
			// C:/Users/npi/Desktop
			// /Users/mhadaniya/Desktop/
			// Classe responsavel por inserir os objetos

			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
			// Grava o objeto cliente no arquivo

			objGravar.writeObject(cliente);

			objGravar.flush();

			objGravar.close();

			arquivoGrav.flush();

			arquivoGrav.close();

			System.out.println("Objeto gravado com sucesso!");

		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("Recuperando objeto: ");

		try {

			// Carrega o arquivo

			FileInputStream arquivoLeitura = new FileInputStream("C:/Users/npi/Documents/saida.dat");

			// Classe responsável por recuperar os objetos do arquivo

			ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);

			System.out.println("Lendo o objeto salvo em um arquivo\n" + objLeitura.readObject());

			objLeitura.close();

			arquivoLeitura.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}