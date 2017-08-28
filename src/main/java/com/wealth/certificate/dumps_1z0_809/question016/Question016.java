package com.wealth.certificate.dumps_1z0_809.question016;

import java.util.ArrayList;
import java.util.List;

public class Question016 {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List  names = new ArrayList(); 
        names.add("David");
        names.add("Sam");
        names.add("Ben");
 
        names.stream()
        	.forEach((x) -> printNames((String) x));
	}

	@SuppressWarnings("rawtypes")
	static void printNames(String str) {
		System.out.println(str);
	}
}
