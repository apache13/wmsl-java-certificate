package com.wealth.certificate.dumps_1z0_809.question017;

interface Rideable {Car getCar (String name); }

public class Car {	
	
	private String name;
	
	public Car (String name) {
		this.name = name;
		//A
		//Car auto = Car (“MyCar”): : new;
		
		//B
		//Car auto = Car : : new;
		//Car vehicle = auto : : getCar(“MyCar”);
		
		//C
		Rideable rider = Car : : new;
		Car vehicle = rider.getCar(“MyCar”);
		
		//D
		//Car vehicle = Rideable : : new : : getCar(“MyCar”);
	}

}
