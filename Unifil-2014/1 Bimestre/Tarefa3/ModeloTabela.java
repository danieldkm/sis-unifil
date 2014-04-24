package Tarefa3;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {

	private ArrayList<Pessoa> pessoas;
	private String[] colunas = new String[] { "ID", "Nome", "Email", "Codigo", "CPF",
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
		return 6;
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
			value = pessoa.getId();
			break;
		case 1:
			value = pessoa.getNome();
			break;
		case 2:
			value = pessoa.getEmail();
			break;
		case 3:
			value = pessoa.getCodigo();
			break;
		case 4:
			value = pessoa.getCpf();
			break;
		case 5:
			value = pessoa.getData();
			break;
		}
		return value;
	}
	
//	 @Override  
//	    public void setValueAt(Object valor, int linha, int coluna) {  
//	        // aqui devemos atualizar o valor de nossos Clientes  
//	        // vemos em qual linha ele está  
//	        Pessoa p = pessoas.get(linha);  
//	        // e vemos o que será atualizado  
//	        switch (coluna) {  
//	        case 0:  
//	            p.setNome(valor.toString());  
//	            break;  
//	        case 1:  
//	            p.setEmail(valor.toString());   
//	            break;  
//	        case 2:  
//	            p.setCodigo(valor.toString()); 
//	            break;
//	        case 3:  
//	            p.setCpf(valor.toString());   
//	            break;  
//	        case 4:  
//	            p.setData(valor.toString());   
//	            break;  
//	        }  
//	        fireTableDataChanged();  
//	    }
	 
	 public void atualizarTabela(Pessoa ps){
		 pessoas.add(ps);
		 fireTableDataChanged();
	 }
	 
	 public void atualizarTabela(){
		 pessoas = new Banco().consultaPessoa();
		 fireTableDataChanged();
	 }

}
