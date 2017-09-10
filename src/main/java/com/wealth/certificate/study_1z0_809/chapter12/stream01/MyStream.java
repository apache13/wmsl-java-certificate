package com.wealth.certificate.study_1z0_809.chapter12.stream01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

public class MyStream {

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
				
		- Streams work perfectly with lambdas.
		- Streams don't store its elements.
		- Streams are immutable.
		- Streams don't mutate their underlying source of elements. 		
		- Streams are not reusable.
		- Streams can be traversed only once.
		- Streams don't support indexed access to their elements.		
		- Streams are easily parallelizable.		
		- Stream operations are lazy when possible.

		*/

	}

}
