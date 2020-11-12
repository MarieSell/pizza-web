package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.deutscherv.kurse.jee.control.PizzaLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/pizzen")
public class PizzadatenAnzeigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaLager lager;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Pizza> pizzen = lager.getPizzen();

		// Antwort generieren in JSP, kein PrintWriter!

		request.setAttribute("pz", pizzen);
		request.setAttribute("pageTitle", "Anzeige aller Fahrzeuge");
		request.getRequestDispatcher("/displayPizzaLager.jsp").forward(request, response);
	}

}
