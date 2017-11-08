package com.wealth.certificate.dumps_1z0_809_ert.question059;

import java.util.Arrays;
import java.util.List;

public class Question059 {
	public static void main(String[] args) {
		List<String> nums = Arrays.asList("EE" , "SE");
		String ans = nums
				.parallelStream ()
				.reduce("Java",(a,b) -> a.concat(b)) ;
		System.out.print(ans) ;
	}
}
