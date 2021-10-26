package it.prova.service;

import it.prova.dao.NegozioDAO;
import it.prova.dao.NegozioDAOImpl;

public class MyServiceFactory {

	private static NegozioService NEGOZIO_SERVICE_INSTANCE = null;
	private static NegozioDAO NEGOZIODAO_INSTANCE = null;

	public static NegozioService getNegozioServiceInstance() {
		if (NEGOZIO_SERVICE_INSTANCE == null)
			NEGOZIO_SERVICE_INSTANCE = new NegozioServiceImpl();

		if (NEGOZIODAO_INSTANCE == null)
			NEGOZIODAO_INSTANCE = new NegozioDAOImpl();

		NEGOZIO_SERVICE_INSTANCE.setNegozioDao(NEGOZIODAO_INSTANCE);

		return NEGOZIO_SERVICE_INSTANCE;
	}

}
