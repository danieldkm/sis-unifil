package bim2.trab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ArquivoTxt implements LerArquivo {

	private File local;

	@Override
	public String lerArquivo(File localArquivo) {
		try {
			local = localArquivo;
			BufferedReader arqentrada;
			arqentrada = new BufferedReader(new FileReader(local));
			String linha;
			while ((linha = arqentrada.readLine()) != null) {
				return linha;
			}
			arqentrada.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de leitura");
		}
		return "";
	}

	@Override
	public void salvarArquivo(String conteudo) {
		FileWriter fw;
		try {
			fw = new FileWriter(local);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(conteudo + "\r\n");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
