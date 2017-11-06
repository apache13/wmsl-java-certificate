package com.wealth.certificate.dump_1z0_809_72.question064;

public class Country {
	public enum Continent {ASIA, EUROPE}
	String name;
	Continent region;
	
	public Country(String na,Continent reg){
		name = na; region = reg;
	}
	public String getName() {return name;}
	public Continent getRegion() {return region;}
}