package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import tabela.ClienteTabela;
import controller.ClienteController;
import dao.ClienteDao;
import entity.Cliente;

public class BuscarClienteFrame extends JFrame implements TableModelListener {

	private static final long serialVersionUID = 1L;
	private JFrame frmBuscarCliente;
	Font fontTextCima = new Font(Font.DIALOG, Font.BOLD, 16);
	Font font = new Font(Font.DIALOG, Font.PLAIN, 5);
	private JTable tbBuscarClientes;
	private JTextField txtBuscaCodigo;
	private JTextField txtBuscaNome;
	private ClienteTabela modelo;
	private JScrollPane scrollPane;
	private ClienteDao clienteDao;
	private MaskFormatter formatData;
	private MaskFormatter formatoData;
	private MaskFormatter formatCPF;
	private MaskFormatter formatRG;
	private MaskFormatter formatCEP;
	private MaskFormatter formatTel;
	private MaskFormatter formatCel;
	// p/ listeners da tabela
	// private JButton btnOk = null;
	// private JButton btnCancelar = null;
	// protected boolean okSelecionado;
	private ClienteFrame clienteFrame;

	// busca
	private TableRowSorter<TableModel> rowSorter;

	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// BuscarClienteFrame window = new BuscarClienteFrame();
	// window.frmBuscarCliente.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public BuscarClienteFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmBuscarCliente = new JFrame();
		frmBuscarCliente.setTitle("Localizar Cliente");
		frmBuscarCliente.setBounds(100, 100, 800, 600);
		// finaliza o programa**
		frmBuscarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBuscarCliente.getContentPane().setLayout(null);

		// /Table////
		modelo = new ClienteTabela();
		clienteDao = new ClienteDao();
		tbBuscarClientes = new JTable();
		modelo.addTableModelListener(this);
		try {
			modelo.adicionaLista(clienteDao.findClientes());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		tbBuscarClientes.setModel(modelo);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 772, 493);
		scrollPane.setViewportView(tbBuscarClientes);
		frmBuscarCliente.getContentPane().add(scrollPane);
		tamanhoColuna();
		formatarCelulas();
		tbBuscarClientes.setAutoCreateRowSorter(true);

