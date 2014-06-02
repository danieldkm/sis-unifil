package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import tabela.TabelaVisitante;
import FactoryMethod.Dao;
import entidades.Visitante;

public class ControllerVisitante extends Controller implements Telas {

	private ArrayList<Visitante> listaVisitante;
	private TabelaVisitante tVisitante;
	private Visitante visitanteSelecionado;

	protected JDialog frame;
	protected JTextField txtNome;
	protected JTextField txtTelefone;
	protected JTextField txtEmail;
	
	public ControllerVisitante() {
		// TODO Auto-generated constructor stub
	}
	
	public ControllerVisitante(JDialog frame, JTextField txtBuscar, boolean isConsulta) {
		this.frame = frame;
		this.txtBuscar = txtBuscar;
		this.isConsulta = isConsulta;
	}
	
	public ControllerVisitante(JDialog frame, JTextField txtNome, JTextField txtTelefone, JTextField txtEmail, JTextField txtBuscar) {
		this.frame = frame;
		this.txtNome = txtNome;
		this.txtTelefone = txtTelefone;
		this.txtEmail = txtEmail;
		this.txtBuscar = txtBuscar;
	}

	protected ArrayList<Visitante> getListaVisitante() {
		ArrayList<Object> listaObjeto = Dao.select(new Visitante());
		ArrayList<Visitante> listaVisitante = new ArrayList<>();
		for (Object o : listaObjeto) {
			Visitante v = (Visitante) o;
			listaVisitante.add(v);
		}
		return listaVisitante;
	}

	public JScrollPane getTable() {
		listaVisitante = getListaVisitante();
		tVisitante = new TabelaVisitante(listaVisitante);
		table = new JTable(tVisitante);
		return new JScrollPane(table);
	}

	@Override
	public boolean validarCampos() {
		if (txtNome.getText().equals("") || txtNome.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo NOME n�o foi preenchido");
			return true;
		} else if (txtTelefone.getText().equals("")
				|| txtTelefone.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo TELEFONE n�o foi preenchido");
			return true;
		} else if (txtEmail.getText().equals("")
				|| txtEmail.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo E-MAIL n�o foi preenchido");
			return true;
		}
		return false;
	}

	@Override
	public void salvar(ActionEvent arg0) {
		try {
			if (!validarCampos()) {
				if (isEdited) {
					visitanteSelecionado.setNome(txtNome.getText());
					visitanteSelecionado.setTelefone(txtTelefone.getText());
					visitanteSelecionado.setEmail(txtEmail.getText());
					Dao.update(visitanteSelecionado);
					visitanteSelecionado = null;
					JOptionPane.showMessageDialog(frame,
							"Atualizado com sucesso!");
					isEdited = false;
					frame.dispose();
				} else {
					visitanteSelecionado = new Visitante(txtNome.getText(),
							txtTelefone.getText(), txtEmail.getText());
					Dao.insert(visitanteSelecionado);
					JOptionPane.showMessageDialog(frame,
							"Cadastrado com sucesso!");
					frame.dispose();
					System.out.println("Salvo com sucesso");
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public void excluir(ActionEvent e) {
		if (isEdited) {
			int r = JOptionPane.showConfirmDialog(frame,
					"Tem certeza que deseja EXCLUIR!\nVisitante a ser excluido: "
							+ visitanteSelecionado.getNome());
			if (r == 0) {
				Dao.delete(visitanteSelecionado);
				frame.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(frame,
					"Visitante n�o foi selecionado para ser exclu�do");
		}
	}

	@Override
	public void limpar(ActionEvent e) {
		isEdited = false;
		visitanteSelecionado = null;
		txtBuscar.setText(null);
		txtEmail.setText(null);
		txtNome.setText(null);
		txtTelefone.setText(null);
		txtTelefone.setText(null);
	}

	@Override
	public void actionMouseClickedOnTable(MouseEvent e) {
		if (e.getClickCount() == 2) {
			visitanteSelecionado = new Visitante(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString(), table
					.getModel().getValueAt(table.getSelectedRow(), 2)
					.toString(), table.getModel()
					.getValueAt(table.getSelectedRow(), 3).toString());
			visitanteSelecionado.setId(Integer.parseInt(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString()));
			if (isConsulta) {
				txtVisitante.setText(visitanteSelecionado.getNome());
				frame.dispose();
				isConsulta = false;
				JOptionPane.showMessageDialog(null, "Visitante selecionado: " + visitanteSelecionado.getNome());
			} else {
				txtNome.setText(visitanteSelecionado.getNome());
				txtTelefone.setText(visitanteSelecionado.getTelefone());
				txtEmail.setText(visitanteSelecionado.getEmail());
			}
			isEdited = true;
		}
	}

	@Override
	public void actionButtonBuscar(KeyEvent e) {
		ArrayList<Visitante> novaLista = new ArrayList<>();
		String bus = "";
		for (Visitante v : listaVisitante) {
			bus = v.getId() + v.getNome() + v.getTelefone() + v.getEmail();
			if (bus.contains(txtBuscar.getText())) {
				novaLista.add(v);
			}
		}
		tVisitante.atualizarTabela(novaLista);
	}

	@Override
	public void setAddMouseListener() {
		table.addMouseListener(new MouseListener() {
		@Override public void mouseReleased(MouseEvent e) {}
		@Override public void mousePressed(MouseEvent e) {}
		@Override public void mouseExited(MouseEvent e) {}
		@Override public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			actionMouseClickedOnTable(e);
		}
	});
	}

	@Override
	public void verificarTipoQuarto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionListenerBtn() {
		// TODO Auto-generated method stub
		
	}


}
