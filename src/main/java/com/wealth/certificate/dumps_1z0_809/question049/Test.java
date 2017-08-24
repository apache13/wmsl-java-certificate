package com.wealth.certificate.dumps_1z0_809.question049;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10,20,8);
		System.out.println(
				/*A*/
				nums.stream().max(Comparator.comparing(a -> a)).get()
				
				/*B*///nums.stream().max(Integer::max).get() // reference : https://www.programcreek.com/2014/01/why-stream-maxintegermax-compile/
				
				/*C*///nums.stream().max()  
				
				/*D*///nums.stream().map(a -> a).max()
								
		);
		
	}

}
//"::" is called Method Reference
// B Integer::max not a Comparator
// C And D not correct because The method max(Comparator<? super Integer>) in the type Stream<Integer> is not applicable for the arguments ()