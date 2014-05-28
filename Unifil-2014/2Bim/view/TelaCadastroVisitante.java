package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.ControllerVisitante;

public class TelaCadastroVisitante extends ControllerVisitante {


//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroVisitante window = new TelaCadastroVisitante();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastroVisitante() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setTitle("Cadastro de Visitante");
		frame.setBounds(100, 100, 449, 452);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 424, 102);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 80, 14);
		panel.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 36, 80, 14);
		panel.add(lblTelefone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 61, 80, 14);
		panel.add(lblEmail);

		txtNome = new JTextField();
		txtNome.setBounds(100, 8, 314, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(100, 33, 314, 20);
		panel.add(txtTelefone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 58, 314, 20);
		panel.add(txtEmail);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 124, 424, 40);
		frame.getContentPane().add(panel_1);

		JButton btnSalvaratualizar = new JButton("Salvar/Atualizar");
		btnSalvaratualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar(e);
			}
		});
		panel_1.add(btnSalvaratualizar);

		JButton btnNovolimpar = new JButton("Novo/Limpar");
		btnNovolimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(e);
			}
		});
		panel_1.add(btnNovolimpar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir(e);
			}
		});
		panel_1.add(btnExcluir);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_2.setBounds(10, 176, 421, 236);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(12, 12, 80, 16);
		panel_2.add(lblPesquisar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(110, 10, 299, 20);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				actionButtonBuscar(e);
			}
		});

		JScrollPane scrollPane = getTable();
		scrollPane.setBounds(12, 40, 397, 184);
		panel_2.add(scrollPane);
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
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}

}
