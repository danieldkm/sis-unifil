package ultimaAula;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonTest extends JFrame {
	
	private JTextField field;
	private Font plainFont, boldFont, italicFont, boldItalicFont;
	private JRadioButton plainButton, boldButton, italicButton, boldItalicButton;
	private ButtonGroup radioGroup;
	
	//configura a GUI e fontes
	public RadioButtonTest() {
		
		super ("Testando RadioButton");
		
		//obt�m painel de conte�do e configura seu leiaute
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//configura o JTextField
		field = new JTextField("Veja a mudan�a do estilo da fonte", 25);
		container.add(field);
		
		//cria bot�es de op��o
		plainButton = new JRadioButton("Plain", true);
		container.add(plainButton);
		
		boldButton = new JRadioButton("Bold", false);
		container.add(boldButton);
		
		italicButton = new JRadioButton("Italic", false);
		container.add(italicButton);
		
		boldItalicButton = new JRadioButton("Bold/Italic", false);
		container.add(boldItalicButton);
		
		//registra eventos para JRadioButtons
		RadioButtonHandler handler = new RadioButtonHandler();
		plainButton.addItemListener(handler);
		boldButton.addItemListener(handler);
		italicButton.addItemListener(handler);
		boldItalicButton.addItemListener(handler);
		
		//cria relacionamento l�gico entre JRadioButtons
		radioGroup = new ButtonGroup();
		radioGroup.add(plainButton);
		radioGroup.add(boldButton);
		radioGroup.add(italicButton);
		radioGroup.add(boldItalicButton);
		
		//cria objetos Font
		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		field.setFont(plainFont);
		
		setSize(300,100);
		setVisible(true);
	}
	
	public static void main (String args[]) {

		RadioButtonTest aplicacao = new RadioButtonTest();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//classe interna privativa para tratar de eventos de bot�es de op��o
	private class RadioButtonHandler implements ItemListener {
		
		//trata eventos de bot�es de op��o
		public void itemStateChanged(ItemEvent event) {
			
			//usu�rio clicou no plainButton
			if (event.getSource() == plainButton)
				field.setFont(plainFont);
			
			//usu�rio clicou no boldButton
			else if (event.getSource() == boldButton)
				field.setFont(boldFont);
			
			//usu�rio clicou no italicButton
			else if (event.getSource() == italicButton)
				field.setFont(italicFont);
				
			//usu�rio clicou no boldItalicButton
			else if (event.getSource() == boldItalicButton)
				field.setFont(boldItalicFont);
		}
	}
}