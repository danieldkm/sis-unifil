import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	private ArrayList<Pessoa> pessoas;
	private String[] colunas = new String[] { "Nome", "Email", "Codigo", "CPF",
			"Data Nascimento" };

	public ModeloTabela(ArrayList<Pessoa> pessoas) {
		this.pessoas = new ArrayList<>(pessoas);
	}

	@Override
	public int getRowCount() {
		return this.pessoas.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return colunas[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Pessoa pessoa = pessoas.get(rowIndex);
		Object value = null;
		switch (columnIndex) {
		case 0:
			value = pessoa.getNome();
			break;
		case 1:
			value = pessoa.getEmail();
			break;
		case 2:
			value = pessoa.getCodigo();
			break;
		case 3:
			value = pessoa.getCpf();
			break;
		case 4:
			value = pessoa.getData();
			break;
		}
		return value;
	}

	// @Override
	// public Class<?> getColumnClass(int rowIndex, int columnIndex) {
	// Class type = String.class;
	// switch (columnIndex) {
	// case 0:
	//
	// break;
	//
	// default:
	// break;
	// }
	// }
	// @Override
	// public Object getValueAt(int rowIndex, int columnIndex) {
	// Click click = clicks.get(rowIndex);
	// Object value = null;
	// switch (columnIndex) {
	// case 0:
	// value = click.getX();
	// break;
	// case 1:
	// value = click.getY();
	// break;
	// }
	// return value;
	// }
	// }
}
