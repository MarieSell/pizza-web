package de.deutscherv.kurse.jee.control;

import java.util.Collection;
import java.util.LinkedList;

import de.deutscherv.kurse.jee.entity.Pizza;

@PizzaHandling
public class PizzaLager {

	private final Collection<Pizza> pizzen = new LinkedList<>();
	
	// nur 1 Lager in der Anwendung -> Singleton

	public PizzaLager() {
	}

	public Collection<Pizza> getPizzen() {
		return pizzen;
	}

	public boolean add(Pizza e) {
		return pizzen.add(e);
	}

	public boolean remove(Pizza o) {
		return pizzen.remove(o);
	}

}
