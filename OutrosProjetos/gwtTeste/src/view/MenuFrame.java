package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MenuFrame {

	private JFrame frame;
	private final Action action = new SwingAction();

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("MENU");
		internalFrame.setBounds(0, 0, 107, 966);
		frame.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
		internalFrame.setResizable(true);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnArquivo = new JButton("Arquivo");
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JInternalFrame internalFrameArquivo = new JInternalFrame("Arquivo");
				internalFrameArquivo.setBounds(100, 150, 500, 500);
				frame.getContentPane().add(internalFrameArquivo);
				internalFrameArquivo.setVisible(true);
				internalFrameArquivo.setResizable(true);
				internalFrameArquivo.getContentPane().setLayout(null);
			}
		});
		btnArquivo.setBounds(10, 11, 80, 75);
		internalFrame.getContentPane().add(btnArquivo);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JInternalFrame internalFrameCadastro = new JInternalFrame("Cadastro");
				internalFrameCadastro.setBounds(150, 150, 500, 500);
				frame.getContentPane().add(internalFrameCadastro);
				internalFrameCadastro.setVisible(true);
				internalFrameCadastro.setResizable(true);
				internalFrameCadastro.setClosable(true);
				internalFrameCadastro.getContentPane().setLayout(null);
				
				JButton btnCadastroCliente = new JButton("Cadastro de Cliente");
				btnCadastroCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ClienteFrame();
					}
				});
				btnCadastroCliente.setBounds(50,50,80, 75);
				internalFrameCadastro.getContentPane().add(btnCadastroCliente);
			}
		});
		btnCadastro.setBounds(10, 97, 80, 75);
		internalFrame.getContentPane().add(btnCadastro);
		
		JButton btnRelatrio = new JButton("Relat\u00F3rio");
		btnRelatrio.setBounds(10, 269, 80, 75);
		internalFrame.getContentPane().add(btnRelatrio);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(10, 183, 80, 75);
		internalFrame.getContentPane().add(btnConsulta);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
