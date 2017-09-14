package com.wealth.certificate.study_1z0_809.chapter12.stream03;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) {

		/* 
		 * Intermediate Operations แบ่งออกเป็น 2 ประเภท
		 * 1. Stateless Operations เป็น state ที่ไม่ต้องใช้ element ก่อนหน้าในการ processing element ใหม่ โดยแต่ละ element เป็นอิสระต่อกัน
		 * 2. Stateful Operations เป็น state ที่ต้องใช้ element ก่อนหน้าในการ processing element ใหม่
		 */
		
		/*
		 *  Example: Intermediate Operations
		 */
		System.out.println("# Example: Intermediate");
		Stream<String> s = Stream.of("m", "k", "c", "t", "a").sorted().limit(3);
		s.forEach(System.out::print);
		System.out.println("\n");

		/*
		 * Example: Stream<T> distinct() 
		 * Type: Stateful 
		 * Description: Return Stream ที่ประกอบด้วย Element ที่แตกต่างกัน ( Object.equals.(Object) )
		 */
		System.out.println("# Example: Stream<T> distinct()");
		System.out.print("List<String>: ");
		List<String> slDist = Arrays.asList("1", "1", "2", "3", "4");
		slDist.stream().distinct().forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> limit(long maxSize) 
		 * Type: Stateful 
		 * Description: Return Stream ที่มี Element ที่ยาวไม่เกินตามที่กำหนดใน maxSize ส่วน Element ที่เกินจะถูกตัดออก
		 */
		System.out.println("# Example: Stream<T> distinct()");
		System.out.print("List<String>: ");
		List<String> slLimit = Arrays.asList("1", "1", "2", "3", "4");
		slLimit.stream().limit(3).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> skip(long n) 
		 * Type: Stateful 
		 * Description: Return Stream ค่าที่เหลืออยู่จากการข้ามไปจำนวน n ตัว โดยเริ่มนับตั้งแต่ตัวแรก
		 */
		System.out.println("# Example: Stream<T> skip(long n)");
	    System.out.print("Stream<String>: ");
	    Stream<String> ssSkip = Stream.of("1", "1", "2", "3", "4");
		ssSkip.skip(2).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> sorted() 
		 * Type: Stateful 
		 * Description: Return Stream ที่ถูกจัดเรียงตาม Natural order
		 */
		System.out.println("# Example: Stream<T> sorted()");	    
	    System.out.print("Stream<String>: ");
	    Stream<String> ssSort = Stream.of("3","5","1","4","3","2");
	    ssSort.sorted().forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> sorted(Comparator<? super T> comparator)
		 * Type: Stateful 
		 * Description: Return Stream ที่ถูกจัดเรียงตาม Comparator
		 */
		System.out.println("# Example: Stream<T> sorted(Comparator<? super T> comparator)");
		System.out.print("List<String>: ");
		List<String> slSortComp = Arrays.asList("3","5","1","4","3","2");
	    slSortComp.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> filter(Predicate<? super T> predicate)
		 * Type: Stateless
		 * Description: Return Stream ที่มี Element ผ่านเงื่อนไข
		 */
		System.out.println("# Stream<T> filter(Predicate<? super T> predicate)");
		System.out.print("List<Integer>: ");
		List<Integer> nlFilter = Arrays.asList(1,2,3,4,5,6);
		nlFilter.stream().filter(n -> n % 2 == 0).forEach(System.out::print);
		System.out.println();
		
		System.out.print("Stream: ");
		Stream.of(1,2,3,4,5,6).filter(n -> n % 3 == 0).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
		 * Type: Stateless
		 * Description: 
		 */
		System.out.println("# Example: <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper");
		System.out.print("List<String>: ");
		List<String> slFlatMap = Arrays.asList("1.0", "1", "2.0", "3", "4");
		slFlatMap.stream().flatMap(n -> Stream.of("A", "b", "C", "d", "E")).forEach(System.out::print);
	    System.out.println();
	    
	    System.out.print("Stream: ");
	    Stream.of("A", "b", "C", "d", "E").flatMap(n -> Stream.of(n)).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: <R> Stream<R> map(Function<? super T,? extends R> mapper)
		 * Type: Stateless
		 * Description: 
		 */
		System.out.println("# <R> Stream<R> map(Function<? super T,? extends R> mapper)");
		System.out.print("List<Integer>: ");
		List<Integer> nlMap = Arrays.asList(1,2,3,4);
		nlMap.stream().map(n -> n * 2).forEach(System.out::print);
		System.out.println();
		
		System.out.print("Stream: ");
		Stream.of(1,2,3).map(n -> n * 3).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> peek(Consumer<? super T> action))
		 * Type: Stateless
		 * Description:  
		 */
		System.out.println("# Example: Stream<T> peek(Consumer<? super T> action))");
		System.out.print("List<String>: ");
		List<String> slPeek = Arrays.asList("1", "1", "2", "3", "4");
		slPeek.stream().limit(3).peek(n -> System.out.print(n)).forEach(System.out::print);
		System.out.println();
		
		System.out.print("Stream: ");
		Stream.of("1", "1", "2", "3", "4").limit(3).peek(n -> System.out.print("| |")).forEach(System.out::print);
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> parallel()
		 * Type: N/A
		 * Description: 
		 */
		System.out.println("# Example: Stream<T> parallel()");
		LocalTime start = LocalTime.now();
		Stream.of(1, 1, 2, 3, 4).parallel().filter(n -> n % 3 == 0).forEach(e -> {});
		LocalTime finish = LocalTime.now();
		System.out.println("Parallel using time : "+Duration.between(start, finish).toMillis()+" ms");
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> sequential()
		 * Type: N/A
		 * Description: 
		 */
		System.out.println("# Example: Stream<T> sequential()");
		start = LocalTime.now();
		Stream.of(1, 1, 2, 3, 4).sequential().filter(n -> n % 3 == 0).forEach(e -> {});
		finish = LocalTime.now();
		System.out.println("Parallel using time : "+Duration.between(start, finish).toMillis()+" ms");
		System.out.println("\n");
		
		/*
		 * Example: Stream<T> unordered()
		 * Type: N/A
		 * Description: 
		 */
		System.out.println("# Example: Stream<T> unordered()");
		Stream.of(1, 1, 2, 3, 4).unordered().forEach(System.out::print);
		System.out.println("\n");
	}

}
