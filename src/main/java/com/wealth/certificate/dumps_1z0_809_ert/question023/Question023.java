package com.wealth.certificate.dumps_1z0_809_ert.question023;

public class Question023 {

	public static void main(String[] args) {

		MyClass obj = null;
		try (MyClass obj1 = new MyClass()) {
			obj1.test = 100;
			obj = obj1.copyObject(); // line n1 

		}
		
		System.out.println(obj.test); //line n2 
	}
}

/*
 
  What is the result? 
  A) An exception is thrown at line n2. 
  B) A compilation error occurs because the try block is declared with 
  C) A compilation error occurs at line n1. 
  D) 100 

*/