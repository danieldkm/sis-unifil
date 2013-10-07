package dia0710;

import javax.swing.JOptionPane;
import java.io.*;

public class LeituraArquivo {
	static String arquivo = "./TESTES.TXT";

	public static void main (String args[]) {
		try {
			BufferedReader arqentrada;
			arqentrada = new BufferedReader(new FileReader(arquivo));
			String linha;
			while ((linha = arqentrada.readLine()) != null){
			         System.out.println(linha);
                                                }
			arqentrada.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de leitura");
		}
	}
}
