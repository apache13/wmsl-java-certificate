package com.wealth.certificate.study_1z0_809.chapter07.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		// Creating an ArrayList with an initial capacity of 10
		List<String> list = new ArrayList<>(10);

		System.out.println(list.isEmpty()); // true
		list.add("a");
		System.out.println(list.get(0)); // a
		list.add(0, "b"); // Inserting b at index 0
		list.add("c");
		list.add(null);
		System.out.println(list); // [b, a, c, null]
		list.set(2, "a"); // Replacing element at index 2 with a
		System.out.println(list.contains("d")); // false
		// Returning the index of the first match, -1 if not found
		System.out.println(list.indexOf("a")); // 1
		// Returning the index of the last match, -1 if not found
		System.out.println(list.lastIndexOf("a")); // 2

		list.remove(1); // Removing by index
		list.remove(null); // Removing null
		list.remove("a"); // Removing the first matching element

		System.out.println(list.size()); // 1
		
		//An easy way to create a List is using the java.util.Arrays.asList method:
		String[] arr = {"a", "b", "c", "d"};
		List<String> listStr1 = Arrays.asList(arr);

		//Or simply:
		List<String> listStr2 = Arrays.asList("a", "b", "c", "d");
	}
}
