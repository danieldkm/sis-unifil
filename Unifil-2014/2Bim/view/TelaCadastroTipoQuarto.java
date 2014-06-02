package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import FactoryMethod.Dao;
import controller.ControllerTipoQuarto;
import controller.Telas;
import entidades.TipoQuarto;

public class TelaCadastroTipoQuarto /*extends ControllerTipoQuarto*/ {

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroTipoQuarto window = new TelaCadastroTipoQuarto();
//					window.frmCadastroTipoDe.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	private TipoQuarto tipoQuartoSelecionado;
	private boolean isEdited = false;
	private Telas controle;
	private JDialog frmCadastroTipoDe;
	private JTextField txtDescricao;
	private JTextField txtBuscar;

	/**
	 * Create the application.
	 */
	public TelaCadastroTipoQuarto(TipoQuarto tq) {
		isEdited = true;
		tipoQuartoSelecionado = tq;
		initialize();
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroTipoQuarto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroTipoDe = new JDialog();
		frmCadastroTipoDe.setTitle("Cadastro tipo de quarto");
		frmCadastroTipoDe.setBounds(100, 100, 400, 387);
		// frmCadastroTipoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroTipoDe.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 377, 51);
		frmCadastroTipoDe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(10, 11, 72, 14);
		panel.add(lblDescricao);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(92, 8, 280, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		if (isEdited) {
			txtDescricao.setText(tipoQuartoSelecionado.getDescricao());
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 73, 377, 40);
		frmCadastroTipoDe.getContentPane().add(panel_1);

		JButton btnAtualizar = new JButton("Atualizar/Salvar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.salvar(e);
			}
		});
		panel_1.add(btnAtualizar);

		JButton btnCriarNovo = new JButton("Criar novo");
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.limpar(e);
			}
		});
		panel_1.add(btnCriarNovo);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controle.excluir(e);
			}
		});
		panel_1.add(btnExcluir);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_2.setBounds(10, 124, 377, 224);
		frmCadastroTipoDe.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 11, 80, 14);
		panel_2.add(lblPesquisar);

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				controle.actionButtonBuscar(e);
			}
		});
		txtBuscar.setBounds(100, 8, 275, 20);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		controle = new ControllerTipoQuarto(frmCadastroTipoDe, txtDescricao, txtBuscar, tipoQuartoSelecionado, isEdited);
		JScrollPane scrollPane = controle.getTable();
		scrollPane.setBounds(10, 37, 360, 175);
		panel_2.add(scrollPane);
		controle.setAddMouseListener();

		frmCadastroTipoDe.setModal(true);
		frmCadastroTipoDe.setResizable(false);
		frmCadastroTipoDe.setVisible(true);
	}

}
