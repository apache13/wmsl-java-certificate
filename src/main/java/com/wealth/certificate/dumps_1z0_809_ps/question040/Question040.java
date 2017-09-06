package com.wealth.certificate.dumps_1z0_809_ps.question040;

public class Question040 {

	public static void main(String[] args) { 
		String names[] = new String[3];
		names[0] = "Mary Brown";
		names[1] = "Nancy Red";
		names[2] = "Jessy Orange";
		try {
			for(String n: names) {
				try {
					String pwd = n.substring(0, 3)+n.substring(6, 10);
					System.out.println(pwd);
				} catch(StringIndexOutOfBoundsException sie) {
					System.out.println("String out of limits");
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array out of limits");
		}
	}
}