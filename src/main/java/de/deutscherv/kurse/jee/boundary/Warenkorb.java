package de.deutscherv.kurse.jee.boundary;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import javax.enterprise.context.SessionScoped;

import de.deutscherv.kurse.jee.entity.Pizza;

@SessionScoped
public class Warenkorb implements Serializable {

	private static final long serialVersionUID = -1967512274800853590L;

	private final Collection<Pizza> pizzen = new TreeSet<>(Comparator.comparing(Pizza::getKartenNummer));

	public Collection<Pizza> getPizza() {
		return pizzen;
	}

	public boolean add(Pizza e) {
		return pizzen.add(e);
	}

	public boolean remove(Pizza o) {
		return pizzen.remove(o);
	}

}
