package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ZutatenPreisServlet")
public class ZutatenPreisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		double sum = 0;

		String[] zutatenListe = request.getParameterValues("zutat");
		for (String zutat : zutatenListe) {
			System.out.println(zutat);
			switch (zutat) {
			case "salami":
				sum += 1.5;
				System.out.println("bin im salami case");
				break;
			case "schinken":
				sum += 2;
				System.out.println("bin im schinken case");
				break;
			case "sardellen":
				sum += 4;
				System.out.println("bin im sardellencase case");
				break;
			default:
				break;
			}
		}
		System.out.println(sum);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gesamt-preis.jsp");
		request.setAttribute("gesamtPreis", sum);
		requestDispatcher.forward(request, response);
	}

}
