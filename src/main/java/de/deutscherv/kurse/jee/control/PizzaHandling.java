package de.deutscherv.kurse.jee.control;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Schreibt jede Verwendung eines Fahrzeugs als Methodenparameter auf die
 * Konsole. Es wird geprüft, ob das Baujahr mind. 1900 ist, ansonsten gibt es
 * eine IllegalArgumentException.
 */
@Inherited
@InterceptorBinding
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)

public @interface PizzaHandling {

}