		// JTextField
		txtBuscaCodigo = new JTextField();
		txtBuscaCodigo.setBounds(190, 41, 187, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaCodigo);
		txtBuscaCodigo.setColumns(10);
		txtBuscaCodigo.setFont(fontTextCima);
		// busca por codigo
		txtBuscaCodigo.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String text = txtBuscaCodigo.getText().trim();
				rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
			}
		});

		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(190, 10, 187, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		txtBuscaNome.setFont(fontTextCima);
		// busca por nome
		txtBuscaNome.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				String text = txtBuscaNome.getText().trim();
				rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 3));
			}
		});

		// JLabel
		JLabel lblLocalizarPorCdigo = new JLabel("Localizar por C\u00F3digo");
		lblLocalizarPorCdigo.setBounds(10, 41, 170, 14);
		frmBuscarCliente.getContentPane().add(lblLocalizarPorCdigo);
		lblLocalizarPorCdigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		JLabel lblLocalizarPorNome = new JLabel("Localizar por Nome");
		lblLocalizarPorNome.setBounds(10, 11, 169, 14);
		frmBuscarCliente.getContentPane().add(lblLocalizarPorNome);
		lblLocalizarPorNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		JButton btnBuscarExcluir = new JButton("Excluir");
		btnBuscarExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// modelo.remove(tbBuscarClientes.getSelectedRow());
				// String[] options = new String[] { "Claro", "Nahhh" };
				//
				// Object ret = JOptionPane.showOptionDialog(null, "Vai?",
				// "Titulo",
				// JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				// null,
				// options, options[0]);
				//
				// System.out.println(options[Integer.valueOf(ret.toString())]);
				String[] options = new String[] { "Sim", "Não" };
				Object ret = JOptionPane
						.showOptionDialog(null,
								"Deseja Excluir o Cliente selecionado?",
								"Excluir Cliente", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);

				if (ret.equals(JOptionPane.YES_NO_OPTION)) {
					// pega a linha selecionada
					int indice = tbBuscarClientes.getSelectedRow();
					JOptionPane.showMessageDialog(null, "Excluído");
					Object Object = modelo.getValueAt(indice, 0);
					clienteDao.excluir(Object);
					modelo.remove(indice);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao excluir");
				}
			}
		});
		btnBuscarExcluir.setBounds(691, 8, 91, 51);
		frmBuscarCliente.getContentPane().add(btnBuscarExcluir);

		JButton btnBuscarAdicionar = new JButton("Novo");
		btnBuscarAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = new String[] { "Sim", "Não" };
				Object ret = JOptionPane
						.showOptionDialog(null,
								"Deseja Adicionar Novo Cliente?",
								"Adicionar Cliente", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);

				if (ret.equals(JOptionPane.YES_NO_OPTION)) {
					Cliente c = new Cliente(clienteDao.lastId(), dataAtual(),
							dataAtual(), "", "01/01/1999", "", "", "", "", "",
							"", "", "", "", "Masculino", "", "Solteiro");
					ClienteController cc = new ClienteController();
					try {
						cc.salvar("", "01/01/1999", "", "", "", "", "", "", "",
								"", "", "Masculino", "", "Solteiro");
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					modelo.inserir(c);
				}
			}

		});
		btnBuscarAdicionar.setBounds(590, 10, 91, 48);
		frmBuscarCliente.getContentPane().add(btnBuscarAdicionar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tbBuscarClientes.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null,
							"Seleciona uma linha para voltar!!");
				} else {
					frmBuscarCliente.dispose();
					clienteFrame = new ClienteFrame();
					String codigo = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 0).toString();
					String nome = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 3).toString();
					String dataCadastro = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 1).toString();
					String dataNascimento = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 4).toString();
					String cpf = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 5).toString();
					String rg = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 6).toString();
					String endereco = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 7).toString();
					String bairro = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 8).toString();
					String cidade = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 9).toString();
					String estado = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 10).toString();
					String cep = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 11).toString();
					String telefone = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 12).toString();
					String celular = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 13).toString();
					String sexo = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 14).toString();
					String natu = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 15).toString();
					String estCivil = modelo.getValueAt(
							tbBuscarClientes.getSelectedRow(), 16).toString();
					clienteFrame.metodo(codigo, nome, dataCadastro,
							dataNascimento, cpf, rg, endereco, bairro, cidade,
							estado, cep, telefone, celular, sexo, natu,
							estCivil);
				}
			}

		});
		btnVoltar.setBounds(489, 12, 91, 46);
		frmBuscarCliente.getContentPane().add(btnVoltar);

		formatarCelulas();
		setColunaDtNascimento();
		setColunaSexo();
		setColunaCPF();
		setColunaRG();
		setColunaCep();
		setColunaTel();
		setColunaCel();
		setColunaEstCivil();
		setColunaEstado();
		setRowSorter();
		frmBuscarCliente.setVisible(true);
		frmBuscarCliente.setResizable(false);
	}

	// atualiza a tabela quando é digitado nos campos nome e id
	private void setRowSorter() {
		if (rowSorter == null) {
			rowSorter = new TableRowSorter<TableModel>(
					tbBuscarClientes.getModel());
			tbBuscarClientes.setRowSorter(rowSorter);
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// quando a estrutura de dados muda, imprimimos a informação. Fazer a
		// persistência no banco seria o comportamento realista desse método.
		String tipo;
		System.out.println("Primeira Linha: " + e.getFirstRow());
		System.out.println("Última Linha:" + e.getLastRow());
		System.out.println("Coluna:" + e.getColumn());
		System.out.println(e.getSource());
		ClienteController cc = new ClienteController();
		Cliente c = modelo.cliente(e.getFirstRow());

		switch (e.getType()) {
		case TableModelEvent.DELETE:
			tipo = "DELETE";
			// modelo.fireTableRowsDeleted(e.getFirstRow(), e.getLastRow());
			// long id = 0;
			// try {
			// cc.excluir(id);
			// } catch (SQLException e3) {
			// JOptionPane.showMessageDialog(null, "Erro ao Deletar");
			// e3.printStackTrace();
			// }
			// Object Object = tbBuscarClientes.getValueAt(indice, 0);

			break;
		case TableModelEvent.INSERT:
			tipo = "INSERT";
			if (e.getFirstRow() == 0) {
			} else {
				try {
					cc.salvar(c.getNome(), c.getDataNascimento(), c.getCpf(),
							c.getRg(), c.getEndereco(), c.getBairro(),
							c.getCidade(), c.getEstado(), c.getCep(),
							c.getTelefone(), c.getCelular(), c.getSexo(),
							c.getNaturalidade(), c.getEstadoCivil());
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, "Erro ao Inserir");
					e2.printStackTrace();
				} catch (ParseException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Inserir");
				}
			}
			break;
		case TableModelEvent.UPDATE:
			try {
				cc.alterar(c.getId(), c.getNome(), c.getDataNascimento(),
						c.getCpf(), c.getRg(), c.getEndereco(), c.getBairro(),
						c.getCidade(), c.getEstado(), c.getCep(),
						c.getTelefone(), c.getCelular(), c.getSexo(),
						c.getNaturalidade(), c.getEstadoCivil());
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
				e1.printStackTrace();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
				e1.printStackTrace();
			}
			tipo = "UPDATE";
			break;
		default:
			tipo = "?";
			break;
		}
		// mostra uma mensagem:
		// TIPO_DE_EVENTO: linhaInicial-linhaFinal, coluna
		// -1 representa todas as linhas ou todas as colunas
		// 2147483647 representa possível mudança em toda a tabela
		System.out.printf("%s: %d-%d, %d%n", tipo, e.getFirstRow(),
				e.getLastRow(), e.getColumn());
	}

	public void tamanhoColuna() {
		tbBuscarClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbBuscarClientes.getColumnModel().getColumn(0).setPreferredWidth(25);
		tbBuscarClientes.getColumnModel().getColumn(1).setPreferredWidth(75);
		tbBuscarClientes.getColumnModel().getColumn(3).setPreferredWidth(150);
		tbBuscarClientes.getColumnModel().getColumn(4).setPreferredWidth(75);
		tbBuscarClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
		tbBuscarClientes.getColumnModel().getColumn(6).setPreferredWidth(85);
		tbBuscarClientes.getColumnModel().getColumn(7).setPreferredWidth(200);
		tbBuscarClientes.getColumnModel().getColumn(12).setPreferredWidth(100);
		tbBuscarClientes.getColumnModel().getColumn(13).setPreferredWidth(100);
	}

	public String dataAtual() {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
		String dataAtual = formatarDate.format(data);
		String dataA = dataAtual.replace('-', '/');
		String dataInv = "";
		dataInv = "" + dataA.substring(0, 2) + dataA.substring(2, 6)
				+ dataA.substring(6, 10);
		return dataInv;
	}

	// Formatar coluna Sexo
	public void setColunaSexo() {
		TableColumn sexo = tbBuscarClientes.getColumnModel().getColumn(14);
		javax.swing.JComboBox comboBox = new javax.swing.JComboBox();
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");
		sexo.setCellEditor(new DefaultCellEditor(comboBox));
	}

	// Formatar coluna Estado civil
	public void setColunaEstCivil() {
		TableColumn estCivil = tbBuscarClientes.getColumnModel().getColumn(16);
		javax.swing.JComboBox comboBox = new javax.swing.JComboBox();
		comboBox.addItem("Solteiro");
		comboBox.addItem("Casado");
		comboBox.addItem("Viúvo");
		comboBox.addItem("Separado");
		comboBox.addItem("Amasiado");
		estCivil.setCellEditor(new DefaultCellEditor(comboBox));
	}

	// Formatar coluna Estado civil
	public void setColunaEstado() {
		TableColumn estado = tbBuscarClientes.getColumnModel().getColumn(10);
		javax.swing.JComboBox comboBox = new javax.swing.JComboBox();
		comboBox.addItem("AC");
		comboBox.addItem("AL");
		comboBox.addItem("AP");
		comboBox.addItem("AM");
		comboBox.addItem("BA");
		comboBox.addItem("CE");
		comboBox.addItem("DF");
		comboBox.addItem("ES");
		comboBox.addItem("GO");
		comboBox.addItem("MA");
		comboBox.addItem("MT");
		comboBox.addItem("MS");
		comboBox.addItem("MG");
		comboBox.addItem("PA");
		comboBox.addItem("PB");
		comboBox.addItem("PR");
		comboBox.addItem("PE");
		comboBox.addItem("PI");
		comboBox.addItem("RJ");
		comboBox.addItem("RS");
		comboBox.addItem("RN");
		comboBox.addItem("RO");
		comboBox.addItem("RR");
		comboBox.addItem("SC");
		comboBox.addItem("SP");
		comboBox.addItem("SE");
		comboBox.addItem("TO");
		estado.setCellEditor(new DefaultCellEditor(comboBox));
	}

	// Formatar coluna CPF
	public void setColunaCPF() {
		TableColumn cpf = tbBuscarClientes.getColumnModel().getColumn(5);
		// formatarCelulas();
		JFormattedTextField formatado = new JFormattedTextField(formatCPF);
		cpf.setCellEditor(new DefaultCellEditor(formatado));
	}

	// Formatar coluna RG
	public void setColunaRG() {
		TableColumn rg = tbBuscarClientes.getColumnModel().getColumn(6);
		// formatarCelulas();
		JFormattedTextField formatado = new JFormattedTextField(formatRG);
		rg.setCellEditor(new DefaultCellEditor(formatado));
	}

	// Formatar coluna Data de nasci
	public void setColunaDtNascimento() {
		TableColumn dt = tbBuscarClientes.getColumnModel().getColumn(4);
		JFormattedTextField formatado = new JFormattedTextField(formatData);
		dt.setCellEditor(new DefaultCellEditor(formatado));
	}

	public void setColunaCep() {
		TableColumn cep = tbBuscarClientes.getColumnModel().getColumn(11);
		JFormattedTextField formatado = new JFormattedTextField(formatCEP);
		cep.setCellEditor(new DefaultCellEditor(formatado));
	}

	public void setColunaTel() {
		TableColumn tel = tbBuscarClientes.getColumnModel().getColumn(12);
		JFormattedTextField formatado = new JFormattedTextField(formatTel);
		tel.setCellEditor(new DefaultCellEditor(formatado));
	}

	public void setColunaCel() {
		TableColumn cel = tbBuscarClientes.getColumnModel().getColumn(13);
		JFormattedTextField formatado = new JFormattedTextField(formatCel);
		cel.setCellEditor(new DefaultCellEditor(formatado));
	}

	public void formatarCelulas() {
		try {
			formatoData = new MaskFormatter("##/##/####");
			formatoData.setValidCharacters("1234567890");
			formatData = new MaskFormatter("##/##/####");
			formatData.setValidCharacters("1234567890");
			formatCPF = new MaskFormatter("###.###.###-##");
			formatCPF.setValidCharacters("1234567890");
			formatRG = new MaskFormatter("##.###.###-#");
			formatRG.setValidCharacters("1234567890");
			formatCEP = new MaskFormatter("#####-###");
			formatCEP.setValidCharacters("1234567890");
			formatTel = new MaskFormatter("(##)####-####");
			formatTel.setValidCharacters("1234567890");
			formatCel = new MaskFormatter("(##)####-####");
			formatCel.setValidCharacters("1234567890");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// // Pega valores da JTABLE
	// public int PegaRegistro(JTable jTable) {
	//
	// // variavel q guarda o valor do código p/ retorno
	// int codigo = 0;
	// /*
	// * Captura o numero da linha selecionada na tabela e coloca o valor na
	// * variavel linha. Se nenhuma linha for selecionada o valor da variavel
	// * linha será = -1
	// */
	//
	// int linha = jTable.getSelectedRow();
	//
	// /*
	// * Verificar se alguma linha da tabela esta selecionada, caso não esteja
	// * selecionado o valor da váriavel será menor que zero, e o IF abaixo
	// * será executado.
	// */
	// if (linha < 0) {
	// JOptionPane.showMessageDialog(null, "Selecione algum registro");
	// } else {
	//
	// // cria uma variavel do tipo object que recebe o valor do codigo da
	// // linha lecionada e coluna 1 <
	// Object cod = jTable.getValueAt(linha, 1);
	//
	// // Caso seja selecionado uma linha da tabela que não contem dados o
	// // IF abaixo sera executado.
	// if (cod == null) {
	// JOptionPane.showMessageDialog(null,
	// "A linha selecionado não contem dados");
	// } else {
	//
	// /*
	// * Caso os if acima não seja executado, é porque a tabela esta
	// * selecionada e a linha selecionada contem dados, então sera
	// * executado o else, que pega os dados da linha selecionada de
	// * cada coluna e coloca nos campos de textos
	// */
	// codigo = Integer.parseInt(String.valueOf(jTable.getValueAt(
	// linha, 0)));
	// }
	//
	// }
	//
	// // Retorna o valor que esta na celula selecionada
	// return codigo;
	//
	// }

	// // LISTENERS
	// public boolean alterarDados() {
	// okSelecionado = false; // Marcamos que o ok não foi selecionado
	// // setModal(true); //A dialog tem que ser modal. Só pode retornar do
	// // setVisible após ficar invisível.
	// setVisible(true); // Mostramos a dialog e esperamos o usuário escolher
	// // alguma coisa.
	// return okSelecionado; // Retornamos true, se ele pressionou ok.
	// }
	//
	// public String getNome() {
	// return tbBuscarClientes.getColumnName(3);
	// }

	// private JButton getBtnVoltar()
	// {
	// if (btnOk == null)
	// {
	// btnOk = new JButton();
	// btnOk.setText("Voltar");
	// btnOk.setBounds(489, 12, 91, 46);
	// btnOk.addActionListener(new java.awt.event.ActionListener()
	// {
	// public void actionPerformed(java.awt.event.ActionEvent e)
	// {
	// //Um pouco de validação, para não aceitar uma idade textual.
	// // try
	// // {
	// // Integer.parseInt(txtIdade.getText());
	// // }
	// // catch (NumberFormatException ex)
	// // {
	// // JOptionPane.showMessageDialog(DlgAlterarDados.this,
	// "A idade deve ser um número!");
	// // }
	// okSelecionado = true; //Dizemos que o ok foi selecionado.
	// frmBuscarCliente.dispose();
	// PegaRegistro(tbBuscarClientes);
	// }
	// });
	// }
	// return btnOk;
	// }

}
