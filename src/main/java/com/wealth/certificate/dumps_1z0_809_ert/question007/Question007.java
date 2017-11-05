package com.wealth.certificate.dumps_1z0_809_ert.question007;

public class Question007 {
	
}

//Listing 1
class MySingleton1 {
	 private static MySingleton1 _instance = new MySingleton1();

	 private MySingleton1() {
		 // construct object . . .
	 }

	 public static MySingleton1 getInstance() {
		 return _instance;
	 }
}

//Listing 2
class MySingleton2 {
	 private static MySingleton2 _instance;

	 private MySingleton2() {
		 // construct object . . .
	 }

	 // For lazy initialization
	 public static synchronized MySingleton2 getInstance() {
		  if (_instance==null) {
			  _instance = new MySingleton2();
		  }
		  return _instance;
	 }
}
