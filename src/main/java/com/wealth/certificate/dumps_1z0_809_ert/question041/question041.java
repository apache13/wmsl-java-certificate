package com.wealth.certificate.dumps_1z0_809_ert.question041;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class question041 {
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream(getCurrentPath() + "/version.txt");
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);) {
			if (br.markSupported()) {
				System.out.print((char) br.read());
				br.mark(2);
				System.out.print((char) br.read());
				br.reset();
				System.out.print((char) br.read());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentPath() {
		return System.getProperty("user.dir") + "/src/main/java/com/wealth/certificate/dumps_1z0_809_ert/question041";
	}
}

/*
What is the result?
A) The program prints nothing. 
B) 122
C) 135
D) 121

Answer: B

mark(int readAheadLimit) = Marks the current position in this input stream.

reset() = Resets the stream to the most recent mark.

https://stackoverflow.com/questions/8240071/what-are-mark-and-reset-in-bufferedreader
*/