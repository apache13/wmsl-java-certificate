package com.wealth.certificate.study_1z0_809.chapter12.stream04;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
			
		Map<Object, List<String>> listToMap = strCollectList.stream().collect(Collectors.groupingBy(p -> p));
		listToMap.forEach((key, value) -> System.out.format("key %s: %s\n", key, value));
		System.out.println("collect to Map: " + listToMap);
		
		List<Person> persons = Arrays.asList(
									        new Person("Max", 18),
									        new Person("Peter", 23),
									        new Person("Pamela", 23),
									        new Person("Ed", 23),
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

		Map<Integer, String> map = persons
				    .stream()
				    .collect(Collectors.toMap(
				        p -> p.age,
				        p -> p.name,
				        (name1, name2) -> name1 + ", " + name2));
		System.out.println("list to Map: " + map);		// {18=Max, 23=Peter;Pamela, 12=David}
		
		Collector<Person, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

		String names = persons
					.stream()
					.collect(personNameCollector);
		System.out.println("collect with collectors: " + names);  // MAX | PETER | PAMELA | DAVID
		
		
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
		
		
		/*void forEachOrdered(Consumer<? super T> action)	
		Performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order.*/
		
		/*Optional<T> max(Comparator<? super T> comparator)	
		Returns the maximum element of this stream according to the provided Comparator.*/
		
		/*Optional<T> min(Comparator<? super T> comparator)	
		Returns the maximum element of this stream according to the provided Comparator.*/
		
		/*T reduce(T identity, BinaryOperator<T> accumulator)	
		Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.*/
		
		/*Object[] toArray()	
		Returns an array containing the elements of this stream.*/
		
		/*<A> A[] toArray(IntFunction<A[]> generator)	
		Returns an array containing the elements of this stream, using the provided generator function to allocate the returned array.*/
		
		/*Iterator<T> iterator()	
		Returns an iterator for the elements of the stream.*/
		
		/*Spliterator<T> spliterator()
		Returns a spliterator for the elements of the stream.*/

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
