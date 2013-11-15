package dia2110;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Exemplo1Agenda {

	private static String arquivo = EscolherArquivo.caminho();
	private BufferedWriter saida;

	public Exemplo1Agenda() {
		try {
			saida = new BufferedWriter(new FileWriter(arquivo, false));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setArquivo(String descri) {
		try {
			saida.write(descri + ": " + getDataAtual() + "\r\n");
			saida.flush();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro de gravação");
		}
	}

	public void fecharArquivo() {
		try {
			saida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getDataAtual() {
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		return formatador.format(data);
	}
}
