package tabela;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import model.entity.Cliente;

/**
 * A interface {@link TableModel} define 9 métodos, sendo que 2 deles cuidam da
 * parte de listeners. Esses dois métodos (addTableModelListener e
 * removeTableModelListener) nós delegaremos para a classe
 * {@link AbstractTableModel}. Os outros 7 nós implementaremos. Uma pequena
 * explicação de cada um deles (para mais detalhes, consulte a documentação):<br>
 * <ul>
 * <li>getColumnClass: retorna a classe de determinada coluna. Útil para os
 * renderers saberem como exibir determinada informação.</li>
 * <li>getColumnCount: retorna o número de colunas que nossa tabela terá
 * (geralmente é o número de atributos do objeto que será exibido).</li>
 * <li>getColumnName: retorna o nome da coluna. Será usado no cabeçalho da
 * tabela.</li>
 * <li>getRowCount: retorna o número de registros. Geralmente é a quantidade de
 * elementos que há em nossa lista.</li>
 * <li>getValueAt: retorna o valor que está contido em determinada célula. Para
 * resgatarmos esse valor, primeiro pegamos o objeto da linha e depois, a partir
 * do número da coluna, retornamos uma de suas propriedades.</li>
 * <li>isCellEditable: informa se determinada célula pode ser editada ou não.</li>
 * <li>setValueAt: é chamado quanto o valor de determinada célula é alterada.
 * Devemos modificar nosso objeto para refletir essa mudança.</li>
 * </ul>
 */
