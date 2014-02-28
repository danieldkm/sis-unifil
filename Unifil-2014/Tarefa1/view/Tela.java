package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JFrame {

	public Tela(String titulo) {
		super(titulo);
		init();
	}

	private GridLayout grid1;
	private JLabel label;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCodigo;
	private JTextField txtCPF;
	private JTextField txtDataNasc;
	private JButton button;
	private JPanel jpanel;

	private void init() {

		Container container = getContentPane();
		container.setLayout(null);
		setResizable(false);
		setTextFields();
		container.add(getLabel("Nome: ",10,10,100,14));
		container.add(txtNome);
		container.add(getLabel("E-mail: ",10,40,100,14));
		container.add(txtEmail);
		
		container.add(getLabel("Código: ",10,80,100,14));
		container.add(txtCodigo);
		
		container.add(getLabel("CPF: ",10,120,100,14));
		container.add(txtCPF);
		
		container.add(getLabel("Data de Nasc: ",10,160,100,14));
		container.add(txtDataNasc);
		
		container.add(getButton());
		
		setSize(300, 300);
		setVisible(true);
		
		
	}

	private JLabel getLabel(String texto, int x, int y, int w, int h) {
		label = new JLabel(texto);
		label.setBounds(x, y, w, h);
		return label;
	}
	
	private JButton getButton(){
		button= new JButton("Inserir");
		button.setBounds(100, 200, 100, 40);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pessoa a = new Pessoa();
				a.setNome(txtNome.getText());
				a.setCodigo(txtCodigo.getText());
				a.setCpf(txtCPF.getText());
				a.setEmail(txtEmail.getText());
				a.setData(txtDataNasc.getText());
				Conf.aluno = a;
				new Inserir();
			}
		});
		return  button;
	}
	
	private void setTextFields(){
		txtNome = new JTextField();
		txtNome.setBounds(120, 10, 100, 20);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(120, 40, 100, 20);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(120, 80, 100, 20);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(120, 120, 100, 20);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setBounds(120, 160, 100, 20);
	}
	
	
	public static void main(String args[]) {

		Tela aplicacao = new Tela("TEla");
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
