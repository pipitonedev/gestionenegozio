package it.prova.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.model.Negozio;


public class PreparaInsertNegozioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public PreparaInsertNegozioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("insert_negozio_attr", new Negozio());
		request.getRequestDispatcher("/negozio/insert.jsp").forward(request, response);
	}


}
