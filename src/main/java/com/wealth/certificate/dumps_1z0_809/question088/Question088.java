package com.wealth.certificate.dumps_1z0_809.question088;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Question088 {
	public static void main(String[] args) {
		UnaryOperator<Integer> uo1 = s -> s*2;//line n1 
		List<Double> loanValues = Arrays.asList(1000.0, 2000.0); 
        System.out.println(uo1.apply(1));
		loanValues.stream().filter(lv -> lv >= 1500).map(lv -> uo1.apply(lv.intValue())).forEach(s -> System.out.print(s + " "));
		
	}
}
