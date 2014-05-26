package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import controller.Controller;

import FactoryMethod.Dao;

import entidades.TipoQuarto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroTipoQuarto extends Controller{

	private JDialog frmCadastroTipoDe;
	private static JTextField txtDescricao;
	private static int id;
	private TipoQuarto tipoQuarto;

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
	public TelaCadastroTipoQuarto(TipoQuarto tq) {
		isEdited = true;
		tipoQuarto = tq;
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
		frmCadastroTipoDe.setBounds(100, 100, 337, 160);
		// frmCadastroTipoDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if (isEdited) {
			txtDescricao.setText(tipoQuarto.getDescricao());
		}

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 73, 314, 40);
		frmCadastroTipoDe.getContentPane().add(panel_1);

		JButton btnAtualizar = new JButton("Atualizar/Salvar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEdited) {
					int r = JOptionPane.showConfirmDialog(
							frmCadastroTipoDe,
							"Tem certeza que deseja ATUALIZAR "
									+ tipoQuarto.getDescricao() + " para "
									+ txtDescricao.getText());
					if (r == 0) {
						tipoQuarto.setDescricao(txtDescricao.getText());
						Dao.update(tipoQuarto);
						isEdited = false;
					}
				} else {
					if (validarCampos()) {
					} else {
						tipoQuarto = new TipoQuarto(txtDescricao.getText());
						Dao.insert(tipoQuarto);
						JOptionPane.showMessageDialog(frmCadastroTipoDe,
								"Cadastrado com sucesso!");
//						frmCadastroTipoDe.setVisible(false);
						frmCadastroTipoDe.dispose();
						
					}
				}
			}
		});
		panel_1.add(btnAtualizar);

		JButton btnCriarNovo = new JButton("Criar novo");
		btnCriarNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDescricao.setText(null);
				tipoQuarto = null;
				isEdited = false;
			}
		});
		panel_1.add(btnCriarNovo);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEdited) {
					int r = JOptionPane.showConfirmDialog(frmCadastroTipoDe,
							"Tem certeza que deseja EXCLUIR!\nTipo do quarto a ser excluido "
									+ txtDescricao.getText());
					if (r == 0) {
						Dao.delete(tipoQuarto);
						JOptionPane.showMessageDialog(frmCadastroTipoDe,
								"Deletado com sucesso!");
						frmCadastroTipoDe.dispose();
					}
				} else {
					JOptionPane
							.showMessageDialog(frmCadastroTipoDe,
									"Tipo do quarto não foi selecionado para ser excluído");
				}
			}
		});
		panel_1.add(btnExcluir);

		frmCadastroTipoDe.setModal(true);
		frmCadastroTipoDe.setResizable(false);
		frmCadastroTipoDe.setVisible(true);
	}

	private boolean validarCampos() {
		if (txtDescricao.getText().equals("")) {
			JOptionPane.showMessageDialog(frmCadastroTipoDe,
					"Campo de descrição vazio!!");
			return true;
		}
		for (TipoQuarto tq : getListaTipoQuarto()) {
			if(txtDescricao.getText().equals(tq.getDescricao())){
				JOptionPane.showMessageDialog(frmCadastroTipoDe,
						"Descrição informada ja existe!!");
				return true;
			}
		}
		return false;
	}
}
