package com.wealth.certificate.study_1z0_809.chapter1.singleton5;

public class Singleton5 {

}

class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	//NOT PERFECT
	//The problem is at the Java Virtual Machine (JVM) level. 
	//The JVM, or sometimes the compiler, can optimize the code by reordering or caching the value of variables (and not making the updates visible).
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

//Synchronized
//https://stackoverflow.com/questions/2056243/java-synchronized-block-for-class
//https://stackoverflow.com/questions/9056190/what-is-the-difference-between-synchronizedthis-and-synchronizedclassname-cla