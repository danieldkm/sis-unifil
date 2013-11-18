package ultimaAula;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxTest extends JFrame {
	
	private JTextField field;
	private JCheckBox bold, italic;
	
	//configura a GUI
	public CheckBoxTest() {
		
		super ("Testando JCheckBox");
		
		//obtém painel de conteúdo e configura seu leiaute
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//configura o JTextField e configura a fonte
		field = new JTextField("Veja a mudança do estilo da fonte", 20);
		field.setFont(new Font("Serif", Font.PLAIN, 14));
		container.add(field);
		
		//cria objetos caixa de marcação
		bold = new JCheckBox("Negrito");
		container.add(bold);
		
		italic = new JCheckBox("Itálico");
		container.add(italic);
		
		//registra ouvintes para JCheckBoxes
		CheckBoxHandler handler = new CheckBoxHandler();
		bold.addItemListener(handler);
		italic.addItemListener(handler);
		
		setSize(275,100);
		setVisible(true);
	}
	
	public static void main (String args[]) {

		CheckBoxTest aplicacao = new CheckBoxTest();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//classe interna para tratamento de evento do botão
	private class CheckBoxHandler implements ItemListener {
		
		private int valBold = Font.PLAIN;
		private int valItalic = Font.PLAIN;
		
		//responde a eventos de caixas de marcação
		public void itemStateChanged(ItemEvent event) {
			
			//processa eventos da caixa de marcação Bold
			if (event.getSource() == bold) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					valBold = Font.BOLD;
				else
					valBold = Font.PLAIN;
			}	
				
			//processa eventos da caixa de marcação Italic
			if (event.getSource() == italic) {
				if (event.getStateChange() == ItemEvent.SELECTED)
					valItalic = Font.ITALIC;
				else
					valItalic = Font.PLAIN;
			}
			
			//configura a fonte do campo de texto
			field.setFont(new Font("Serif", valBold + valItalic, 14));
		}
	}
}