import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


public class CadastroCliente {

	private JFrame frmCadastro;
	private JTextField txtClienteId;
	private JTextField txtClienteNome;
	private JTextField txtClienteDataNascimento;
	private JTextField txtClienteCPF;
	private JTextField txtClienteRG;
	private JTextField txtClienteBairro;
	private JTextField txtClienteEndereco;
	private JTextField txtClienteCEP;
	private JTextField txtClienteCidade;
	private JTextField txtClienteTelefone;
	private JTextField txtClienteCelular;
	private JTextField txtClienteProfissao;
	private JTextField txtClienteNaturalidade;
	private MaskFormatter formatData;
	private MaskFormatter formatoData;
	private MaskFormatter formatCPF;
	private MaskFormatter formatRG;
	private MaskFormatter formatCEP;
	private MaskFormatter formatTel;
	private MaskFormatter formatCel;
	private Date data;
	private SimpleDateFormat formatador;
	private SimpleDateFormat formatadorInv;
	private Banco banco;
	private JTextField txtClienteDataCadastro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente window = new CadastroCliente();
					window.frmCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroCliente() {
		banco = new Banco();
//		codCliente = banco.getCodClienteMax();
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
			data = new Date();   
			formatador = new SimpleDateFormat("dd/MM/yyyy");
			formatadorInv = new SimpleDateFormat("yyyy/MM/dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro de Cliente");
//		frmCadastro.setBounds(-796, -62, 642, 432);
		frmCadastro.setBounds(100, 100, 642, 432);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnClienteSalvar = new JButton("Salvar");
		btnClienteSalvar.setBounds(454, 308, 80, 75);
		btnClienteSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		txtClienteId = new JTextField();
		txtClienteId.setBounds(65, 11, 86, 20);
		txtClienteId.setEditable(false);
		txtClienteId.setColumns(10);
		
		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setBounds(10, 14, 33, 14);
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro");
		lblDataDeCadastro.setBounds(407, 14, 85, 14);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 55, 27, 14);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(407, 55, 96, 14);
		
		txtClienteNome = new JTextField();
		txtClienteNome.setBounds(65, 52, 332, 20);
		txtClienteNome.setColumns(10);
		
