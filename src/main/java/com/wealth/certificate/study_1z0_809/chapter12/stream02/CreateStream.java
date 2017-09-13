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

		// #### Stream Declaration  ####
		
				/*  Empty Stream 
				* Its often the case that the empty() method is used upon creation to avoid returning null for streams with no element:
				* 
				* public Stream<String> streamOf(List<String> list) {
		    		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
				  }
				*/
				 Stream<String> stream = Stream.empty();
				 
				 
				/*1. Declared from Array
				 * They can also be created out of an existing array or of a part of an array
				 */
				String[] arr = { "program", "creek", "program", "creek", "java", "web", "program" };
				stream= Stream.of(arr);
				
				stream = Stream.of("program", "creek", "program", "creek", "java", "web", "program");
				
				String[] stringArr = { "a", "b", "c", "d" };
				stream = Arrays.stream(stringArr);
				
				
				/*2.Declared from collection
				 * Stream can also be created of any type of Collection (Collection, List, Set):
				 */
				List<String> list = new ArrayList<String>();
				list.add("java");
				list.add("php");
				list.add("python");
				stream = list.stream();
				
				List<String> words = Arrays.asList(new String[]{"hello", "hola", "hallo", "ciao"});
				stream = words.stream();
				
				/*3 Use stream generate() 
				* Static <T> Stream<T> generate(Supplier<T> s)
				* The generate() method accepts a Supplier<T> for element generation. 
				* As the resulting stream is infinite, 
				* developer should specify the desired size 
				* or the generate() method will work until it reaches the memory limit:
				*/
				stream = Stream.generate(() -> "test").limit(10);
				String[] strArr = stream.toArray(String[]::new);
				System.out.println(Arrays.toString(strArr));
				
				Stream<Double> streamInt = Stream.generate(()-> Math.random() ).limit(5);
				System.out.println(Arrays.toString(streamInt.toArray(String[]::new)));
				
				/*4. Use Stream.iterate() 
				* Static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
				* 
				* The first element of the resulting stream is a first parameter of the iterate() method. 
				* For creating every following element the specified function is applied to the previous element.
				* 
				*/
				Stream<BigInteger> bigIntStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
				BigInteger[] bigIntArr = bigIntStream.toArray(BigInteger[]::new);
				System.out.println(Arrays.toString(bigIntArr));
				
				Stream<Integer> s = Stream.iterate(1, t -> t * 2).limit(5);
				System.out.println(Arrays.toString(s.toArray(String[]::new)));
				
				/*5. Stream Builder
				* void accept(T t) Stream.Builder<T> add(T t)
				*
				* When builder is used the desired type should be additionally specified in the right part of the statement, 
				*otherwise the build() method will create an instance of the Stream<Object>
				*/
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
				
				
				/*6. From Popular APIs
				* Stream method from APIs
				* 
				*  Instead of splitting strings into streams 
				*  for each character we can split strings for any pattern and create a stream
				*/
				String sentence = "Program creek is a Java site.";
				Stream<String> wordStream = Pattern.compile(" ").splitAsStream(sentence);
				String[] wordArr = wordStream.toArray(String[]::new);
				System.out.println(Arrays.toString(wordArr));
				
				
				/*  Stream of Primitives
				* IntStream and LongStream  
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
				 *  
				 *  We are not creating a stream of Integers (Stream<Integer>), but a stream of int arrays (Stream<int[]>). 
				 *  This means that instead of having a stream with five elements we have a stream of one element:
				 */
				int[] intNum = {1, 2, 3, 4, 5};
				Integer[] IntegerNum = {1, 2, 3, 4, 5};
				System.out.println(Stream.of(intNum).count()); // It prints 1!  So if want to prints all elements should be use IntStream
				System.out.println(Stream.of(IntegerNum).count()); // It prints 5!
				 
		
	}
}
