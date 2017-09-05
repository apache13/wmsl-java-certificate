package com.a;

public class BaseballTeam {
	private String city, mascot;
	private int numberOfPlayers;
	public boolean equals(Object obj) {
		if ( !(obj instanceof BaseballTeam))
			return false;
		BaseballTeam other = (BaseballTeam) obj;
		return (city.equals(other.city) && mascot.equals(other.mascot));
	}
	public int hashCode() {
		return numberOfPlayers;
	}
	// imagine getters and setters are here
}

abstract class Cat {
String name = "The Cat";
void clean() { }
}
class Lion extends Cat {
void clean() { }
}


