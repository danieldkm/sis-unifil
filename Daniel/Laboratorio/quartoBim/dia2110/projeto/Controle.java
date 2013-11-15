package dia2110.projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Controle {

	public static void main(String[] args) throws IOException {
		
		JFileChooser fileChooser = new JFileChooser();
		System.out.println(fileChooser.showOpenDialog(null));
		System.out.println(JFileChooser.CANCEL_OPTION);
		File file = fileChooser.getSelectedFile();
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("kct");
		bw.write("\r\n");
		bw.flush();
		bw.close();
		
		
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String linha = "";
		
		while((linha = br.readLine()) != null){
				System.out.println(linha);
		}
		br.close();
		
		
		
		
		
	}

}
