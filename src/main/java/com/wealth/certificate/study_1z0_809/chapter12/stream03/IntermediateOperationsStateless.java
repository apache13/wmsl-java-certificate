package com.wealth.certificate.study_1z0_809.chapter12.stream03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsStateless {

	public static void main(String[] args) {

		/*1. Stream<T> filter(Predicate<? super T> predicate)	Stateless	Returns a stream of elements that match the given predicate.*/		
		System.out.println("1. Stream<T> filter(Predicate<? super T> predicate)	Stateless	Returns a stream of elements that match the given predicate.");
		List<Integer> filterList = Arrays.asList(1,2,3,4,5,6);
		long filterListSize = filterList.stream()
				.peek(p->System.out.println("bf "+p))
				.filter(n -> n % 2 == 0)
				.peek(p->System.out.println("af "+p))
				.count();
		System.out.println("filterListSize : "+filterListSize);
		
		
		/*2. <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)	Stateless	Returns a stream with the content produced by applying the provided mapping function to each element. There are versions for int, long and double also.*/
		System.out.println("2. <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)	Stateless");
		List<String> flatMapList = Arrays.asList("1.0", "1", "2.0", "3", "4");
		long flatMapListSize = flatMapList.stream()
				.peek(p->System.out.println("bf "+p))
				.flatMap(n -> Stream.of(n))
				.peek(p->System.out.println("bf "+p))
				.count();
		System.out.println("flatMapListSize : "+flatMapListSize);
	    

		
		/*3. <R> Stream<R> map(Function<? super T,? extends R> mapper)	Stateless	Returns a stream consisting of the results of applying the given function to the elements of this stream. There are versions for int, long and double also.*/
		System.out.println("# <R> Stream<R> map(Function<? super T,? extends R> mapper)");
		System.out.print("List<Integer>: ");
		List<Integer> nlMap = Arrays.asList(1,2,3,4);
		nlMap.stream().map(n -> n * 2).forEach(System.out::print);
		System.out.println();
		
		System.out.print("Stream<Integer>: ");
		Stream<Integer> nsMap = Stream.of(1,2,3);
		nsMap.map(n -> n * 3).forEach(System.out::print);
		System.out.println("\n");
		
		
		/*4. Stream<T> peek(Consumer<? super T> action)	Stateless	Returns a stream with the elements of this stream, performing the provided action on each element.*/
		System.out.println("# Example: Stream<T> peek(Consumer<? super T> action))");
		System.out.print("List<String>: ");
		List<String> slPeek = Arrays.asList("1", "1", "2", "3", "4");
		slPeek.stream().limit(3).peek(n -> System.out.print(n)).forEach(System.out::print);
		System.out.println();
		
		System.out.print("Stream<String>: ");
		Stream<String> ssPeek = Stream.of("1", "1", "2", "3", "4");
		ssPeek.limit(3).peek(n -> System.out.print("| |")).forEach(System.out::print);
		System.out.println("\n");
		
		
		/*
		 * Example: Stream<T> parallel()
		 * Type: N/A
		 * Description: 
		 */
		
		/*
		 * Example: Stream<T> sequential()
		 * Type: N/A
		 * Description: 
		 */
		
		/*
		 * Example: Stream<T> unordered()
		 * Type: N/A
		 * Description: 
		 */
	}

}
