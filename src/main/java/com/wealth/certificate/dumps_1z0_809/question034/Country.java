package com.wealth.certificate.dumps_1z0_809.question034;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Country {
	public enum Continent {
		ASIA, EUROPE
	}

	String name;
	Continent region;

	public Country(String na, Continent reg) {
		name = na;
		region = reg;
	}

	public String getName() {
		return name;
	}

	public Continent getRegion() {
		return region;
	}

	public static void main(String[] args) {
		List<Country> couList = Arrays.asList(new Country("Japan", Country.Continent.ASIA),
				new Country("Italy", Country.Continent.EUROPE), new Country("Germany", Country.Continent.EUROPE));
		Map<Country.Continent, List<String>> regionNames = couList.stream().collect(
				Collectors.groupingBy(Country::getRegion, Collectors.mapping(Country::getName, Collectors.toList())));
		System.out.println(regionNames);
	}
}

/*
What is the output?
A. {EUROPE = [Italy, Germany], ASIA = [Japan]}
B. {ASIA = [Japan], EUROPE = [Italy, Germany]}
C. {EUROPE = [Germany, Italy], ASIA = [Japan]}
D. {EUROPE = [Germany], EUROPE = [Italy], ASIA = [Japan]}


Answer: A
*/