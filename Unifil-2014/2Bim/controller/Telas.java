package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

interface Telas {

	boolean validarCampos();
	void salvar(ActionEvent arg0);
	void excluir(ActionEvent e);
	void limpar(ActionEvent e);
	void actionMouseClickedOnTable(MouseEvent e);
	void actionButtonBuscar(KeyEvent e);
}
