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
import controller.Controller;
import entidades.Quarto;
import entidades.Visitante;

public class TelaCadastroVisitante extends Controller implements Telas {

	private JDialog frame;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVisitante window = new TelaCadastroVisitante();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
				try {
					if (!validarCampos()) {
						if (isEdited) {
							visitanteSelecionado.setNome(txtNome.getText());
							visitanteSelecionado.setTelefone(txtTelefone
									.getText());
							visitanteSelecionado.setEmail(txtEmail.getText());
							Dao.update(visitanteSelecionado);
							visitanteSelecionado = null;
							JOptionPane.showMessageDialog(frame,
									"Atualizado com sucesso!");
							isEdited = false;
							frame.dispose();
						} else {
							visitanteSelecionado = new Visitante(txtNome
									.getText(), txtTelefone.getText(), txtEmail
									.getText());
							Dao.insert(visitanteSelecionado);
							JOptionPane.showMessageDialog(frame,
									"Cadastrado com sucesso!");
							frame.dispose();
							System.out.println("Salvo com sucesso");
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		panel_1.add(btnSalvaratualizar);

		JButton btnNovolimpar = new JButton("Novo/Limpar");
		btnNovolimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isEdited = false;
				visitanteSelecionado = null;
				txtBuscar.setText(null);
				txtEmail.setText(null);
				txtNome.setText(null);
				txtTelefone.setText(null);
				txtTelefone.setText(null);
			}
		});
		panel_1.add(btnNovolimpar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEdited) {
					int r = JOptionPane.showConfirmDialog(frame,
							"Tem certeza que deseja EXCLUIR!\nVisitante a ser excluido: "
									+ visitanteSelecionado.getNome());
					if (r == 0) {
						Dao.delete(visitanteSelecionado);
						JOptionPane.showMessageDialog(frame,
								"Deletado com sucesso!");
						frame.dispose();
					}
				} else {
					JOptionPane
							.showMessageDialog(frame,
									"Visitante não foi selecionado para ser excluído");
				}
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
				ArrayList<Visitante> novaLista = new ArrayList<>();
				String bus = "";
				for (Visitante v : listaVisitante) {
					bus = v.getId() + v.getNome() + v.getTelefone() + v.getEmail();
					if(bus.contains(txtBuscar.getText())){
						novaLista.add(v);
					}
				}
				tVisitante.atualizarTabela(novaLista);
			}
		});

		JScrollPane scrollPane = getTable("visitante");
		scrollPane.setBounds(12, 40, 397, 184);
		panel_2.add(scrollPane);
		table.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					visitanteSelecionado = new Visitante(table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
						table.getModel().getValueAt(table.getSelectedRow(), 2).toString(), 
						table.getModel().getValueAt(table.getSelectedRow(), 3).toString());
					visitanteSelecionado.setId(Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 0).toString()));
					txtNome.setText(visitanteSelecionado.getNome());
					txtTelefone.setText(visitanteSelecionado.getTelefone());
					txtEmail.setText(visitanteSelecionado.getEmail());
					isEdited = true;
				}
			}
		});

		frame.setResizable(false);
		frame.setModal(true);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public boolean validarCampos() {
		if (txtNome.getText().equals("") || txtNome.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo NOME não foi preenchido");
			return true;
		} else if (txtTelefone.getText().equals("")
				|| txtTelefone.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo TELEFONE não foi preenchido");
			return true;
		} else if (txtEmail.getText().equals("")
				|| txtEmail.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo E-MAIL não foi preenchido");
			return true;
		}
		return false;
	}
}
