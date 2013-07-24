package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.text.MaskFormatter;

import model.Cliente;

import controller.ClienteController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LocalizarClienteFrame extends JFrame {

	private JFrame frmBuscarCliente;
	private JTextField txtBuscaNome;
	private JTextField txtBuscaDataNascimento;
	private JTextField txtBuscaLocalizar;
	private JTextField txtBuscaId;
	private List<Cliente> clienteList = new ClienteController().listaClientes();
	private int registroAtual = 0;
	private Date data;
	private SimpleDateFormat formatador;
	private SimpleDateFormat formatadorInv;
	private MaskFormatter formatData;
	private MaskFormatter formatoData;
	private MaskFormatter formatCPF;
	private MaskFormatter formatRG;
	private MaskFormatter formatCEP;
	private MaskFormatter formatTel;
	private MaskFormatter formatCel;
	Font fontTextCima = new Font(Font.DIALOG, Font.BOLD, 16);
	Font font = new Font(Font.DIALOG, Font.PLAIN, 14);
	private JTextField txtBuscaCPF;

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
		} catch (Exception e) {
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuscarCliente = new JFrame();
		frmBuscarCliente.setTitle("Localizar Cliente");
		frmBuscarCliente.setBounds(100, 100, 527, 371);
		// frmBuscarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscarCliente.getContentPane().setLayout(null);

		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(10, 96, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaNome);
		txtBuscaNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 71, 46, 14);
		frmBuscarCliente.getContentPane().add(lblNewLabel);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 183, 160, 14);
		frmBuscarCliente.getContentPane().add(lblDataDeNascimento);

		txtBuscaDataNascimento = new JFormattedTextField(formatData);
		txtBuscaDataNascimento.setFont(font);
		txtBuscaDataNascimento.setBounds(10, 208, 86, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaDataNascimento);
		txtBuscaDataNascimento.setColumns(10);

		// Botões
		final JButton btnBuscarSalvar = new JButton("Salvar");
		final JButton btnBuscaAlterar = new JButton("Alterar");
		final JButton btnExcluir = new JButton("Excluir");

		JButton btnPrimeiro = new JButton("<<");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(true);
				btnBuscaAlterar.setEnabled(true);
				btnBuscarSalvar.setEnabled(false);
				onClickPrimeiro();
			}
		});
		btnPrimeiro.setBounds(11, 239, 70, 23);
		frmBuscarCliente.getContentPane().add(btnPrimeiro);

		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(true);
				btnBuscaAlterar.setEnabled(true);
				btnBuscarSalvar.setEnabled(false);
				onClickAnterior();
			}
		});
		btnAnterior.setBounds(82, 239, 70, 23);
		frmBuscarCliente.getContentPane().add(btnAnterior);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(false);
				btnBuscaAlterar.setEnabled(false);
				btnBuscarSalvar.setEnabled(true);
				clearFields();
			}
		});
		btnLimpar.setBounds(152, 239, 91, 23);
		frmBuscarCliente.getContentPane().add(btnLimpar);

		JButton btnProximo = new JButton(">");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(true);
				btnBuscaAlterar.setEnabled(true);
				btnBuscarSalvar.setEnabled(false);
				onClickProximo();
			}
		});
		btnProximo.setBounds(243, 239, 70, 23);
		frmBuscarCliente.getContentPane().add(btnProximo);

		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(true);
				btnBuscaAlterar.setEnabled(true);
				btnBuscarSalvar.setEnabled(false);
				onClickUltimo();
			}
		});
		btnUltimo.setBounds(312, 239, 70, 23);
		frmBuscarCliente.getContentPane().add(btnUltimo);

		txtBuscaLocalizar = new JTextField();
		txtBuscaLocalizar.setBounds(10, 298, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaLocalizar);
		txtBuscaLocalizar.setColumns(10);

		JLabel lblLocalizarPorNome = new JLabel("Localizar por Nome");
		lblLocalizarPorNome.setBounds(10, 273, 339, 14);
		frmBuscarCliente.getContentPane().add(lblLocalizarPorNome);

		// Função Salvar
		btnBuscarSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController cc = new ClienteController();
				Date dt = new Date();
				String dtAtual = dt.toString(), vazio = "";
				if (txtBuscaNome.getText().equals("")
						|| txtBuscaCPF.getText().equals("")
						|| txtBuscaDataNascimento.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Alguns campos não foram preenchido!");

				} else {
					try {
						cc.salvar(dtAtual, txtBuscaNome.getText(),
								txtBuscaDataNascimento.getText(),
								txtBuscaCPF.getText(), vazio, vazio, vazio,
								vazio, vazio, vazio, vazio, vazio, "Masculino",
								vazio, "Solteiro");
						JOptionPane.showMessageDialog(null,
								"Cliente salvo com sucesso!");
						clearFields();
						clienteList = new ClienteController().listaClientes();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(
								null,
								"Nao foi possivel salvar cliente!n"
										+ e.getLocalizedMessage());
					} catch (ParseException e) {
						JOptionPane.showMessageDialog(
								null,
								"Data possui formato inválido!n"
										+ e.getLocalizedMessage());
					}
				}
			}
		});
		btnBuscarSalvar.setBounds(408, 35, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscarSalvar);

		// Função Alterar
		btnBuscaAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController cc = new ClienteController();
				// String dataNasc =
				// txtBuscaDataNascimento.getText().replace('/',
				// '-');
				// String dataNascInv = "";
				// dataNascInv = "" + dataNasc.substring(6, 10)
				// + dataNasc.substring(2, 6) + dataNasc.substring(0, 1);

				long id = clienteList.get(registroAtual).getId();
				Date dt = new Date();
				// long aux = dt.getTime();
				String vazio = "", dtAtual;
				// System.out.println("aaaaaaaaaaa" + aux);
				try {
					cc.alterar(id, ""/* dtAtual */, txtBuscaNome.getText(),
							txtBuscaDataNascimento.getText(),
							txtBuscaCPF.getText(), vazio, vazio, vazio, vazio,
							vazio, vazio, vazio, vazio, "Masculino", vazio,
							"Solteiro");
					JOptionPane.showMessageDialog(null,
							"Cliente alterado com sucesso!");
					clearFields();
					clienteList = new ClienteController().listaClientes();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(
							null,
							"Nao foi possivel alterar Cliente!n"
									+ e.getLocalizedMessage());
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(
							null,
							"Data possui formato inválido!n"
									+ e.getLocalizedMessage());
				}
			}
		});
		btnBuscaAlterar.setBounds(408, 95, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscaAlterar);

		// Função excluir
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cc = new ClienteController();
				long id = clienteList.get(registroAtual).getId();
				if (txtBuscaNome.getText().equals("")) {
					// JOptionPane
					// .showMessageDialog(
					// null,
					// "Não existe cliente para ser excluído"
					// +
					// "\n Busca o cliente pelo campo 'Localizar por nome' ou pelas setas");
					btnExcluir.setEnabled(false);
				} else {
					try {
						cc.excluir(id);
						JOptionPane.showMessageDialog(null,
								"Cliente excluido com sucesso!");
						clearFields();
						clienteList = new ClienteController().listaClientes();
					} catch (SQLException exception) {
						JOptionPane.showMessageDialog(null,
								"Nao foi possivel excluir o cliente!n"
										+ exception.getLocalizedMessage());
					}
				}
			}
		});
		btnExcluir.setBounds(408, 151, 91, 23);
		frmBuscarCliente.getContentPane().add(btnExcluir);

		JLabel lblCdigoDoCliente = new JLabel("C\u00F3digo do Cliente");
		lblCdigoDoCliente.setBounds(10, 11, 160, 14);
		frmBuscarCliente.getContentPane().add(lblCdigoDoCliente);

		txtBuscaId = new JTextField();
		txtBuscaId.setEditable(false);
		txtBuscaId.setBounds(10, 36, 86, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaId);
		txtBuscaId.setColumns(10);

		JButton btnBuscarIr = new JButton("Ir");
		btnBuscarIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cc = new ClienteController();
				try {
					Cliente c = cc.buscaClientePorNome(txtBuscaLocalizar
							.getText());
					txtBuscaId.setText(c.getId().toString());
					txtBuscaNome.setText(c.getNome());
					txtBuscaCPF.setText(c.getCpf());
					txtBuscaDataNascimento.setText(new SimpleDateFormat(
							"dd/MM/yyyy").format(c.getDataNascimento()));
				} catch (SQLException exception) {
					JOptionPane.showMessageDialog(
							null,
							"Ocorreu um erro, tente novamente!n"
									+ exception.getLocalizedMessage());
				} catch (NullPointerException exception) {
					JOptionPane.showMessageDialog(
							null,
							"Cliente não localizdo ou não existe!n"
									+ exception.getLocalizedMessage());
				}
			}
		});
		btnBuscarIr.setBounds(408, 297, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscarIr);

		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setBounds(10, 127, 46, 14);
		frmBuscarCliente.getContentPane().add(lblNewLabel_1);

		txtBuscaCPF = new JFormattedTextField(formatCPF);
		txtBuscaCPF.setBounds(10, 152, 114, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaCPF);
		txtBuscaCPF.setColumns(10);
		btnExcluir.setEnabled(false);
		btnBuscaAlterar.setEnabled(false);

	}

	private void onClickUltimo() {
		registroAtual = clienteList.size() - 1;
		getValores(registroAtual);
	}

	private void onClickProximo() {
		if (registroAtual != clienteList.size() - 1) {
			getValores(++registroAtual);
		}
	}

	private void onClickAnterior() {
		if (registroAtual != 0) {
			getValores(--registroAtual);
		}
	}

	private void onClickPrimeiro() {
		registroAtual = 0;
		getValores(registroAtual);
	}

	private void getValores(int index) {
		if (index <= clienteList.size() - 1) {
			Cliente clienteAtual = clienteList.get(index);
			txtBuscaNome.setText(clienteAtual.getNome());
			txtBuscaCPF.setText(clienteAtual.getCpf());
			txtBuscaId.setText(clienteAtual.getId().toString());
			txtBuscaDataNascimento.setText(new SimpleDateFormat("dd/MM/yyyy")
					.format(clienteAtual.getDataNascimento()));
		}
	}

	private void clearFields() {
		txtBuscaId.setText("");
		txtBuscaNome.setText("");
		txtBuscaCPF.setText("");
		txtBuscaDataNascimento.setText("");
		txtBuscaLocalizar.setText("");
	}
}
