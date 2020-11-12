package de.deutscherv.kurse.jee.faces;

import java.util.Comparator;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.deutscherv.kurse.jee.control.PizzaLager;
import de.deutscherv.kurse.jee.entity.Pizza;

@RequestScoped
@Named("insertBean")
public class InsertBean {

	@Inject
	Pizza pizza;
	@Inject
	PizzaLager lager;

	public String insert() { // Bean Validation automatisch
		// ID setzen
		Optional<Integer> max = lager.getPizzen().stream().map(Pizza::getKartennummer).max(Comparator.naturalOrder());
		// Kopie erstellen, da CDI Managed Bean Proxy -> bei Validierung in Interceptor
		// gibt es Probleme
		Pizza newP = new Pizza(max.orElse(0) + 1, pizza.getName(), pizza.getdurchmesser());
		lager.add(newP);
		return "anzeige";
	}

}
