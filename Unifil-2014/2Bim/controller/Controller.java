package controller;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import FactoryMethod.Dao;
import entidades.Quarto;
import entidades.Reserva;
import entidades.TipoQuarto;
import entidades.Visitante;

public abstract class Controller {

	protected boolean isEdited = false;
	protected boolean isConsulta = false;
	protected JTable table;
	
	// campos da tela Visitante
	protected static JTextField txtVisitante;
	// campos da tela Quarto
	protected static JTextField txtQuarto;
	
	protected JTextField txtBuscar;


//	protected JScrollPane getTable() {
//		return new JScrollPane(table);
//	}
	public ArrayList<Quarto> getListaQuarto() {
		ArrayList<Object> listaObjeto = Dao.select(new Quarto());
		ArrayList<Quarto> listaQuarto = new ArrayList<>();
		for (Object o : listaObjeto) {
			Quarto q = (Quarto) o;
			listaQuarto.add(q);
		}
		return listaQuarto;
	}
	
	protected ArrayList<Reserva> getListaReserva() {
		ArrayList<Object> listaObjeto = Dao.select(new Reserva());
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		for (Object o : listaObjeto) {
			Reserva r = (Reserva) o;
			listaReserva.add(r);
		}
		return listaReserva;
	}
	
	
	protected ArrayList<TipoQuarto> getListaTipoQuarto() {
		ArrayList<Object> listaObjeto = Dao.select(new TipoQuarto());
		ArrayList<TipoQuarto> listaTipoQuarto = new ArrayList<>();
		for (Object o : listaObjeto) {
			TipoQuarto tq = (TipoQuarto) o;
			listaTipoQuarto.add(tq);
		}
		return listaTipoQuarto;
	}
	
	protected ArrayList<Visitante> getListaVisitante() {
		ArrayList<Object> listaObjeto = Dao.select(new Visitante());
		ArrayList<Visitante> listaVisitante = new ArrayList<>();
		for (Object o : listaObjeto) {
			Visitante v = (Visitante) o;
			listaVisitante.add(v);
		}
		return listaVisitante;
	}

}
