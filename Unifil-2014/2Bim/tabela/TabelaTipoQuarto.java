package tabela;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import FactoryMethod.Dao;

import entidades.Quarto;
import entidades.TipoQuarto;

public class TabelaTipoQuarto extends AbstractTableModel {

	private ArrayList<TipoQuarto> tipoQuartos;
	private String[] colunas = new String[] { "ID", "Descricao" };

	public TabelaTipoQuarto() {
	}

	public TabelaTipoQuarto(ArrayList<TipoQuarto> lista) {
		tipoQuartos = new ArrayList<>(lista);
	}

	@Override
	public int getRowCount() {
		return tipoQuartos.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TipoQuarto tipoQuarto = tipoQuartos.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = tipoQuarto.getId();
			break;
		case 1:
			value = tipoQuarto.getDescricao();
			break;
		}
		return value;
	}

	public void atualizarTabela(ArrayList<TipoQuarto> tq) {
		tipoQuartos = tq;
		fireTableDataChanged();
	}

	public void atualizarTabela(TipoQuarto tq) {
		tipoQuartos.add(tq);
		fireTableDataChanged();
	}

	public void atualizarTabela() {
		// quartos = new Banco().consultaPessoa();
		ArrayList<Object> listaObjeto = Dao.select(new TipoQuarto());
		ArrayList<TipoQuarto> listaQuarto = new ArrayList<>();
		for (Object o : listaObjeto) {
			TipoQuarto tq = (TipoQuarto) o;
			listaQuarto.add(tq);
		}
		tipoQuartos = listaQuarto;
		fireTableDataChanged();
	}

}