		txtClienteDataNascimento = new JFormattedTextField(formatData);
		txtClienteDataNascimento.setText("(  )     -     ");
		txtClienteDataNascimento.setBounds(513, 52, 106, 20);
		txtClienteDataNascimento.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 90, 19, 14);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(237, 90, 14, 14);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(407, 125, 28, 14);
		
		txtClienteCPF = new JFormattedTextField(formatCPF);
		txtClienteCPF.setBounds(65, 87, 162, 20);
		txtClienteCPF.setColumns(10);
		
		txtClienteRG = new JFormattedTextField(formatRG);
		txtClienteRG.setBounds(282, 87, 115, 20);
		txtClienteRG.setColumns(10);
		
		txtClienteBairro = new JTextField();
		txtClienteBairro.setBounds(513, 122, 106, 20);
		txtClienteBairro.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 125, 45, 14);
		
		txtClienteEndereco = new JTextField();
		txtClienteEndereco.setBounds(65, 122, 332, 20);
		txtClienteEndereco.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(407, 90, 19, 14);
		
		txtClienteCEP = new JFormattedTextField(formatCEP);
		txtClienteCEP.setBounds(513, 87, 106, 20);
		txtClienteCEP.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 167, 33, 14);
		
		txtClienteCidade = new JTextField();
		txtClienteCidade.setBounds(65, 164, 162, 20);
		txtClienteCidade.setColumns(10);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(240, 167, 13, 14);
		
		JComboBox cbClienteUF = new JComboBox();
		cbClienteUF.setBounds(285, 163, 115, 22);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(407, 167, 24, 14);
		
		JRadioButton rdbtnClienteMasculino = new JRadioButton("Masculino");
		rdbtnClienteMasculino.setBounds(458, 163, 71, 23);
		
		JRadioButton rdbtnClienteFeminino = new JRadioButton("Feminino");
		rdbtnClienteFeminino.setBounds(557, 163, 67, 23);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 210, 42, 14);
		
		txtClienteTelefone = new JFormattedTextField(formatTel);
		txtClienteTelefone.setBounds(65, 207, 162, 20);
		txtClienteTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(240, 210, 33, 14);
		
		txtClienteCelular = new JFormattedTextField(formatCel);
		txtClienteCelular.setBounds(285, 207, 115, 20);
		txtClienteCelular.setColumns(10);
		
		JLabel lblEstCivil = new JLabel("Est. Civil");
		lblEstCivil.setBounds(407, 210, 41, 14);
		
		JComboBox cbClienteEstCivil = new JComboBox();
		cbClienteEstCivil.setBounds(513, 206, 111, 22);
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o");
		lblProfisso.setBounds(10, 252, 44, 14);
		
		txtClienteProfissao = new JTextField();
		txtClienteProfissao.setBounds(68, 249, 219, 20);
		txtClienteProfissao.setColumns(10);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade");
		lblNaturalidade.setBounds(297, 252, 61, 14);
		
		txtClienteNaturalidade = new JTextField();
		txtClienteNaturalidade.setBounds(368, 249, 256, 20);
		txtClienteNaturalidade.setColumns(10);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(792, 38, 1, 1);
		frmCadastro.getContentPane().setLayout(null);
		frmCadastro.getContentPane().add(btnClienteSalvar);
		frmCadastro.getContentPane().add(layeredPane);
		frmCadastro.getContentPane().add(lblCidade);
		frmCadastro.getContentPane().add(lblEndereo);
		frmCadastro.getContentPane().add(lblProfisso);
		frmCadastro.getContentPane().add(lblTelefone);
		frmCadastro.getContentPane().add(txtClienteEndereco);
		frmCadastro.getContentPane().add(txtClienteCidade);
		frmCadastro.getContentPane().add(txtClienteTelefone);
		frmCadastro.getContentPane().add(txtClienteProfissao);
		frmCadastro.getContentPane().add(lblId);
		frmCadastro.getContentPane().add(lblNome);
		frmCadastro.getContentPane().add(txtClienteId);
		frmCadastro.getContentPane().add(txtClienteCPF);
		frmCadastro.getContentPane().add(txtClienteNome);
		frmCadastro.getContentPane().add(lblCpf);
		frmCadastro.getContentPane().add(lblRg);
		frmCadastro.getContentPane().add(lblCep);
		frmCadastro.getContentPane().add(lblUf);
		frmCadastro.getContentPane().add(lblCelular);
		frmCadastro.getContentPane().add(lblNaturalidade);
		frmCadastro.getContentPane().add(txtClienteNaturalidade);
		frmCadastro.getContentPane().add(txtClienteCEP);
		frmCadastro.getContentPane().add(cbClienteUF);
		frmCadastro.getContentPane().add(lblSexo);
		frmCadastro.getContentPane().add(txtClienteRG);
		frmCadastro.getContentPane().add(txtClienteCelular);
		frmCadastro.getContentPane().add(lblEstCivil);
		frmCadastro.getContentPane().add(lblBairro);
		frmCadastro.getContentPane().add(txtClienteBairro);
		frmCadastro.getContentPane().add(rdbtnClienteMasculino);
		frmCadastro.getContentPane().add(rdbtnClienteFeminino);
		frmCadastro.getContentPane().add(cbClienteEstCivil);
		frmCadastro.getContentPane().add(lblDataDeNascimento);
		frmCadastro.getContentPane().add(txtClienteDataNascimento);
		frmCadastro.getContentPane().add(lblDataDeCadastro);
		
		JButton btnClienteBuscar = new JButton("Buscar");
		ImageIcon imagemBuscar = new ImageIcon("imagens\\buscar24.png");
		btnClienteBuscar = new JButton("Buscar", imagemBuscar);
		btnClienteBuscar.setPreferredSize(new java.awt.Dimension(105, 40));
		
		btnClienteBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> list = banco.buscaCliente(txtClienteNome.getText());
				
				if (!list.isEmpty()) {
					txtClienteId.setText(list.remove(0));
					txtClienteNome.setText(list.remove(0));
					txtClienteCPF.setText(list.remove(0));
					txtClienteRG.setText(list.remove(0));
					txtClienteEndereco.setText(list.remove(0));
					txtClienteBairro.setText(list.remove(0));
					txtClienteCelular.setText(list.remove(0));
					txtClienteDataCadastro.setText(list.remove(0));
					txtClienteCEP.setText(list.remove(0));
					txtClienteCidade.setText(list.remove(0));
					txtClienteDataNascimento.setText(list.remove(0));
					txtClienteNaturalidade.setText(list.remove(0));
					txtClienteProfissao.setText(list.remove(0));
					txtClienteTelefone.setText(list.remove(0));
					
				}
				else
					JOptionPane.showMessageDialog(null, "Digite o nome primeiro!");
			}
		});
		btnClienteBuscar.setBounds(276, 308, 80, 75);
		frmCadastro.getContentPane().add(btnClienteBuscar);
		
		JButton btnClienteCancelar = new JButton("Cancelar");
		btnClienteCancelar.setBounds(98, 308, 80, 75);
		frmCadastro.getContentPane().add(btnClienteCancelar);
		
		txtClienteDataCadastro = new JTextField();
		txtClienteDataCadastro.setEditable(false);
		txtClienteDataCadastro.setBounds(513, 11, 86, 20);
		frmCadastro.getContentPane().add(txtClienteDataCadastro);
		txtClienteDataCadastro.setColumns(10);
	}
}
