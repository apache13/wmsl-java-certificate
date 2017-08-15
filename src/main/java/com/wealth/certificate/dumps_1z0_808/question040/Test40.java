package com.wealth.certificate.dumps_1z0_808.question040;

public class Test40 {

	public static void main(String[] args) {
		StringBuilder message = new StringBuilder("hello java!");
		int pos = 0;

		try {
			for (pos = 0; pos < 12; pos++) {
				switch (message.charAt(pos)) {
				case 'a':
				case 'e':
				case 'o':
					String uc = Character.toString(message.charAt(pos)).toUpperCase();
					// System.out.println("uc: " + uc);

					message.replace(pos, pos + 1, uc);
					// System.out.println("msg: " + msg);

				}

				// System.out.println("++pos:" + pos);
			}
		} catch (Exception e) { // StingIndexOutOfBoundException
			System.out.println("out of limit");
		}
		System.out.println(message);
	}

}

//Answer : C. but 
//	C. Out of limits 
//     hEllOjAvA!