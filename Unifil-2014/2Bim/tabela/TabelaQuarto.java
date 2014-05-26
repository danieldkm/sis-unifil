package tabela;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import FactoryMethod.Dao;
import Tarefa3.Banco;
import Tarefa3.Pessoa;

import entidades.Quarto;

public class TabelaQuarto extends AbstractTableModel {

	private ArrayList<Quarto> quartos;
	private String[] colunas = new String[] {"ID",  "Descricao", "Tipo", "Capacidade"};

	public TabelaQuarto() {
	}

	public TabelaQuarto(ArrayList<Quarto> lista) {
		quartos = new ArrayList<>(lista);
	}

	@Override
	public int getRowCount() {
		return quartos.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Quarto quarto = quartos.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = quarto.getId();
			break;
		case 1:
			value = quarto.getDescricao();
			break;
		case 2:
			value = quarto.getTipo();
			break;
		case 3:
			value = quarto.getCapacidade();
			break;
		}
		return value;
	}
	
	public void atualizarTabela(ArrayList<Quarto> ps) {
		quartos = ps;
		fireTableDataChanged();
	}

	public void atualizarTabela(Quarto ps) {
		quartos.add(ps);
		fireTableDataChanged();
	}

	public void atualizarTabela() {
		// quartos = new Banco().consultaPessoa();
		ArrayList<Object> listaObjeto = Dao.select(new Quarto());
		ArrayList<Quarto> listaQuarto = new ArrayList<>();
		for (Object o : listaObjeto) {
			Quarto q = (Quarto) o;
			listaQuarto.add(q);
		}
		quartos = listaQuarto;
		fireTableDataChanged();
	}

}
