package com.wealth.certificate.dumps_1z0_809_ert.question069;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Question069 {
	public static void main(String[] args) {
		Path source = Paths.get(getCurrentPath() +"/data/december/log.txt");
		Path destination = Paths.get("/data");
		try {
			Files.copy(source, destination);
			//Files.copy(Paths.get("/my/file.txt"), Paths.get("/my/output/directory/file.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String getCurrentPath() {
		return System.getProperty("user.dir") + "/src/main/java/com/wealth/certificate/dumps_1z0_809/question053";
	}
}