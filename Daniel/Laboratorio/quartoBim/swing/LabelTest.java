package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelTest extends JFrame {
	
	private JLabel label1, label2, label3;
	
	//configura a GUI
	public LabelTest() {
		
		super ("Testando JLabel");
		
		//obtém painel de conteúdo e configura seu leiaute
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		//construtor JLabel com um argumento string
		label1 = new JLabel("Label com texto");
		label1.setToolTipText("Este é o label1");
		container.add(label1);
		
		//construtor JLabel com argumentos string, Icon e alinhamento
		Icon bug = new ImageIcon("bug1.jpg");
		label2 = new JLabel("Label com texto e ícone", bug, SwingConstants.LEFT);
		label2.setToolTipText("Este é o label2");
		container.add(label2);
		
		//construtor JLabel sem argumentos
		label3 = new JLabel();
		label3.setText("Label com ícone e texto embaixo");
		label3.setIcon(bug);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("Este é o label3");
		container.add(label3);
		
		setSize(275,170);
		setVisible(true);
	}
	
	public static void main (String args[]) {

		LabelTest aplicacao = new LabelTest();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}