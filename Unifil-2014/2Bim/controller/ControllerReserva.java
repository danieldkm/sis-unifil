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

import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import tabela.TabelaReserva;
import FactoryMethod.Dao;
import entidades.Quarto;
import entidades.Reserva;

public class ControllerReserva extends Controller implements Telas {

	private ArrayList<Reserva> listaReserva;
	private TabelaReserva tReserva;
	private Reserva reservaSelecionado;
	
	protected JDialog frame;
	protected JTextField txtPagamento;
	protected JComboBox comboBox;
	protected JDatePickerImpl datePicker;
	protected JDatePickerImpl datePicker2;

	protected ArrayList<Reserva> getListaReserva() {
		ArrayList<Object> listaObjeto = Dao.select(new Reserva());
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		for (Object o : listaObjeto) {
			Reserva r = (Reserva) o;
			listaReserva.add(r);
		}
		return listaReserva;
	}

	protected JScrollPane getTable() {
		listaReserva = getListaReserva();
		tReserva = new TabelaReserva(listaReserva);
		table = new JTable(tReserva);
		return new JScrollPane(table);
	}

	@Override
	public boolean validarCampos() {
		if (txtVisitante.getText().equals("")
				|| txtVisitante.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo Visitante não foi preenchido");
			return true;
		} else if (txtQuarto.getText().equals("")
				|| txtQuarto.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo Quarto não foi preenchido");
			return true;
		} else if (datePicker.getModel().getValue() == null) {
			JOptionPane.showMessageDialog(frame,
					"Campo data de entrada não foi preenchido");
			return true;
		} else if (datePicker2.getModel().getValue() == null) {
			JOptionPane.showMessageDialog(frame,
					"Campo data de saída não foi preenchido");
			return true;
		} else if (txtPagamento.getText().equals("")
				|| txtPagamento.getText().equals(null)) {
			JOptionPane.showMessageDialog(frame,
					"Campo Pagamento não foi preenchido");
			return true;
		}
		try {
			String aux = "";
			if(txtPagamento.getText().contains(",")){
				aux = txtPagamento.getText().replace(",", ".");
				double n = Double.parseDouble(aux);
			}else if(txtPagamento.getText().contains(".")){
				double n = Double.parseDouble(txtPagamento.getText());	
			} else {
				int n = Integer.parseInt(txtPagamento.getText());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
					"Campo Pagamento deve ser número para ser cadastrado");
			return true;
		}
		return false;
	}

	@Override
	public void salvar(ActionEvent arg0) {
		if (!validarCampos()) {
			if (isEdited) {
				reservaSelecionado.setVisitante(txtVisitante.getText());
				reservaSelecionado.setQuarto(txtQuarto.getText());
				java.util.Date d = (java.util.Date) datePicker
						.getModel().getValue();
				java.sql.Date dataSql = new java.sql.Date(d.getTime());
				java.util.Date d2 = (java.util.Date) datePicker2
						.getModel().getValue();
				java.sql.Date dataSql2 = new java.sql.Date(d2.getTime());
				reservaSelecionado.setDtEntrada(dataSql);
				reservaSelecionado.setDtSaida(dataSql2);
				reservaSelecionado.setPagamento(txtPagamento.getText());
				reservaSelecionado.setStatus(comboBox.getSelectedItem()
						.toString());
				Dao.update(reservaSelecionado);
				reservaSelecionado = null;
				JOptionPane.showMessageDialog(frame,
						"Atualizado com sucesso!");
				isEdited = false;
				frame.dispose();
			} else {
				java.util.Date d = (java.util.Date) datePicker
						.getModel().getValue();
				java.sql.Date dataSql = new java.sql.Date(d.getTime());
				java.util.Date d2 = (java.util.Date) datePicker2
						.getModel().getValue();
				java.sql.Date dataSql2 = new java.sql.Date(d2.getTime());
				Reserva r = new Reserva(txtVisitante.getText(),
						txtQuarto.getText(), dataSql, dataSql2,
						txtPagamento.getText(), comboBox
								.getSelectedItem().toString());
				Dao.insert(r);
				JOptionPane.showMessageDialog(frame,
						"Cadastrado com sucesso!");
				frame.dispose();
				System.out.println("Salvo com sucesso");
			}
		}
	}

