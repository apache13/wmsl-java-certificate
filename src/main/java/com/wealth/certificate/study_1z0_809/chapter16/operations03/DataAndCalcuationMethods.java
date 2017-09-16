package com.wealth.certificate.study_1z0_809.chapter16.operations03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class DataAndCalcuationMethods {
	public static void main(String[] args) {
		/* ------ Data and Calculation Methods ------ */
		/*
		 * The Stream interface provides the following data and calculation methods:
		 * 1. long count() 
		 * 2. Optional<T> max(Comparator<? super T> comparator) 
		 * 3. Optional<T> min(Comparator<? super T> comparator)
		 */
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		long countIntStream = intStream.count(); // 10
		System.out.println("countIntStream : " + countIntStream);

		Stream<String> emptyStream = Stream.empty();
		long countEmptyStream = emptyStream.count(); // 0
		System.out.println("countEmptyStream : " + countEmptyStream);
		
		List<String> stringMax = Arrays.asList("Stream","Operations","on","Collections");
		System.out.print("stringMax : ");
		stringMax.stream()
			.max(Comparator.comparing(s -> s.length()))
			.ifPresent(System.out::println); // Collections
		
		List<String> stringMin = Arrays.asList("Stream","Operations","on","Collections");
		System.out.print("stringMin : ");
		stringMin.stream()
			.min(Comparator.comparing(s -> s.length()))
			.ifPresent(System.out::println); // on

		/* ------ IntStream ------ */
		/*
		 * 1. OptionalDouble average()
		 * 2. long count()
		 * 3. OptionalInt max()
		 * 4. OptionalInt min()
		 * 5. int sum()
		 */
		//IntStream intStream = IntStream.of(28,4,91,30).average();// 38.25
		System.out.println(IntStream.of(28,4,91,30).average()); 

		/* ------ LongStream ------ */
		/*
		 * 1. OptionalDouble average()
		 * 2. long count()
		 * 3. OptionalLong max()
		 * 4. OptionalLong min()
		 * 5. long sum()
		 */

		/* ------ DoubleStream ------ */
		/*
		 * 1. OptionalDouble average()
		 * 2. long count()
		 * 3. OptionalDobule max()
		 * 4. OptionalDobule min()
		 * 5. double sum()
		 */

	}

}