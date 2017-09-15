package com.wealth.certificate.study_1z0_809.chapter12.stream03;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.derby.impl.sql.catalog.SYSROUTINEPERMSRowFactory;
import org.apache.derby.tools.sysinfo;

public class IntermediateOperations {

	public static void main(String[] args) {

		/*You can easily identify intermediate operations; they always return a new stream. This allows the operations to be connected.*/
		
		/*An important feature of intermediate operations is that they don't process the elements until a terminal operation is invoked, in other words, they're lazy.*/
		
		/*Intermediate operations are further divided into stateless and stateful operations.*/
		
		/*		
 		Stateless operations retain no state from previously elements when processing a new element so each can be processed independently of operations on other elements.
		Stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing new elements.
		*/
		
		Stream<String> s = Stream.of("m", "k", "c", "t", "a").sorted().limit(3);
		s.forEach(System.out::println);
		System.out.println();
		
		
		/* 1. Stream<T> parallel()   Type: N/A   Returns an equivalent stream that is parallel. */
		System.out.println("1. Stream<T> parallel()   Type: N/A   Returns an equivalent stream that is parallel.");
		LocalTime start = LocalTime.now();
		IntStream.rangeClosed(1, 20)
				.parallel()
				.forEach(e -> {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				});
		LocalTime finish = LocalTime.now();
		System.out.println("Parallel using time: "+Duration.between(start, finish).toMillis()+" ms\n");
		
		
		/* 2. Stream<T> sequential()   Type: N/A   Returns an equivalent stream that is sequential. */
		System.out.println("2. Stream<T> sequential()   Type: N/A   Returns an equivalent stream that is sequential.");
		start = LocalTime.now();
		IntStream.rangeClosed(1, 20)
				.sequential()
				.forEach(e -> {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				} );
		finish = LocalTime.now();
		System.out.println("Sequential using time: "+Duration.between(start, finish).toMillis()+" ms\n");
		
		
		/* 3. Stream<T> unordered()   Type: N/A   Returns an equivalent stream that is unordered. */
		System.out.println("3. Stream<T> unordered()   Type: N/A   Returns an equivalent stream that is unordered.");
		//IntStream.range(1, 21).unordered().peek(n -> System.out.print(n)).forEach(e -> System.out.println());
		List<Integer> numberStream = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		System.out.println("skip-skip-unordered-toList: " +
		numberStream.parallelStream()
				.filter(n -> n != 0)
				.skip(1)
				.skip(1)
				.unordered()
				.collect(Collectors.toList()));
		
		numberStream = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		System.out.println("skip-unordered-skip-toList: " +
		numberStream.parallelStream()
				.filter(n -> n != 0)
	            .skip(1)
	            .unordered()
	            .skip(1)
	            .collect(Collectors.toList()));
		
		numberStream = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		System.out.println("unordered-skip-skip-toList: " +
		numberStream.parallelStream()
				.filter(n -> n != 0)
	            .unordered()
	            .skip(1)
	            .skip(1)
	            .collect(Collectors.toList()));
		
	}

}
