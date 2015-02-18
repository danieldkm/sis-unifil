package tarefa2;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class Tabela extends AbstractTableModel {

	private ListaPessoa listaPessoa;
	private String[] colunas = new String[] { "Nome", "Idade" };

	public Tabela(ListaPessoa lista) {
		this.listaPessoa = lista;
	}

	@Override
	public int getRowCount() {
		return listaPessoa.tamanho();
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
		Pessoa p = listaPessoa.pega(rowIndex);
		Object value = null;
		if (p != null) {
			switch (columnIndex) {
			case 0:
				value = p.getNome();
				break;
			case 1:
				value = p.getIdade();
				break;
			default:
				break;
			}
		}
		return value;
	}

	public void atualizarTabela(ListaPessoa lp) {
		listaPessoa = lp;
		fireTableDataChanged();
	}

}
