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

import controller.ControllerQuarto;
import controller.Telas;

public class TelaConsultaQuarto /*extends ControllerQuarto*/ {
	private JDialog frmQuarto;
	private Telas controle;
	private boolean isConsulta;
	private JTextField txtBuscar;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaConsultaQuarto window = new TelaConsultaQuarto();
//					window.frmQuarto.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaConsultaQuarto() {
		isConsulta = true;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuarto = new JDialog();
		frmQuarto.setBounds(100, 100, 477, 379);
		frmQuarto.setTitle("Consulta Quarto");
		frmQuarto.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 441, 319);
		frmQuarto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesquisar.setBounds(10, 11, 91, 14);
		panel.add(lblPesquisar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(111, 8, 320, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controle.actionButtonBuscar(e);
			}
		});
		
		controle = new ControllerQuarto(frmQuarto, txtBuscar, isConsulta);
		JScrollPane scrollPane = controle.getTable();
		scrollPane.setBounds(10, 37, 419, 270);
		panel.add(scrollPane);
		controle.setAddMouseListener();
//		table.addMouseListener(new MouseListener() {
//			@Override public void mouseReleased(MouseEvent e) {}
//			@Override public void mousePressed(MouseEvent e) {}
//			@Override public void mouseExited(MouseEvent e) {}
//			@Override public void mouseEntered(MouseEvent e) {}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				actionMouseClickedOnTable(e);
//			}
//		});
		
		frmQuarto.setResizable(false);
		frmQuarto.setModal(true);
		frmQuarto.setVisible(true);
	}

}
