package tabela;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import FactoryMethod.Dao;

import entidades.Quarto;
import entidades.Visitante;

public class TabelaVisitante extends AbstractTableModel {

	private ArrayList<Visitante> visitantes;
	private String[] colunas = new String[] { "ID", "Nome", "Telefone",
			"E-mail" };
	
	public TabelaVisitante() {
		// TODO Auto-generated constructor stub
	}

	public TabelaVisitante(ArrayList<Visitante> lista) {
		visitantes = lista;
	}

	@Override
	public int getRowCount() {
		return visitantes.size();
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
		Visitante visitante = visitantes.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = visitante.getId();
			break;
		case 1:
			value = visitante.getNome();
			break;
		case 2:
			value = visitante.getTelefone();
			break;
		case 3:
			value = visitante.getEmail();
			break;
		}
		return value;
	}

	public void atualizarTabela(ArrayList<Visitante> v) {
		visitantes = v;
		fireTableDataChanged();
	}

	public void atualizarTabela(Visitante v) {
		visitantes.add(v);
		fireTableDataChanged();
	}

	public void atualizarTabela() {
		// quartos = new Banco().consultaPessoa();
		ArrayList<Object> listaObjeto = Dao.select(new Quarto());
		ArrayList<Visitante> listaVisitante = new ArrayList<>();
		for (Object o : listaObjeto) {
			Visitante v = (Visitante) o;
			listaVisitante.add(v);
		}
		visitantes = listaVisitante;
		fireTableDataChanged();
	}
}
