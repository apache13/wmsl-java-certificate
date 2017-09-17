package com.wealth.certificate.study_1z0_809.chapter12.stream04.find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Find {

	public static void printPeek(String s) {
		System.out.println("@"+Thread.currentThread().getId()+"-peek : "+s);
	}
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
		
		/*1. Optional<T> findAny()	Returns an Optional describing some element of the stream.*/
		{
			Optional<String> result = words.stream()
			.peek(Find::printPeek)
//			.parallel()
			.findAny();
			System.out.println("findAny : "+result.orElse("Not found"));
		}
		
		/*2. Optional<T> findFirst()	Returns an Optional describing the first element of this stream.*/
		{
			Optional<String> result = words.stream()
			.peek(Find::printPeek)
//			.parallel()
			.findFirst();
			System.out.println("findFirst : "+result.orElse("Not found"));
		}
		
	}

}
