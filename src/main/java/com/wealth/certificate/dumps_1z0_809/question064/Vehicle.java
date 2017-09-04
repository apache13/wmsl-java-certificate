package com.wealth.certificate.dumps_1z0_809.question064;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Vehicle {
	int vno;
	String name;
	public Vehicle (int vno, String name) {
		this.vno = vno;
		this.name = name;
	}
	
	public String toString () {
		return vno + ":" + name;
	}
	
	public static void main(String[] args) {
		Set<Vehicle> vehicles = new TreeSet <>();
		vehicles.add(new Vehicle(10123, "Ford"));
		vehicles.add(new Vehicle(10124, "BMW"));
		System.out.println(vehicles);
		
		//Ex1. TreeSet new Object implements Comparator
//		Set<Vehicle> vehicles1 = new TreeSet <>(new vehicleCompare());
		
		 //Ex1. TreeSet Anonymuse
//		Set<Vehicle> vehicles1 = new TreeSet <>(new Comparator<Vehicle>() {		
//			@Override
//			public int compare(Vehicle o1, Vehicle o2) {
//				Integer a = o1.vno;
//				Integer b = o2.vno;
//				return a.compareTo(b);
//			}
//		});
		
//		vehicles1.add(new Vehicle(10123, "Ford"));
//		vehicles1.add(new Vehicle(10124, "BMW"));
//		System.out.println(vehicles1);
	}
}

class vehicleCompare implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		Integer a = o1.vno;
		Integer b = o2.vno;
		return a.compareTo(b);
	}	
}
