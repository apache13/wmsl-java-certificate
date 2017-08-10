package question222;

public class Test222 {

	public static void main(String[] args) {
		try {
			Double number = Double.valueOf("120D"); // line 5
		} catch (NumberFormatException ex) {
			
		}
//		System.out.println(number);  //line 8
	}

}
