package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
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

import controller.ClienteController;

public class ClienteFrame extends JFrame {

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
	private JRadioButton rdbtnClienteMasculino;
	private JRadioButton rdbtnClienteFeminino;
	private JComboBox cbClienteUF;
	private JComboBox cbClienteEstCivil;
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
	private JTextField txtClienteDataCadastro;
	private ClienteController clienteController;
	private JButton btnClienteBuscar = null;
	private JButton btnClienteSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteFrame window = new ClienteFrame();
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
	public ClienteFrame() {
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
		frmCadastro.setBounds(100, 100, 642, 432);
		frmCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Text field's
		txtClienteId = new JTextField();
		txtClienteId.setBounds(65, 11, 86, 20);
		txtClienteId.setEditable(false);
		txtClienteId.setColumns(10);

		txtClienteNome = new JTextField();
		txtClienteNome.setBounds(65, 52, 332, 20);
		txtClienteNome.setColumns(10);

		txtClienteDataNascimento = new JFormattedTextField(formatData);
		txtClienteDataNascimento.setText("(  )     -     ");
		txtClienteDataNascimento.setBounds(513, 52, 106, 20);
		txtClienteDataNascimento.setColumns(10);

		txtClienteCPF = new JFormattedTextField(formatCPF);
		txtClienteCPF.setBounds(65, 87, 162, 20);
		txtClienteCPF.setColumns(10);

		txtClienteRG = new JFormattedTextField(formatRG);
		txtClienteRG.setBounds(282, 87, 115, 20);
		txtClienteRG.setColumns(10);

		txtClienteBairro = new JTextField();
		txtClienteBairro.setBounds(513, 122, 106, 20);
		txtClienteBairro.setColumns(10);

		txtClienteEndereco = new JTextField();
		txtClienteEndereco.setBounds(65, 122, 332, 20);
		txtClienteEndereco.setColumns(10);

		txtClienteCEP = new JFormattedTextField(formatCEP);
		txtClienteCEP.setBounds(513, 87, 106, 20);
		txtClienteCEP.setColumns(10);

		txtClienteCidade = new JTextField();
		txtClienteCidade.setBounds(65, 164, 162, 20);
		txtClienteCidade.setColumns(10);

		txtClienteTelefone = new JFormattedTextField(formatTel);
		txtClienteTelefone.setBounds(65, 207, 162, 20);
		txtClienteTelefone.setColumns(10);

		txtClienteCelular = new JFormattedTextField(formatCel);
		txtClienteCelular.setBounds(285, 207, 115, 20);
		txtClienteCelular.setColumns(10);

		txtClienteProfissao = new JTextField();
		txtClienteProfissao.setBounds(68, 249, 219, 20);
		txtClienteProfissao.setColumns(10);

		txtClienteNaturalidade = new JTextField();
		txtClienteNaturalidade.setBounds(368, 249, 256, 20);
		txtClienteNaturalidade.setColumns(10);

		txtClienteDataCadastro = new JTextField();
		txtClienteDataCadastro.setEditable(false);
		txtClienteDataCadastro.setBounds(513, 11, 86, 20);
		txtClienteDataCadastro.setColumns(10);
		// Label`s

		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setBounds(10, 14, 33, 14);

		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro");
		lblDataDeCadastro.setBounds(407, 14, 85, 14);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 55, 27, 14);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(407, 55, 96, 14);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 90, 19, 14);

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(237, 90, 14, 14);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(407, 125, 28, 14);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 125, 45, 14);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(407, 90, 19, 14);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 167, 33, 14);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(240, 167, 13, 14);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(407, 167, 24, 14);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 210, 42, 14);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(240, 210, 33, 14);

		JLabel lblEstCivil = new JLabel("Est. Civil");
		lblEstCivil.setBounds(407, 210, 41, 14);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o");
		lblProfisso.setBounds(10, 252, 44, 14);

		JLabel lblNaturalidade = new JLabel("Naturalidade");
		lblNaturalidade.setBounds(297, 252, 61, 14);

		// Radio Button's
		rdbtnClienteMasculino = new JRadioButton("Masculino");
		rdbtnClienteMasculino.setBounds(458, 163, 71, 23);

		rdbtnClienteFeminino = new JRadioButton("Feminino");
		rdbtnClienteFeminino.setBounds(557, 163, 67, 23);

		final ButtonGroup myButtonGroup = new ButtonGroup();
		myButtonGroup.add(rdbtnClienteFeminino);
		myButtonGroup.add(rdbtnClienteMasculino);

		// ComboBox
		cbClienteUF = new JComboBox();
		cbClienteUF.setBounds(285, 163, 115, 22);
		cbClienteUF.addItem("AC");
		cbClienteUF.addItem("AL");
		cbClienteUF.addItem("AP");
		cbClienteUF.addItem("AM");
		cbClienteUF.addItem("BA");
		cbClienteUF.addItem("CE");
		cbClienteUF.addItem("DF");
		cbClienteUF.addItem("ES");
		cbClienteUF.addItem("GO");
		cbClienteUF.addItem("MA");
		cbClienteUF.addItem("MT");
		cbClienteUF.addItem("MS");
		cbClienteUF.addItem("MG");
		cbClienteUF.addItem("PA");
		cbClienteUF.addItem("PB");
		cbClienteUF.addItem("PR");
		cbClienteUF.addItem("PE");
		cbClienteUF.addItem("PI");
		cbClienteUF.addItem("RJ");
		cbClienteUF.addItem("RS");
		cbClienteUF.addItem("RN");
		cbClienteUF.addItem("RO");
		cbClienteUF.addItem("RR");
		cbClienteUF.addItem("SC");
		cbClienteUF.addItem("SP");
		cbClienteUF.addItem("SE");
		cbClienteUF.addItem("TO");

		cbClienteEstCivil = new JComboBox();
		cbClienteEstCivil.setBounds(513, 206, 111, 22);
		cbClienteEstCivil.addItem("Solteiro");
		cbClienteEstCivil.addItem("Casado");
		cbClienteEstCivil.addItem("Viúvo");
		cbClienteEstCivil.addItem("Separado");
		cbClienteEstCivil.addItem("Amasiado");

		// Button's
		btnClienteSalvar = new JButton("Salvar");
		btnClienteSalvar.setBounds(454, 308, 80, 75);
		// TODO - erro de validação
		btnClienteSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteController = new ClienteController();
				String estado = (String) cbClienteUF.getSelectedItem();
				System.out.println("Estado!!! " + estado);
				String estadoCivil = (String) cbClienteEstCivil
						.getSelectedItem();
				System.out.println("Estado civil! " + estadoCivil);
				String sexo = "";
				if (rdbtnClienteMasculino.isSelected() == true) {
					sexo = rdbtnClienteMasculino.getText();
					System.out.println("sexo!! " + sexo);

				} else if (rdbtnClienteFeminino.isSelected() == true) {
					sexo = rdbtnClienteFeminino.getText();
					System.out.println("sexo!! " + sexo);
				}
				boolean erro = false;

				if (txtClienteNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Favor preencher o nome");
					erro = true;
				} else if (!txtClienteDataNascimento.getText().equals("")) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					sdf.setLenient(false);
					String dataString = txtClienteDataNascimento.getText();
					// TODO - erro nas validações
					try {
						Date data = sdf.parse(dataString);
						JOptionPane.showMessageDialog(null, "?????data?????"
								+ data);
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Data Inválida");
					}

					// Pattern p = Pattern
					// .compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
					// Matcher m =
					// p.matcher(txtClienteDataNascimento.getText());
					// if (!m.find())
					// System.err.println("Data inválida.");
					erro = true;
				}
				try {
					clienteController.salvar(txtClienteNome.getText(),
							txtClienteDataNascimento.getText(),
							txtClienteCPF.getText(), txtClienteRG.getText(),
							txtClienteEndereco.getText(),
							txtClienteBairro.getText(),
							txtClienteCidade.getText(), estado,
							txtClienteCEP.getText(),
							txtClienteTelefone.getText(),
							txtClienteCelular.getText(), sexo,
							txtClienteNaturalidade.getText(), estadoCivil);
				} catch (SQLException e1) {
					JOptionPane
							.showMessageDialog(null,
									"Erro ao salvar\nFavor preencher os campos corretamente!!");
					e1.printStackTrace();
					erro = true;
				} catch (ParseException e1) {
					JOptionPane
							.showMessageDialog(null,
									"Erro ao salvar\nFavor preencher os campos corretamente!!");
					e1.printStackTrace();
					erro = true;
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(null,
									"Erro ao salvar\nFavor preencher os campos corretamente!!");
					e1.printStackTrace();
					erro = true;
				}
				if (erro == false) {
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!");
				}

			}
		});

		JButton btnClienteBuscar = new JButton();
		ImageIcon imagemBuscar = new ImageIcon("imagens\\buscar24.png");
		btnClienteBuscar = new JButton(imagemBuscar);
		btnClienteBuscar.setPreferredSize(new java.awt.Dimension(105, 40));
		btnClienteBuscar.setBounds(276, 308, 80, 75);
		btnClienteBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BuscarClienteFrame();
				frmCadastro.setVisible(false);
			}
		});

		JButton btnClienteCancelar = new JButton("Cancelar");
		btnClienteCancelar.setBounds(98, 308, 90, 75);
		btnClienteCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtClienteBairro.setText("");
				txtClienteCelular.setText("");
				txtClienteCEP.setText("");
				txtClienteCidade.setText("");
				txtClienteCPF.setText("");
				txtClienteDataCadastro.setText("");
				txtClienteDataNascimento.setText("");
				txtClienteEndereco.setText("");
				txtClienteId.setText("");
				txtClienteNaturalidade.setText("");
				txtClienteNome.setText("");
				txtClienteProfissao.setText("");
				txtClienteRG.setText("");
				txtClienteTelefone.setText("");
				// rdbtnClienteFeminino.setSelected(false);
				// rdbtnClienteMasculino.setSelected(false);
				// cbClienteEstCivil.setDefaultLocale();
				// cbClienteUF.setName("");
				btnClienteSalvar.setEnabled(true);
			}
		});

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
		frmCadastro.getContentPane().add(btnClienteBuscar);
		frmCadastro.getContentPane().add(btnClienteCancelar);
		frmCadastro.getContentPane().add(txtClienteDataCadastro);
		frmCadastro.setVisible(true);
		frmCadastro.setResizable(false);
	}

	// Listener
	public void metodo(String codigo, String nome, String dataCadastro,
			String dataNascimento, String cpf, String rg, String endereco,
			String bairro, String cidade, String estado, String cep,
			String telefone, String celular, String sexo, String natu,
			String estCivil) {
		txtClienteNome.setText(nome);
		txtClienteId.setText(codigo);
		txtClienteDataCadastro.setText(dataCadastro);
		txtClienteDataNascimento.setText(dataNascimento);
		txtClienteCPF.setText(cpf);
		txtClienteRG.setText(rg);
		txtClienteEndereco.setText(endereco);
		txtClienteBairro.setText(bairro);
		txtClienteCidade.setText(cidade);
		cbClienteUF.setSelectedItem(estado);
		txtClienteCEP.setText(cep);
		txtClienteTelefone.setText(telefone);
		txtClienteCelular.setText(celular);
		if (sexo.equals("Masculino")) {
			rdbtnClienteMasculino.setSelected(true);
			rdbtnClienteFeminino.setSelected(false);
		} else {
			rdbtnClienteMasculino.setSelected(false);
			rdbtnClienteFeminino.setSelected(true);
		}
		txtClienteNaturalidade.setText(natu);
		cbClienteEstCivil.setSelectedItem(estCivil);
		btnClienteSalvar.setEnabled(false);
	}
}
