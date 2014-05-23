package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import FactoryMethod.Dao;
import entidades.Quarto;

public class TelaCadastroQuarto {

	private JDialog frmQuarto;
	private JTextField txtDescricao;
	private JTextField txtCapacidade;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroQuarto window = new TelaCadastroQuarto();
					window.frmQuarto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroQuarto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuarto = new JDialog();
		frmQuarto.setTitle("Cadastro de Quarto");
		frmQuarto.setBounds(100, 100, 375, 453);
		// frmQuarto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuarto.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 347, 102);
		frmQuarto.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 14, 77, 14);
		panel.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(90, 11, 240, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 39, 77, 14);
		panel.add(lblTipo);

		final JComboBox cbTipo = new JComboBox();
		cbTipo.setBounds(90, 36, 135, 20);
		// ArrayList<String> array = new ArrayList();
		// array.add("1");
		// cbTipo.setadd("");
		cbTipo.addItem("1");
		cbTipo.addItem("2");
		panel.add(cbTipo);

		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setBounds(10, 63, 77, 14);
		panel.add(lblCapacidade);

		txtCapacidade = new JTextField();
		txtCapacidade.setBounds(90, 60, 135, 20);
		panel.add(txtCapacidade);
		txtCapacidade.setColumns(10);
		
		JButton btnEditarTipo = new JButton("Editar tipo");
		btnEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaCadastroTipoQuarto();
			}
		});
		btnEditarTipo.setBounds(241, 35, 89, 23);
		panel.add(btnEditarTipo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 124, 347, 40);
		frmQuarto.getContentPane().add(panel_1);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Quarto q = new Quarto(txtDescricao.getText(), Integer
							.parseInt(cbTipo.getSelectedItem().toString()),
							Integer.parseInt(txtCapacidade.getText()));
					Dao.insert(q);
					System.out.println("Salvo com sucesso");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Erro ao salvar");
				}
			}
		});
		panel_1.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		panel_1.add(btnExcluir);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_2.setBounds(10, 175, 347, 233);
		frmQuarto.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pesquisa:");
		lblNewLabel.setBounds(10, 11, 58, 14);
		panel_2.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(78, 8, 259, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 327, 186);
		panel_2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		frmQuarto.setResizable(false);
		frmQuarto.setModal(true);
		frmQuarto.setVisible(true);
	}
}
