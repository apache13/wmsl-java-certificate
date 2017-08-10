package question054;

abstract class Vehicle {
	int x;

	Vehicle() {
//		this(10); // line n1
	}

	Vehicle(int x) {
		this.x = x;
	}
}

class Car extends Vehicle {
	int y;

	Car() {
		super();
//		this(20); //line n2
	}

	Car(int y) {
		this.y = y;
	}

	public String toString() {
		return super.x + " : " + this.y;
	}
}

public class Test54 {

	public static void main(String[] args) {
		Vehicle y = new Car();
		System.out.println(y);
	}

}
