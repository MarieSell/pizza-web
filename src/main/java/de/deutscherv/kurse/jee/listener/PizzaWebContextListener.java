package de.deutscherv.kurse.jee.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import de.deutscherv.kurse.jee.control.PizzaLager;

/**
 * Application Lifecycle Listener implementation class PizzaWebContextListener
 *
 */
@WebListener
public class PizzaWebContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContextListener started. Logging initialisiert.");
		ServletContext sc = sce.getServletContext(); 
		
		
	}
}
