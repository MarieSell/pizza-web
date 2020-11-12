package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import de.deutscherv.kurse.jee.control.PizzaLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/pizzaAnlegen")
public class PizzadatenAnlegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaLager lager;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hauptzutat = request.getParameter("hauptzutat");
		String durchmesserParam = request.getParameter("durchmesser");

		if (null == hauptzutat || null == durchmesserParam || hauptzutat.isEmpty() || durchmesserParam.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// Konvertierung + Validierung
		int durchmesser;
		try {
			durchmesser = Integer.valueOf(durchmesserParam);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// neue Id finden
		Optional<Integer> max = lager.getPizzen().stream().map(Pizza::getKartennummer).max(Comparator.naturalOrder());
		// Pizza erstellen
		Pizza pizza = new Pizza(max.orElse(0) + 1, hauptzutat, durchmesser);

		// JSR 303 Bean Validation
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Pizza>> violations = validator.validate(pizza);
		if (!violations.isEmpty()) {
			// fachlicher Fehler, kein technischer Fehler
			response.setContentType("text/plain");
			try (PrintWriter out = response.getWriter()) {
				out.println("Objekt ist fehelerhaft, konnte nicht eingefuegt werden.");
				violations.forEach(v -> out.printf(" - %s %s%n", v.getPropertyPath(), v.getMessage()));
			}
		}

		// Anzeige der PizzaDaten
		response.sendRedirect("pizzen");

	}

}
