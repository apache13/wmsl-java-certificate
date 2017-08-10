package com.wealth.certificate.dumps_1z0_808.question089;

public class Test {
	public static void main(String[] args) {
		int ax = 10, az = 30;
		int aw = 1, ay = 1;
		try {
			aw = ax % 2;
			ay = az / aw;
		} catch (ArithmeticException e1) {
			System.out.println("Invalid Divisor");
		} catch (Exception e2) {
			aw = 1;
			System.out.println("Divisor Changed");
		}
		ay = az / aw; // Line 14
		System.out.println("Succesful Division " + ay);
	}
}