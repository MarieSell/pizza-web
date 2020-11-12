package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.deutscherv.kurse.jee.control.PizzaLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/pizzaAnlegen")
public class PizzadatenAnlegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PizzaLager lager;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hauptzutat = request.getParameter("hauptzutat");
		String durchmesserParam = request.getParameter("durchmesser");

		// Konvertierung + Validierung
		int durchmesser = Integer.valueOf(durchmesserParam);

		// neue Id finden
		Optional<Integer> max = lager.getPizzen().stream().map(Pizza::getKartenNummer).max(Comparator.naturalOrder());
		lager.add(new Pizza(max.orElse(0) + 1, hauptzutat, durchmesser));

		// Anzeige der PizzaDaten
		response.sendRedirect("pizzen");

	}

}
