package com.wealth.certificate.study_1z0_809.chapter07.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		// Adding a key/value pair
		System.out.println( map.put("oranges", 7) ); // null
		System.out.println( map.put("apples", 5) ); // null
		System.out.println( map.put("lemons", 2) ); // null
		System.out.println( map.put("bananas", 7) ); // null

		// Replacing the value of an existing key. Returns the old one
		System.out.println( map.put("apples", 4) ); // 5
		 System.out.println( map.size() ); // 4

		// {oranges=7, bananas=7, apples=4, lemons=2}
		System.out.println(map);

		// Getting a value
		System.out.println( map.get("oranges") ); // 7

		// Testing if the map contains a key
		System.out.println( map.containsKey("apples") ); // true
		// Testing if the map contains a value
		System.out.println( map.containsValue(5) ); // false

		// Removing the key/value pair and returning the value
		System.out.println( map.remove("lemons") ); // 2
		// Returns null if it can't find the key
		System.out.println( map.remove("lemons") ); // null

		// Getting the keys as a Set
		// (changes are reflected on the map and vice-versa)
		Set<String> keys = map.keySet(); // [oranges, bananas, apples]

		// Getting the values as a Collection
		// (changes are reflected on the map and vice-versa)
		Collection<Integer> values = map.values(); // [7, 7, 4]

		// Removing all key/value pairs
		map.clear();

		System.out.println( map.isEmpty() ); // true
	}
}
