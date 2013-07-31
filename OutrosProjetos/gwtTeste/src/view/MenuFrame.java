package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.cliente.ClienteFrame;
import view.cliente.ConsultarClienteFrame;

public class MenuFrame {

	private JFrame frame;
	private JInternalFrame internalFrameArquivo;
	private JInternalFrame internalFrameCadastro;
	private JInternalFrame internalFrameRelatorio;
	private JInternalFrame internalFrameConsulta;
	private JInternalFrame internalFrameOperacoes;
	private JInternalFrame internalFrameMenuFiscal;
	private JButton btnArquivo;
	private JButton btnCadastro;
	private JButton btnRelatrio;
	private JButton btnConsulta;
	private JButton btnOperacoes;
	private JButton btnMenuFiscal;
	private JButton btnSair;
	private ClienteFrame cf = null;
	private ConsultarClienteFrame ccf = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame window = new MenuFrame();
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
	public MenuFrame() {
		initialize();
		tema(1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("PAF-ECF");
		frame.setBounds(0, 0, 1280, 1024);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

		JInternalFrame internalFrame = new JInternalFrame("MENU");
		internalFrame.setBounds(0, 0, 107, 966);
		frame.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
		// internalFrame.setResizable(true);
		internalFrame.getContentPane().setLayout(null);

		// Button's
		btnArquivo = new JButton("Arquivo");
		btnArquivo.setBounds(10, 11, 80, 75);
		btnArquivo.setToolTipText("Arquivo");
		internalFrame.getContentPane().add(btnArquivo);
		btnArquivo.setEnabled(false);

		ImageIcon imagemCadastro = new ImageIcon("imagens\\cadastro.png");
		btnCadastro = new JButton(imagemCadastro);
		btnCadastro.setBounds(10, 97, 80, 75);
		btnCadastro.setToolTipText("Cadastro");
		internalFrame.getContentPane().add(btnCadastro);

		ImageIcon imagemConsulta = new ImageIcon("imagens\\consulta.png");
		btnConsulta = new JButton(imagemConsulta);
		btnConsulta.setBounds(10, 183, 80, 75);
		btnConsulta.setToolTipText("Consulta");
		internalFrame.getContentPane().add(btnConsulta);

		ImageIcon imagemRelatorio = new ImageIcon("imagens\\relatorio.png");
		btnRelatrio = new JButton(imagemRelatorio);
		btnRelatrio.setBounds(10, 269, 80, 75);
		btnRelatrio.setToolTipText("Relat\u00F3rio");
		internalFrame.getContentPane().add(btnRelatrio);

		ImageIcon imagemOperacoes = new ImageIcon("imagens\\operacoes.png");
		btnOperacoes = new JButton(imagemOperacoes);
		btnOperacoes.setBounds(10, 352, 80, 75);
		btnOperacoes.setToolTipText("Operações");
		internalFrame.getContentPane().add(btnOperacoes);

		ImageIcon imagemFiscal = new ImageIcon("imagens\\menufiscal.png");
		btnMenuFiscal = new JButton(imagemFiscal);
		btnMenuFiscal.setBounds(10, 436, 80, 75);
		btnMenuFiscal.setToolTipText("Menu Fiscal");
		internalFrame.getContentPane().add(btnMenuFiscal);

		ImageIcon imagemSair = new ImageIcon("imagens\\sair.png");
		btnSair = new JButton(imagemSair);
		btnSair.setBounds(10, 820, 80, 75);
		btnSair.setToolTipText("Sair");
		internalFrame.getContentPane().add(btnSair);

		// Janelas interna
		internalFrameArquivo = new JInternalFrame("Menu Arquivo");
		internalFrameCadastro = new JInternalFrame("Menu Cadastro");
		internalFrameRelatorio = new JInternalFrame("Menu Relatório");
		internalFrameConsulta = new JInternalFrame("Menu Consulta");
		internalFrameOperacoes = new JInternalFrame("Menu Operacções");
		internalFrameMenuFiscal = new JInternalFrame("Menu Fiscal");

		// Ação do botão arquivo
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (internalFrameArquivo.isVisible() == false) {
					internalFrameArquivo.setBounds(150, 150, 500, 500);
					frame.getContentPane().add(internalFrameArquivo);
					internalFrameArquivo.setVisible(true);
					internalFrameArquivo.setResizable(true);
					internalFrameArquivo.setClosable(true);
					internalFrameArquivo.getContentPane().setLayout(null);
				}
			}
		});

		// Ação do botão cadastro
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (internalFrameCadastro.isVisible() == false) {
					internalFrameCadastro.setBounds(170, 170, 500, 500);
					frame.getContentPane().add(internalFrameCadastro);
					internalFrameCadastro.setVisible(true);
					internalFrameCadastro.setResizable(true);
					internalFrameCadastro.setClosable(true);
					internalFrameCadastro.getContentPane().setLayout(null);
					ImageIcon imagemCadastroCliente = new ImageIcon("imagens\\cadastroCliente.png");
					JButton btnCadastroCliente = new JButton(imagemCadastroCliente);
					btnCadastroCliente.setToolTipText("Cadastro de Cliente");
					btnCadastroCliente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (cf == null) {
								cf = new ClienteFrame();
							}
							cf.retornaTela().setVisible(true);

						}
					});
					btnCadastroCliente.setBounds(50, 50, 80, 75);
					internalFrameCadastro.getContentPane().add(
							btnCadastroCliente);
					//Botão cadastrar produto
					ImageIcon imagemCadastroProduto = new ImageIcon("imagens\\cadastroProduto.png");
					JButton btnCadastroProduto = new JButton(imagemCadastroProduto);
					btnCadastroCliente.setToolTipText("Cadastro de Produto");
					btnCadastroCliente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (cf == null) {
//								cf = new ClienteFrame();
							}
