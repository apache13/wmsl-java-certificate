package com.wealth.certificate.study_1z0_809.chapter12.stream02;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
	
	public static void main(String[] args) {

		/*
		 * Stream Declaration
		*/
		
		Stream<String> stream = Stream.empty();
		
		//1. Declared from Array
		String[] arr = { "program", "creek", "program", "creek", "java", "web", "program" };
		stream= Stream.of(arr);
		
		stream = Stream.of("program", "creek", "program", "creek", "java", "web", "program");
		
		String[] stringArr = { "a", "b", "c", "d" };
		stream = Arrays.stream(stringArr);
		
		
		//2.Declared from collection
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("php");
		list.add("python");
		stream = list.stream();
		
		List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
		stream = words.stream();
		
		//3 Use stream generate()
		//static <T> Stream<T> generate(Supplier<T> s)
		stream = Stream.generate(() -> "test").limit(10);
		String[] strArr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(strArr));
		
		Stream<Double> streamInt = Stream.generate(()-> Math.random() ).limit(5);
		System.out.println(Arrays.toString(streamInt.toArray(String[]::new)));
		
		//4. Use Stream.iterate() 
		//static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
		Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
		BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
		System.out.println(Arrays.toString(bigIntArr));
		
		Stream<Integer> s = Stream.iterate(1, t -> t * 2).limit(5);
		System.out.println(Arrays.toString(s.toArray(String[]::new)));
		
		//5. Stream Builder
		//void accept(T t) Stream.Builder<T> add(T t)
		Stream.Builder<String> builder =
			    Stream.<String>builder()
			       .add("h")
			       .add("e")
			       .add("l");
		
		builder.add("l");
		
		builder.accept("o"); //return void
		builder.accept("!");
		Stream<String> StBuilder = builder.build();
		System.out.println(Arrays.toString(StBuilder.toArray(String[]::new)));
		
		
		//6. From Popular APIs
		//Stream method from APIs
		String sentence = "Program creek is a Java site.";
		Stream<String> wordStream = Pattern.compile(" ").splitAsStream(sentence);
		String[] wordArr = wordStream.toArray(String[]::new);
		System.out.println(Arrays.toString(wordArr));
		
		
		/*  IntStream and LongStream 
		* 
		*	static IntStream range(long startInclusive, long endExclusive)
		*	static IntStream rangeClosed(long startInclusive, long endInclusive)
		*	static LongStream range(long startInclusive, long endExclusive)
		*	static LongStream rangeClosed(long startInclusive, long endInclusive)
		*
		*   That returns a sequential stream for the range of int or long elements. For example:
		*/

			// stream of 1, 2, 3
			IntStream s1 = IntStream.range(1, 4);
			// stream of 1, 2, 3, 4
			IntStream s2 = IntStream.rangeClosed(1, 4);
			// stream 5 elements of 1-9
			IntStream s3 = new Random().ints(5, 1, 10);

		/*
		 * NOTE : 
		 *  static <T> Stream<T> of(T t) : returns a stream of one element
		 *  static <T> Stream<T> of(T... values) : returns a stream whose elements are the specified values
		 *  
		 *  Don't use Stream<T>.of() when working with primitives.
		 */
		int[] intNum = {1, 2, 3, 4, 5};
		Integer[] IntegerNum = {1, 2, 3, 4, 5};
		System.out.println(Stream.of(intNum).count()); // It prints 1!  So if want to prints all elements should be use IntStream
		System.out.println(Stream.of(IntegerNum).count()); // It prints 5!
		 
		
	}
}
