package ultimaAula;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame {
	
	private JButton button1, button2;
	
	//configura a GUI
	public ButtonTest() {
		
		super ("Testando Botões");
		
		//obtém painel de conteúdo e configura seu leiaute
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//cria botões
		button1 = new JButton("Botão 1");
		container.add(button1);
		
		Icon bug1 = new ImageIcon("bug1.jpg");
		Icon bug2 = new ImageIcon("bug2.jpg");
		button2 = new JButton("Botão 2", bug1);
		container.add(button2);
		
		//cria uma instância da classe interna ButtonHandler
		//para uso no tratamento de eventos do botão
		ButtonHandler handler = new ButtonHandler();
		button2.addActionListener(handler);
		button1.addActionListener(handler);
		
		setSize(275,100);
		setVisible(true);
	}
	
	public static void main (String args[]) {

		ButtonTest aplicacao = new ButtonTest();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//classe interna para tratamento de evento do botão
	private class ButtonHandler implements ActionListener {
		
		//trata evento do botão
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "Você pressionou: " + event.getActionCommand());
		}
	}
}