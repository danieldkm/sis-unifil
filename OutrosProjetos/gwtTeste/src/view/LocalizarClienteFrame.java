package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import tabela.ClienteTabela;
import dao.ClienteDao;

public class LocalizarClienteFrame extends JFrame implements TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmBuscarCliente;
//	private JTextField txtBuscaLocalizar;
//	private JTextField txtBuscaId;
//	private List<Cliente> clienteList = new ClienteController().listaClientes();
//	private int registroAtual = 0;
//	private Date data;
//	private SimpleDateFormat formatador;
//	private SimpleDateFormat formatadorInv;
//	private MaskFormatter formatData;
//	private MaskFormatter formatoData;
//	private MaskFormatter formatCPF;
//	private MaskFormatter formatRG;
//	private MaskFormatter formatCEP;
//	private MaskFormatter formatTel;
//	private MaskFormatter formatCel;
	Font fontTextCima = new Font(Font.DIALOG, Font.BOLD, 16);
	Font font = new Font(Font.DIALOG, Font.PLAIN, 5);
//	private JTextField txtBuscaCPF;
//	String[] colunas = new String[] { "ID", "Data de cadastro", "nome",
//			"Data de nascimento", "CPF", "RG", "Endereco", "Bairro", "Cidade",
//			"CEP", "Telefone", "Celular", "Sexo", "Naturalidade",
//			"Estado Civil", "Estado" };
	private JTable tbBuscarClientes;
	private JTextField txtBuscaCodigo;
	private JTextField txtBuscaNome;
	private ClienteTabela modelo;
	private JScrollPane scrollPane;	
	private ClienteDao clienteDao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocalizarClienteFrame window = new LocalizarClienteFrame();
					window.frmBuscarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocalizarClienteFrame() {

		
//		try {
//			formatoData = new MaskFormatter("##/##/####");
//			formatoData.setValidCharacters("1234567890");
//			formatData = new MaskFormatter("##/##/####");
//			formatData.setValidCharacters("1234567890");
//			formatCPF = new MaskFormatter("###.###.###-##");
//			formatCPF.setValidCharacters("1234567890");
//			formatRG = new MaskFormatter("##.###.###-#");
//			formatRG.setValidCharacters("1234567890");
//			formatCEP = new MaskFormatter("#####-###");
//			formatCEP.setValidCharacters("1234567890");
//			formatTel = new MaskFormatter("(##)####-####");
//			formatTel.setValidCharacters("1234567890");
//			formatCel = new MaskFormatter("(##)####-####");
//			formatCel.setValidCharacters("1234567890");
//			data = new Date();
//			formatador = new SimpleDateFormat("dd/MM/yyyy");
//			formatadorInv = new SimpleDateFormat("yyyy/MM/dd");
//		} catch (Exception e) {
//		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarCliente = new JFrame();
		frmBuscarCliente.setTitle("Localizar Cliente");
		frmBuscarCliente.setBounds(100, 100, 800, 600);
		//finaliza o programa**
		// frmBuscarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscarCliente.getContentPane().setLayout(null);
		
//		txtBuscaLocalizar = new JTextField();
//		txtBuscaLocalizar.setBounds(190, 11, 372, 20);
//		frmBuscarCliente.getContentPane().add(txtBuscaLocalizar);
//		txtBuscaLocalizar.setColumns(10);
		
		
		//JTextField
		txtBuscaCodigo = new JTextField();
		txtBuscaCodigo.setBounds(190, 41, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaCodigo);
		txtBuscaCodigo.setColumns(10);
		txtBuscaCodigo.setFont(fontTextCima);
		
		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(190, 10, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaNome);
		txtBuscaNome.setColumns(10);
		txtBuscaNome.setFont(fontTextCima);
		
		//JLabel
		JLabel lblLocalizarPorCdigo = new JLabel("Localizar por C\u00F3digo");
		lblLocalizarPorCdigo.setBounds(10, 41, 170, 14);
		frmBuscarCliente.getContentPane().add(lblLocalizarPorCdigo);
		lblLocalizarPorCdigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		JLabel lblLocalizarPorNome = new JLabel("Localizar por Nome");
		lblLocalizarPorNome.setBounds(10, 11, 169, 14);
		frmBuscarCliente.getContentPane().add(lblLocalizarPorNome);
		lblLocalizarPorNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		//JButton
		JButton btnBuscarCodigo = new JButton("Buscar");
		btnBuscarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarCodigo.setBounds(572, 40, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscarCodigo);
		
		JButton btnBuscarSalvar = new JButton("Salvar");
		btnBuscarSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarSalvar.setBounds(691, 8, 91, 51);
		frmBuscarCliente.getContentPane().add(btnBuscarSalvar);
		
		JButton btnBuscarNome = new JButton("Buscar");
		btnBuscarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btnBuscarNome.setBounds(572, 10, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscarNome);
		
		
		///Table////
		modelo = new ClienteTabela();
		clienteDao = new ClienteDao();
		tbBuscarClientes = new JTable();
		modelo.addTableModelListener(this);
		try {
			modelo.adicionaLista(clienteDao.findClientes());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollPane  = new JScrollPane();
		scrollPane.setBounds(10, 69, 772, 493);
		frmBuscarCliente.getContentPane().add(scrollPane);
		tbBuscarClientes.setModel(modelo);
		scrollPane.setViewportView(tbBuscarClientes);
		tamanhoColuna();
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 69, 772, 493);
//		frmBuscarCliente.getContentPane().add(scrollPane);
//		
//		Object[][] o = new Object[1111][1111];
//		tbBuscarClientes = new JTable(o, colunas);
//		scrollPane.setViewportView(tbBuscarClientes);
//		ajustaColunas(tbBuscarClientes);
//		///Table////
	}

