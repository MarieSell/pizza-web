package de.deutscherv.kurse.jee.entity;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;

	@Min(0)
	private int kartennummer;
	@Size(min = 4)
	@NotNull
	private String name;
	@Min(20)
	private int durchmesser;
	// private Ofen ofen; // Field Injection

	public void rolleTeig(TeigRolle rolle) { // MethodInjection
	}

	public Pizza(int kartennummer, String name, int durchmesser) { // Constructor Injection
		super();
		this.kartennummer = kartennummer;
		this.name = name;
		this.durchmesser = durchmesser;
	}

	public int getKartennummer() {
		return kartennummer;
	}

	public void setKartenNummer(int kartenNummer) {
		this.kartennummer = kartenNummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getdurchmesser() {
		return durchmesser;
	}

	public void setdurchmesser(int durchmesser) {
		this.durchmesser = durchmesser;
	}

}
