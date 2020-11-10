package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.deutscherv.kurse.jee.control.PizzenLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/PizzenDatenAnzeige")
public class PizzenDatenAnzeige extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Collection<Pizza> pizzen = PizzenLager.getInstance().getPizzen();

		request.setAttribute("pz", pizzen);
		request.getRequestDispatcher("/displayPizzaLager.jsp").forward(request, response);
	}

}
