package com.wealth.certificate.dumps_1z0_808.question010;

public class Question10 {
	public String name;
	public int moons;

	public Question10(String name, int moons) {
		this.name = name;
		this.moons = moons;
	}

	public static void main(String[] args){
		
		Question10[] planets = {
				new Question10("Mercury", 0)
				, new Question10("Venus", 0)
				, new Question10("Earth", 1)
				, new Question10("Mars", 2) 
		};
		System.out.println(planets);
		System.out.println(planets[2]);
		System.out.println(planets[2].moons);

	}
};