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
		
		//obtém painel de conteúdo e configura seu leiaute
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//configura o JTextField
		field = new JTextField("Veja a mudança do estilo da fonte", 25);
		container.add(field);
		
		//cria botões de opção
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
		
		//cria relacionamento lógico entre JRadioButtons
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
	
	//classe interna privativa para tratar de eventos de botões de opção
	private class RadioButtonHandler implements ItemListener {
		
		//trata eventos de botões de opção
		public void itemStateChanged(ItemEvent event) {
			
			//usuário clicou no plainButton
			if (event.getSource() == plainButton)
				field.setFont(plainFont);
			
			//usuário clicou no boldButton
			else if (event.getSource() == boldButton)
				field.setFont(boldFont);
			
			//usuário clicou no italicButton
			else if (event.getSource() == italicButton)
				field.setFont(italicFont);
				
			//usuário clicou no boldItalicButton
			else if (event.getSource() == boldItalicButton)
				field.setFont(boldItalicFont);
		}
	}
}