//	public void adicionaColuna() {
//		String[] colunas = new String[] { "Nome", "Idade", "Sexo" };
//		String[][] dados = new String[][] { { "Rodrigo", "28", "Masculino" },
//				{ "Maria", "30", "Feminino" } };
//		DefaultTableModel model = new DefaultTableModel(dados, colunas);
//		tbBuscarClientes.setModel(model);
//		JScrollPane scroll = new JScrollPane();
//		scroll.setViewportView(tbBuscarClientes);
//		getContentPane().add(scroll);
//	}
//
//	public void ajustaColunas(JTable tabela) {
//		tabela.setAutoResizeMode(0);
//		// FontMetrics fm = tabela.getGraphics().getFontMetrics();
//
//		for (int i = 0; i < tabela.getColumnCount(); i++) {
//			String columnName = tabela.getColumnName(i);
//			TableColumn col = tabela.getColumnModel().getColumn(i);
//			// col.setMinWidth(fm.stringWidth(columnName) + 10);
//			col.setMinWidth(colunas[i].length() + 25);
//		}
//	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// quando a estrutura de dados muda, imprimimos a informação. Fazer a
		// persistência no banco seria o comportamento realista desse método.
		String tipo;
		switch (e.getType()) {
		case TableModelEvent.DELETE:
			tipo = "DELETE";
			break;
		case TableModelEvent.INSERT:
			tipo = "INSERT";
			break;
		case TableModelEvent.UPDATE:
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
		System.out.printf("%s: %d-%d, %d%n", tipo, e.getFirstRow(), e
				.getLastRow(), e.getColumn());
	}
	
	public void tamanhoColuna(){
		tbBuscarClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbBuscarClientes.getColumnModel().getColumn(0).setPreferredWidth(25); 
		tbBuscarClientes.getColumnModel().getColumn(1).setPreferredWidth(75);
		tbBuscarClientes.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbBuscarClientes.getColumnModel().getColumn(3).setPreferredWidth(75);
		tbBuscarClientes.getColumnModel().getColumn(4).setPreferredWidth(90);		
	}
	
}
