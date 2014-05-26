package controller;

import java.util.ArrayList;

import FactoryMethod.Dao;
import entidades.Quarto;
import entidades.TipoQuarto;
import entidades.Visitante;

public class Controller {
	
	protected boolean isEdited = false;

	protected ArrayList<Quarto> getListaQuarto() {
		ArrayList<Object> listaObjeto = Dao.select(new Quarto());
		ArrayList<Quarto> listaQuarto = new ArrayList<>();
		for (Object o : listaObjeto) {
			Quarto q = (Quarto) o;
			listaQuarto.add(q);
		}
		return listaQuarto;
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
