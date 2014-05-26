package tabela;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import FactoryMethod.Dao;

import entidades.Quarto;
import entidades.Reserva;

public class TabelaReserva extends AbstractTableModel {

	private ArrayList<Reserva> reservas;
	private String[] colunas = new String[] {"ID",  "Visitante", "Quarto", "Data Entrada", "Data Saída", "Pagamento", "Status"};

	public TabelaReserva() {
	}

	public TabelaReserva(ArrayList<Reserva> lista) {
		reservas = new ArrayList<>(lista);
	}
	
	@Override
	public int getRowCount() {
		return reservas.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Reserva reserva = reservas.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = reserva.getId();
			break;
		case 1:
			value = reserva.getVisitante();
			break;
		case 2:
			value = reserva.getQuarto();
			break;
		case 3:
			value = reserva.getDtEntrada();
			break;
		case 4:
			value = reserva.getDtSaida();
			break;
		case 5:
			value = reserva.getPagamento();
			break;
		case 6:
			value = reserva.getStatus();
			break;
		}
		return value;
	}
	
	
	public void atualizarTabela(ArrayList<Reserva> r) {
		reservas = r;
		fireTableDataChanged();
	}

	public void atualizarTabela(Reserva r) {
		reservas.add(r);
		fireTableDataChanged();
	}

	public void atualizarTabela() {
		ArrayList<Object> listaObjeto = Dao.select(new Reserva());
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		for (Object o : listaObjeto) {
			Reserva v = (Reserva) o;
			listaReserva.add(v);
		}
		reservas = listaReserva;
		fireTableDataChanged();
	}

}
