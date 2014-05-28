package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import tabela.TabelaQuarto;
import view.TelaCadastroTipoQuarto;
import FactoryMethod.Dao;
import entidades.Quarto;
import entidades.TipoQuarto;

public class ControllerQuarto extends ControllerTipoQuarto implements Telas {

	private ArrayList<Quarto> listaQuarto;
	private TabelaQuarto tQuarto;
	private Quarto quartoSelecionado;

	protected JDialog frmQuarto;
	protected JTextField txtDescricao;
	protected JTextField txtCapacidade;
	protected ArrayList<TipoQuarto> listaTipoQuarto = new ArrayList<>();
	protected JComboBox cbTipo;

	protected ArrayList<Quarto> getListaQuarto() {
		ArrayList<Object> listaObjeto = Dao.select(new Quarto());
		ArrayList<Quarto> listaQuarto = new ArrayList<>();
		for (Object o : listaObjeto) {
			Quarto q = (Quarto) o;
			listaQuarto.add(q);
		}
		return listaQuarto;
	}

	protected JScrollPane getTable() {
		listaQuarto = getListaQuarto();
		tQuarto = new TabelaQuarto(listaQuarto);
		table = new JTable(tQuarto);
		return new JScrollPane(table);
	}

	@Override
	public boolean validarCampos() {
		if (txtDescricao.getText().equals(null)
				|| txtDescricao.getText().equals("")) {
			JOptionPane.showMessageDialog(frmQuarto,
					"Campo DESCRIÇÃO não foi preenchido");
			return true;
		} else if (txtCapacidade.getText().equals("")
				|| txtCapacidade.getText().equals(null)) {
			JOptionPane.showMessageDialog(frmQuarto,
					"Campo CAPACIDADE não foi preenchido");
			return true;
		}

		try {
			int n = Integer.parseInt(txtCapacidade.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmQuarto,
					"Campo CAPACIDADE deve ser um número");
			return true;
		}
		return false;
	}

	@Override
	public void salvar(ActionEvent arg0) {
		try {
			if (!validarCampos()) {
				if (isEdited) {
					quartoSelecionado.setDescricao(txtDescricao.getText());
					quartoSelecionado.setTipo(cbTipo.getSelectedItem()
							.toString());
					quartoSelecionado.setCapacidade(Integer
							.parseInt(txtCapacidade.getText()));
					Dao.update(quartoSelecionado);
					quartoSelecionado = null;
					JOptionPane.showMessageDialog(frmQuarto,
							"Atualizado com sucesso!");
					isEdited = false;
					frmQuarto.dispose();
				} else {
					Quarto q = new Quarto(txtDescricao.getText(), cbTipo
							.getSelectedItem().toString(),
							Integer.parseInt(txtCapacidade.getText()));
					Dao.insert(q);
					JOptionPane.showMessageDialog(frmQuarto,
							"Cadastrado com sucesso!");
					frmQuarto.dispose();
					System.out.println("Salvo com sucesso");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao salvar");
		}

	}

	@Override
	public void excluir(ActionEvent e) {
		if (isEdited) {
			int r = JOptionPane.showConfirmDialog(frmQuarto,
					"Tem certeza que deseja EXCLUIR!\nO quarto a ser excluido: "
							+ txtDescricao.getText());
			if (r == 0) {
				Dao.delete(quartoSelecionado);
				frmQuarto.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(frmQuarto,
					"Quarto não foi selecionado para ser excluído");
		}
	}

	@Override
	public void limpar(ActionEvent e) {
		isEdited = false;
		quartoSelecionado = null;
		txtCapacidade.setText(null);
		txtDescricao.setText(null);
		cbTipo.setSelectedIndex(0);
	}

	@Override
	public void actionButtonBuscar(KeyEvent e) {
		ArrayList<Quarto> novaLista = new ArrayList<>();
		String bus = "";
		for (Quarto q : listaQuarto) {
			bus = q.getId() + q.getDescricao() + q.getTipo()
					+ q.getCapacidade();
			if (bus.contains(txtBuscar.getText())) {
				novaLista.add(q);
			}
		}
		tQuarto.atualizarTabela(novaLista);
	}

	@Override
	public void actionMouseClickedOnTable(MouseEvent e) {
		if (e.getClickCount() == 2) {
			System.out.println("selecionada "
					+ table.getModel().getValueAt(table.getSelectedRow(), 0));
			quartoSelecionado = new Quarto(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString(), table
					.getModel().getValueAt(table.getSelectedRow(), 2)
					.toString(), Integer.parseInt(table.getModel()
					.getValueAt(table.getSelectedRow(), 3).toString()));
			quartoSelecionado.setId(Integer.parseInt(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString()));
			if (isConsulta) {
				txtQuarto.setText(quartoSelecionado.getDescricao());
				frmQuarto.dispose();
				isConsulta = false;
				JOptionPane.showMessageDialog(null, "Quarto selecionado: " + quartoSelecionado.getDescricao());
			} else {
				txtDescricao.setText(quartoSelecionado.getDescricao());
				txtCapacidade.setText(quartoSelecionado.getCapacidade() + "");
				cbTipo.setSelectedItem(quartoSelecionado.getTipo());
			}
			isEdited = true;
		}
	}

	protected void verificarTipoQuarto() {
		listaTipoQuarto = getListaTipoQuarto();
		if (listaTipoQuarto.isEmpty()) {
			System.out.println("Lista de quarto está vazia");
			int r = JOptionPane
					.showConfirmDialog(
							frmQuarto,
							"Para cadastrar um quarto, deve antes cadastrar pelo menos 1 tipo de Quarto!\nDeseja cadastrar agora?");
			switch (r) {
			case 0:
				System.out.println("0");
				new TelaCadastroTipoQuarto();
				break;
			}
		} else {
			for (TipoQuarto tipoQuarto : listaTipoQuarto) {
				cbTipo.addItem(tipoQuarto.getDescricao());
			}
			// listaTipoQuarto.add(new TipoQuarto(1,"teste"));
			// cbTipo.addItem(listaTipoQuarto.get(0).getDescricao());
			frmQuarto.setResizable(false);
			frmQuarto.setModal(true);
			frmQuarto.setVisible(true);
		}
	}
}
