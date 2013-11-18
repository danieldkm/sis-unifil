package ultimaAula;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Swing extends JFrame {

	private GridLayout grid;
	private Container container;
	private JButton btnMostrar, btnLimpar;
	private JLabel lbl1, lbl2, lbl3;
	private JTextField txtAltura, txtPeso, txtResultado;

	public Swing() {
		super("Testando");

		grid = new GridLayout(4, 2);

		container = getContentPane();
		container.setLayout(grid);

		lbl1 = new JLabel("Altura:");
		container.add(lbl1);
		txtAltura = new JTextField();
		container.add(txtAltura);
		lbl2 = new JLabel("Peso:");
		container.add(lbl2);
		txtPeso = new JTextField();
		container.add(txtPeso);
		lbl3 = new JLabel("Resultado:");
		container.add(lbl3);
		txtResultado = new JTextField();
		container.add(txtResultado);

		BotaoHandle handle = new BotaoHandle();

		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(handle);
		container.add(btnMostrar);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(handle);
		container.add(btnLimpar);

		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		Swing t = new Swing();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class BotaoHandle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnMostrar) {
				JOptionPane.showMessageDialog(
						null,
						"Altura: " + txtAltura.getText() + "\nPeso: "
								+ txtPeso.getText() + "\nResultado: "
								+ txtResultado.getText());
			} else if (e.getSource() == btnLimpar) {
				txtAltura.setText("");
				txtPeso.setText("");
				txtResultado.setText("");
			}
		}

	}
}
