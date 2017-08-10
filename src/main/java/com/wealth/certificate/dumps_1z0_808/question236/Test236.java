package question236;

class Vehicle {
	String type = "4W";
	int maxSpeed = 100;

	Vehicle(String type, int maxSpeed) {
		this.type = type;
		this.maxSpeed = maxSpeed;
	}
}

public class Test236 extends Vehicle{
	String trans;

	Test236(String trans){ // line n1
		super("T4", 140);
		this.trans = trans;
	}
	
	Test236(String type, int maxSpeed, String trans){
		super(type,maxSpeed);
//		this(trans); // line n2
	}
	public static void main(String[] args) {
		Test236 c1 = new Test236("Auto");
		Test236 c2 = new Test236("4W", 150, "Manual");
		
		System.out.println(c1.type + " " + c1.maxSpeed + " " + c1.trans);
		System.out.println(c2.type + " " + c2.maxSpeed + " " + c2.trans);
	}

}