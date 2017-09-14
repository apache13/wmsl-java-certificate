package com.wealth.certificate.study_1z0_809.chapter12.stream04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

	public static void main(String[] args) {
//		List<Integer> myListInteger = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
//		List<String> myListString = Arrays.asList("a1", "a2", "b1", "c2", "c1");
//		myListString.stream().forEach(System.out::println);
//		myListString.stream().filter(s -> s.startsWith("c")).forEach(System.out::println);
//		myListString.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
//		Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println); // a1
		
		// ======= boolean allMatch(Predicate<? super T> predicate) ========
		/*Returns whether all elements of this stream match the provided predicate.*/
		Predicate<String> pc1 = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.length() <= 2;
			}
		};
		
		Predicate<String> pdAM = s -> s.length() <= 2;
		boolean isAllMatch = Arrays.asList("a1", "a2", "a3").stream().allMatch(pdAM);
		System.out.println("is all match: " + isAllMatch);
		
		// ======== boolean anyMatch(Predicate<? super T> predicate) =======
		/*Returns whether any elements of this stream match the provided predicate.*/
		Predicate<String> pdANM = s -> s.length() >= 2;
		boolean isAnyMatch = Arrays.asList("a1", "a2", "a3", "a10").stream().allMatch(pdANM);
		System.out.println("is any match: " + isAnyMatch + " (at least 1 match in stream)");
		
		
		// ======== boolean noneMatch(Predicate<? super T> predicate) ======	
		/*Returns whether no elements of this stream match the provided predicate.*/
		Predicate<String> pdNM = s -> s.length() > 3;
		boolean isNoneMatch = Arrays.asList("a1", "a2", "a3", "a10").stream().noneMatch(pdNM);
		System.out.println("is none match: " + isNoneMatch + " (all of stream doesn't match)");
		
		
		// ======== Optional<T> findAny() ===================================	
		/*Returns an Optional describing some element of the stream.
		  If there is no data in stream, it returns empty Optional instance
		 * */
		
//		List<Integer> numbers = Arrays.asList();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("find any with filter : " + numbers.stream().filter(x -> x > 3).findAny().orElse(100));
		numbers.stream().filter(x -> x > 3).findAny().ifPresent(s -> System.out.println("find any: " + s));
		
		Optional<Integer> opt = numbers.stream().findAny();
		if (opt.isPresent()) {
			System.out.println("find any: " + opt.get());
		} else {
			System.out.println("no value");
		}

		
		// ======== Optional<T> findFirst()	==================================
		/*Returns an Optional describing the first element of this stream.*/
		List<String> strList = Arrays.asList("A","BB","CCC", "DDDD");
		System.out.println("find first with filter : " + strList.stream().filter(x -> x.length() > 4).findFirst().orElse("Else (not found first)"));
		strList.stream().filter(x -> x.length() > 4).findFirst().ifPresent(s -> System.out.println("find first:" + s));
		strList.stream().findFirst().ifPresent(s -> System.out.println("find first:" + s));
		
		Optional<String> optStr = strList.stream().findFirst();
		if (optStr.isPresent()) {
			System.out.println("find first: " + optStr.get());
		} else {
			System.out.println("no value");
		}
		
		
		// ======== <R,A> R collect(Collector<? super T,A,R> collector)	======
		/*Performs a mutable reduction operation on the elements of this stream using a Collector.*/
		List<String> strCollectList = Arrays.asList("A1","B1","A2", "B2", "A11","B12","A21", "B22");
		List<String> filtered =
				strCollectList
			        .stream()
			        .filter(p -> p.startsWith("A"))
			        .collect(Collectors.toList());
		System.out.println("collect to List: " + filtered);
			
		Map<Object, List<String>> listToMap = 
				strCollectList.stream()
					.collect(Collectors.groupingBy(p -> p));
		
		listToMap.forEach((key, value) -> System.out.format("key %s: %s\n", key, value));
		System.out.println("collect to Map: " + listToMap);
		
		List<Person> persons = Arrays.asList(
									        new Person("Max", 18),
									        new Person("Peter", 23),
									        new Person("Pamela", 23),
//									        new Person("Ed", 23),
									        new Person("David", 12)
									        );
		
		List<Person> filteredP = persons
			        .stream()
			        .filter(p -> p.name.startsWith("P"))
			        .collect(Collectors.toList());
		System.out.println("collect to List:" + filteredP); // [Peter, Pamela]

		Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));
		personsByAge.forEach((age, name) -> System.out.format("age %s: %s\n", age, name));
		System.out.println("collect to Map: " + personsByAge);
		// age 18: [Max]
		// age 23: [Peter, Pamela]
		// age 12: [David]
		
		Map<Integer, String> map = persons
				    .stream()
				    .collect(Collectors.toMap(
				        p -> p.age,
				        p -> p.name,
				        (name1, name2) -> name1 + ", " + name2));
		System.out.println("list to Map: " + map);		// {18=Max, 23=Peter;Pamela, 12=David}

		Double averageAge = persons
				    .stream()
				    .collect(Collectors.averagingInt(p -> p.age));
		System.out.println("average of age is " + averageAge); // 19.0
		
		
		IntSummaryStatistics ageSummary = persons
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.age));
		System.out.println("summarizing: " + ageSummary); 	// IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
		
		String phrase = persons
				    .stream()
				    .filter(p -> p.age >= 18)
				    .map(p -> p.name+"("+p.age+")")
				    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));	// delimiter, prefix, suffix
