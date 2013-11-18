package ultimaAula;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridLayoutDemo extends JFrame implements ActionListener {

	private JButton buttons[];
	private String names[] = {"one", "two", "three", "four", "five", "six"};
	private boolean toggle = true;
	private Container container;
	private GridLayout grid1, grid2;

	//configura a GUI
	public GridLayoutDemo() {

		super ("GridLayout Demo");

		//configura leiautes
		grid1 = new GridLayout(2,3);
		grid2 = new GridLayout(3,2);

		//obtém painel de conteúdo e configura o leiaute
		container = getContentPane();
		container.setLayout(grid1);

		//cria e adiciona botões
		buttons = new JButton[names.length];

		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			container.add(buttons[count]);
		}

		setSize(300,150);
		setVisible(true);
	}

	//trata eventos de botão chaveando entre os leiautes
	public void actionPerformed(ActionEvent event) {

		if (toggle)
			container.setLayout(grid2);
		else
			container.setLayout(grid1);

		toggle = !toggle;
		container.validate();
	}

	public static void main (String args[]) {

		GridLayoutDemo aplicacao = new GridLayoutDemo();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
