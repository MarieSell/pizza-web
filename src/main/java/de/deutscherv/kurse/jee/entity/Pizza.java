package de.deutscherv.kurse.jee.entity;

import java.io.Serializable;

public class Pizza implements Serializable {

	private static final long serialVersionUID = 1L;

	private int kartenNummer;
	private String name;
	private int durchmesser;
	// private Ofen ofen; // Field Injection

	public void rolleTeig(TeigRolle rolle) { // MethodInjection
	}

	public Pizza(int kartennummer, String name, int durchmesser) { // Constructor Injection
		super();
		this.kartenNummer = kartennummer;
		this.name = name;
		this.durchmesser = durchmesser;
	}

	public int getKartenNummer() {
		return kartenNummer;
	}

	public void setKartenNummer(int kartenNummer) {
		this.kartenNummer = kartenNummer;
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
