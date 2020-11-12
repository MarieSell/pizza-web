package de.deutscherv.kurse.jee.boundary;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.deutscherv.kurse.jee.control.PizzaLager;

@WebServlet("/warenkorb")
public class WarenkorbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaLager lager;
	@Inject
	private Warenkorb warenkorb;

	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] kartennummer = request.getParameterValues("kartennummer");

		if (null != kartennummer && kartennummer.length > 0) {

			// BestellNr als Integer
			Set<Integer> bestellNrSet = Arrays.stream(kartennummer).map(Integer::valueOf).collect(Collectors.toSet());
			// alles aus Bestand, dessen BestellNr in bestellNrSet (=Parameter) zu finden
			// ist, wird in den Warenkorb gepackt
			lager.getPizzen().stream().filter(p -> bestellNrSet.contains(p.getKartennummer())).forEach(warenkorb::add);
		}

		response.sendRedirect("warenkorbliste");
	}

}
