package com.wealth.certificate.dumps_1z0_808.question203;

/*package p3; */
/*import p1.DoInterface; */
/*public*/ class DoClass implements DoInterface {
	public DoClass(int p1) {
	}

	public void method1(int p1) {} // line n2

	private void method2(int p1) {} // line n3 -> change private to public
}

public class Test {
	public static void main(String[] args) {
		DoInterface doi = new DoClass(100); // line n4
		doi.method1(100);
		doi.method2(100);
	}
}