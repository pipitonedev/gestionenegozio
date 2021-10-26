package it.prova.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import it.prova.model.Negozio;
import it.prova.service.MyServiceFactory;
import it.prova.utility.UtilityNegozioForm;

public class ExecuteInsertNegozioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertNegozioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ragioneSocialeInputParam = request.getParameter("ragioneSociale");
		String partitaIvaInputParam = request.getParameter("partitaIva");
		String fatturatoInputStringParam = request.getParameter("fatturato");
		String dataAperturaStringParam = request.getParameter("dataApertura");

		Negozio negozioInstance = UtilityNegozioForm.createNegozioFromParams(ragioneSocialeInputParam,
				partitaIvaInputParam, fatturatoInputStringParam, dataAperturaStringParam);

		if (!UtilityNegozioForm.validateNegozioBean(negozioInstance)) {
			request.setAttribute("insert_negozio_attr", negozioInstance);
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("/negozio/insert.jsp").forward(request, response);
			return;
		}
		try {
			MyServiceFactory.getNegozioServiceInstance().inserisciNuovo(negozioInstance);
			request.setAttribute("listaNegoziAttribute", MyServiceFactory.getNegozioServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		// andiamo ai risultati
		request.getRequestDispatcher("/negozio/results.jsp").forward(request, response);

	}

}
