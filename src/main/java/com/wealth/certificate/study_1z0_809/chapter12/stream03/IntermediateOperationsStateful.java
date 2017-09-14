package com.wealth.certificate.study_1z0_809.chapter12.stream03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsStateful {

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

		
		/*1. Stream<T> distinct()	Stateful	Returns a stream consisting of the distinct elements.*/
		System.out.println("1. Stream<T> distinct()	Stateful	Returns a stream consisting of the distinct elements.");
		List<String> distinctList = Arrays.asList("1", "1", "2", "3", "4");
		long distinctListSize = distinctList.stream()
				.peek(p->System.out.println("bf "+p))
				.distinct()
				.peek(p->System.out.println("af "+p))
				.count();
		System.out.println("distinctListSize : "+distinctListSize);
		
		
		/*2. Stream<T> limit(long maxSize)	Stateful	Returns a stream truncated to be no longer than maxSize in length.*/		
		System.out.println("2. Stream<T> limit(long maxSize)	Stateful	Returns a stream truncated to be no longer than maxSize in length.");
		List<String> limitList = Arrays.asList("1", "1", "2", "3", "4");
		long limitListSize = limitList.stream()
				.peek(p->System.out.println("bf "+p))
				.limit(3)
				.peek(p->System.out.println("af "+p))
				.count();
		System.out.println("limitListSize : "+limitListSize);
		
		
		/*3. Stream<T> skip(long n)	Stateful	Returns a stream with the remaining elements of this stream after discarding the first n elements.*/
		System.out.println("3. Stream<T> skip(long n)	Stateful	Returns a stream with the remaining elements of this stream after discarding the first n elements.");
		List<String> skipList = Arrays.asList("1","1","2","3","4");
		long skipListSize = skipList.stream()
				.peek(p->System.out.println("bf "+p))
				.skip(2)
				.peek(p->System.out.println("af "+p))
				.count();
		System.out.println("skipListSize : "+skipListSize);
	    		
		
		/*4. Stream<T> sorted()	Stateful	Returns a stream sorted according to the natural order of its elements.*/
		System.out.println("4. Stream<T> sorted()	Stateful	Returns a stream sorted according to the natural order of its elements.");
		List<String> sortedList = Arrays.asList("3","5","1","4","3","2");
		long sortedListSize = sortedList.stream()
				.peek(p->System.out.println("bf "+p))
				.sorted()
				.peek(p->System.out.println("af "+p))
				.count();
		System.out.println("sortedList : "+sortedListSize);
	    
	   
		
		/*5. Stream<T> sorted(Comparator<? super T> comparator)	Stateful	Returns a stream with the sorted according to the provided Comparator.*/
		System.out.println("5. Stream<T> sorted(Comparator<? super T> comparator)	Stateful	Returns a stream with the sorted according to the provided Comparator.");
		List<String> sortedWithComparatorList = Arrays.asList("3","5","1","4","3","2");
		long sortedWithComparatorListSize = sortedWithComparatorList.stream()
				.peek(p->System.out.println("bf "+p))
				.sorted(Comparator.reverseOrder())
				.peek(p->System.out.println("af "+p))
				.count();
		System.out.println("sortedWithComparatorListSize : "+sortedWithComparatorListSize);
		
	}

}
