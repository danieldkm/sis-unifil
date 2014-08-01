import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.Date;

import javax.swing.JOptionPane;

public class ClienteTCPBasico {
	public static void main(String[] args) {

		try {

			Socket cliente = new Socket("127.0.0.1", 12345);
//			192.168.8.21
			ObjectInputStream entrada = new ObjectInputStream(
					cliente.getInputStream());

			Date data_atual = (Date) entrada.readObject();

			JOptionPane.showMessageDialog(null, "Data recebida do servidor:"
					+ data_atual.toString());

			entrada.close();

			System.out.println("Conexão encerrada");

		}

		catch (Exception e) {

			System.out.println("Erro: " + e.getMessage());

		}

	}
}
