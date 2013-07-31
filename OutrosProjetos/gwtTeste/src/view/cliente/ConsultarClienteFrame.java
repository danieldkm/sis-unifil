package view.cliente;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import dao.ClienteDao;

public class ConsultarClienteFrame extends JFrame implements TableModelListener {

	private static final long serialVersionUID = 1L;
	private JFrame frmConsultaCliente;
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

	// busca
	private TableRowSorter<TableModel> rowSorter;

	/**
	 * Create the application.
	 */
	public ConsultarClienteFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmConsultaCliente = new JFrame();
		frmConsultaCliente.setTitle("Localizar Cliente");
		frmConsultaCliente.setBounds(100, 100, 800, 600);
		// finaliza o programa**
		frmConsultaCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaCliente.getContentPane().setLayout(null);

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
		frmConsultaCliente.getContentPane().add(scrollPane);
		tamanhoColuna();
		formatarCelulas();
		tbBuscarClientes.setAutoCreateRowSorter(true);

		// JTextField
		txtBuscaCodigo = new JTextField();
		txtBuscaCodigo.setBounds(190, 41, 187, 20);
		frmConsultaCliente.getContentPane().add(txtBuscaCodigo);
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
		frmConsultaCliente.getContentPane().add(txtBuscaNome);
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
		frmConsultaCliente.getContentPane().add(lblLocalizarPorCdigo);
		lblLocalizarPorCdigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		JLabel lblLocalizarPorNome = new JLabel("Localizar por Nome");
		lblLocalizarPorNome.setBounds(10, 11, 169, 14);
		frmConsultaCliente.getContentPane().add(lblLocalizarPorNome);
		lblLocalizarPorNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

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
		frmConsultaCliente.setVisible(true);
		frmConsultaCliente.setResizable(false);
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
		TableColumn estCivil = tbBuscarClientes.getColumnModel().getColumn(17);
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

	// Formatar coluna cep
	public void setColunaCep() {
		TableColumn cep = tbBuscarClientes.getColumnModel().getColumn(11);
		JFormattedTextField formatado = new JFormattedTextField(formatCEP);
		cep.setCellEditor(new DefaultCellEditor(formatado));
	}

	// Formatar coluna telefone
	public void setColunaTel() {
		TableColumn tel = tbBuscarClientes.getColumnModel().getColumn(12);
		JFormattedTextField formatado = new JFormattedTextField(formatTel);
		tel.setCellEditor(new DefaultCellEditor(formatado));
	}

	// Formatar coluna celular
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

	//retorna o frame para que a tela principal possa manipular e não deixar abrir duas tela 
	public JFrame retornaTela(){
		return frmConsultaCliente;
	}
}
