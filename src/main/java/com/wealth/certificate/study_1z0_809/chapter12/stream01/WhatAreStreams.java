package com.wealth.certificate.study_1z0_809.chapter12.stream01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	double score;
	String name;

	public double getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Student(String name, double score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return name + " (" + score + ")";
	}

}

public class WhatAreStreams {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student("A", 95.0), new Student("B", 91.0), new Student("C", 99.0));

		List<Student> studentsScore = new ArrayList<Student>();
		for (Student s : students) {
			if (s.getScore() > 90.0) {
				studentsScore.add(s);
			}
		}
		Collections.sort(studentsScore, new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return Double.compare(s1.getScore(), s2.getScore());
			}
		});

		for (Student student : studentsScore) {
			System.out.println(student);
		}

		// Using streams
		System.out.println("----- Using stream -----");
		List<Student> studentsScore2 = students.stream().filter(s -> s.getScore() >= 90.0)
				.sorted(Comparator.comparing(Student::getScore)).collect(Collectors.toList());

		for (Student student : studentsScore2) {
			System.out.println(student);
		}
		
		/*
		What are streams?
		
		First, streams are NOT collections.		
		A simple definition is that streams are WRAPPERS for collections and arrays, 
		They wrap an EXISTING collection (or another data source) to support operations expressed with LAMBDAS
		*/
		
		// ## Streams work perfectly with lambdas.
			Stream.of(1,2,3).filter(e-> e>2).forEach(System.out::println); //print 3

		/* ## Streams don't store its elements.
		* The elements are stored in a collection or generated on the fly. They are only carried from the source through a pipeline of operations.
		*/
			
		/* ## Streams are immutable.
		* Streams don't mutate their underlying source of elements. 
		*/	
			
		/* ## Streams are not reusable.
		 * Streams can be traversed only once.
		 * A stream should be operated on (invoking an intermediate or terminal stream operation) only once.
		 * A stream implementation may throw IllegalStateException if it detects that the stream is being reused.
		 */
			Stream<String> stream = Stream.of("A","A","I","O","O");
			Stream<String> distict = stream.distinct();
		//long count = stream.count();
		
		
		/* ## Streams don't support indexed access to their elements.	
		* streams are not collections or arrays. The most you can do is get their first element.
		*/
		
		// Streams are easily parallelizable.	
		
			Integer[] st = Stream.of(1,3,5,7,9).parallel().filter(i -> i%2 == 1).toArray(Integer[]::new);
			System.out.println(Arrays.toString(st));
			
		/* ## Stream operations are lazy when possible.
		*An important feature of intermediate operations is that they don't process the elements until a terminal operation 
		is invoked, in other words, they're lazy.
		*/	
			System.out.println(Stream.of(1,2,3).filter(e -> e>1).count()); // print 2 because 2 and 3 greater than 1

	}

}
