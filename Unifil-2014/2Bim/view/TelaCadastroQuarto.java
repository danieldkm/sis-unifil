package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import tabela.TabelaQuarto;

import controller.Controller;

import FactoryMethod.Dao;
import Tarefa3.ModeloTabela;
import Tarefa3.Pessoa;
import entidades.Quarto;
import entidades.TipoQuarto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastroQuarto extends Controller {

	private JDialog frmQuarto;
	private JTextField txtDescricao;
	private JTextField txtCapacidade;
	private JTextField buscar;
	private JTable table;
	private ArrayList<TipoQuarto> listaTipoQuarto = new ArrayList<>();
	private ArrayList<Quarto> listaQuarto;
	private TabelaQuarto tQuarto;
	private JTable tabela;
	private JComboBox cbTipo;
	private Quarto quartoSelecionado;

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
		frmQuarto.setBounds(100, 100, 388, 453);
		// frmQuarto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuarto.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 360, 102);
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
				// ArrayList<Object> listaObjeto = Dao.select(new TipoQuarto());
				// ArrayList<TipoQuarto> listaTipoQuarto = new ArrayList<>();
				for (TipoQuarto tp : listaTipoQuarto) {
					if (tp.getDescricao().equals(cbTipo.getSelectedItem())) {
						new TelaCadastroTipoQuarto(tp);
						frmQuarto.dispose();
						break;
					}
				}
			}
		});
		btnEditarTipo.setBounds(241, 35, 107, 23);
		panel.add(btnEditarTipo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_1.setBounds(10, 124, 360, 40);
		frmQuarto.getContentPane().add(panel_1);

		JButton btnSalvar = new JButton("Salvar/Atualizar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!validarCampos()) {
						if (isEdited) {
							quartoSelecionado.setDescricao(txtDescricao.getText());
							quartoSelecionado.setTipo(cbTipo.getSelectedItem().toString());
							quartoSelecionado.setCapacidade(Integer.parseInt(txtCapacidade.getText()));
							Dao.update(quartoSelecionado);
							quartoSelecionado = null;
							JOptionPane.showMessageDialog(frmQuarto,
									"Atualizado com sucesso!");
							isEdited = false;
							frmQuarto.dispose();
						} else {
							Quarto q = new Quarto(txtDescricao.getText(),
									cbTipo.getSelectedItem().toString(), Integer.parseInt(txtCapacidade
											.getText()));
							Dao.insert(q);
							JOptionPane.showMessageDialog(frmQuarto,
									"Cadastrado com sucesso!");
							frmQuarto.dispose();
							System.out.println("Salvo com sucesso");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Erro ao salvar");
				}
			}
		});
		panel_1.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isEdited) {
					int r = JOptionPane.showConfirmDialog(frmQuarto,
							"Tem certeza que deseja EXCLUIR!\nO quarto a ser excluido: "
									+ txtDescricao.getText());
					if (r == 0) {
						Dao.delete(quartoSelecionado);
						JOptionPane.showMessageDialog(frmQuarto,
								"Deletado com sucesso!");
						frmQuarto.dispose();
					}
				} else {
					JOptionPane
							.showMessageDialog(frmQuarto,
									"Quarto não foi selecionado para ser excluído");
				}
			}
		});
		
		JButton btnNovo = new JButton("Novo/Limpar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isEdited = false;
				quartoSelecionado = null;
				txtCapacidade.setText(null);
				txtDescricao.setText(null);
				cbTipo.setSelectedIndex(0);
			}
		});
		panel_1.add(btnNovo);
		panel_1.add(btnExcluir);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel_2.setBounds(10, 175, 360, 233);
		frmQuarto.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pesquisa:");
		lblNewLabel.setBounds(10, 11, 58, 14);
		panel_2.add(lblNewLabel);

		buscar = new JTextField();
		buscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ArrayList<Quarto> novaLista = new ArrayList<>();
				String bus = "";
				for (Quarto q : listaQuarto) {
					bus = q.getId() + q.getDescricao() + q.getTipo() + q.getCapacidade();
					if(bus.contains(buscar.getText())){
						novaLista.add(q);
					}
				}
				tQuarto.atualizarTabela(novaLista);
			}
		});
		buscar.setBounds(78, 8, 270, 20);
		panel_2.add(buscar);
		buscar.setColumns(10);
		

		JScrollPane scrollPane = getTable();
		scrollPane.setBounds(10, 36, 338, 186);
		panel_2.add(scrollPane);

		// table = new JTable();
		// scrollPane.setViewportView(table);

		// ArrayList<Object> listaObjeto = Dao.select(new TipoQuarto());
		// ArrayList<TipoQuarto> listaTipoQuarto = new ArrayList<>();
		listaTipoQuarto = getListaTipoQuarto();
		if (listaTipoQuarto.isEmpty()) {
			System.out.println("Lista de quarto está vazia");
			int r = JOptionPane
					.showConfirmDialog(
							frmQuarto,
							"Para cadastrar um quarto, deve antes cadastrar pelo menos 1 tipo de Quarto!\nDeseja cadastrar agora?");
			switch (r) {
			case 0:
				System.out.println("0");
				new TelaCadastroTipoQuarto();
				break;
			}
		} else {
			for (TipoQuarto tipoQuarto : listaTipoQuarto) {
				cbTipo.addItem(tipoQuarto.getDescricao());
			}
			// listaTipoQuarto.add(new TipoQuarto(1,"teste"));
			// cbTipo.addItem(listaTipoQuarto.get(0).getDescricao());
			frmQuarto.setResizable(false);
			frmQuarto.setModal(true);
			frmQuarto.setVisible(true);
		}
	}

	private boolean validarCampos() {
		if (txtDescricao.getText().equals(null)
				|| txtDescricao.getText().equals("")) {
			JOptionPane.showMessageDialog(frmQuarto,
					"Campo DESCRIÇÃO não foi preenchido");
			return true;
		} else if (txtCapacidade.getText().equals("")
				|| txtCapacidade.getText().equals(null)) {
			JOptionPane.showMessageDialog(frmQuarto,
					"Campo CAPACIDADE não foi preenchido");
			return true;
		}
		
		try {
			int n = Integer.parseInt(txtCapacidade.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmQuarto,
					"Campo CAPACIDADE deve ser um número");
			return true;
		}
		return false;
	}

	private JScrollPane getTable() {
		listaQuarto = getListaQuarto();
		tQuarto = new TabelaQuarto(listaQuarto);
		tabela = new JTable(tQuarto);
		tabela.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					System.out.println("selecionada "
							+ tabela.getModel().getValueAt(
									tabela.getSelectedRow(), 0));
					quartoSelecionado = new Quarto(tabela.getModel()
							.getValueAt(tabela.getSelectedRow(), 1).toString(),
							tabela.getModel()
									.getValueAt(tabela.getSelectedRow(), 2)
									.toString(), Integer.parseInt(tabela
									.getModel()
									.getValueAt(tabela.getSelectedRow(), 3)
									.toString()));
					quartoSelecionado.setId(Integer.parseInt(tabela.getModel()
							.getValueAt(tabela.getSelectedRow(), 0).toString()));
					txtDescricao.setText(quartoSelecionado.getDescricao());
					txtCapacidade.setText(quartoSelecionado.getCapacidade()
							+ "");
					cbTipo.setSelectedItem(quartoSelecionado.getTipo());
					isEdited = true;
				}

			}
		});
		return new JScrollPane(tabela);
	}
}
