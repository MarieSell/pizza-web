package de.deutscherv.kurse.jee.control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

import de.deutscherv.kurse.jee.entity.Pizza;

@ApplicationScoped
public class PizzaLagerFactory {

	@Produces
	@ApplicationScoped
	public PizzaLager createSamples(@New PizzaLager lager) {
		lager.add(new Pizza(1, "Margherita", 27));
		lager.add(new Pizza(2, "Salami", 29));
		lager.add(new Pizza(3, "Schinken", 40));
		lager.add(new Pizza(4, "Sardellen", 24));

		System.out.println("PizzaLager initialisiert.");

		return lager;
	}

}
