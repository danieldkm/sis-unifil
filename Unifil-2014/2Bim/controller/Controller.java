package controller;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import tabela.TabelaQuarto;
import tabela.TabelaReserva;
import tabela.TabelaVisitante;
import FactoryMethod.Dao;
import entidades.Quarto;
import entidades.Reserva;
import entidades.TipoQuarto;
import entidades.Visitante;

public class Controller {

	protected boolean isEdited = false;
	protected JTable table;

	protected ArrayList<Quarto> listaQuarto;
	protected TabelaQuarto tQuarto;
	protected Quarto quartoSelecionado;

	protected ArrayList<Visitante> listaVisitante;
	protected TabelaVisitante tVisitante;
	protected Visitante visitanteSelecionado;

	protected ArrayList<Reserva> listaReserva;
	protected TabelaReserva tReserva;
	protected Reserva reservaSelecionado;

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

	protected ArrayList<Reserva> getListaReserva() {
		ArrayList<Object> listaObjeto = Dao.select(new Reserva());
		ArrayList<Reserva> listaReserva = new ArrayList<>();
		for (Object o : listaObjeto) {
			Reserva r = (Reserva) o;
			listaReserva.add(r);
		}
		return listaReserva;
	}

	protected JScrollPane getTable(String tela) {
		if (tela.equals("quarto")) {
			listaQuarto = getListaQuarto();
			tQuarto = new TabelaQuarto(listaQuarto);
			table = new JTable(tQuarto);
		} else if (tela.equals("visitante")) {
			listaVisitante = getListaVisitante();
			tVisitante = new TabelaVisitante(listaVisitante);
			table = new JTable(tVisitante);
		} else if (tela.equals("reserva")) {
			listaReserva = getListaReserva();
			tReserva = new TabelaReserva(listaReserva);
			table = new JTable(tReserva);
		}
		return new JScrollPane(table);
	}

}
