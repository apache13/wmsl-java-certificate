package com.wealth.certificate.dumps_1z0_809_ert.question044;

import java.io.Console;

public class App {

	public static void main(String[] args) {
		Console console = System.console();
		char[] pass = console.readPassword("Enter password:"); // line 1
		String password = new String(pass); // line 2
	}

}
