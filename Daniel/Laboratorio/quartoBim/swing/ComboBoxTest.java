package swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTest extends JFrame {

	private JComboBox imagesComboBox;
	private JLabel label;

	private String nomes[] = {"bug1.jpg", "bug2.jpg", "bug3.jpg", "bug4.jpg"};
	private Icon icons[] = {new ImageIcon(nomes[0]), new ImageIcon(nomes[1]),
		new ImageIcon(nomes[2]), new ImageIcon(nomes[3])};

	//configura a GUI
	public ComboBoxTest() {

		super ("Testando JComboBox");

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		//configura a JComboBox e registra o tratador de eventos
		imagesComboBox = new JComboBox(nomes);
		imagesComboBox.setMaximumRowCount(3);

		container.add(imagesComboBox);

		//configura o JLabel para exibir ImageIcons
		label = new JLabel(icons[0]);
		container.add(label);

		//registra eventos para JRadioButtons
		ComboBoxHandler handler = new ComboBoxHandler();
		imagesComboBox.addItemListener(handler);

		setSize(350,100);
		setVisible(true);
	}

	public static void main (String args[]) {

		ComboBoxTest aplicacao = new ComboBoxTest();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

		//classe interna privativa para tratar de eventos de botões de opção
	private class ComboBoxHandler implements ItemListener {

		//trata eventos de botões de opção
		public void itemStateChanged(ItemEvent event) {

		//determina se a caixa de marcação está selecionada
			if (event.getStateChange() == ItemEvent.SELECTED)
				label.setIcon(icons[imagesComboBox.getSelectedIndex()]);
		}
	}

}