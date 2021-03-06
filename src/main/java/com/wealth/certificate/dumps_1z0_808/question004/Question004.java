package com.wealth.certificate.dumps_1z0_808.question004;

public class Question004 {
	public static void main(int[] args) {
		System.out.println("int main " + args[0]);
	}
	public static void main(Object[] args) {
		System.out.println("Object main " + args[0]);
	}
	public static void main(String[] args) {
		System.out.println("String main " + args[0]);
	}

	/*Now if we change the signature of main method and try to run same Java program we will get Error as shown 
	below :
	
	public static void main(String args) {
		System.out.println("String main " + args[0]);
	}
	
	*Exception in thread "main" java.lang.NoSuchMethodError: main

 	because we have changed String[] to String which means JVM not able to find standard main method 
 	which is required to start execution of Java program
 	
 	
 	Valid Signature of main method in Java 
		main method is a standard method and has pre specified signature, 
		if you change the signature of main method JVM will not be able to locate main method will
		 throw Exception at runtime as shown in above example. 
		 main method is public, static and void and accept an String[] as argument and from Java 5 
		 onwards it can also accept variable arguments instead of array. 
		 following signatures are valid main method signature in Java :
		
		public static void main(String args[]) {}
		
		public static void main(String[] args){}
		
		public static void main(String... args){}
		
		You can also use certain modifier like final, synchronized and strictfp along with main method in Java.
		
		
	
	Why main method is public static and void in Java
		What is main method in Java and why main is static in Java
		This is very famous core Java interview question, 
		and appeared on many fresher and experience level interviews. 
		Though ever java programmer uses main method not every one is familiar with reason 
		why main is static or why main is public in Java. Here are few reasons 
		which make sense to me to think of Why main is public, static and void in java
		
		main method in Java is public so that its visible to every other class, 
		even which are not part of its package. if its not public JVM classes might not able to access it.
		
		main method is static in Java, so that it can be called without creating any instance. 
		While JVM tries to execute Java program it doesn't know how to create instance of  main class as 
		there is no standard constructor is defined for main class.
		
		main method is void in Java because it doesn't return any thing to caller which is JVM .





	*/
		

}