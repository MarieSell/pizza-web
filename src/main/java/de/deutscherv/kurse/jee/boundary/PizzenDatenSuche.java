package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.deutscherv.kurse.jee.control.PizzaLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/pizzaSuche")
public class PizzenDatenSuche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PizzaLager lager;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String suchtext = request.getParameter("suchtext");
		// Validierung?
		if (null == suchtext) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter suchtext must not be null!");
		} else {
			Collection<Pizza> pizzen = lager.getPizzen();
			Collection<Pizza> suchErgebnisse = pizzen.stream()
					.filter(pz -> pz.getName().toLowerCase().contains(suchtext.toLowerCase()))
					.collect(Collectors.toList());
			
			// Antwort generieren in JSP, kein PrintWriter!
			request.setAttribute("pz", suchErgebnisse);
			request.setAttribute("pageTitle", "Suchergebnisse fuer '" + suchtext + "'");
			request.getRequestDispatcher("displayPizzaLager.jsp").forward(request, response);
		}

	}

}