//				    	.collect(Collectors.joining(" and "));	// delimiter
		System.out.println(phrase); 	// In Germany Max and Peter and Pamela are of legal age.

		// Stream.collect() using Supplier, Accumulator and Combiner
		List<String> list = Arrays.asList("Mukesh", "Vishal", "Amar");
	    String resultStr = list
//	    				.stream()
	    				.parallelStream()
			    		.collect(
			    				StringBuilder::new,	// Supplier
			    				(response, element) -> response.append(" ").append(element),		// Accumulator
			    				(response1, response2) -> response1.append(", ").append(response2.toString())		// Combiner
			    				)
			    		.toString();
	    System.err.println("Result: " + resultStr);
	    // If use list.stream() then the output will be different because it is not parallel processing and so nothing to combine.
	    
		
		// ======== long count() ========================================
		/* Returns the count of elements in this stream.*/
		long countPerson = persons.stream().count();
		System.out.println("amount of person is " + countPerson);
		
		
		// ======== void forEach(Consumer<? super T> action) ============
		/*Performs an action for each element of this stream.*/
		List<String> myListString = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		myListString.stream().forEach(s -> System.out.print(s+" "));
		System.out.println();
		myListString.stream().filter(s -> s.startsWith("c")).forEach(s -> System.out.print(s+" "));
		System.out.println();
		myListString.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::print);
		System.out.println();
		
		
		// ======== void forEachOrdered(Consumer<? super T> action) =====
		/*Performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order.*/
		Stream<String> streamOfString = Stream.of("three", "four", "five", "one", "two"); 
		
		ArrayList<String> myList = new ArrayList<>(); 
		streamOfString.parallel().forEachOrdered(myList::add); 
		System.out.println("for each ordered : " + myList);
		
		
		// ======== Optional<T> max(Comparator<? super T> comparator) ===	
		/*Returns the maximum element of this stream according to the provided Comparator.*/
//		System.out.println(streamOfString.max(comparator));
		
		List<Person> persons2 = Arrays.asList(
									        new Person("Max", 18),
									        new Person("Peter", 23),
									        new Person("Pamela", 23),
									        new Person("Ed", 24),
									        new Person("David", 12)
									        );
		
		Comparator<Person> compMax = (p1, p2) -> Integer.compare(p1.age, p2.age);
		System.out.println("max age is " + persons2.stream().max(compMax).get());
	    
		
		// ======== Optional<T> min(Comparator<? super T> comparator) ===	
		/*Returns the maximum element of this stream according to the provided Comparator.*/
		Comparator<Person> compMin = (p1, p2) -> Integer.compare(p1.age, p2.age);
		System.out.println("min age is " + persons2.stream().min(compMin).get());
		
		
		// ======== T reduce(T identity, BinaryOperator<T> accumulator)	
		/*Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.*/
		persons2
		    .stream()
		    .reduce(
		    			(p1, p2) -> p1.age > p2.age ? p1 : p2
		    			)
		    .ifPresent(System.out::println);    // Ed
		
		Person result = persons2
		        .stream()
		        .reduce(
		        		new Person("", 0), 
		        		(p1, p2) -> {
						            p1.age += p2.age;
						            p1.name = p1.name + " " + p2.name;
						            return p1;
						            }
		        		);

		System.out.format("name=%s; sum of age=%s", result.name, result.age); 	// name=Max Peter Pamela Ed David; age=100
		System.out.println();
		
		Integer ageSum = persons2
			    .stream()
			    .reduce(
			    		0, 
			    		(sum, p) -> sum += p.age, 
			    		(sum1, sum2) -> sum1 + sum2
			    		);

		System.out.println(ageSum); // 100
		
		Integer ageSum2 = persons2
