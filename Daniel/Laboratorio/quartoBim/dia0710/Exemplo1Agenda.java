package dia0710;
import javax.swing.JOptionPane;
import java.io.*;

public class Exemplo1Agenda {

	public static void main (String args[]) {

		try {
			String arquivo = EscolherArquivo.caminho();
			BufferedWriter saida;
			saida = new BufferedWriter(new FileWriter(arquivo, true));
			String nome = JOptionPane.showInputDialog("Digite o nome");
			nome = nome.toUpperCase();
			String tel = JOptionPane.showInputDialog("Digite o telefone");
			String CPF = JOptionPane.showInputDialog("Digite o CPF");
			saida.write(nome + " ");
			saida.write(tel + " ");
			saida.write(CPF + "\r\n");
			saida.flush();
			saida.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de gravação");
		}
	}
}
