package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroTipoQuarto {

	private JDialog frmCadastroTipoDe;
	private static JTextField txtDescricao;
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTipoQuarto window = new TelaCadastroTipoQuarto();
					window.frmCadastroTipoDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmCadastroTipoDe.setBounds(100, 100, 337, 160);
//		frmCadastroTipoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroTipoDe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 314, 51);
		frmCadastroTipoDe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(10, 11, 72, 14);
		panel.add(lblDescricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(92, 8, 165, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 73, 314, 40);
		frmCadastroTipoDe.getContentPane().add(panel_1);
		
		JButton btnAtualizar = new JButton("Atualizar");
		panel_1.add(btnAtualizar);
		
		JButton btnCriarNovo = new JButton("Criar novo");
		panel_1.add(btnCriarNovo);
		
		frmCadastroTipoDe.setModal(true);
		frmCadastroTipoDe.setResizable(false);
		frmCadastroTipoDe.setVisible(true);
	}
	
	public static void setComponent(int id, String descricao){
		TelaCadastroTipoQuarto.id = id;
		TelaCadastroTipoQuarto.txtDescricao.setText(descricao);
	}

}
