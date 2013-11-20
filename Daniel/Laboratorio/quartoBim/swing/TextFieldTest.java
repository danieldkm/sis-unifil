package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldTest extends JFrame {
	
	private JTextField textField1, textField2, textField3;
	private JPasswordField passwordField;
	
	//configura a GUI
	public TextFieldTest() {
		
		super ("Testando JTextField e JPasswordField");
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//constrói campo de texto com dimensões default
		textField1 = new JTextField(10);
		container.add(textField1);
		
		//constrói campo de texto com texto default
		textField2 = new JTextField("Entre com o texto aqui");
		container.add(textField2);
		
		//constrói campo de texto com texto default e 20
		//elementos visíveis e sem tratador de eventos
		textField3 = new JTextField("Campo de texto não-editável", 20);
		textField3.setEditable(false);
		container.add(textField3);
		
		//constrói campo de texto com texto default
		passwordField = new JPasswordField("Texto escondido");
		container.add(passwordField);
		
		//registra tratadores de eventos
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
		
		setSize(325,100);
		setVisible(true);
	}
	
	public static void main (String args[]) {

		TextFieldTest aplicacao = new TextFieldTest();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//classe interna privativa para tratamento de eventos
	private class TextFieldHandler implements ActionListener {
		
		//processa eventos de campos de texto
		public void actionPerformed(ActionEvent event) {
			
			String string = "";
			
			//usuário pressionou ENTER no JTextField textField1
			if (event.getSource() == textField1)
				string = "textField1: " + event.getActionCommand();
			
			//usuário pressionou ENTER no JTextField textField2
			else if (event.getSource() == textField2)
				string = "textField2: " + event.getActionCommand();
			
			//usuário pressionou ENTER no JTextField textField3
			else if (event.getSource() == textField3)
				string = "textField3: " + event.getActionCommand();
			
			//usuário pressionou ENTER no JTextField passwordField
			else if (event.getSource() == passwordField) {
				JPasswordField pwd = (JPasswordField) event.getSource();
				string = "passwordField: " + new String(passwordField.getPassword());
			}
			JOptionPane.showMessageDialog(null, string);
		}	
	}
}