//			    .parallelStream()
			    .stream()
			    .reduce(0,
			        (sum, p) -> {
			            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
			            return sum += p.age;
			        },
			        (sum1, sum2) -> {
			            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
			            return sum1 + sum2;
			        });
		System.out.println("sum of age is " + ageSum2);
		// accumulator: sum=0; person=Max
		// accumulator: sum=18; person=Peter
		// accumulator: sum=41; person=Pamela
		// accumulator: sum=64; person=Ed
		// accumulator: sum=88; person=David
		
			
		// ======== Object[] toArray() ====================================
		/*Returns an array containing the elements of this stream.*/
		
		Stream<Integer> powerOfTen = Stream.of(1, 10, 100, 1000, 10000); 
		Object[] arrayObj = powerOfTen.toArray();
		System.out.println(Arrays.toString(arrayObj));
		
		Object[] person = persons2.stream().toArray();
		System.out.println(Arrays.toString(person));

		
		// ======== <A> A[] toArray(IntFunction<A[]> generator)	===========
		/*Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array.*/
		Stream<Integer> powerOfTen2 = Stream.of(1, 10, 100, 1000, 10000); 
		Integer[] array = powerOfTen2.toArray(size -> new Integer[size]); 
		System.out.println(Arrays.toString(array));
		
		Stream<String> loans = Stream.of("Car Loan", "Home Loan", "Personal Loan");
		Object[] objectArray = loans.toArray();
		System.out.println(Arrays.toString(objectArray));	
		
		Stream<String> num = Stream.of("1", "2", "3", "4", "5");
		int[] ints = num.mapToInt(Integer::parseInt).toArray();
		System.out.println(Arrays.toString(ints));	

		Stream<Integer> numSt = Stream.of(1, 22, 333, 4444, 55555);
		ArrayList<Integer> newList = numSt.collect(Collectors.toCollection(ArrayList::new));
		Integer[] iArray = newList.toArray(new Integer[newList.size()]);
		System.out.println(Arrays.toString(iArray));
		
		
		// ======== Iterator<T> iterator() =================================
		/*Returns an iterator for the elements of the stream.*/
		List<String> nameList = Arrays.asList("Ram", "Sheila", "Mukesh", "Rani", "Nick", "Amy", "Desi", "Margo");
		Iterator<String> itr = nameList.stream().iterator();
		while (itr.hasNext()) {
			System.out.println("name iterator - " + itr.next());
		}

		
		// ======== Spliterator<T> spliterator() ===========================
		/*Returns a spliterator for the elements of the stream.*/
		
		List<String> nameList2 = Arrays.asList("Ram", "Sheila", "Mukesh", "Rani", "Nick", "Amy", "Desi", "Margo");
		Spliterator<String> splitStr = nameList2.stream().spliterator();
		while (splitStr.tryAdvance((n) -> System.out.println("name spliterator - " + n)))
			;
		
		List<Person> persons3 = Arrays.asList(
		        new Person("Max", 18),
		        new Person("Peter", 23),
		        new Person("Pamela", 23),
		        new Person("Ed", 24),
		        new Person("David", 12)
		        );
		Spliterator<Person> peopleSpliterator = persons3.spliterator();

//		System.out.println("characteristics: " + peopleSpliterator.characteristics());        
//		System.out.println("estimateSize: " + peopleSpliterator.estimateSize()); 
//		System.out.println("estimateSize: " + peopleSpliterator.trySplit().getExactSizeIfKnown()); 
//		peopleSpliterator.forEachRemaining((s) -> System.out.println("P: "+s));
		while (peopleSpliterator.tryAdvance((s) -> System.out.println("Person name: "+s)));
		
		List<String> name_List = Arrays.asList("Ram", "Sheila", "Mukesh", "Rani", "Nick", "Amy", "Desi", "Margo");
//		List<String> nameList3 = Arrays.asList("Ram");
		Spliterator<String> splitName_1 = name_List.stream().spliterator();
		System.out.println(splitName_1+ ", Size: " + splitName_1.estimateSize());
		
		Spliterator<String> splitName_2 = splitName_1.trySplit();
		System.out.println(splitName_2+ ", Size: " + splitName_2.estimateSize());

		Spliterator<String> splitName_3 = splitName_2.trySplit();
		System.out.println(splitName_3+ ", Size: " + splitName_3.estimateSize());
		
		Spliterator<String> splitName_4 = splitName_3.trySplit();
		System.out.println(splitName_4+ ", Size: " + splitName_4.estimateSize());

//		Spliterator<String> splitName_5 = splitName_1.trySplit();
//		System.out.println(splitName_5+ ", Size: " + splitName_4.estimateSize());
		
		System.out.println("Spliterator_1");
		while (splitName_1.tryAdvance((n) -> System.out.println("name_1 - " + n)))
			;

		System.out.println("Spliterator_2");
		while (splitName_2.tryAdvance((n) -> System.out.println("name_2 - " + n)))
			;

		System.out.println("Spliterator_3");
		while (splitName_3.tryAdvance((n) -> System.out.println("name_3 - " + n)))
			;

		System.out.println("Spliterator_4");
		while (splitName_4.tryAdvance((n) -> System.out.println("name_4 - " + n)))
			;

//		System.out.println("Spliterator_5");
//		while (splitName_5.tryAdvance((n) -> System.out.println("name_5 - " + n)))
//			;
	}

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
