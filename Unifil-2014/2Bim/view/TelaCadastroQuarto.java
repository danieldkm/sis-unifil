package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.ControllerQuarto;
import entidades.TipoQuarto;
import controller.Telas;

public class TelaCadastroQuarto /*extends ControllerQuarto*/  {

	private Telas controle;
	private JDialog frmQuarto;
	private JTextField txtDescricao;
	private JTextField txtCapacidade;
	private JTextField txtBuscar;
//	private ArrayList<TipoQuarto> listaTipoQuarto = new ArrayList<>();
	private JComboBox cbTipo;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroQuarto window = new TelaCadastroQuarto();
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
	public TelaCadastroQuarto() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuarto = new JDialog();
		frmQuarto.setTitle("Cadastro de Quarto");
		frmQuarto.setBounds(100, 100, 407, 453);
		// frmQuarto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuarto.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 391, 102);
		frmQuarto.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 14, 77, 14);
		panel.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(90, 11, 258, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 39, 77, 14);
		panel.add(lblTipo);

		cbTipo = new JComboBox();
		cbTipo.setBounds(90, 36, 135, 20);
		// cbTipo.addItem("1");
		// cbTipo.addItem("2");
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
				controle.setActionListenerBtn();
			}
		});
		btnEditarTipo.setBounds(241, 35, 107, 23);
		panel.add(btnEditarTipo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 124, 391, 40);
		frmQuarto.getContentPane().add(panel_1);

		JButton btnSalvar = new JButton("Salvar/Atualizar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controle.salvar(arg0);
			}
		});
		panel_1.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.excluir(e);
			}
		});
		
				JButton btnNovo = new JButton("Novo/Limpar");
				btnNovo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controle.limpar(e);
					}
				});
				panel_1.add(btnNovo);
		panel_1.add(btnExcluir);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_2.setBounds(10, 175, 391, 250);
		frmQuarto.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pesquisa:");
		lblNewLabel.setBounds(10, 11, 75, 14);
		panel_2.add(lblNewLabel);

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controle.actionButtonBuscar(e);
			}
		});
		txtBuscar.setBounds(97, 8, 288, 20);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);

		controle = new ControllerQuarto(frmQuarto, txtDescricao, txtCapacidade, txtBuscar, cbTipo);
		JScrollPane scrollPane = controle.getTable();
		scrollPane.setBounds(10, 36, 375, 186);
		panel_2.add(scrollPane);
		controle.setAddMouseListener();
		controle.verificarTipoQuarto();
	}
}
