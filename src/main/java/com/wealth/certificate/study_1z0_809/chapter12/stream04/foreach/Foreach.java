package com.wealth.certificate.study_1z0_809.chapter12.stream04.foreach;

import java.util.ArrayList;
import java.util.List;

public class Foreach {

	public static void printPeek(Integer i) {
		System.out.println("@"+Thread.currentThread().getId()+"-peek : "+i);
	}
	
	public static void printForEach(Integer i) {
		System.out.println("@"+Thread.currentThread().getId()+"-forEach : "+i+"*");
	}
	
	public static void main(String[] args) {

		{ // Ordered
			List<Integer> integerList = new ArrayList<>();
			integerList.add(1);
			integerList.add(2);
			integerList.add(3);
			integerList.add(4);
			integerList.add(5);

			System.out.println("----- Ordered + forEach -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.forEach(Foreach::printForEach);
						
			System.out.println("----- 1. Ordered + Parallel + forEach -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.parallel()			
			.forEach(Foreach::printForEach);
			
			System.out.println("----- 2. Ordered + Parallel + forEach -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.parallel()			
			.forEach(Foreach::printForEach);
			
			System.out.println("----- 3. Ordered + Parallel + forEach -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.parallel()			
			.forEach(Foreach::printForEach);
			
			System.out.println("----- 1. Ordered + Parallel + forEachOrdered -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.parallel()
			.forEachOrdered(Foreach::printForEach);
			
			System.out.println("----- 2. Ordered + Parallel + forEachOrdered -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.parallel()
			.forEachOrdered(Foreach::printForEach);
			
			System.out.println("----- 3. Ordered + Parallel + forEachOrdered -----");
			integerList.stream()
			.peek(Foreach::printPeek)
			.parallel()
			.forEachOrdered(Foreach::printForEach);
			
			System.out.println("----- 4. Ordered + forEachOrdered -----");
			integerList.stream()
			.peek(Foreach::printPeek)
//			.parallel()
			.forEachOrdered(Foreach::printForEach);
		}
		
	}

}
