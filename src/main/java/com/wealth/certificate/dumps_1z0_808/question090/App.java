package com.wealth.certificate.dumps_1z0_808.question090;

public class App {
	public static void main(String args[]) {
		int[] array = { 1, 2, 3, 4, 5 };
		for (int i : array) {
			if (i < 2) {
				// keyword1 ;
				continue;
			}
			System.out.print(i); // ที่โจทย์เขียนเป็น println นะคะ อาจจะต้องสังเกตกันเพิ่มนิดนึง
			if (i == 3) {
				// keyword2 ;
				continue;
			}
		}
	}
}
