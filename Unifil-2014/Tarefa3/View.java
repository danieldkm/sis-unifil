import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class View extends JFrame {

	Container container;
	private JTextField txtNome = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtCodigo = new JTextField();
	private JTextField txtCpf = new JTextField();
	private JTextField txtData = new JTextField();
	private JTextField txtId = new JTextField();
	private JButton btnInserir = new JButton("Inserir");
	private JButton btnAtualizar = new JButton("Atualizar");
	private JButton btnRemover = new JButton("Remover");
	private JButton btnLimpar = new JButton("Limpar");
	private JLabel lblId = new JLabel("ID: ");
	private JLabel lblNome = new JLabel("Nome: ");
	private JLabel lblEmail = new JLabel("Email: ");
	private JLabel lblCodigo = new JLabel("Código: ");
	private JLabel lblCpf = new JLabel("CPF: ");
	private JLabel lblData = new JLabel("Data nasc: ");
	private Banco banco = new Banco();
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private JTable tabela;
	private ModeloTabela modeloTabela;

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
		JPanel pane = new JPanel(new GridLayout(6, 3));
		pane.add(lblId);
		txtId.setEnabled(false);
		pane.add(txtId);
		pane.add(btnInserir);
		
		pane.add(lblNome);
		pane.add(txtNome);
		pane.add(btnAtualizar);

		pane.add(lblEmail);
		pane.add(txtEmail);
		pane.add(btnRemover);

		pane.add(lblCodigo);
		pane.add(txtCodigo);
		pane.add(btnLimpar);
		
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

	private JScrollPane getTable() {
		pessoas = banco.consultaPessoa();
		modeloTabela = new ModeloTabela(pessoas);
		tabela = new JTable(modeloTabela);
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount() == 2){
					System.out.println("selecionada " + tabela.getModel().getValueAt(tabela.getSelectedRow(), 0));
					Pessoa p = new Pessoa();
					p.setId(Integer.parseInt(tabela.getModel().getValueAt(tabela.getSelectedRow(), 0)+""));
					p.setNome(tabela.getModel().getValueAt(tabela.getSelectedRow(), 1)+"");
					p.setEmail(tabela.getModel().getValueAt(tabela.getSelectedRow(), 2)+"");
					p.setCodigo(tabela.getModel().getValueAt(tabela.getSelectedRow(), 3)+"");
					p.setCpf(tabela.getModel().getValueAt(tabela.getSelectedRow(), 4)+"");
					p.setData(tabela.getModel().getValueAt(tabela.getSelectedRow(), 5)+"");
					txtId.setText(p.getId()+"");
					txtNome.setText(p.getNome());
					txtEmail.setText(p.getEmail());
					txtCodigo.setText(p.getCodigo());
					txtCpf.setText(p.getCpf());
					txtData.setText(p.getData());
				}
				
			}
		});
		return new JScrollPane(tabela);
	}
	
	private void atualizarTabela(){
		pessoas = banco.consultaPessoa();
		modeloTabela.atualizarTabela(pessoas);
	}
	

	private void setListenerButton() {
		btnInserir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p = new Pessoa(txtNome.getText(), txtCodigo.getText(), txtEmail.getText(), txtCpf.getText(), txtData.getText());
				try {
					banco.inserirPessoa(p);
					atualizarTabela();
				} catch (Exception e) {
					System.out.println("Erro ao inseriro PESSOA");
				}
			}
		});

		btnAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p = new Pessoa(Integer.parseInt(txtId.getText()), txtNome.getText(), txtCodigo.getText(), txtEmail.getText(), txtCpf.getText(), txtData.getText());
				try {
					banco.atualizarPessoa(p);
					atualizarTabela();
				} catch (Exception e) {
					System.out.println("Erro ao atualizar PESSOA");
				}
			}
		});

		btnRemover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pessoa p = new Pessoa(txtNome.getText(), txtCodigo.getText(), txtEmail.getText(), txtCpf.getText(), txtData.getText());
				try {
					banco.removerPessoa(p);
					atualizarTabela();
				} catch (Exception e) {
					System.out.println("Erro ao consultar PESSOA");
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtId.setText(null);
				txtNome.setText(null);
				txtEmail.setText(null);
				txtCodigo.setText(null);
				txtCpf.setText(null);
				txtData.setText(null);
			}
		});
	}

}
