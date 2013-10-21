package dia2110;

import javax.swing.JOptionPane;
import java.io.*;

public class LeituraArquivo {
	static String arquivo = "C:/Documents and Settings/121023035/Meus documentos/logProjeto.txt";

	public static void main(String args[]) {
		File f = new File("resumo.txt");//onde colocar isso é importante  
		int quantidadeExecutada = 0;
		int quantidadeInclusao = 0;
		int quantidaderegistro = 0;
		int quantidadeConsulta = 0;
		try {
			FileWriter fw = new FileWriter(f);  
	        BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader arqentrada;
			arqentrada = new BufferedReader(new FileReader(arquivo));
			String linha;
			while ((linha = arqentrada.readLine()) != null) {
				System.out.println(linha);
				if(linha.contains("Inicio")){
					quantidadeExecutada ++;
				} else if(linha.contains("Inclusao")){
					quantidadeInclusao ++;
				} else if(linha.contains("Registro")){
					quantidaderegistro ++;
				} else if(linha.contains("Consulta")){
					quantidadeConsulta ++;
				}
			}
			bw.write("Quantidade executada: " +quantidadeExecutada+ "\r\n");
			bw.write("Quantidade incluida: "+quantidadeInclusao+"\r\n");
			bw.write("Quantidade consultada: "+ quantidaderegistro+"\r\n");
			bw.write("Quantidade registro horas: "+ quantidadeConsulta+"\r\n");
			bw.flush();
			bw.close();
			
			arqentrada.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de leitura");
		}
	}
}
