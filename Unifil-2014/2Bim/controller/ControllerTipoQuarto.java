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

import tabela.TabelaTipoQuarto;
import FactoryMethod.Dao;
import entidades.TipoQuarto;

public class ControllerTipoQuarto extends Controller implements Telas {
	
	private ArrayList<TipoQuarto> listaTipoQuarto;
	private TabelaTipoQuarto tTipoQuarto;
	private TipoQuarto tipoQuartoSelecionado;
	private JDialog frmCadastroTipoDe;
	private static JTextField txtDescricao;
	private static int id;
	
	public ControllerTipoQuarto() {
	}
	
	public ControllerTipoQuarto(JDialog frmCadastroTipoDe, JTextField txtDescricao,  JTextField txtBuscar, TipoQuarto tipoQuartoSelecionado, boolean isEdited) {
		this.frmCadastroTipoDe = frmCadastroTipoDe;
		this.txtDescricao = txtDescricao;
		this.txtBuscar = txtBuscar;
		this.tipoQuartoSelecionado = tipoQuartoSelecionado;
		this.isEdited = isEdited;
	}
	
	public JScrollPane getTable() {
		listaTipoQuarto = getListaTipoQuarto();
		tTipoQuarto = new TabelaTipoQuarto(listaTipoQuarto);
		table = new JTable(tTipoQuarto);
		return new JScrollPane(table);
	}

	@Override
	public boolean validarCampos() {
		if (txtDescricao.getText().equals("")) {
			JOptionPane.showMessageDialog(frmCadastroTipoDe,
					"Campo de descri��o vazio!!");
			return true;
		}
		for (TipoQuarto tq : getListaTipoQuarto()) {
			if (txtDescricao.getText().equals(tq.getDescricao())) {
				JOptionPane.showMessageDialog(frmCadastroTipoDe,
						"Descri��o informada ja existe!!");
				return true;
			}
		}
		return false;
	}

	@Override
	public void salvar(ActionEvent arg0) {
		if (isEdited) {
			int r = JOptionPane.showConfirmDialog(
					frmCadastroTipoDe,
					"Tem certeza que deseja ATUALIZAR "
							+ tipoQuartoSelecionado.getDescricao() + " para "
							+ txtDescricao.getText());
			if (r == 0) {
				tipoQuartoSelecionado.setDescricao(txtDescricao.getText());
				Dao.update(tipoQuartoSelecionado);
				isEdited = false;
				frmCadastroTipoDe.dispose();
			}
		} else {
			if (!validarCampos()) {
				tipoQuartoSelecionado = new TipoQuarto(txtDescricao.getText());
				Dao.insert(tipoQuartoSelecionado);
				JOptionPane.showMessageDialog(frmCadastroTipoDe,
						"Cadastrado com sucesso!");
				frmCadastroTipoDe.dispose();

			}
		}
	}

	@Override
	public void excluir(ActionEvent e) {
		if (isEdited) {
			int r = JOptionPane.showConfirmDialog(frmCadastroTipoDe,
					"Tem certeza que deseja EXCLUIR!\nTipo do quarto a ser excluido "
							+ txtDescricao.getText());
			if (r == 0) {
				Dao.delete(tipoQuartoSelecionado);
				isEdited = false;
				frmCadastroTipoDe.dispose();
			}
		} else {
			JOptionPane
					.showMessageDialog(frmCadastroTipoDe,
							"Tipo do quarto n�o foi selecionado para ser exclu�do");
		}
	}

	@Override
	public void limpar(ActionEvent e) {
		txtDescricao.setText(null);
		tipoQuartoSelecionado = null;
		isEdited = false;
	}

	@Override
	public void actionMouseClickedOnTable(MouseEvent e) {
		if (e.getClickCount() == 2) {
			tipoQuartoSelecionado = new TipoQuarto(Integer
					.parseInt(table.getModel()
							.getValueAt(table.getSelectedRow(), 0)
							.toString()), table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			txtDescricao.setText(tipoQuartoSelecionado.getDescricao());
			isEdited = true;
		}
	}

	@Override
	public void actionButtonBuscar(KeyEvent e) {
		ArrayList<TipoQuarto> novaLista = new ArrayList<>();
		String bus = "";
		for (TipoQuarto tq : listaTipoQuarto) {
			bus = tq.getId() + tq.getDescricao();
			if (bus.contains(txtBuscar.getText())) {
				novaLista.add(tq);
			}
		}
		tTipoQuarto.atualizarTabela(novaLista);
	}

	@Override
	public void setAddMouseListener() {
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				actionMouseClickedOnTable(e);
			}
		});
		
	}

	@Override
	public void verificarTipoQuarto() {
	}

	@Override
	public void setActionListenerBtn() {
	}


}
