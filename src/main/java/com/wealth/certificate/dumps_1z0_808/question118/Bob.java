package com.wealth.certificate.dumps_1z0_808.question118;

class Star {
	public void doStuff() {
		System.out.println("Twinkling Star");
	}
}

interface Universe {
	public void doStuff();
}

class Sun extends Star implements Universe {
	public void doStuff() {
		System.out.println("Shining sun");
	}
}

public class Bob {

	public static void main(String[] args) {
		Sun obj2 = new Sun();
		Star obj3 = obj2;
		((Sun) obj3).doStuff();
		((Star) obj2).doStuff();
		((Universe) obj2).doStuff();
	}

}
