package controller;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public abstract class Controller {

	protected boolean isEdited = false;
	protected boolean isConsulta = false;
	protected JTable table;
	
	// campos da tela Visitante
	protected static JTextField txtVisitante;
	// campos da tela Quarto
	protected static JTextField txtQuarto;
	
	protected JTextField txtBuscar;


	protected JScrollPane getTable() {
		return new JScrollPane(table);
	}
	
	

}
