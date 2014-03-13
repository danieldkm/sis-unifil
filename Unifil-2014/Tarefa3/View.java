import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

	Container container;
	private JTextField txtNome = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtCodigo = new JTextField();
	private JTextField txtCpf = new JTextField();
	private JTextField txtData = new JTextField();
	private JButton btnInserir = new JButton("Inserir");
	private JButton btnAtualizar = new JButton("Atualizar");
	private JButton btnRemover = new JButton("Remover");
	private JLabel lblNome = new JLabel("Nome: ");
	private JLabel lblEmail = new JLabel("Email: ");
	private JLabel lblCodigo = new JLabel("Código: ");
	private JLabel lblCpf = new JLabel("CPF: ");
	private JLabel lblData = new JLabel("Data nasc: ");
	private Banco banco = new Banco();
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private JTable tabela;

	public View() {
		super("Telaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		container = getContentPane();
		container.setLayout(new BorderLayout());

		container.add(getPanel(), BorderLayout.PAGE_START);
		container.add(getTable(), BorderLayout.CENTER);

		setListenerButton();
		
		setSize(600, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new View();
	}

	private JPanel getPanel() {
		JPanel pane = new JPanel(new GridLayout(5, 3));
		pane.add(lblNome);
		pane.add(txtNome);
		pane.add(btnInserir);

		pane.add(lblEmail);
		pane.add(txtEmail);
		pane.add(btnAtualizar);

		pane.add(lblCodigo);
		pane.add(txtCodigo);
		pane.add(btnRemover);
		
		pane.add(lblCpf);
		pane.add(txtCpf);
		pane.add(new JLabel());
		
		pane.add(lblData);
		pane.add(txtData);
		pane.add(new JLabel());
		
		return pane;
	}

	private JLabel getLabel() {
		return new JLabel("   ");
	}

//		String[] colunas = new String []{"Estado","Cidade"};  
//		String[][] dados = new String [][] {  
//		       {"SP","Sao Paulo"},  
//		       {"RJ","Rio de Janeiro"},  
//		       {"RN","Rio Grande do Norte"},  
//		       {"PR","Parana"}  
//		};  
//		      
//		JTable jtable = new JTable(dados, colunas); 
	private JScrollPane getTable() {
		pessoas = banco.consultaPessoa();
		ModeloTabela mt = new ModeloTabela(pessoas);
		tabela = new JTable(mt);
		return new JScrollPane(tabela);
	}
	

	private void setListenerButton() {
		btnInserir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p = new Pessoa(txtNome.getText(), txtCodigo.getText(), txtEmail.getText(), txtCpf.getText(), txtData.getText());
				try {
					banco.inserirPessoa(p);
				} catch (Exception e) {
					System.out.println("Erro ao inseriro PESSOA");
				}
			}
		});

		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p = new Pessoa(txtNome.getText(), txtCodigo.getText(), txtEmail.getText(), txtCpf.getText(), txtData.getText());
				try {
					banco.atualizarPessoa(p);
				} catch (Exception e) {
					System.out.println("Erro ao atualizar PESSOA");
				}
			}
		});

		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					pessoas = banco.consultaPessoa();
				} catch (Exception e) {
					System.out.println("Erro ao consultar PESSOA");
				}
			}
		});
	}

}
