package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.deutscherv.kurse.jee.control.PizzenLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/PizzenDatenSuche")
public class PizzenDatenSuche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String suchtext = request.getParameter("suchtext");
		// Validierung?
		if (null == suchtext) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter suchtext must not be null!");
		} else {
			Collection<Pizza> pizzen = PizzenLager.getInstance().getPizzen();
			Collection<Pizza> suchErgebnisse = pizzen.stream()
					.filter(pz -> pz.getName().toLowerCase().contains(suchtext.toLowerCase()))
					.collect(Collectors.toList());
			
			request.setAttribute("pz", suchErgebnisse);
			request.getRequestDispatcher("displayPizzaLager.jsp").forward(request, response);
		}

	}

}
