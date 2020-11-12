package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.deutscherv.kurse.jee.control.PizzaLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@WebServlet("/PizzaWarenkorbServlet")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("PizzaWarenkorbServlet wurde gerufen.");
		String[] bestelltePizzen = request.getParameterValues("warenkorb");

		if (null != bestelltePizzen && bestelltePizzen.length > 0) {

			HttpSession session = request.getSession();
			Collection<Pizza> warenkorb;
			ServletContext context = request.getSession().getServletContext();
			
			synchronized (session) { // parallele Zugriffe auf dieselbe Session -> Thread Safety
				warenkorb = (Collection<Pizza>) session.getAttribute("warenkorb");
				if(null == warenkorb) {
					warenkorb = new TreeSet<>(Comparator.comparing(Pizza::getKartenNummer)); // keine Duplikate, Sortierung nach ID
					session.setAttribute("merkliste", warenkorb);
				}
			}
			// BestellNr als Integer
			Set<Integer> bestellNrSet = Arrays.stream(bestelltePizzen).map(Integer::valueOf).collect(Collectors.toSet());
			PizzaLager pizzenLagerObjekt = (PizzaLager) getServletContext().getAttribute("pizzen");
			Collection<Pizza> pizzenLager = pizzenLagerObjekt.getPizzen();
			// alles aus Bestand, dessen BestellNr in bestellNrSet (=Parameter) zu finden ist, wird in den Warenkorb gepackt
			pizzenLager.stream().filter(p -> bestellNrSet.contains(p.getKartenNummer())).forEach(warenkorb::add);
			

		}

		response.sendRedirect("merkliste");
	}

}
