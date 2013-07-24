package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import model.Cliente;

import controller.ClienteController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LocalizarClienteFrame {

	private JFrame frmBuscarCliente;
	private JTextField txtBuscaNome;
	private JTextField txtBuscaDataNascimento;
	private JTextField txtBuscaLocalizar;
	private JTextField txtBuscaId;
	private List<Cliente> clienteList = new ClienteController().listaClientes();
	private int registroAtual = 0;
	private SimpleDateFormat formatadorInv;
	private Date data;

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
			data = new Date();
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
		frmBuscarCliente.setBounds(100, 100, 527, 305);
		frmBuscarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuscarCliente.getContentPane().setLayout(null);

		txtBuscaNome = new JTextField();
		txtBuscaNome.setBounds(10, 96, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaNome);
		txtBuscaNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 71, 46, 14);
		frmBuscarCliente.getContentPane().add(lblNewLabel);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 127, 160, 14);
		frmBuscarCliente.getContentPane().add(lblDataDeNascimento);

		txtBuscaDataNascimento = new JTextField();
		txtBuscaDataNascimento.setBounds(10, 152, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaDataNascimento);
		txtBuscaDataNascimento.setColumns(10);

		JButton btnPrimeiro = new JButton("<<");
		btnPrimeiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickPrimeiro();
			}
		});
		btnPrimeiro.setBounds(11, 183, 70, 23);
		frmBuscarCliente.getContentPane().add(btnPrimeiro);

		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickAnterior();
			}
		});
		btnAnterior.setBounds(82, 183, 70, 23);
		frmBuscarCliente.getContentPane().add(btnAnterior);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnLimpar.setBounds(152, 183, 91, 23);
		frmBuscarCliente.getContentPane().add(btnLimpar);

		JButton btnProximo = new JButton(">");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickProximo();
			}
		});
		btnProximo.setBounds(243, 183, 70, 23);
		frmBuscarCliente.getContentPane().add(btnProximo);

		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickUltimo();
			}
		});
		btnUltimo.setBounds(312, 183, 70, 23);
		frmBuscarCliente.getContentPane().add(btnUltimo);

		txtBuscaLocalizar = new JTextField();
		txtBuscaLocalizar.setBounds(10, 242, 372, 20);
		frmBuscarCliente.getContentPane().add(txtBuscaLocalizar);
		txtBuscaLocalizar.setColumns(10);

		JLabel lblLocalizarPorNome = new JLabel("Localizar por Nome");
		lblLocalizarPorNome.setBounds(10, 217, 339, 14);
		frmBuscarCliente.getContentPane().add(lblLocalizarPorNome);

		JButton btnBuscarSalvar = new JButton("Salvar");
		btnBuscarSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController cc = new ClienteController();
				/////*********************************** arrumar aqui **********************************//
				//******************************************************************************************************
				//******************************************************************************************************//
				String dataNasc = txtBuscaDataNascimento.getText().replace('/',
						'-');
//				System.out.println(dataNasc);
				String dataNascInv = "";
//				
				dataNascInv = "" + dataNasc.substring(6, 10)
						+ dataNasc.substring(2, 6) + dataNasc.substring(0, 1);
//				SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
//				Date dt = new Date(dataNascInv);
//				String dataAtual = dt.(data);
				
				try {
					cc.salvarNome(txtBuscaNome.getText(),
							dataNascInv);
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
		});
		btnBuscarSalvar.setBounds(408, 35, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscarSalvar);

		JButton btnBuscaAlterar = new JButton("Alterar");
		btnBuscaAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController cc = new ClienteController();
				String dataNasc = txtBuscaDataNascimento.getText().replace('/',
						'-');
				String dataNascInv = "", sexo = "";
				dataNascInv = "" + dataNasc.substring(6, 10)
						+ dataNasc.substring(2, 6) + dataNasc.substring(0, 1);

				long id = clienteList.get(registroAtual).getId();
				try {
					cc.alterarNome(id, txtBuscaNome.getText(), dataNascInv);
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

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController cc = new ClienteController();
				long id = clienteList.get(registroAtual).getId();
				try {
					cc.excluir(id);
					JOptionPane.showMessageDialog(null,
							"Cliente excluido com sucesso!");
					clearFields();
					clienteList = new ClienteController().listaClientes();
				} catch (SQLException exception) {
					JOptionPane.showMessageDialog(
							null,
							"Nao foi possivel excluir o cliente!n"
									+ exception.getLocalizedMessage());
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
					txtBuscaNome.setText(c.getNome());
					txtBuscaId.setText(c.getId().toString());
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
		btnBuscarIr.setBounds(408, 241, 91, 23);
		frmBuscarCliente.getContentPane().add(btnBuscarIr);
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
			txtBuscaId.setText(clienteAtual.getId().toString());
			txtBuscaDataNascimento.setText(new SimpleDateFormat("dd/MM/yyyy")
					.format(clienteAtual.getDataNascimento()));
		}
	}

	private void clearFields() {
		txtBuscaId.setText("");
		txtBuscaNome.setText("");
		txtBuscaDataNascimento.setText("");
		txtBuscaLocalizar.setText("");
	}
}
