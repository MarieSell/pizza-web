package de.deutscherv.kurse.jee.entity;

public class Pizza {

	private int kartenNummer;
	private String name;
	private double preis;

	public Pizza() {
		super();
	}

	public Pizza(int kartennummer, String name, double preis) {
		super();
		this.kartenNummer = kartennummer;
		this.name = name;
		this.preis = preis;
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

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
}
