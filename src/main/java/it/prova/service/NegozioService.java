package it.prova.service;

import java.util.List;

import it.prova.dao.NegozioDAO;
import it.prova.model.Negozio;


public interface NegozioService {
	
	public List<Negozio> listAll() throws Exception;

	public Negozio caricaSingoloElemento(Long idInput) throws Exception;

	public void aggiorna(Negozio input) throws Exception;

	public void inserisciNuovo(Negozio input) throws Exception;

	public void rimuovi(Negozio input) throws Exception;
	
	public void setNegozioDao(NegozioDAO negozioDao);

}
