package com.wealth.certificate.study_1z0_809.chapter17.stream03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

	public static void main(String[] args) {
		
		/* flatMap() is used to "flatten" (or combine) the elements of a stream into one (new) stream: */
		
		/*
		 * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
		 * 
		 * DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)
		 * 
		 * IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper)
		 * 
		 * LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper)
		 */
		
		/*
		 * Stream<String[]>		-> flatMap ->	Stream<String>
		 * Stream<Set<String>>	-> flatMap ->	Stream<String>
		 * Stream<List<String>>	-> flatMap ->	Stream<String>
		 * Stream<List<Object>>	-> flatMap ->	Stream<Object>
		*/
		
		Stream<List<String>> flatMapStream = Stream.of(Arrays.asList("a","b","c"),Arrays.asList("x","y","z"));			
		long flatMapListSize = flatMapStream
				.peek(p -> System.out.println("before " + p))
				.flatMap(n -> n.stream() )
				.peek(p -> System.out.println("after "+p))
				.count();
		System.out.println("flatMapListSize : " + flatMapListSize + "\n");

	}

}
