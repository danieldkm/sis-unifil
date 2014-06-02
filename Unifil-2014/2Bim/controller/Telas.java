package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public interface Telas {

	boolean validarCampos();
	void salvar(ActionEvent arg0);
	void excluir(ActionEvent e);
	void limpar(ActionEvent e);
	void actionMouseClickedOnTable(MouseEvent e);
	void actionButtonBuscar(KeyEvent e);
	JScrollPane getTable();
	void setAddMouseListener();
	void verificarTipoQuarto();
	void setActionListenerBtn();
	
}