	@Override
	public void excluir(ActionEvent e) {
		if (isEdited) {
			int r = JOptionPane.showConfirmDialog(frame,
					"Tem certeza que deseja EXCLUIR!");
			if (r == 0) {
				Dao.delete(reservaSelecionado);
				frame.dispose();
			}
		} else {
			JOptionPane.showMessageDialog(frame,
					"Reserva não foi selecionado para ser excluído");
		}
	}

	@Override
	public void limpar(ActionEvent e) {
		isEdited = false;
		reservaSelecionado = null;
		txtPagamento.setText(null);
		txtVisitante.setText(null);
		txtQuarto.setText(null);
		datePicker.getModel().setValue(null);
		datePicker2.getModel().setValue(null);
	}

	@Override
	public void actionMouseClickedOnTable(MouseEvent e) {
		if (e.getClickCount() == 2) {
			// System.out.println("selecionada "
			// + table.getModel().getValueAt(
			// table.getSelectedRow(), 0));
			// ------------------------------------------------------------------------------
			// Setando data
			String dt1 = table.getModel()
					.getValueAt(table.getSelectedRow(), 3).toString();
			String dt2 = table.getModel()
					.getValueAt(table.getSelectedRow(), 4).toString();

			String a1[] = dt1.split("-");
			String a2[] = dt2.split("-");

			datePicker.getModel().setDay(Integer.parseInt(a1[0]));
			datePicker.getModel().setMonth(Integer.parseInt(a1[1]) - 1);
			datePicker.getModel().setYear(Integer.parseInt(a1[2]));
			datePicker.getModel().setSelected(true);

			datePicker2.getModel().setDay(Integer.parseInt(a2[0]));
			datePicker2.getModel()
					.setMonth(Integer.parseInt(a2[1]) - 1);
			datePicker2.getModel().setYear(Integer.parseInt(a2[2]));
			datePicker2.getModel().setSelected(true);

			java.util.Date d1 = (java.util.Date) datePicker.getModel()
					.getValue();
			java.sql.Date dataSql1 = new java.sql.Date(d1.getTime());

			java.util.Date d2 = (java.util.Date) datePicker2.getModel()
					.getValue();
			java.sql.Date dataSql2 = new java.sql.Date(d2.getTime());
			// ------------------------------------------------------------------------------Setando
			reservaSelecionado = new Reserva(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString(),
					table.getModel()
							.getValueAt(table.getSelectedRow(), 2)
							.toString(), dataSql1, dataSql2, table
							.getModel()
							.getValueAt(table.getSelectedRow(), 5)
							.toString(), table.getModel()
							.getValueAt(table.getSelectedRow(), 6)
							.toString());
			reservaSelecionado.setId(Integer.parseInt(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString()));
			txtVisitante.setText(reservaSelecionado.getVisitante());
			txtQuarto.setText(reservaSelecionado.getQuarto());
			txtPagamento.setText(reservaSelecionado.getPagamento());
			for (int i = 0; i < 3; i++) {
				if (comboBox.getSelectedItem().equals(
						reservaSelecionado.getStatus())) {

				} else {
					comboBox.setSelectedIndex(i);
				}
			}
			isEdited = true;
		}
	}

	@Override
	public void actionButtonBuscar(KeyEvent e) {
		ArrayList<Reserva> novaLista = new ArrayList<>();
		String bus = "";
		for (Reserva r : listaReserva) {
			bus = r.getId() + r.getVisitante() + r.getQuarto() + r.getDtEntrada() + r.getDtSaida() + r.getPagamento() + r.getStatus();
			if (bus.contains(txtBuscar.getText())) {
				novaLista.add(r);
			}
		}
		tReserva.atualizarTabela(novaLista);

	}

}
