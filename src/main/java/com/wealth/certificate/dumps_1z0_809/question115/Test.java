package com.wealth.certificate.dumps_1z0_809.question115;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		Stream<List<String>> iStr= Stream.of (
		Arrays.asList ("1", "John"),
		Arrays.asList ("2", null));
		Stream<String> nInSt = iStr.flatMapToInt ((x) -> x.stream());
		//Stream<String> nInSt = iStr.map(x -> x.toString());
		nInSt.forEach (System.out :: print);
	}
}