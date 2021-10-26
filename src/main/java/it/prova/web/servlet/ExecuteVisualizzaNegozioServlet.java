package it.prova.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.service.MyServiceFactory;

public class ExecuteVisualizzaNegozioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteVisualizzaNegozioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idNegozioParam = request.getParameter("idNegozio");

		if (!NumberUtils.isCreatable(idNegozioParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_negozio_attr", MyServiceFactory.getNegozioServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idNegozioParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/negozio/show.jsp").forward(request, response);
	}

}
