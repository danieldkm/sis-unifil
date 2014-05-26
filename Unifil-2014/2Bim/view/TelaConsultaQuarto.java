package view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.Controller;
import controller.ControllerTela;
import entidades.Quarto;

public class TelaConsultaQuarto extends ControllerTela {

	private JDialog frame;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaQuarto window = new TelaConsultaQuarto();
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
	public TelaConsultaQuarto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JDialog();
		frame.setBounds(100, 100, 477, 379);
		frame.setTitle("Consulta Quarto");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("FormattedTextField.border"));
		panel.setBounds(10, 11, 441, 319);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesquisar.setBounds(10, 11, 91, 14);
		panel.add(lblPesquisar);
		
		textField = new JTextField();
		textField.setBounds(111, 8, 320, 20);
		panel.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				ArrayList<Quarto> novaLista = new ArrayList<>();
				String bus = "";
				for (Quarto q : listaQuarto) {
					bus = q.getId() + q.getDescricao() + q.getTipo() + q.getCapacidade();
					if(bus.contains(textField.getText())){
						novaLista.add(q);
					}
				}
				tQuarto.atualizarTabela(novaLista);
			}
		});
		
		
		scrollPane = getTable("quarto");
		scrollPane.setBounds(10, 37, 419, 270);
		panel.add(scrollPane);
		table.addMouseListener(new MouseListener() {
			@Override public void mouseReleased(MouseEvent e) {}
			@Override public void mousePressed(MouseEvent e) {}
			@Override public void mouseExited(MouseEvent e) {}
			@Override public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					quartoSelecionado = new Quarto(table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
							table.getModel().getValueAt(table.getSelectedRow(), 2).toString(), 
							Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()));
					quartoSelecionado.setId(Integer.parseInt(table
							.getModel().getValueAt(table.getSelectedRow(), 0)
							.toString())); 
					txtQuarto.setText(quartoSelecionado.getDescricao());
					JOptionPane.showMessageDialog(frame,
							"Quarto selecionado");
					frame.dispose();
				}
			}
		});
		
		frame.setResizable(false);
		frame.setModal(true);
		frame.setVisible(true);
	}

}
