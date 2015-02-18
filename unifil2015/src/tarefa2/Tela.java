package tarefa2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Tela {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtIdade;
	private ListaPessoa listaPessoa = new ListaPessoa();
	private JTable table;
	private Tabela tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
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
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 283, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(6, 6, 56, 30);
		frame.getContentPane().add(lblNome);

		JLabel lblNewLabel = new JLabel("Idade:");
		lblNewLabel.setBounds(6, 48, 56, 30);
		frame.getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(74, 6, 200, 30);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(74, 48, 200, 30);
		frame.getContentPane().add(txtIdade);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!txtIdade.getText().equals("")
						&& !txtNome.getText().equals("")) {
					adicionarPessoa();
				} else {
					System.out.println("Deve preencher nome e idade");
				}
			}
		});
		btnAdicionar.setBounds(6, 107, 117, 29);
		frame.getContentPane().add(btnAdicionar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(135, 107, 117, 29);
		btnRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("REMOVER");
				String n = JOptionPane.showInputDialog("Informe a posição");
				boolean erro = true;
				do {
					try {
						int a = Integer.parseInt(n);
						erro = false;
						if (listaPessoa.pega(a) != null) {
							listaPessoa.remove(a);
						} else {
							System.out.println("Não existe");
						}
					} catch (Exception e2) {
						// e2.printStackTrace();
						n = JOptionPane.showInputDialog("Informe a posição");
					}
				} while (erro);
			}
		});
		frame.getContentPane().add(btnRemover);

		JPanel panel = new JPanel();
		panel.setBounds(6, 148, 268, 228);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(getTable(), BorderLayout.CENTER);
	}

	private void adicionarPessoa() {
		try {
			Pessoa p = new Pessoa(txtNome.getText(), Integer.parseInt(txtIdade
					.getText()));
			System.out.println("ADICIONAR PESSOA " + p);
			listaPessoa.adicionarPessoa(p);
			tabela.atualizarTabela(listaPessoa);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	private JScrollPane getTable() {
		tabela = new Tabela(listaPessoa);
		table = new JTable(tabela);
		return new JScrollPane(table);
	}
}
