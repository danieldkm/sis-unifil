package view.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import model.Validacao;
import model.ValidaçãoCPF;
import controller.ClienteController;
import entity.Cliente;

public class ClienteFrame extends JDialog {
	private UIManager.LookAndFeelInfo[] looks = UIManager
			.getInstalledLookAndFeels();
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
	private JButton btnClienteAtualizar;
	private boolean erro;
	private Validacao validar = new Validacao();

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// ClienteFrame window = new ClienteFrame();
	// window.frmCadastro.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */

	public ClienteFrame() {
		initialize();
		// JOptionPane.showMessageDialog(null, frmCadastro.isVisible());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
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
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro de Cliente");
		frmCadastro.setBounds(100, 100, 698, 392);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// frmCadastro.setVisible(true);

		// Text field's
		txtClienteId = new JTextField();
		txtClienteId.setBounds(81, 11, 86, 20);
		txtClienteId.setEditable(false);
		txtClienteId.setColumns(10);

		txtClienteNome = new JTextField();
		txtClienteNome.setBounds(81, 52, 332, 20);
		txtClienteNome.setColumns(10);

		txtClienteDataNascimento = new JFormattedTextField(formatData);
		txtClienteDataNascimento.setText("(  )     -     ");
		txtClienteDataNascimento.setBounds(561, 52, 118, 20);
		txtClienteDataNascimento.setColumns(10);

		txtClienteCPF = new JFormattedTextField(formatCPF);
		txtClienteCPF.setBounds(81, 80, 162, 20);
		txtClienteCPF.setColumns(10);

		txtClienteRG = new JFormattedTextField(formatRG);
		txtClienteRG.setBounds(276, 80, 137, 20);
		txtClienteRG.setColumns(10);

		txtClienteBairro = new JTextField();
		txtClienteBairro.setBounds(561, 108, 118, 20);
		txtClienteBairro.setColumns(10);

		txtClienteEndereco = new JTextField();
		txtClienteEndereco.setBounds(81, 108, 332, 20);
		txtClienteEndereco.setColumns(10);

		txtClienteCEP = new JFormattedTextField(formatCEP);
		txtClienteCEP.setBounds(561, 80, 118, 20);
		txtClienteCEP.setColumns(10);

		txtClienteCidade = new JTextField();
		txtClienteCidade.setBounds(81, 136, 162, 20);
		txtClienteCidade.setColumns(10);

		txtClienteTelefone = new JFormattedTextField(formatTel);
		txtClienteTelefone.setBounds(81, 165, 142, 20);
		txtClienteTelefone.setColumns(10);

		txtClienteCelular = new JFormattedTextField(formatCel);
		txtClienteCelular.setBounds(276, 165, 137, 20);
		txtClienteCelular.setColumns(10);

		txtClienteProfissao = new JTextField();
		txtClienteProfissao.setBounds(81, 193, 219, 20);
		txtClienteProfissao.setColumns(10);

		txtClienteNaturalidade = new JTextField();
		txtClienteNaturalidade.setBounds(423, 193, 256, 20);
		txtClienteNaturalidade.setColumns(10);

		txtClienteDataCadastro = new JTextField();
		txtClienteDataCadastro.setEditable(false);
		txtClienteDataCadastro.setBounds(561, 11, 118, 20);
		txtClienteDataCadastro.setColumns(10);
		// Label`s

		JLabel lblId = new JLabel("C\u00F3digo");
		lblId.setBounds(10, 14, 61, 14);

		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro");
		lblDataDeCadastro.setBounds(423, 14, 115, 14);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 55, 61, 14);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(423, 55, 130, 14);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 83, 61, 14);

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(253, 83, 50, 14);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(423, 111, 80, 14);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 111, 61, 14);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(423, 83, 80, 14);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 139, 61, 14);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(253, 139, 47, 14);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(423, 139, 61, 14);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 168, 61, 14);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(230, 168, 47, 14);

		JLabel lblEstCivil = new JLabel("Est. Civil");
		lblEstCivil.setBounds(423, 168, 80, 14);

		JLabel lblProfisso = new JLabel("Profiss\u00E3o");
		lblProfisso.setBounds(10, 196, 61, 14);

		JLabel lblNaturalidade = new JLabel("Naturalidade");
		lblNaturalidade.setBounds(310, 196, 103, 14);

		// Radio Button's
		rdbtnClienteMasculino = new JRadioButton("Masculino");
		rdbtnClienteMasculino.setBounds(490, 135, 96, 23);

		rdbtnClienteFeminino = new JRadioButton("Feminino");
		rdbtnClienteFeminino.setBounds(588, 135, 79, 23);

		final ButtonGroup myButtonGroup = new ButtonGroup();
		myButtonGroup.add(rdbtnClienteFeminino);
		myButtonGroup.add(rdbtnClienteMasculino);

		// ComboBox
		cbClienteUF = new JComboBox();
		cbClienteUF.setBounds(276, 135, 137, 22);
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
		cbClienteEstCivil.setBounds(556, 164, 123, 22);
		cbClienteEstCivil.addItem("Solteiro");
		cbClienteEstCivil.addItem("Casado");
		cbClienteEstCivil.addItem("Viúvo");
		cbClienteEstCivil.addItem("Separado");
		cbClienteEstCivil.addItem("Amasiado");

		// Button's
		ImageIcon imagemSalvarCliente = new ImageIcon(
				"imagens\\cadastroCliente.png");
		btnClienteSalvar = new JButton(imagemSalvarCliente);
		btnClienteSalvar.setToolTipText("Salvar");
		btnClienteSalvar.setBounds(521, 266, 80, 75);
		// TODO - erro de validação
		btnClienteSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteController = new ClienteController();
				// atributos
				String estado = (String) cbClienteUF.getSelectedItem();
				String estadoCivil = (String) cbClienteEstCivil
						.getSelectedItem();
				String sexo = "";

				// Condições
				if (rdbtnClienteMasculino.isSelected() == true) {
					sexo = rdbtnClienteMasculino.getText();
					System.out.println("sexo!! " + sexo);

				} else if (rdbtnClienteFeminino.isSelected() == true) {
					sexo = rdbtnClienteFeminino.getText();
					System.out.println("sexo!! " + sexo);
				}

				validacao();

				if (erro == false) {
					try {
						clienteController.salvar(txtClienteNome.getText(),
								txtClienteDataNascimento.getText(),
								txtClienteCPF.getText(),
								txtClienteRG.getText(),
								txtClienteEndereco.getText(),
								txtClienteBairro.getText(),
								txtClienteCidade.getText(), estado,
								txtClienteCEP.getText(),
								txtClienteTelefone.getText(),
								txtClienteCelular.getText(), sexo,
								txtClienteNaturalidade.getText(), estadoCivil,
								txtClienteProfissao.getText());
						limparCampos();
						// JOptionPane.showMessageDialog(null,
						// "Cadastrado com sucesso!");
					} catch (SQLException e1) {
						// JOptionPane
						// .showMessageDialog(null,
						// "Erro ao salvar\nFavor preencher os campos corretamente!!");
						erro = true;
						e1.printStackTrace();
					} catch (ParseException e1) {
						// JOptionPane
						// .showMessageDialog(null,
						// "Erro ao salvar\nFavor preencher os campos corretamente!!");
						erro = true;
						e1.printStackTrace();
					} catch (Exception e1) {
						// JOptionPane
						// .showMessageDialog(null,
						// "Erro ao salvar\nFavor preencher os campos corretamente!!");
						erro = true;
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!");
				}
			}
		});

		ImageIcon imagemBuscarCliente = new ImageIcon(
				"imagens\\buscarCliente.png");
		JButton btnClienteBuscar = new JButton(imagemBuscarCliente);
		btnClienteBuscar.setToolTipText("Buscar");
		btnClienteBuscar.setPreferredSize(new java.awt.Dimension(105, 40));
		btnClienteBuscar.setBounds(310, 266, 80, 75);
		btnClienteBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BuscarClienteFrame();
				frmCadastro.setVisible(false);
			}
		});

		ImageIcon imagemCancelarCliente = new ImageIcon(
				"imagens\\cancelarCliente.png");
		JButton btnClienteCancelar = new JButton(imagemCancelarCliente);
		btnClienteCancelar.setToolTipText("Cancelar");
		btnClienteCancelar.setBounds(90, 266, 90, 75);
		btnClienteCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
				btnClienteAtualizar.setVisible(false);
				btnClienteSalvar.setVisible(true);
			}
		});

		ImageIcon imagemAtualizarCliente = new ImageIcon(
				"imagens\\atualizarCliente.png");
		btnClienteAtualizar = new JButton(imagemAtualizarCliente);
		btnClienteAtualizar.setToolTipText("Atualizar");
		btnClienteAtualizar.setBounds(521, 266, 80, 75);
		btnClienteAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteController = new ClienteController();
				// Cliente cliente = null;
				// boolean erro = false;
				// try {
				// cliente = clienteController.buscaClientePorId(Integer
				// .parseInt(txtClienteId.getText()));
				// } catch (NumberFormatException e2) {
				// e2.printStackTrace();
				// } catch (SQLException e2) {
				// e2.printStackTrace();
				// }
				// atributo e condições estado
				String estado = (String) cbClienteUF.getSelectedItem();
				// atributo e condições estado civil
				String estadoCivil = (String) cbClienteEstCivil
						.getSelectedItem();
				// atributo e condições sexo
				String sexo = "";
				if (rdbtnClienteMasculino.isSelected() == true) {
					sexo = rdbtnClienteMasculino.getText();
					System.out.println("sexo!! " + sexo);

				} else if (rdbtnClienteFeminino.isSelected() == true) {
					sexo = rdbtnClienteFeminino.getText();
					System.out.println("sexo!! " + sexo);
				}

				validacao();
				// // atributo e condições CPF
				// String cpf = "";
				// if (!cliente.getCpf().equals(txtClienteCPF.getText())) {
				// cpf = txtClienteCPF.getText().replace("-", "");
				// cpf = cpf.replace(".", "");
				// if (ValidaçãoCPF.isCPF(cpf) == false) {
				// JOptionPane.showMessageDialog(null, "CPF inválido");
				// txtClienteCPF.setText("");
				// erro = true;
				// txtClienteCPF.setText(cliente.getCpf());
				// }
				// } else {
				// cpf = txtClienteCPF.getText();
				// }
				// // String cpf = txtClienteCPF.getText().replace(".", "");
				// // cpf = cpf.replace("-", "");
				// // String cpf2 = txtClienteCPF.getText();
				//
				// // Validações
				//
				// // if (txtClienteNome.getText().equals("")) {
				// // JOptionPane.showMessageDialog(null,
				// // "Favor preencher o nome");
				// // erro = true;
				// // } else if (txtClienteDataNascimento.getText().equals(""))
				// // {
				// // SimpleDateFormat sdf = new
				// // SimpleDateFormat("dd/MM/yyyy");
				// // sdf.setLenient(false);
				// // String dataString = txtClienteDataNascimento.getText();
				// // try {
				// // Date data = sdf.parse(dataString);
				// // } catch (ParseException e1) {
				// // JOptionPane.showMessageDialog(null, "Data Inválida");
				// // }
				// // erro = true;
				// // } else if (ValidaçãoCPF.isCPF(cpf) == false) {
				// // JOptionPane.showMessageDialog(null, "CPF inválido");
				// // erro = true;
				// // } else if (rdbtnClienteMasculino.isSelected() == false
				// // && rdbtnClienteFeminino.isSelected() == false) {
				// // JOptionPane.showMessageDialog(null, "Selecione o sexo");
				// // erro = true;
				// // }
				// //
				// // if (ValidaçãoCPF.existeCPF(cpf2)) {
				// // JOptionPane.showMessageDialog(null, "CPF já existe");
				// // erro = true;
				// // }

				if (erro == false) {
					try {
						long n = Long.parseLong(txtClienteId.getText());
						clienteController.alterar(n, txtClienteNome.getText(),
								txtClienteDataNascimento.getText(),
								txtClienteCPF.getText(),
								txtClienteRG.getText(),
								txtClienteEndereco.getText(),
								txtClienteBairro.getText(),
								txtClienteCidade.getText(), estado,
								txtClienteCEP.getText(),
								txtClienteTelefone.getText(),
								txtClienteCelular.getText(), sexo,
								txtClienteNaturalidade.getText(), estadoCivil,
								txtClienteProfissao.getText());
						limparCampos();
						btnClienteAtualizar.setVisible(false);
						btnClienteSalvar.setVisible(true);
						// JOptionPane.showMessageDialog(null,
						// "Cadastrado com sucesso!");
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
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!");
				}

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
		frmCadastro.getContentPane().add(btnClienteAtualizar);
		frmCadastro.getContentPane().add(txtClienteDataCadastro);

		// frmCadastro.setVisible(true);
		frmCadastro.setResizable(false);
	}

	// Listener
	public void metodo(String codigo, String nome, String dataCadastro,
			String dataNascimento, String cpf, String rg, String endereco,
			String bairro, String cidade, String estado, String cep,
			String telefone, String celular, String sexo, String profissao,
			String natu, String estCivil) {
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
		btnClienteAtualizar.setVisible(true);
		btnClienteSalvar.setVisible(false);
		txtClienteProfissao.setText(profissao);
	}

	public void limparCampos() {
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
	}

	public void validacao() {
		erro = false;
		if (erro == false) {
			erro = validar.validarNome(txtClienteNome.getText());
			if (erro == true) {
				JOptionPane.showMessageDialog(null, "Favor preencher o nome");
			}
		}

		if (erro == false) {
			erro = validar.validarDataNascimento(txtClienteDataNascimento
					.getText());
			if (erro == true) {
				JOptionPane.showMessageDialog(null, "Data Inválida");
				txtClienteDataNascimento.setText("");
			}
		}

		if (erro == false) {
			erro = validar.validarSexo(rdbtnClienteFeminino.isSelected(),
					rdbtnClienteMasculino.isSelected());
			if (erro == true) {
				JOptionPane.showMessageDialog(null, "Selecione o sexo");
			}
		}

		if (erro == false) {
			erro = validar.validarCPFValido(txtClienteCPF.getText());
			boolean erro2 = false;
			if (erro == true) {
				JOptionPane.showMessageDialog(null, "CPF Inválido");
				txtClienteCPF.setText("");
				erro2 = true;
			}

			if (erro2 == true) {
				erro = validar.validarCPFExistente(txtClienteCPF.getText());
				if (erro == true) {
					JOptionPane.showMessageDialog(null, "CPF já foi cadastrado");
					txtClienteCPF.setText("");
				}
			}
		}

		// String cpf = txtClienteCPF.getText().replace(".", "");
		// cpf = cpf.replace("-", "");
		// String cpf2 = txtClienteCPF.getText();
		// erro = false;
		// boolean cpfValido = ValidaçãoCPF.isCPF(cpf);
		// if (txtClienteNome.getText().equals("")) {
		// JOptionPane.showMessageDialog(null, "Favor preencher o nome");
		// erro = true;
		// }
		//
		// if (erro == false) {
		// if (txtClienteDataNascimento.getText().equals("  /  /    ")
		// || !txtClienteDataNascimento.getText().equals("")) {
		// Pattern p = Pattern
		// .compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		// Matcher m = p.matcher(txtClienteDataNascimento.getText());
		// if (!m.find()) {
		// System.err.println("Data inválida.");
		// erro = true;
		// txtClienteDataNascimento.setText("");
		// JOptionPane.showMessageDialog(null, "Data Inválida");
		// }
		// }
		// }
		//
		// if (erro == false) {
		// if (rdbtnClienteMasculino.isSelected() == false
		// && rdbtnClienteFeminino.isSelected() == false) {
		// JOptionPane.showMessageDialog(null, "Selecione o sexo");
		// erro = true;
		// }
		// }
		//
		// if (erro == false) {
		// if (cpfValido == false) {
		// JOptionPane.showMessageDialog(null, "CPF inválido");
		// erro = true;
		// } else if (ValidaçãoCPF.existeCPF(cpf2)) {
		// JOptionPane.showMessageDialog(null, "CPF já cadastrado");
		// txtClienteCPF.setText("");
		// erro = true;
		// }
		// }
	}

	// retorna o frame para que a tela principal possa manipular e não deixar
	// abrir duas tela
	public JFrame retornaTela() {
		return frmCadastro;
	}
}
