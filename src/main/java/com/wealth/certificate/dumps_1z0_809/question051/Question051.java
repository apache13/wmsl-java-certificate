package com.wealth.certificate.dumps_1z0_809.question051;

import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Question051 {

	public static void main(String[] args) {
		IntStream stream = IntStream.of(1, 2, 3);

		//IntFunction<Integer> inFu = x -> y -> x * y; // line n1
		
		//A
		//IntFunction<UnaryOperator> inFu = x -> y -> x * y;
		
		//B
		IntFunction<IntUnaryOperator> inFu = x -> y -> x * y;
		
		//C
		//BiFunction<IntUnaryOperator> inFu = x -> y -> x * y;
		
		IntStream newStream = stream.map(inFu.apply(10)); // line n2
		
		//D
		//IntStream newStream = stream.map(inFu.applyAsInt(10));

		newStream.forEach(System.out::print);
	}

}
