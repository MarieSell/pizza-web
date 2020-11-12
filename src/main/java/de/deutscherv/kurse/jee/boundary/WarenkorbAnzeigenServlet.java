package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/warenkorbliste")
public class WarenkorbAnzeigenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private Warenkorb warenkorb;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Logik, z.B. DB-Zugriff o.Ä.

		request.setAttribute("pz", warenkorb.getPizza()); // null ist ok
		request.setAttribute("pageTitle", "WarenkorbListe");
		request.setAttribute("merkenFormDisabled", true);
		request.getRequestDispatcher("/WEB-INF/jsp/displayPizzen.jsp").forward(request, response);

	}

}
