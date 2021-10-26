package it.prova.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.service.MyServiceFactory;

import it.prova.model.Negozio;

public class ExecuteRemoveNegozioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteRemoveNegozioServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNegozioParam = request.getParameter("idNegozio");

		if (!NumberUtils.isCreatable(idNegozioParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		Negozio negozioInstance = new Negozio();
		Long idNegozio = Long.parseLong(idNegozioParam);

		try {
			negozioInstance = MyServiceFactory.getNegozioServiceInstance().caricaSingoloElemento(idNegozio);
			MyServiceFactory.getNegozioServiceInstance().rimuovi(negozioInstance);
			request.setAttribute("listaNegoziAttribute", MyServiceFactory.getNegozioServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/negozio/results.jsp").forward(request, response);

	}

}
