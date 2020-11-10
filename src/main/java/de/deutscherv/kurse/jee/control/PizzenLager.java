package de.deutscherv.kurse.jee.control;

import java.util.Collection;
import java.util.LinkedList;

import de.deutscherv.kurse.jee.entity.Pizza;

public class PizzenLager {

	private static final PizzenLager theInstance = new PizzenLager();

	private final Collection<Pizza> pizzen = new LinkedList<>();

	private PizzenLager() {
		pizzen.add(new Pizza(01, "Margarita", 5.50));
		pizzen.add(new Pizza(02, "Salami", 6.50));
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

	public static PizzenLager getInstance() {
		return theInstance;
	}

}
