package de.deutscherv.kurse.jee.control;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import de.deutscherv.kurse.jee.entity.Pizza;

@PizzaHandling
@Interceptor
public class PizzaHandlingInterceptor implements Serializable { // fuer SessionScopedBeans

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		// Suche nach dem Parameter vom Typ Pizza

		// Suchen nach dem Parameter vom Typ Pizza
		for (Object o : ic.getParameters()) {
			if (o instanceof Pizza) {
				Pizza p = (Pizza) o;
				if (p.getdurchmesser() < 20) {
					throw new IllegalArgumentException("Pizzen mit Durchmesser kleiner 20 sind nicht zulässig.");
				} else {
					System.out.printf("Pizza mit Durchmesser %d an Methoden '%s' übergeben.%n", p.getdurchmesser(),
							ic.getMethod().getName());
				}
			}
		}

		// Aufruf der Original-Methode
		return ic.proceed();

	}

}
