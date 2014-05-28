package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import controller.ControllerReserva;

public class TelaCadastroReserva extends ControllerReserva {



//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroReserva window = new TelaCadastroReserva();
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
	public TelaCadastroReserva() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setBounds(100, 100, 450, 549);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Cadastro de Reserva");

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 414, 205);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblVisitante = new JLabel("Visitante:");
		lblVisitante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisitante.setBounds(10, 11, 90, 14);
		panel.add(lblVisitante);

		txtVisitante = new JTextField();
		txtVisitante.setEnabled(false);
		txtVisitante.setBounds(110, 8, 192, 20);
		panel.add(txtVisitante);
		txtVisitante.setColumns(10);

		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuarto.setBounds(10, 42, 90, 14);
		panel.add(lblQuarto);

		txtQuarto = new JTextField();
		txtQuarto.setEnabled(false);
		txtQuarto.setColumns(10);
		txtQuarto.setBounds(110, 39, 192, 20);
		panel.add(txtQuarto);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConsultaVisitante();
			}
		});
		btnNewButton.setBounds(314, 5, 90, 26);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConsultaQuarto();
			}
		});
		btnNewButton_1.setBounds(314, 36, 90, 26);
		panel.add(btnNewButton_1);

		JLabel lblData = new JLabel("Data entrada:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(10, 68, 90, 16);
		panel.add(lblData);

		JLabel lblDataSada = new JLabel("Data sa\u00EDda:");
		lblDataSada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataSada.setBounds(10, 103, 90, 16);
		panel.add(lblDataSada);

		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPagamento.setBounds(10, 138, 90, 16);
		panel.add(lblPagamento);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(10, 172, 90, 16);
		panel.add(lblStatus);

		txtPagamento = new JTextField();
		txtPagamento.setBounds(110, 136, 192, 20);
		panel.add(txtPagamento);
		txtPagamento.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(110, 168, 192, 25);
		panel.add(comboBox);
		comboBox.addItem("Ocupado");
		comboBox.addItem("Reservado");
		comboBox.addItem("Disponível");

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(110, 65, 192, 26);
		panel.add(datePicker);

		UtilDateModel model2 = new UtilDateModel();
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.setBounds(110, 98, 192, 26);
		panel.add(datePicker2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 228, 412, 40);
		frame.getContentPane().add(panel_1);

		JButton btnNewButton_2 = new JButton("Salvar/Atualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar(e);
			}
		});
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Novo/Limpar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar(e);
			}
		});
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Excluir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir(e);
			}
		});
		panel_1.add(btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_2.setBounds(12, 280, 412, 229);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(12, 12, 90, 16);
		panel_2.add(lblPesquisar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(120, 10, 280, 20);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				actionButtonBuscar(e);
			}
		});

		JScrollPane scrollPane = getTable();
		scrollPane.setBounds(12, 40, 388, 153);
		panel_2.add(scrollPane);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

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
