package com.wealth.certificate.dumps_1z0_809.question062;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test062 {
	public enum Continent {
		ASIA, EUROPE
	}

	String name;
	Continent region;

	public Test062(String na, Continent reg) {
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
		List<Test062> couList = Arrays.asList(new Test062("Japan", Test062.Continent.ASIA),
				new Test062("Italy", Test062.Continent.EUROPE), new Test062("Germany", Test062.Continent.EUROPE));
		Map<Test062.Continent, List<String>> regionNames = couList.stream().collect(
				Collectors.groupingBy(Test062::getRegion, Collectors.mapping(Test062::getName, Collectors.toList())));
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