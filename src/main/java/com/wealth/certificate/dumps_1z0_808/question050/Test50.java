package com.wealth.certificate.dumps_1z0_808.question050;

public class Test50 {
	public static void main(String[] args) { 
	 		int x = 5;
	 		while (isAvailable(x)) {
	 			System.out.print(x);
	 			x--;
	 		}
	}
	 
	public static boolean isAvailable(int x) { 
	 	return x-- > 0 ? true : false;
	}
}