//							cf.retornaTela().setVisible(true);

						}
					});
					btnCadastroProduto.setBounds(150, 50, 80, 75);
					internalFrameCadastro.getContentPane().add(
							btnCadastroProduto);
				}
			}
		});

		// Ação do botão relatorio
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (internalFrameRelatorio.isVisible() == false) {
					internalFrameRelatorio.setBounds(190, 190, 500, 500);
					frame.getContentPane().add(internalFrameRelatorio);
					internalFrameRelatorio.setVisible(true);
					internalFrameRelatorio.setResizable(true);
					internalFrameRelatorio.setClosable(true);
					internalFrameRelatorio.getContentPane().setLayout(null);
				}
			}
		});

		// Ação do botão Consulta
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (internalFrameConsulta.isVisible() == false) {
					internalFrameConsulta.setBounds(210, 210, 500, 500);
					frame.getContentPane().add(internalFrameConsulta);
					internalFrameConsulta.setVisible(true);
					internalFrameConsulta.setResizable(true);
					internalFrameConsulta.setClosable(true);
					internalFrameConsulta.getContentPane().setLayout(null);
					ImageIcon imagemConsultaCliente = new ImageIcon("imagens\\buscarCliente.png");
					JButton btnConsultaCliente = new JButton(
							imagemConsultaCliente);
					btnConsultaCliente.setToolTipText("Consulta de Cliente");
					btnConsultaCliente.setToolTipText("Consulta de Cliente");
					btnConsultaCliente.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (ccf == null) {
								ccf = new ConsultarClienteFrame();
							}
							ccf.retornaTela().setVisible(true);

						}
					});
					btnConsultaCliente.setBounds(50, 50, 80, 75);
					internalFrameConsulta.getContentPane().add(btnConsultaCliente);
				}
			}
		});

		// Ação do botão Operações
		btnOperacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (internalFrameOperacoes.isVisible() == false) {
					internalFrameOperacoes.setBounds(230, 230, 500, 500);
					frame.getContentPane().add(internalFrameOperacoes);
					internalFrameOperacoes.setVisible(true);
					internalFrameOperacoes.setResizable(true);
					internalFrameOperacoes.setClosable(true);
					internalFrameOperacoes.getContentPane().setLayout(null);
				}
			}
		});

		// Ação do botão Menu Fiscal
		btnMenuFiscal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (internalFrameMenuFiscal.isVisible() == false) {
					internalFrameMenuFiscal.setBounds(250, 250, 500, 500);
					frame.getContentPane().add(internalFrameMenuFiscal);
					internalFrameMenuFiscal.setVisible(true);
					internalFrameMenuFiscal.setResizable(true);
					internalFrameMenuFiscal.setClosable(true);
					internalFrameMenuFiscal.getContentPane().setLayout(null);
				}
			}
		});

		// Ação do botão sair
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}

		});

		// public void actionPerformed(ActionEvent arg0) {
		// // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// // System.exit(0);
		// frame.addWindowListener(new WindowAdapter() {
		// public void windowClosing (WindowEvent e)
		// {
		// //caixa de dialogo retorna um inteiro
		// int resposta =
		// JOptionPane.showConfirmDialog(null,"Deseja finalizar essa operação?","Finalizar",JOptionPane.YES_NO_OPTION);
		//
		// //sim = 0, nao = 1
		// if (resposta == 0)
		// {
		// System.exit(0);
		// }
		//
		// }
		//
		// });
	}

	// private class SwingAction extends AbstractAction {
	// public SwingAction() {
	// putValue(NAME, "SwingAction");
	// putValue(SHORT_DESCRIPTION, "Some short description");
	// }
	//
	// public void actionPerformed(ActionEvent e) {
	// }
	// }
	private void tema(int n) {
		UIManager.LookAndFeelInfo[] tema = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(tema[n].getClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);
	}
}

// imagens do site http://www.iconesgratis.net/
