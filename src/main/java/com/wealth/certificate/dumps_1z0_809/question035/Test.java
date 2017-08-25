package com.wealth.certificate.dumps_1z0_809.question035;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("my", "pen", "is", "your", "pen");
		Predicate<String> test = s->{
			int i = 0;
			boolean result = s.contains("pen");
			System.out.print(i++ +":");
			//System.out.print(i++) + “:”);
			return result;
		};
		
		// round 1 -> 0:, false
		// round 2 -> 0:0:, true
		
		str.stream().filter(test).findFirst().ifPresent(System.out ::print);
		//str.stream().filter(s -> s.contains("y")).forEach(s -> System.out.println(s));  -> //str.stream().filter(s -> s.contains("y")).forEach(System.out ::print);
		//str.stream().filter(s -> s.contains("y")).findFirst().ifPresent(System.out ::print);
		
	}

}
