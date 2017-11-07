package com.wealth.certificate.dumps_1z0_809_ert.question010;

public class Question010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// A)
		Foo<String, Integer> mark = new Foo<String, Integer>("Steve", 1);
		// B)
		Foo<String, String> pair = Foo.<String>twice("Hello World!");
		// C)
		Foo<Object, Object> percentage = new Foo<String, Integer>("Steve", 1);
		// D)
		Foo<String, String> grade = new Foo<>(“John”, “A”);
	}

}

/*

 Which option fails? 
 A) Foo<String, Integer> mark = new Foo<String, Integer>(“Steve”, 1); 
 B) Foo<String, String> pair = Foo.<String>twice(“Hello World!”); 
 C) Foo<object, Object> percentage = new Foo<String, Integer>(“Steve”,1); 
 D) Foo<String, String> grade = new Foo<>(“John”, “A”);  
 
*/