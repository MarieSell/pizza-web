package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/WarenkorbAnzeige")
public class WarenkorbAnzeige extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Logik, z.B. DB-Zugriff o.Ä.

		Collection<Pizza> warenkorb = null;
		HttpSession session = request.getSession(false);

		System.out.println("WarenkorbBerechnungServlet wurde gerufen.");

		if (null != session) {
			warenkorb = (Collection<Pizza>) session.getAttribute("warenkorb");
		}

		request.setAttribute("pz", warenkorb); // null ist ok
		request.setAttribute("pageTitle", "Warenkorb");
		request.setAttribute("merkenFormDisabled", true);
		request.getRequestDispatcher("/shoppingCard.jsp").forward(request, response);

	}

}
