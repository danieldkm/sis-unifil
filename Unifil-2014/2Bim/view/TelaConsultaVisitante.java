package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.ControllerVisitante;

public class TelaConsultaVisitante extends ControllerVisitante {


	// /**
	// * Launch the application.
	// */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// TelaConsultaVisitante window = new TelaConsultaVisitante();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public TelaConsultaVisitante() {
		isConsulta = true;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setBounds(100, 100, 513, 479);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 477, 419);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesquisar.setBounds(10, 11, 90, 14);
		panel.add(lblPesquisar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(110, 8, 357, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				actionButtonBuscar(e);
			}
		});

		JScrollPane scrollPane = getTable();
		scrollPane.setBounds(10, 36, 457, 372);
		panel.add(scrollPane);
		table.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				actionMouseClickedOnTable(e);
			}
		});

		frame.setResizable(false);
		frame.setModal(true);
		frame.setVisible(true);
	}
}