public class ClienteTabela extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private ArrayList linhas = null;
	private String[] colunas = null;

	public String[] getColunas() {
		return colunas;
	}

	public ArrayList getLinhas() {
		return linhas;
	}

	public void setColunas(String[] strings) {
		colunas = strings;
	}

	public void setLinhas(ArrayList list) {
		linhas = list;
	}

	/**
	 * Essa lista armazenará os objetos do tipo {@link Cliente} atualmente
	 * exibidos na tablela.
	 */
	private List<Cliente> clientes;

	// ==============================================================
	// Construtores.
	// ==============================================================

	/**
	 * Constutor que simplesmente instancia o nosso {@link List} que usaremos
	 * para guardar os valores.
	 */
	public ClienteTabela() {
		// no construtor, instanciamos o List
		clientes = new ArrayList<Cliente>();
	}

	/**
	 * Criamos um construtor de conveniência para já popular a lista.
	 * 
	 * @param lista
	 *            a lista de clientes a ser adicionada.
	 */
	public ClienteTabela(List<Cliente> lista) {
		this();
		clientes.addAll(lista);
	}

	public ClienteTabela(ArrayList dados, String[] colunas) {
		setLinhas(dados);
		setColunas(colunas);
	}

	// ==============================================================
	// Métodos implementados.
	// ==============================================================

	@Override
	public Class<?> getColumnClass(int coluna) {
		// todas as colunas representam uma String
		return String.class;
	}

	// retorno o números de colunas
	@Override
	public int getColumnCount() {
		return 17;
	}

	// public void setAddRows(){
	// fireTableRowsInserted(0, 20);
	// }

	@Override
	public String getColumnName(int coluna) {
		// vamos retornar o nome de cada coluna
		switch (coluna) {
		case 0:
			return "ID";
		case 1:
			return "Data de Cadastro";
		case 2:
			return "Data da Última Alteração";
		case 3:
			return "Nome";
		case 4:
			return "Data de Nascimento";
		case 5:
			return "CPF";
		case 6:
			return "RG";
		case 7:
			return "Endereço";
		case 8:
			return "Bairro";
		case 9:
			return "Cidade";
		case 10:
			return "Estado";
		case 11:
			return "CEP";
		case 12:
			return "Telefone";
		case 13:
			return "Celular";
		case 14:
			return "Sexo";
		case 15:
			return "Naturalidade";
		case 16:
			return "Est. Civil";
		default:
			return "";
		}
	}

	@Override
	public int getRowCount() {
		// retorna o número de linhas, ou seja, a quantidade de entradas na
		// nossa lista.
		return clientes.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// vai retornar o valor de determinada célula. A linha representa a
		// posição do Cliente na nossa lista e a coluna vai ser: 1 - id, 2 -
		// data de cadastro e 3 - nome
		// primeiro vamos pegar o Cliente da linha
		Cliente c = clientes.get(linha);
		// façamos um switch
		switch (coluna) {
		case 0:
			return c.getId();
		case 1:
			return c.getDataCadastro();
		case 2:
			return c.getDataUltimaAlteracao();
		case 3:
			return c.getNome();
		case 4:
			return c.getDataNascimento();
		case 5:
			return c.getCpf();
		case 6:
			return c.getRg();
		case 7:
			return c.getEndereco();
		case 8:
			return c.getBairro();
		case 9:
			return c.getCidade();
		case 10:
			return c.getEstado();
		case 11:
			return c.getCep();
		case 12:
			return c.getTelefone();
		case 13:
			return c.getCelular();
		case 14:
			return c.getSexo();
		case 15:
			return c.getNaturalidade();
		case 16:
			return c.getEstadoCivil();
		default:
			return null;
		}
	}

	public Cliente cliente(int linha) {
		Cliente c = clientes.get(linha);
		return c;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// nesse caso, quase todas as células são editáveis (true)
		switch (columnIndex) {
		case 0:
			return false;
		case 1:
			return false;
		case 2:
			return false;
		case 3:
			return true;
		case 4:
			return true;
		case 5:
			return true;
		case 6:
			return true;
		case 7:
			return true;
		case 8:
			return true;
		case 9:
			return true;
		case 10:
			return true;
		case 11:
			return true;
		case 12:
			return true;
		case 13:
			return true;
		case 14:
			return true;
		case 15:
			return true;
		case 16:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		// aqui devemos atualizar o valor de nossos Clientes
		// vemos em qual linha ele está
		Cliente c = clientes.get(linha);
		// e vemos o que será atualizado
		switch (coluna) {
		case 0:
			// c.setNome(valor.toString());
			break;
		case 1:
			// c.setDa(valor.toString());
			break;
		case 2:
			// c.setDa(valor.toString());
			break;
		case 3:
			c.setNome(valor.toString());
			break;
		case 4:
			c.setDataNascimento(valor.toString());
			break;
		case 5:
			c.setCpf(valor.toString());
			break;
		case 6:
			c.setRg(valor.toString());
			break;
		case 7:
			c.setEndereco(valor.toString());
			break;
		case 8:
			c.setBairro(valor.toString());
			break;
		case 9:
			c.setCidade(valor.toString());
			break;
		case 10:
			c.setEstado(valor.toString());
			break;
		case 11:
			c.setCep(valor.toString());
			break;
		case 12:
			c.setTelefone(valor.toString());
			break;
		case 13:
			c.setCelular(valor.toString());
			break;
		case 14:
			c.setSexo(valor.toString());
			break;
		case 15:
			c.setNaturalidade(valor.toString());
			break;
		case 16:
			c.setEstadoCivil(valor.toString());
			break;
		}

		// é importante notificar os listeners a cada alteração
		// fireTableDataChanged();
		// agora mostra as celular que foram alteradas, linha e coluna.
		fireTableCellUpdated(linha, coluna);
	}
	
	// ==============================================================
	// Até aqui seria o mínimo necessário para um TableModel funcional, mas
	// ainda não há métodos para adicionar, remover ou resgatar objetos. Vamos
	// criá-los.
	// ==============================================================

	/**
	 * Adiciona um novo {@link Cliente} e notifica os listeners que um novo
	 * registro foi adicionado.
	 */
	public void adiciona(Cliente c) {
		clientes.add(c);
		// informamos os listeners que a linha (size - 1) foi adicionada
		fireTableRowsInserted(clientes.size() - 1, clientes.size() - 1);
	}

	/**
	 * Similar ao {@link #adiciona(Cliente)}, porém para remover. Recebe o
	 * índice do cliente a ser removido. Se não souber o índice, use o método
	 * {@link #getIndice(Cliente)} antes.
	 */
	public void remove(int indice) {
		clientes.remove(indice);
		fireTableRowsDeleted(indice, indice);
	}

	/**
	 * Retorna o índice de determinado cliente.
	 */
	public int getIndice(Cliente c) {
		return clientes.indexOf(c);
	}

	/**
	 * Adiciona todos os clientes na lista à este modelo.
	 */
	public void adicionaLista(List<Cliente> lista) {
		int i = clientes.size();
		if (lista.size() == i) {

		} else {
			clientes.addAll(lista);
			fireTableRowsInserted(i, i + lista.size());
		}
	}

	/**
	 * Esvazia a lista.
	 */
	public void limpaLista() {
		int i = clientes.size();
		clientes.clear();
		fireTableRowsDeleted(0, i - 1);
	}

	public boolean buscaNome(String nome) {
		return clientes.contains(nome);
	}

	public void inserir(Cliente c) {
		clientes.add(c);
		fireTableDataChanged();
	}
	
	// Pega valores da JTABLE
	public int PegaRegistro(JTable jTable) {

		// variavel q guarda o valor do código p/ retorno
		int codigo = 0;
		/*
		 * Captura o numero da linha selecionada na tabela e coloca o valor na
		 * variavel linha. Se nenhuma linha for selecionada o valor da variavel
		 * linha será = -1
		 */

		int linha = jTable.getSelectedRow();

		/*
		 * Verificar se alguma linha da tabela esta selecionada, caso não esteja
		 * selecionado o valor da váriavel será menor que zero, e o IF abaixo
		 * será executado.
		 */
		if (linha < 0) {
			JOptionPane.showMessageDialog(null, "Selecione algum registro");
		} else {

			// cria uma variavel do tipo object que recebe o valor do codigo da
			// linha lecionada e coluna 1 <
			Object cod = jTable.getValueAt(linha, 1);

			// Caso seja selecionado uma linha da tabela que não contem dados o
			// IF abaixo sera executado.
			if (cod == null) {
				JOptionPane.showMessageDialog(null,
						"A linha selecionado não contem dados");
			} else {

				/*
				 * Caso os if acima não seja executado, é porque a tabela esta
				 * selecionada e a linha selecionada contem dados, então sera
				 * executado o else, que pega os dados da linha selecionada de
				 * cada coluna e coloca nos campos de textos
				 */
				codigo = Integer.parseInt(String.valueOf(jTable.getValueAt(
						linha, 0)));
			}

		}

		// Retorna o valor que esta na celula selecionada
		return codigo;

	}
}
